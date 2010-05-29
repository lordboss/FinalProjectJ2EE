/**
 * 
 */
package qt.bus;

import java.util.List;

import qt.dao.DonHangDAO;
import qt.dto.DonHang;

/**
 * @author tqthe
 * 
 */
public class DonHangBUS {

	private DonHangDAO donHangDAO;

	/**
	 * @param donHangDAO
	 *            the donHangDAO to set
	 */
	public void setDonHangDAO(DonHangDAO donHangDAO) {
		this.donHangDAO = donHangDAO;
	}

	/**
	 * @return the donHangDAO
	 */
	public DonHangDAO getDonHangDAO() {
		return donHangDAO;
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
		return donHangDAO.rangeStatistic(d1, m1, y1, d2, m2, y2);
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
		return donHangDAO.monthlyStatistic(year);
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
		return donHangDAO.dailyStatistic(month, year);
	}

	/**
	 * Đánh dấu xóa một DonHang. Các ChiTietDonHang thuộc về DonHang này sẽ bị
	 * đánh dấu xóa theo.
	 * 
	 * @param d
	 *            DonHang sẽ bị đánh dấu xóa.
	 */
	public void markAsDeleted(DonHang d) {
		donHangDAO.markAsDeleted(d);
	}

	/**
	 * Xóa (vĩnh viễn) một DonHang. <b>Chú ý:</b> Các ChiTietDonHang của DonHang
	 * này sẽ bị xóa theo.
	 * 
	 * @param d
	 *            DonHang sẽ bị xóa.
	 */
	public void makeTransient(DonHang d) {
		donHangDAO.makeTransient(d);
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
		donHangDAO.makePersistent(d);
		return d;
	}

	/**
	 * Tìm các DonHang theo HinhThucThanhToan.
	 * 
	 * @param idHinhThucThanhToan
	 *            id của HinhThucThanhToan.
	 * @return Danh sách các DonHang của HinhThucThanhToan.
	 */
	public List<DonHang> findByHinhThucThanhToan(int idHinhThucThanhToan) {
		return donHangDAO.findByHinhThucThanhToan(idHinhThucThanhToan);
	}

	/**
	 * Tìm các DonHang theo TrangThai
	 * 
	 * @param idTrangThai
	 *            id của TrangThai.
	 * @return Danh sách DonHang của TrangThai.
	 */
	public List<DonHang> findByTrangThai(int idTrangThai) {
		return donHangDAO.findByTrangThai(idTrangThai);
	}

	/**
	 * Tìm các đơn hàng của một KhachHang.
	 * 
	 * @param idKhanhHang
	 *            id của KhachHang.
	 * @return Danh sách DonHang của KhachHang.
	 */
	public List<DonHang> findByKhachHang(int idKhanhHang) {
		return donHangDAO.findByKhachHang(idKhanhHang);
	}

	/**
	 * Tìm một DonHang theo id.
	 * 
	 * @param id
	 *            id của DonHang cần tìm.
	 * @return DonHang tìm được. Nếu tìm không thấy trả về null.
	 */
	public DonHang findById(int id) {
		return donHangDAO.findById(id);
	}

	/**
	 * Tìm tất cả DonHang.
	 * 
	 * @return Danh sách DonHang tìm được.
	 */
	public List<DonHang> findAll() {
		return donHangDAO.findAll();
	}
}
