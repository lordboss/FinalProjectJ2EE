/**
 * 
 */
package qt.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import qt.dto.KhachHang;

/**
 * @author tqthe
 * 
 */
@Transactional
public class KhachHangDAO {

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
	 * Tìm một KhachHang theo ID.
	 * 
	 * @param id
	 *            id của KhachHang cần tìm.
	 * @return KhachHang tìm được. Nếu không tìm thấy trả về null.
	 */
	public KhachHang findById(int id) {

		KhachHang k = (KhachHang) factory.getCurrentSession().get(
				KhachHang.class, id);
		return k.isXoa() ? null : k;

		/*
		 * return (KhachHang) factory.getCurrentSession().createCriteria(
		 * KhachHang.class).add(Restrictions.eq("xoa", false)).add(
		 * Restrictions.eq("id", id)).uniqueResult();
		 */
	}

	/**
	 * Tìm tất cả các KhachHang.
	 * 
	 * @return Danh sách KhachHang tìm được.
	 */
	@SuppressWarnings("unchecked")
	public List<KhachHang> findAll() {
		return factory.getCurrentSession().createCriteria(KhachHang.class).add(
				Restrictions.eq("xoa", false)).list();
	}

	/**
	 * Đánh dấu xóa một KhachHang.
	 * 
	 * @param k
	 *            KhachHang sẽ bị đánh dấu xóa.
	 */
	public void markAsDeleted(KhachHang k) {
		k.setXoa(true);
		makePersistent(k);
	}

	/**
	 * Xóa (vĩnh viễn) một KhachHang.
	 * 
	 * @param k
	 *            KhachHang sẽ bị xóa.
	 * @param force
	 * <br>
	 *            Nếu <code>force=true</code> sẽ thực hiện xóa KhachHang và các
	 *            danh sách tương ứng như dsDonHang, dsGopY, dsNhanXetDienThoai. <br>
	 * <br>
	 *            Nếu <code>force=false</code> chỉ xóa được KhachHang nếu
	 *            KhachHang chưa có bất kì đơn hàng, nhận xét hay góp ý nào.
	 * @throws Exception
	 *             Nếu khách hàng đã có danh sách đơn hàng, góp ý hoặc nhận xét
	 *             và tham số <code>force=false</code>
	 */
	public void makeTransient(KhachHang k, boolean force) throws Exception {
		if ((k.getDsDonHang().size() > 0 || k.getDsGopY().size() > 0 || k
				.getDsNhanXetDienThoai().size() > 0)
				&& !force) {
			throw new Exception(
					"Không thể xóa khách hàng đã có danh sách đơn hàng, góp ý hoặc nhận xét!");
		}
		factory.getCurrentSession().delete(k);
	}

	/**
	 * Thêm mới hoặc cập nhật một KhachHang.
	 * 
	 * @param k
	 *            KhachHang sẽ được thêm mới
	 * @return KhachHang đã được thêm mới hay cập nhật.
	 */
	public KhachHang makePersistent(KhachHang k) {
		factory.getCurrentSession().saveOrUpdate(k);
		factory.getCurrentSession().flush();

		return k;
	}
}
