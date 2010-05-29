/**
 * 
 */
package qt.dao;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import qt.dto.ChiTietDonHang;
import qt.dto.DonHang;

/**
 * @author tqthe
 * 
 */
@Transactional
public class DonHangDAO {

	private SessionFactory factory;

	/**
	 * @param factory
	 *            the factory to set
	 */
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	/**
	 * @return the factory
	 */
	public SessionFactory getFactory() {
		return factory;
	}

	/**
	 * Thống kê doanh thu bán hàng trong một khoảng thời gian bất kì
	 * 
	 * @param d1
	 *            Ngày bắt đầu
	 * @param m1
	 *            Tháng bắt đầu
	 * @param y1
	 *            Năm bắt đầu
	 * @param d2
	 *            Ngày kết thúc
	 * @param m2
	 *            Tháng kết thúc
	 * @param y2
	 *            Năm kết thúc
	 * @return Tổng doanh thu trong một khoảng thời gian
	 */
	public double rangeStatistic(int d1, int m1, int y1, int d2, int m2, int y2) {
		return rangeStatisticHelper(d1, m1, y1, d2, m2, y2);
	}

	/**
	 * Thống kê doanh thu theo tháng của một năm bất kì.
	 * 
	 * @param year
	 *            Năm cần thống kê.
	 * @return Mảng một chiều chứa doanh thu của từng tháng trong năm. Số phần
	 *         tử của mảng là 12 (tương ứng với 12 tháng). Tháng đầu tiên của
	 *         năm có index = 0 (Zero base)
	 */
	public double[] monthlyStatistic(int year) {
		double[] sums = new double[12];
		for (int i = 0; i < sums.length; i++) {
			sums[i] = monthlyStatisticHelper(i + 1, year);
		}
		return sums;
	}

	/**
	 * Thống kê doanh số bán hàng theo từng ngày của một tháng bất kì
	 * 
	 * @param month
	 *            tháng cần thống kê.
	 * @param year
	 *            Năm chứa tháng cần thống kê.
	 * @return Mảng một chiều chứa doanh thu của từng ngày trong tháng. Số phần
	 *         tử của mảng bằng số ngày trong tháng. Ngày đầu tiên của tháng có
	 *         index = 0 (Zero base)
	 */
	public double[] dailyStatistic(int month, int year) {
		Calendar calendar = Calendar.getInstance();
		// month base on 0
		calendar.set(year, month - 1, 1);
		int daysOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		double[] sums = new double[daysOfMonth];
		for (int i = 0; i < sums.length; i++) {
			sums[i] = dailyStatisticHelper(i + 1, month, year);
		}
		return sums;
	}

	@SuppressWarnings("unchecked")
	private double rangeStatisticHelper(int d1, int m1, int y1, int d2, int m2,
			int y2) {
		double sum = 0;

		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.set(y1, m1 - 1, d1, 0, 0, 0);
		c2.set(y2, m2 - 1, d2, 23, 59, 59);

		Session session = factory.getCurrentSession();
		List<DonHang> dsDonHang = session.createCriteria(DonHang.class).add(
				Restrictions.ge("ngayTao", c1.getTime())).add(
				Restrictions.le("ngayTao", c2.getTime())).list();

		for (DonHang d : dsDonHang) {
			sum += calculateBill(d);
		}

		return sum;
	}

	@SuppressWarnings("unchecked")
	private double monthlyStatisticHelper(int month, int year) {
		double sum = 0;
		Session session = factory.getCurrentSession();

		List<DonHang> dsDonHangTrongThang = session
				.createQuery(
						"from DonHang as d  where d.xoa = false and d.trangThai.id = 4 and month(d.ngayTao) = :mm and year(d.ngayTao) = :yyyy")
				.setInteger("mm", month).setInteger("yyyy", year).list();
		for (DonHang d : dsDonHangTrongThang) {
			sum += calculateBill(d);
		}

		return sum;
	}

	@SuppressWarnings("unchecked")
	private double dailyStatisticHelper(int day, int month, int year) {
		double sum = 0;
		Session session = factory.getCurrentSession();

		List<DonHang> dsDonHangTrongNgay = session
				.createQuery(
						"from DonHang as d  where d.xoa = false and d.trangThai.id = 4 and day(d.ngayTao) = :dd and month(d.ngayTao) = :mm and year(d.ngayTao) = :yyyy")
				.setInteger("dd", day).setInteger("mm", month).setInteger(
						"yyyy", year).list();
		for (DonHang d : dsDonHangTrongNgay) {
			sum += calculateBill(d);
		}

		return sum;
	}

	/**
	 * Tính tổng giá trị của một DonHang.
	 * 
	 * @param d
	 *            DonHang cần tính giá trị.
	 * @return Tổng giá trị của DonHang
	 */
	private double calculateBill(DonHang d) {
		double sum = 0;
		Set<ChiTietDonHang> ds = d.getDsChiTietDonHang();
		for (ChiTietDonHang ct : ds) {
			sum += ct.getSoLuong() * ct.getSanPham().getGiaHienHanh();
		}
		return sum;
	}

	/**
	 * Đánh dấu xóa một DonHang. Các ChiTietDonHang thuộc về DonHang này sẽ bị
	 * đánh dấu xóa theo.
	 * 
	 * @param d
	 *            DonHang sẽ bị đánh dấu xóa.
	 */
	public void markAsDeleted(DonHang d) {
		Set<ChiTietDonHang> dsChiTiet = d.getDsChiTietDonHang();
		for (ChiTietDonHang ct : dsChiTiet) {
			ct.setXoa(true);
		}

		makePersistent(d);
	}

	/**
	 * Xóa (vĩnh viễn) một DonHang. <b>Chú ý:</b> Các ChiTietDonHang của DonHang
	 * này sẽ bị xóa theo.
	 * 
	 * @param d
	 *            DonHang sẽ bị xóa.
	 */
	public void makeTransient(DonHang d) {
		// remove all association before deleting
		if (d.getKhachHang() != null) {
			d.getKhachHang().getDsDonHang().remove(d);
			d.setKhachHang(null);
		}
		if (d.getHinhThucThanhToan() != null) {
			d.getHinhThucThanhToan().getDsDonHang().remove(d);
			d.setHinhThucThanhToan(null);
		}
		if (d.getTrangThai() != null) {
			d.getTrangThai().getDsDonHang().remove(d);
			d.setTrangThai(null);
		}

		factory.getCurrentSession().delete(d);
	}

	/**
	 * Thêm mới hoặc cập nhật một DonHang. Việc thêm mới hay cập nhật được căn
	 * cứ theo giá trị của ID.
	 * 
	 * @param d
	 *            DonHang sẽ được thêm mới hay cập nhật.
	 * @return DonHang đã được thêm mới hay cập nhật. Trong trường hợp thêm mới
	 *         giá trị ID sẽ được cập nhật tương ứng.
	 */
	public DonHang makePersistent(DonHang d) {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(d);
		session.flush();
		return d;
	}

	/**
	 * Tìm các DonHang theo HinhThucThanhToan.
	 * 
	 * @param idHinhThucThanhToan
	 *            id của HinhThucThanhToan.
	 * @return Danh sách các DonHang của HinhThucThanhToan.
	 */
	@SuppressWarnings("unchecked")
	public List<DonHang> findByHinhThucThanhToan(int idHinhThucThanhToan) {
		return factory
				.getCurrentSession()
				.createQuery(
						"from DonHang d where d.hinhThucThanhToan.id = :id and d.xoa = false")
				.setInteger("id", idHinhThucThanhToan).list();
	}

	/**
	 * Tìm các DonHang theo TrangThai
	 * 
	 * @param idTrangThai
	 *            id của TrangThai.
	 * @return Danh sách DonHang của TrangThai.
	 */
	@SuppressWarnings("unchecked")
	public List<DonHang> findByTrangThai(int idTrangThai) {
		return factory.getCurrentSession().createQuery(
				"from DonHang d where d.trangThai.id = :id and d.xoa = false")
				.setInteger("id", idTrangThai).list();
	}

	/**
	 * Tìm các đơn hàng của một KhachHang.
	 * 
	 * @param idKhanhHang
	 *            id của KhachHang.
	 * @return Danh sách DonHang của KhachHang.
	 */
	@SuppressWarnings("unchecked")
	public List<DonHang> findByKhachHang(int idKhanhHang) {
		return factory.getCurrentSession().createQuery(
				"from DonHang d where d.khachHang.id = :id and d.xoa = false")
				.setInteger("id", idKhanhHang).list();
	}

	/**
	 * Tìm một DonHang theo id.
	 * 
	 * @param id
	 *            id của DonHang cần tìm.
	 * @return DonHang tìm được. Nếu tìm không thấy trả về null.
	 */
	public DonHang findById(int id) {
		DonHang d = (DonHang) factory.getCurrentSession()
				.get(DonHang.class, id);
		return d.isXoa() ? null : d;
	}

	/**
	 * Tìm tất cả DonHang.
	 * 
	 * @return Danh sách DonHang tìm được.
	 */
	@SuppressWarnings("unchecked")
	public List<DonHang> findAll() {
		return factory.getCurrentSession().createCriteria(DonHang.class).add(
				Restrictions.eq("xoa", false)).list();
	}

}
