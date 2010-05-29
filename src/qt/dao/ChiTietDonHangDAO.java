/**
 * 
 */
package qt.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import qt.dto.ChiTietDonHang;

/**
 * @author tqthe
 * 
 */
@Transactional
public class ChiTietDonHangDAO {

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
	 * Đánh dấu xóa một ChiTietDonHang
	 * 
	 * @param c
	 *            ChiTietDonHang sẽ bị đánh dấu xóa.
	 */
	public void markAsDeleted(ChiTietDonHang c) {
		c.setXoa(true);
		makePersistent(c);
	}

	/**
	 * Xóa (vĩnh viễn) một ChiTietDonHang.
	 * 
	 * @param c
	 *            ChiTietDonHang sẽ bị xóa.
	 */
	public void makeTransient(ChiTietDonHang c) {
		// remove all association before deleting
		if (c.getDonHang() != null) {
			c.getDonHang().getDsChiTietDonHang().remove(c);
			c.setDonHang(null);
		}
		if (c.getSanPham() != null) {
			c.getSanPham().getDsChiTietDonHang().remove(c);
			c.setSanPham(null);
		}

		factory.getCurrentSession().delete(c);
	}

	/**
	 * Thêm mới hay cập nhật một ChiTietDonHang. Việc thêm mới hay cập nhật phụ
	 * thuộc vào giá trị ID.
	 * 
	 * @param c
	 *            ChiTietDonHang sẽ được thêm mới hoặc cập nhật.
	 * @return ChiTietDonHang đã được thêm mới hoặc cập nhật. Trong trường hợp
	 *         thêm mới giá trị ID sẽ được cập nhật tương ứng.
	 */
	public ChiTietDonHang makePersistent(ChiTietDonHang c) {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(c);
		session.flush();
		return c;
	}

	/**
	 * Tìm các ChiTietDonHang của một SanPham
	 * 
	 * @param idSanPham
	 *            id của SanPham.
	 * @return Danh sách ChiTietDonHang của SanPham.
	 */
	@SuppressWarnings("unchecked")
	public List<ChiTietDonHang> findBySanPham(int idSanPham) {
		return factory
				.getCurrentSession()
				.createQuery(
						"from ChiTietDonHang c where c.sanPham.id = :id and c.xoa = false")
				.setInteger("id", idSanPham).list();
	}

	/**
	 * Tìm các ChiTietDonHang của một DonHang.
	 * 
	 * @param idDonHang
	 *            id của DonHang.
	 * @return Danh sách ChiTietDonHang của DonHang.
	 */
	@SuppressWarnings("unchecked")
	public List<ChiTietDonHang> findByDonHang(int idDonHang) {
		return factory
				.getCurrentSession()
				.createQuery(
						"from ChiTietDonHang c where c.donHang.id = :id  and c.xoa = false")
				.setInteger("id", idDonHang).list();
	}

	/**
	 * Tìm một ChiTietDonHang theo ID
	 * 
	 * @param id
	 *            id của ChiTietDonHang cần tìm.
	 * @return ChiTietDonHang tìm được. Nếu không tìm thấy trả về null.
	 */
	public ChiTietDonHang findById(int id) {
		ChiTietDonHang c = (ChiTietDonHang) factory.getCurrentSession().get(
				ChiTietDonHang.class, id);
		return c.isXoa() ? null : c;
	}

	/**
	 * Tìm tất cả ChiTietDonHang.
	 * 
	 * @return Danh sách ChiTietDonHang tìm được.
	 */
	@SuppressWarnings("unchecked")
	public List<ChiTietDonHang> findAll() {
		return factory.getCurrentSession().createCriteria(ChiTietDonHang.class)
				.add(Restrictions.eq("xoa", false)).list();
	}
}
