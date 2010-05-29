/**
 * 
 */
package qt.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import qt.dto.NhanVienQuanTri;

/**
 * @author tqthe
 * 
 */
@Transactional
public class NhanVienQuanTriDAO {

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
	 * Đánh dấu xóa một NhanVienQuanTri.
	 * 
	 * @param e
	 *            NhanVienQuanTri sẽ bị đánh dấu xóa.
	 */
	public void markAsDeleted(NhanVienQuanTri e) {
		e.setXoa(true);
		makePersistent(e);
	}

	/**
	 * Xóa (vĩnh viễn) một NhanVienQuanTri.
	 * 
	 * @param e
	 *            NhanVienQuanTri sẽ bị xóa.
	 */
	public void makeTransient(NhanVienQuanTri e) {
		factory.getCurrentSession().delete(e);
	}

	/**
	 * Thêm mới hoặc cập nhật một NhanVienQuanTri.
	 * 
	 * @param e
	 *            NhanVienQuanTri sẽ được thêm mới hay cập nhật.
	 * @return NhanVienQuanTri đã được thêm mới hay cập nhật.
	 */
	public NhanVienQuanTri makePersistent(NhanVienQuanTri e) {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(e);
		session.flush();
		return e;
	}

	/**
	 * Tìm một NhanVienQuanTri theo ID.
	 * 
	 * @param id
	 *            id của NhanVienQuanTri cần tìm.
	 * @return NhanVienQuanTri tỉm được. Nếu không tìm thấy trả về null.
	 */
	public NhanVienQuanTri findById(int id) {
		NhanVienQuanTri e = (NhanVienQuanTri) factory.getCurrentSession().get(
				NhanVienQuanTri.class, id);
		return e.isXoa() ? null : e;
	}

	/**
	 * Tìm tất cả các NhanVienQuanTri.
	 * 
	 * @return Danh sách NhanVienQuanTri.
	 */
	@SuppressWarnings("unchecked")
	public List<NhanVienQuanTri> findAll() {
		return factory.getCurrentSession()
				.createCriteria(NhanVienQuanTri.class).add(
						Restrictions.eq("xoa", false)).list();
	}
}
