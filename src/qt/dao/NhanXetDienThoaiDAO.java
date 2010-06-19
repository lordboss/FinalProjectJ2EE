/**
 * 
 */
package qt.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import qt.dto.NhanXetDienThoai;

/**
 * @author tqthe
 * 
 */
@Transactional
public class NhanXetDienThoaiDAO {

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
	 * Đánh đấu xóa một NhanXetDienThoai. NhanXetDienThoai sẽ không bị xóa thật
	 * sự.
	 * 
	 * @param c
	 *            NhanXetDienThoai bị đánh dấu xóa.
	 */
	public void markAsDeleted(NhanXetDienThoai c) {
		c.setXoa(true);
		makePersistent(c);
	}

	/**
	 * Xóa vĩnh viễn một NhanXetDienThoai.
	 * 
	 * @param c
	 *            NhanXetDienThoai sẽ bị xóa.
	 */
	public void makeTransient(NhanXetDienThoai c) {
		// remove all association before deleting.
		if (c.getKhachHang() != null) {
			c.getKhachHang().getDsNhanXetDienThoai().remove(c);
			c.setKhachHang(null);
		}
		if (c.getDienThoai() != null) {
			c.getDienThoai().getDsNhanXet().remove(c);
			c.setDienThoai(null);
		}

		factory.getCurrentSession().delete(c);
	}

	/**
	 * Thêm mới hoặc cập nhật một NhanXetDienThoai. Việc thêm mới hay cập nhật
	 * được căn cứ trên giá trị ID.
	 * 
	 * @param c
	 *            NhanXetDienThoai sẽ được thêm mới hay cập nhật.
	 * @return NhanXetDienThoai vừa được thêm mới hay cập nhật. Trong trường hợp
	 *         thêm mới giá trị ID sẽ được cập nhật tương ứng.
	 */
	public NhanXetDienThoai makePersistent(NhanXetDienThoai c) {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(c);
		session.flush();
		return c;
	}

	/**
	 * Tìm tất cả NhanXetDienThoai của một KhachHang.
	 * 
	 * @param idKhachHang
	 *            id của KhachHang cần lấy danh sách NhanXetDienThoai.
	 * @return Danh sách NhanXetDienThoai của một KhachHang.
	 */
	@SuppressWarnings("unchecked")
	public List<NhanXetDienThoai> findByKhachHang(int idKhachHang) {
		if (idKhachHang < 0) {
			return findByAnonymous();
		}
		return factory
				.getCurrentSession()
				.createQuery(
						"from NhanXetDienThoai c where c.khachHang.id = :id and c.xoa = false")
				.setInteger("id", idKhachHang).list();
	}

	/**
	 * Tìm các NhanXetDienThoai của Anonymous
	 * 
	 * @return Danh sách NhanXetDienThoai của Anonymous
	 */
	@SuppressWarnings("unchecked")
	public List<NhanXetDienThoai> findByAnonymous() {
		return factory
				.getCurrentSession()
				.createQuery(
						"from NhanXetDienThoai c where c.khachHang is null and c.xoa = false")
				.list();
	}

	/**
	 * Tìm tất cả NhanXetDienThoai của một loại DienThoai.
	 * 
	 * @param idDienThoai
	 *            id của DienThoai cần lấy nhận xét.
	 * @return Danh sách NhanXetDienThoai của một loại DienThoai.
	 */
	@SuppressWarnings("unchecked")
	public List<NhanXetDienThoai> findByDienThoai(int idDienThoai) {
		return factory
				.getCurrentSession()
				.createQuery(
						"from NhanXetDienThoai c where c.dienThoai.id = :id and c.xoa = false")
				.setInteger("id", idDienThoai).list();
	}

	/**
	 * Tìm một NhanXetDienThoai theo ID.
	 * 
	 * @param id
	 *            id của NhanXetDienThoai cần tìm.
	 * @return NhanXetDienThoai tìm được. Trả về null nếu không tìm thấy.
	 */
	public NhanXetDienThoai findById(int id) {
		NhanXetDienThoai c = (NhanXetDienThoai) factory.getCurrentSession()
				.get(NhanXetDienThoai.class, id);
		return c.isXoa() ? null : c;
	}

	/**
	 * Tìm tất cả NhanXetDienThoai.
	 * 
	 * @return Danh sách NhanXetDienThoai tìm được.
	 */
	@SuppressWarnings("unchecked")
	public List<NhanXetDienThoai> findAll() {
		return factory.getCurrentSession().createCriteria(
				NhanXetDienThoai.class).add(Restrictions.eq("xoa", false))
				.addOrder(Order.desc("thoiGian")).list();
	}
}
