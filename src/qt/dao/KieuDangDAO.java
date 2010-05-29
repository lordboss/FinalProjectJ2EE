/**
 * 
 */
package qt.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import qt.dto.KieuDang;

/**
 * @author tqthe
 * 
 */
@Transactional
public class KieuDangDAO {

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
	 * Tìm tất cả KieuDang
	 * 
	 * @return Danh sách KieuDang
	 */
	@SuppressWarnings("unchecked")
	public List<KieuDang> findAll() {
		return factory.getCurrentSession().createCriteria(KieuDang.class)
				.list();
	}

	/**
	 * Tìm một KieuDang theo ID
	 * 
	 * @param id
	 *            id của KieuDang cần tìm
	 * @return KieuDang tìm được. Nếu không tìm thấy trả về null
	 */
	public KieuDang findById(int id) {
		return (KieuDang) factory.getCurrentSession().get(KieuDang.class, id);
	}

	/**
	 * Tìm một KieuDang theo tên
	 * 
	 * @param name
	 *            Tên của KieuDang cần tìm.
	 * @return KieuDang tìm được. Nếu không tìm thấy trả về null.
	 */
	public KieuDang findByName(String name) {
		return (KieuDang) factory.getCurrentSession().createQuery(
				"from KieuDang k where k.ten = :name").setString("name", name)
				.uniqueResult();
	}

	/**
	 * Thêm mới hoặc cập nhật KieuDang. Việc thêm mới hay cập nhật được căn cứ
	 * vào ID.
	 * 
	 * @param k
	 *            KieuDang sẽ được thêm mới hoặc cập nhật.
	 * @return KieuDang vừa được thêm mới hoặc cập nhật. Trong trường hợp thêm
	 *         mới giá trị ID sẽ được cập nhật.
	 */
	public KieuDang makePersistent(KieuDang k) {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(k);
		session.flush();
		return k;
	}

	/**
	 * Xóa (vĩnh viễn) một KieuDang.
	 * 
	 * @param k
	 *            : KieuDang sẽ bị xóa
	 */
	public void makeTransient(KieuDang k) {
		k.setDsDienThoai(null);

		factory.getCurrentSession().delete(k);
	}
}
