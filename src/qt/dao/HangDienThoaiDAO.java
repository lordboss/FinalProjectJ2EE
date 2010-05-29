/**
 * 
 */
package qt.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import qt.dto.HangDienThoai;

/**
 * @author tqthe
 * 
 */
@Transactional
public class HangDienThoaiDAO {

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
	 * Tìm tất cả các HangDienThoai.
	 * 
	 * @return Danh sách các HangDienThoai
	 */
	@SuppressWarnings("unchecked")
	public List<HangDienThoai> findAll() {
		return factory.getCurrentSession().createCriteria(HangDienThoai.class)
				.list();
	}

	/**
	 * Tìm một HangDienThoai theo id
	 * 
	 * @param id
	 *            id của HangDienThoai cần tìm
	 * @return HangDienThoai tìm được. Nếu không tìm thấy trả về null
	 */
	public HangDienThoai findById(int id) {
		return (HangDienThoai) factory.getCurrentSession().get(
				HangDienThoai.class, id);
	}

	/**
	 * Thêm mới hoặc cập nhật một HangDienThoai. Việc thêm mới hay cập nhật được
	 * căn cứ trên ID.
	 * 
	 * @param h
	 *            HangDienThoai sẽ được thêm mới hoặc cập nhật.
	 * @return HangDienThoai đã được thêm mới hoặc cập nhật. Giá trị id sẽ được
	 *         cập nhật trong trường hợp thêm mới.
	 */
	public HangDienThoai makePersistent(HangDienThoai h) {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(h);
		session.flush();
		return h;
	}

	/**
	 * Xóa (vĩnh viễn) một HangDienThoai.
	 * 
	 * @param h
	 *            HangDienThoai sẽ bị xóa
	 */
	public void makeTransient(HangDienThoai h) {
		// be very confused here!
		// prevent cascade delete
		h.setDsDienThoai(null);

		factory.getCurrentSession().delete(h);
	}
}
