/**
 * 
 */
package qt.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import qt.dto.NhanVien;

/**
 * @author tqthe
 * 
 */
@Transactional
public class NhanVienDAO {

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
	 * Đánh dấu xóa một NhanVien.
	 * 
	 * @param e
	 *            NhanVien sẽ bị đánh dấu xóa.
	 */
	public void markAsDeleted(NhanVien e) {
		e.setXoa(true);
		makePersistent(e);
	}

	/**
	 * Xóa (vĩnh viễn) một NhanVien.
	 * 
	 * @param e
	 *            NhanVien sẽ bị xóa.
	 * @param force
	 *            Nếu <code>force=true</code> thực hiện xóa NhanVien và các
	 *            dsPhieuNhapDienThoai, dsPhieuNhapPhuKien. <br>
	 *            Nếu <code>force=false</code> chỉ xóa nếu NhanVien không có bất
	 *            kì danh sách phiếu nhập điện thoại hoặc phụ kiện nào.
	 * @throws Exception
	 *             Nếu NhanVien đã có danh sách phiếu nhập điện thoại hoạc phụ
	 *             kiện và tham số <code>force=false</code>
	 */
	public void makeTransient(NhanVien e, boolean force) throws Exception {
		if ((e.getDsPhieuNhapDienThoai().size() > 0 || e
				.getDsPhieuNhapPhuKien().size() > 0)
				&& !force) {
			throw new Exception(
					"Không thể xóa nhân viên đã có danh sách phiếu nhập điện thoại hoặc phụ kiện");
		}

		factory.getCurrentSession().delete(e);
	}

	/**
	 * Thêm mới hoặc cập nhật một NhanVien.
	 * 
	 * @param e
	 *            NhanVien sẽ được thêm mới hay cập nhật.
	 * @return NhanVien đã được thêm mới hay cập nhật.
	 */
	public NhanVien makePersistent(NhanVien e) {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(e);
		session.flush();
		return e;
	}

	/**
	 * Tìm một NhanVien theo ID.
	 * 
	 * @param id
	 *            id của NhanVien cần tìm.
	 * @return NhanVien tỉm được. Nếu không tìm thấy trả về null.
	 */
	public NhanVien findById(int id) {
		NhanVien e = (NhanVien) factory.getCurrentSession().get(NhanVien.class,
				id);
		return e.isXoa() ? null : e;
	}

	/**
	 * Tìm tất cả các NhanVien.
	 * 
	 * @return Danh sách NhanVien.
	 */
	@SuppressWarnings("unchecked")
	public List<NhanVien> findAll() {
		return factory.getCurrentSession().createCriteria(NhanVien.class).add(
				Restrictions.eq("xoa", false)).list();
	}
}
