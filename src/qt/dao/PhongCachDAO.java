/**
 * 
 */
package qt.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import qt.dto.PhongCach;

/**
 * @author tqthe
 *
 */
@Transactional
public class PhongCachDAO {

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
	 * Tìm tất cả PhongCach
	 * 
	 * @return Danh sách PhongCach
	 */
	@SuppressWarnings("unchecked")
	public List<PhongCach> findAll() {
		return factory.getCurrentSession().createCriteria(PhongCach.class)
				.list();
	}

	/**
	 * Tìm một PhongCach theo ID
	 * 
	 * @param id
	 *            id của PhongCach cần tìm
	 * @return PhongCach tìm được. Nếu không tìm thấy trả về null
	 */
	public PhongCach findById(int id) {
		return (PhongCach) factory.getCurrentSession().get(PhongCach.class, id);
	}

	/**
	 * Tìm một PhongCach theo tên
	 * 
	 * @param name
	 *            Tên của PhongCach cần tìm.
	 * @return PhongCach tìm được. Nếu không tìm thấy trả về null.
	 */
	public PhongCach findByName(String name) {
		return (PhongCach) factory.getCurrentSession().createQuery(
				"from PhongCach k where k.ten = :name").setString("name", name)
				.uniqueResult();
	}

	/**
	 * Thêm mới hoặc cập nhật PhongCach. Việc thêm mới hay cập nhật được căn cứ
	 * vào ID.
	 * 
	 * @param p
	 *            PhongCach sẽ được thêm mới hoặc cập nhật.
	 * @return PhongCach vừa được thêm mới hoặc cập nhật. Trong trường hợp thêm
	 *         mới giá trị ID sẽ được cập nhật.
	 */
	public PhongCach makePersistent(PhongCach p) {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(p);
		session.flush();
		return p;
	}

	/**
	 * Xóa (vĩnh viễn) một PhongCach. 
	 * 
	 * @param p
	 *            : PhongCach sẽ bị xóa
	 */
	public void makeTransient(PhongCach p) {
		p.setDsDienThoai(null);
		
		factory.getCurrentSession().delete(p);
	}
}
