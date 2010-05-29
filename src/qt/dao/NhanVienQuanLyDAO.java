/**
 * 
 */
package qt.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import qt.dto.NhanVienQuanLy;

/**
 * @author tqthe
 * 
 */
@Transactional
public class NhanVienQuanLyDAO {

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
	 * Đánh dấu xóa một NhanVienQuanLy.
	 * 
	 * @param e
	 *            NhanVienQuanLy sẽ bị đánh dấu xóa.
	 */
	public void markAsDeleted(NhanVienQuanLy e) {
		e.setXoa(true);
		makePersistent(e);
	}

	/**
	 * Xóa (vĩnh viễn) một NhanVienQuanLy.
	 * 
	 * @param e
	 *            NhanVienQuanLy sẽ bị xóa.
	 */
	public void makeTransient(NhanVienQuanLy e) {
		factory.getCurrentSession().delete(e);
	}

	/**
	 * Thêm mới hoặc cập nhật một NhanVienQuanLy.
	 * 
	 * @param e
	 *            NhanVienQuanLy sẽ được thêm mới hay cập nhật.
	 * @return NhanVienQuanLy đã được thêm mới hay cập nhật.
	 */
	public NhanVienQuanLy makePersistent(NhanVienQuanLy e) {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(e);
		session.flush();
		return e;
	}

	/**
	 * Tìm một NhanVienQuanLy theo ID.
	 * 
	 * @param id
	 *            id của NhanVienQuanLy cần tìm.
	 * @return NhanVienQuanLy tỉm được. Nếu không tìm thấy trả về null.
	 */
	public NhanVienQuanLy findById(int id) {
		NhanVienQuanLy e = (NhanVienQuanLy) factory.getCurrentSession().get(
				NhanVienQuanLy.class, id);
		return e.isXoa() ? null : e;
	}

	/**
	 * Tìm tất cả các NhanVienQuanLy.
	 * 
	 * @return Danh sách NhanVienQuanLy.
	 */
	@SuppressWarnings("unchecked")
	public List<NhanVienQuanLy> findAll() {
		return factory.getCurrentSession().createCriteria(NhanVienQuanLy.class)
				.add(Restrictions.eq("xoa", false)).list();
	}
}
