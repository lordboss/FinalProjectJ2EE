/**
 * 
 */
package qt.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import qt.dto.PhuKien;

/**
 * @author tqthe
 * 
 */
@Transactional
public class PhuKienDAO {

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
	 * Tìm các PhuKien theo LoaiPhuKien.
	 * 
	 * @param idLoaiPhuKien
	 *            id của LoaiPhuKien.
	 * @return Danh sách PhuKien của LoaiPhuKien.
	 */
	@SuppressWarnings("unchecked")
	public List<PhuKien> findByLoaiPhuKien(int idLoaiPhuKien) {
		return factory
				.getCurrentSession()
				.createQuery(
						"from PhuKien p where p.loaiPhuKien.id = :id and p.xoa = false")
				.setInteger("id", idLoaiPhuKien).list();
	}

	/**
	 * Đánh dấu xóa một PhuKien
	 * 
	 * @param p
	 *            PhuKien sẽ bị đánh dấu xóa.
	 */
	public void markAsDeleted(PhuKien p) {
		p.setXoa(true);
		makePersistent(p);
	}

	/**
	 * Xóa (vĩnh viễn) một PhuKien. Danh sách HinhAnh và danh sách
	 * TinGiamGiaPhuKien bị xóa theo.
	 * 
	 * @param p
	 *            PhuKien bị xóa.
	 * @param force
	 *            Nếu <code>force=true</code> thực hiện xóa PhuKien và
	 *            dsDonHang, dsChiTietPhieuNhapPhuKien. <b>Rất là nguy hiểm</b> <br>
	 *            Nếu <code>force=false</code> chĩ hiện xóa PhuKien nếu PhuKien
	 *            không có bất kì danh sách đơn hàng hoặc phiếu nhập nào.
	 * @throws Exception
	 *             Nếu phụ kiện đã có danh sách đơn hàng hoặc phiếu nhập và tham
	 *             số <code>force=false</code>
	 */
	public void makeTransient(PhuKien p, boolean force) throws Exception {
		if ((p.getDsChiTietDonHang().size() > 0 || p.getDsChiTietNhapPhuKien()
				.size() > 0)
				&& !force) {
			throw new Exception(
					"Không thể xóa phụ kiện đã có danh sách đơn hàng hoặc phiếu nhập");
		}

		if (p.getLoaiPhuKien() != null) {
			p.getLoaiPhuKien().getDsPhuKien().remove(p);
			p.setLoaiPhuKien(null);
		}
		if (p.getTinhTrangSanPham() != null) {
			p.getTinhTrangSanPham().getDsSanPham().remove(p);
			p.setTinhTrangSanPham(null);
		}
		p.setDsDienThoaiTuongThich(null);
		p.setDsNhaCungCap(null);

		factory.getCurrentSession().delete(p);
	}

	/**
	 * Thêm mới hoặc cập nhật một PhuKien. Việc thêm mới hay cập nhật phụ thuộc
	 * vào giá trị ID.
	 * 
	 * @param p
	 *            PhuKien sẽ được thêm mới hay cập nhật.
	 * @return PhuKien đã được thêm mới hay cập nhật. Trong trường hợp thêm mới
	 *         giá trị của ID sẽ được cập nhật.
	 */
	public PhuKien makePersistent(PhuKien p) {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(p);
		session.flush();
		return p;
	}

	/**
	 * Tìm một PhuKien theo ID.
	 * 
	 * @param id
	 *            id của PhuKien cần tìm.
	 * @return PhuKien tìm được.
	 */
	public PhuKien findById(int id) {
		PhuKien a = (PhuKien) factory.getCurrentSession()
				.get(PhuKien.class, id);
		return a.isXoa() ? null : a;
	}

	/**
	 * Tìm tất cả PhuKien.
	 * 
	 * @return Danh sách PhuKien tìm được.
	 */
	@SuppressWarnings("unchecked")
	public List<PhuKien> findAll() {
		return factory.getCurrentSession().createCriteria(PhuKien.class).add(
				Restrictions.eq("xoa", false)).list();
	}
}
