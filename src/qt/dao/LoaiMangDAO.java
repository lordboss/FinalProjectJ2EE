/**
 * 
 */
package qt.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import qt.dto.LoaiMang;

/**
 * @author tqthe
 *
 */
@Transactional
public class LoaiMangDAO {

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
	 * Tìm tất cả LoaiMang
	 * 
	 * @return Danh sách LoaiMang
	 */
	@SuppressWarnings("unchecked")
	public List<LoaiMang> findAll() {
		return factory.getCurrentSession().createCriteria(LoaiMang.class)
				.list();
	}

	/**
	 * Tìm một LoaiMang theo ID
	 * 
	 * @param id
	 *            id của LoaiMang cần tìm
	 * @return LoaiMang tìm được. Nếu không tìm thấy trả về null
	 */
	public LoaiMang findById(int id) {
		return (LoaiMang) factory.getCurrentSession().get(LoaiMang.class, id);
	}

	/**
	 * Tìm một LoaiMang theo tên
	 * 
	 * @param name
	 *            Tên của LoaiMang cần tìm.
	 * @return LoaiMang tìm được. Nếu không tìm thấy trả về null.
	 */
	public LoaiMang findByName(String name) {
		return (LoaiMang) factory.getCurrentSession().createQuery(
				"from LoaiMang k where k.ten = :name").setString("name", name)
				.uniqueResult();
	}

	/**
	 * Thêm mới hoặc cập nhật LoaiMang. Việc thêm mới hay cập nhật được căn cứ
	 * vào ID.
	 * 
	 * @param n
	 *            LoaiMang sẽ được thêm mới hoặc cập nhật.
	 * @return LoaiMang vừa được thêm mới hoặc cập nhật. Trong trường hợp thêm
	 *         mới giá trị ID sẽ được cập nhật.
	 */
	public LoaiMang makePersistent(LoaiMang n) {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(n);
		session.flush();
		return n;
	}

	/**
	 * Xóa (vĩnh viễn) một PhongCach.
	 * 
	 * @param n
	 *            : LoaiMang sẽ bị xóa
	 */
	public void makeTransient(LoaiMang n) {
		factory.getCurrentSession().delete(n);
	}
}
