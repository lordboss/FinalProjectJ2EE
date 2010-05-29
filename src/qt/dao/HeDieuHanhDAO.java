/**
 * 
 */
package qt.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import qt.dto.HeDieuHanh;

/**
 * @author tqthe
 * 
 */
@Transactional
public class HeDieuHanhDAO {

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
	 * Tìm tất cả HeDieuHanh
	 * 
	 * @return Danh sách HeDieuHanh
	 */
	@SuppressWarnings("unchecked")
	public List<HeDieuHanh> findAll() {
		return factory.getCurrentSession().createCriteria(HeDieuHanh.class)
				.list();
	}

	/**
	 * Tìm một HeDieuHanh theo id
	 * 
	 * @param id
	 *            id của HeDieuHanh cần tìm
	 * @return HeDieuHanh tìm được. Nếu không tìm thấy trả về null.
	 */
	public HeDieuHanh findById(int id) {
		return (HeDieuHanh) factory.getCurrentSession().get(HeDieuHanh.class,
				id);
	}

	/**
	 * Tìm một HeDieuHanh theo tên.
	 * 
	 * @param name
	 *            Tên của HeDieuHanh cần tìm.
	 * @return HeDieuHanh tìm được. Nếu không tìm thấy trả về null.
	 */
	public HeDieuHanh findByName(String name) {
		return (HeDieuHanh) factory.getCurrentSession().createQuery(
				"from HeDieuHanh h where h.ten = :name")
				.setString("name", name).uniqueResult();
	}

	/**
	 * Thêm mới hoặc cập nhật một HeDieuHanh. Việc thêm mới hay cập nhật được
	 * căn cứ theo ID.
	 * 
	 * @param h
	 *            HeDieuHanh sẽ được thêm mới hay cập nhật.
	 * @return HeDieuHanh vừa được thêm mới hay cập nhật. Trong trường hợp thêm
	 *         mới giá trị id được cập nhật.
	 */
	public HeDieuHanh makePersistent(HeDieuHanh h) {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(h);
		session.flush();
		return h;
	}

	/**
	 * Xóa (vĩnh viễn) một HeDieuHanh.
	 * 
	 * @param h
	 *            HeDieuHanh sẽ bị xóa.
	 */
	public void makeTransient(HeDieuHanh h) {
		h.setDsDienThoai(null);

		factory.getCurrentSession().delete(h);
	}
}
