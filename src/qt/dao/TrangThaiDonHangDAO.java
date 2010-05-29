/**
 * 
 */
package qt.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import qt.dto.TrangThaiDonHang;

/**
 * @author tqthe
 * 
 */
@Transactional
public class TrangThaiDonHangDAO {

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
	 * Thêm hoặc cập nhật một TrangThaiDonHang. Việc thêm hay cập nhật được căn
	 * cứ theo giá trị ID.
	 * 
	 * @param t
	 *            TrangThaiDonHang sẽ được thêm hoặc cập nhật.
	 * @return TrangThaiDonHang vừa được thêm hoặc cập nhật. Trong trường hợp
	 *         thêm mới, giá trị ID sẽ được cập nhật.
	 */
	public TrangThaiDonHang makePersistent(TrangThaiDonHang t) {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(t);
		session.flush();
		return t;
	}

	/**
	 * Xóa (vĩnh viễn) một TrangThaiDonHang. 
	 * 
	 * @param t
	 *            TrangThaiDonHang sẽ bị xóa.
	 */
	public void makeTransient(TrangThaiDonHang t) {
		t.setDsDonHang(null);
		
		factory.getCurrentSession().delete(t);
	}

	/**
	 * Tìm một TrangThaiDonHang theo tên.
	 * 
	 * @param name
	 *            Tên của TrangThaiDonHang cần tìm.
	 * @return TrangThaiDonHang tìm được. Nếu không tìm thấy trả về null.
	 */
	public TrangThaiDonHang findByName(String name) {
		return (TrangThaiDonHang) factory.getCurrentSession().createQuery(
				"from TrangThaiDonHang t where t.trangThai = :name").setString(
				"name", name).uniqueResult();
	}

	/**
	 * Tìm một TrangThaiDonHang theo ID.
	 * 
	 * @param id
	 *            id của TrangThaiDonHang cần tìm.
	 * @return TrangThaiDonHang tìm được. Nếu không tìm thấy trả về null.
	 */
	public TrangThaiDonHang findById(int id) {
		return (TrangThaiDonHang) factory.getCurrentSession().get(
				TrangThaiDonHang.class, id);
	}

	/**
	 * Tìm tất cả TrangThaiDonHang.
	 * 
	 * @return Danh sách TrangThaiDonHang.
	 */
	@SuppressWarnings("unchecked")
	public List<TrangThaiDonHang> findAll() {
		return factory.getCurrentSession().createCriteria(
				TrangThaiDonHang.class).list();
	}
}
