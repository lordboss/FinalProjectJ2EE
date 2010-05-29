/**
 * 
 */
package qt.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import qt.dto.ChiTietTinKhuyenMaiDienThoai;

/**
 * @author tqthe
 * 
 */
@Transactional
public class ChiTietTinKhuyenMaiDienThoaiDAO {

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
	 * Đánh dấu xóa một ChiTietTinKhuyenMaiDienThoai.
	 * ChiTietTinKhuyenMaiDienThoai bị đánh dấu xóa sẽ không bị xóa thật sự.
	 * 
	 * @param c
	 *            ChiTietTinKhuyenMaiDienThoai sẽ bị đánh dấu xóa.
	 */
	public void markAsDeleted(ChiTietTinKhuyenMaiDienThoai c) {
		c.setXoa(true);
		makePersistent(c);
	}

	/**
	 * Xóa (vĩnh viễn) một ChiTietTinKhuyenMaiDienThoai.
	 * 
	 * @param c
	 *            ChiTietTinKhuyenMaiDienThoai sẽ bị xóa.
	 */
	public void makeTransient(ChiTietTinKhuyenMaiDienThoai c) {
		// remove all association before deleting
		if (c.getDienThoai() != null) {
			c.getDienThoai().getDsChiTietKhuyenMai().remove(c);
			c.setDienThoai(null);
		}
		if (c.getTinKhuyenMai() != null) {
			c.getTinKhuyenMai().getDsChiTietTinKhuyenMaiDienThoai().remove(c);
			c.setTinKhuyenMai(null);
		}

		factory.getCurrentSession().delete(c);
	}

	/**
	 * Thêm mới hoặc cập nhật một ChiTietTinKhuyenMaiDienThoai. Việc thêm mới
	 * hay cập nhật được căn cứ trên giá trị ID.
	 * 
	 * @param c
	 *            ChiTietTinKhuyenMaiDienThoai sẽ được thêm mới hay cập nhật.
	 * @return ChiTietTinKhuyenMaiDienThoai đã được thêm mới hoặc cập nhật.
	 *         Trong trường hợp thêm mới giá trị ID sẽ được cập nhật tương ứng.
	 */
	public ChiTietTinKhuyenMaiDienThoai makePersistent(
			ChiTietTinKhuyenMaiDienThoai c) {

		Session session = factory.getCurrentSession();
		session.saveOrUpdate(c);
		session.flush();
		return c;
	}

	/**
	 * Tìm các ChiTietTinKhuyenMaiDienThoai của một TinKhuyenMaiDienThoai
	 * 
	 * @param idTinKhuyenMai
	 *            id của TinKhuyenMaiDienThoai.
	 * @return Danh sách ChiTietTinKhuyenMaiDienThoai tìm được.
	 */
	@SuppressWarnings("unchecked")
	public List<ChiTietTinKhuyenMaiDienThoai> findByTinKhuyenMai(
			int idTinKhuyenMai) {
		return factory
				.getCurrentSession()
				.createQuery(
						"from ChiTietTinKhuyenMaiDienThoai c where c.tinKhuyenMai.id = :id and c.xoa = false")
				.setInteger("id", idTinKhuyenMai).list();
	}

	/**
	 * Tìm các ChiTietTinKhuyenMaiDienThoai của một DienThoai.
	 * 
	 * @param idDienThoai
	 *            id của DienThoai.
	 * @return Danh sách ChiTietTinKhuyenMaiDienThoai của DienThoai.
	 */
	@SuppressWarnings("unchecked")
	public List<ChiTietTinKhuyenMaiDienThoai> findByDienThoai(int idDienThoai) {
		return factory
				.getCurrentSession()
				.createQuery(
						"from ChiTietTinKhuyenMaiDienThoai c where c.dienThoai.id = :id and c.xoa = false")
				.setInteger("id", idDienThoai).list();
	}

	/**
	 * Tìm một ChiTietTinKhuyenMaiDienThoai theo ID.
	 * 
	 * @param id
	 *            id của ChiTietTinKhuyenMaiDienThoai cần tìm.
	 * @return ChiTietTinKhuyenMaiDienThoai tìm được. Nếu không tìm thấy trả về
	 *         null.
	 */
	public ChiTietTinKhuyenMaiDienThoai findById(int id) {
		ChiTietTinKhuyenMaiDienThoai c = (ChiTietTinKhuyenMaiDienThoai) factory
				.getCurrentSession()
				.get(ChiTietTinKhuyenMaiDienThoai.class, id);
		return c.isXoa() ? null : c;
	}

	/**
	 * Tìm tất cả các ChiTietTinKhuyenMaiDienThoai.
	 * 
	 * @return Danh sách ChiTietTinKhuyenMaiDienThoai tìm được.
	 */
	@SuppressWarnings("unchecked")
	public List<ChiTietTinKhuyenMaiDienThoai> findAll() {
		return factory.getCurrentSession().createCriteria(
				ChiTietTinKhuyenMaiDienThoai.class).add(
				Restrictions.eq("xoa", false)).list();
	}
}
