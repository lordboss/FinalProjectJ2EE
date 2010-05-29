/**
 * 
 */
package qt.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import qt.dto.HinhThucThanhToan;

/**
 * @author tqthe
 * 
 */
@Transactional
public class HinhThucThanhToanDAO {

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
	 * Xóa (vĩnh viễn) một HinhThucThanhToan. 
	 * 
	 * @param h
	 *            HinhThucThanhToan sẽ bị xóa.
	 */
	public void makeTransient(HinhThucThanhToan h) {
		h.setDsDonHang(null);
		
		factory.getCurrentSession().delete(h);
	}

	/**
	 * Thêm mới hoặc cập nhật một HinhThucThanhToan. Việc thêm mới hay cập nhật
	 * được căn cứ vào ID.
	 * 
	 * @param h
	 *            HinhThucThanhToan sẽ được thêm hoặc cập nhật.
	 * @return HinhThucThanhToan vừa được thêm hoặc cập nhật. Giá trị ID sẽ được
	 *         cập nhật trong trường hợp thêm mới.
	 */
	public HinhThucThanhToan makePersistent(HinhThucThanhToan h) {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(h);
		session.flush();
		return h;
	}

	/**
	 * Tìm một HinhThucThanhToan theo tên.
	 * 
	 * @param name
	 *            tên của HinhThucThanhToan cần tìm.
	 * @return HinhThucThanhToan tìm được. Nếu không tìm thấy trả về null.
	 */
	public HinhThucThanhToan findByName(String name) {
		return (HinhThucThanhToan) factory.getCurrentSession().createQuery(
				"from HinhThucThanhToan h where h.hinhThuc = :name").setString(
				"name", name).uniqueResult();
	}

	/**
	 * Tìm một HinhThucThanhToan theo ID.
	 * 
	 * @param id
	 *            id của HinhThucThanhToan cần tìm.
	 * @return HinhThucThanhToan tìm được. Nếu không tìm thấy trả về null.
	 */
	public HinhThucThanhToan findById(int id) {
		return (HinhThucThanhToan) factory.getCurrentSession().get(
				HinhThucThanhToan.class, id);
	}

	/**
	 * Tìm tất cả HinhThucThanhToan.
	 * 
	 * @return Danh sách HinhThucThanhToan.
	 */
	@SuppressWarnings("unchecked")
	public List<HinhThucThanhToan> findAll() {
		return factory.getCurrentSession().createCriteria(
				HinhThucThanhToan.class).list();
	}
}
