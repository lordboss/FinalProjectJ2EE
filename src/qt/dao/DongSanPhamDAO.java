/**
 * 
 */
package qt.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import qt.dto.DongSanPham;

/**
 * @author tqthe
 * 
 */
@Transactional
public class DongSanPhamDAO {

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
	 * Tìm tất cả các DongSanPham (DienThoai).
	 * 
	 * @return Danh sách DongSanPham tìm được.
	 */
	@SuppressWarnings("unchecked")
	public List<DongSanPham> findAll() {
		return factory.getCurrentSession().createCriteria(DongSanPham.class)
				.list();
	}

	/**
	 * Tìm một DongSanPham theo ID.
	 * 
	 * @param id
	 *            Id của DongSanPham cần tìm.
	 * @return DongSanPham tìm được nếu không tìm thấy trả về NULL.
	 */
	public DongSanPham findById(int id) {
		return (DongSanPham) factory.getCurrentSession().get(DongSanPham.class,
				id);
	}

	/**
	 * Thêm mới hay cập nhật một DongSanPham. Việc thêm mới hay cập nhật phụ
	 * thuộc vào giá trị Id.
	 * 
	 * @param d
	 *            DongSanPham sẽ được thêm mới hay cập nhật.
	 * @return DongSanPham sau khi đã thêm mới hoặc cập nhật. Nếu thêm mới giá
	 *         trị id sẽ được cập nhật tương ứng.
	 */
	public DongSanPham makePersistent(DongSanPham d) {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(d);
		session.flush();
		return d;
	}

	/**
	 * <b style="color:red;">This method is intentionally left private for
	 * safety reason.</b>
	 * 
	 * @param d
	 */
	@SuppressWarnings("unused")
	private void makeTransient(DongSanPham d) {
		factory.getCurrentSession().delete(d);
	}

}
