/**
 * 
 */
package qt.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import qt.dto.LoaiPhuKien;

/**
 * @author tqthe
 * 
 */
@Transactional
public class LoaiPhuKienDAO {

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
	 * Xóa (vĩnh viễn) một LoaiPhuKien. <b>Cascade delete có thể xảy ra!!!</b>
	 * 
	 * @param c
	 *            LoaiPhuKien sẽ được xóa.
	 */
	public void makeTransient(LoaiPhuKien c) {
		c.setDsPhuKien(null);
		
		factory.getCurrentSession().delete(c);
	}

	/**
	 * Thêm mới hoặc cập nhật một LoaiPhuKien. Việc thêm mới hay cập nhật được
	 * căn cứ vào ID.
	 * 
	 * @param c
	 *            LoaiPhuKien sẽ được thêm mới hoặc cập nhật.
	 * @return LoaiPhuKien đã được thêm mới hoặc cập nhật. Trong trường hợp thêm
	 *         mới giá trị ID sẽ được cập nhật.
	 */
	public LoaiPhuKien makePersistent(LoaiPhuKien c) {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(c);
		session.flush();
		return c;
	}

	/**
	 * Tìm một LoaiPhuKien theo tên.
	 * 
	 * @param name
	 *            Tên của LoaiPhuKien cần tìm.
	 * @return LoaiPhuKien cần tìm. Nếu không tìm thấy trả về null.
	 */
	public LoaiPhuKien findByName(String name) {
		return (LoaiPhuKien) factory.getCurrentSession().createQuery(
				"from LoaiPhuKien p where p.ten = :name").setString("name",
				name).uniqueResult();
	}

	/**
	 * Tìm một LoaiPhuKien theo ID.
	 * 
	 * @param id
	 *            id của LoaiPhuKien cần tìm.
	 * @return LoaiPhuKien tìm được. Nếu không tìm thấy trả về null.
	 */
	public LoaiPhuKien findById(int id) {
		return (LoaiPhuKien) factory.getCurrentSession().get(LoaiPhuKien.class,
				id);
	}

	/**
	 * Tìm tất cả LoaiPhuKien.
	 * 
	 * @return Danh sách LoaiPhuKien.
	 */
	@SuppressWarnings("unchecked")
	public List<LoaiPhuKien> findAll() {
		return factory.getCurrentSession().createCriteria(LoaiPhuKien.class)
				.list();
	}
}
