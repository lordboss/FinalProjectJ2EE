/**
 * 
 */
package qt.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import qt.dto.ChiTietHinhAnh;

/**
 * @author tqthe
 * 
 */
@Transactional
public class ChiTietHinhAnhDAO {

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
	 * Đánh dấu xóa một ChiTietHinhAnh
	 * 
	 * @param c
	 *            ChiTietHinhAnh bị đánh dấu xóa.
	 */
	public void markAsDeleted(ChiTietHinhAnh c) {
		c.setXoa(true);
		makePersistent(c);
	}

	/**
	 * Xóa (vĩnh viễn) một ChiTietHinhAnh.
	 * 
	 * @param c
	 *            ChiTietHinhAnh sẽ bị xóa.
	 */
	public void makeTransient(ChiTietHinhAnh c) {
		// remove all association before deleting
		if (c.getSanPham() != null) {
			c.getSanPham().getDsHinhAnh().remove(c);
		}
		c.setSanPham(null);

		factory.getCurrentSession().delete(c);
	}

	/**
	 * Thêm mới hoặc cập nhật ChiTietHinhAnh. Việc thêm mới hay cập nhật phụ
	 * thuộc vào ID.
	 * 
	 * @param c
	 *            ChiTietHinhAnh sẽ được thêm mới hay cập nhật.
	 * @return ChiTietHinhAnh vừa được thêm mới hay cập nhật. Trong trường hợp
	 *         thêm mới giá trị của ID sẽ được cập nhật tương ứng.
	 */
	public ChiTietHinhAnh makePersistent(ChiTietHinhAnh c) {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(c);
		session.flush();
		return c;
	}

	/**
	 * Tìm các ChiTietHinhAnh của một SanPham.
	 * 
	 * @param id
	 *            id của SanPham cần tìm danh sách ChiTietHinhAnh.
	 * @return Danh sách ChiTietHinhAnh của SanPham.
	 */
	@SuppressWarnings("unchecked")
	public List<ChiTietHinhAnh> findBySanPham(int id) {
		return factory
				.getCurrentSession()
				.createQuery(
						"from ChiTietHinhAnh c where c.sanPham.id = :id and c.xoa=false")
				.setInteger("id", id).list();
	}

	/**
	 * Tìm một ChiTietHinhAnh theo ID
	 * 
	 * @param id
	 *            id của ChiTietHinhAnh cần tìm.
	 * @return ChiTietHinhAnh tìm được. Nếu không tìm thấy trả về null.
	 */
	public ChiTietHinhAnh findById(int id) {
		ChiTietHinhAnh c = (ChiTietHinhAnh) factory.getCurrentSession().get(
				ChiTietHinhAnh.class, id);
		return c.isXoa() ? null : c;
	}

	/**
	 * Tìm tất cả ChiTietHinhAnh.
	 * 
	 * @return Danh sách ChiTietHinhAnh tìm được.
	 */
	@SuppressWarnings("unchecked")
	public List<ChiTietHinhAnh> findAll() {
		return factory.getCurrentSession().createCriteria(ChiTietHinhAnh.class)
				.add(Restrictions.eq("xoa", false)).list();
	}
}
