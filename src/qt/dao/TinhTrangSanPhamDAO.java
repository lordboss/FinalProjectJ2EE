/**
 * 
 */
package qt.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import qt.dto.TinhTrangSanPham;

/**
 * @author tqthe
 * 
 */
@Transactional
public class TinhTrangSanPhamDAO {

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
	 * Tìm tất cả TinhTrangSanPham
	 * 
	 * @return Danh sách TinhTrangSanPham
	 */
	@SuppressWarnings("unchecked")
	public List<TinhTrangSanPham> findAll() {
		return factory.getCurrentSession().createCriteria(
				TinhTrangSanPham.class).list();
	}

	/**
	 * Tìm một TinhTrangSanPham theo ID
	 * 
	 * @param id
	 *            id của TinhTrangSanPham cần tìm
	 * @return TinhTrangSanPham tìm thấy. Nếu không tìm thấy trả về null.
	 */
	public TinhTrangSanPham findById(int id) {
		return (TinhTrangSanPham) factory.getCurrentSession().get(
				TinhTrangSanPham.class, id);
	}

	/**
	 * Tìm một TinhTrangSanPham theo tên.
	 * 
	 * @param name
	 *            Tên của TinhTrangSanPham cần tìm.
	 * @return TinhTrangSanPham tìm được. Nếu không tìm thấy trả về null.
	 */
	public TinhTrangSanPham findByName(String name) {
		return (TinhTrangSanPham) factory.getCurrentSession().createQuery(
				"from TinhTrangSanPham t where t.tinhTrang = :name").setString(
				"name", name).uniqueResult();
	}

	/**
	 * Thêm mới hoặc cập nhật TinhTrangSanPham. Việc thêm mới hay cập nhật được
	 * căn cứ vào ID.
	 * 
	 * @param t
	 *            TinhTrangSanPham sẽ được thêm mới hay cập nhật.
	 * @return TinhTrangSanPham vừa được thêm mới hoặc cập nhật. Trong trường
	 *         hợp thêm mới giá trị ID sẽ được cập nhật.
	 */
	public TinhTrangSanPham makePersistent(TinhTrangSanPham t) {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(t);
		session.flush();
		return t;
	}

	/**
	 * Xóa (vĩnh viễn) một TinhTrangSanPham.
	 * 
	 * @param t
	 *            TinhTrangSanPham sẽ bị xóa.
	 */
	public void makeTransient(TinhTrangSanPham t) {
		t.setDsSanPham(null);
		factory.getCurrentSession().delete(t);
	}
}
