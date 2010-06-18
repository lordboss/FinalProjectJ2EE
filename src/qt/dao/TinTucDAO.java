/**
 * 
 */
package qt.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import qt.dto.TinTuc;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * @author tqthe
 * 
 */
@Transactional
public class TinTucDAO {

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
	 * Lấy tất cả tin tức
	 * 
	 * @return Danh sách tin tức.
	 */
	@SuppressWarnings("unchecked")
	public List<TinTuc> findAll() {
		return factory.getCurrentSession().createCriteria(TinTuc.class).add(
				Restrictions.eq("xoa", false)).addOrder(Order.desc("ngayDang")).list();
	}

	/**
	 * Tìm một TinTuc theo id
	 * 
	 * @param id
	 *            id của TinTuc cần tìm
	 * @return Một TinTuc hoặc null nếu không tìm thấy
	 */
	public TinTuc findById(int id) {
		TinTuc t =  (TinTuc) factory.getCurrentSession().get(TinTuc.class, id);
		return t.isXoa() == false ? t : null;
	}

	/**
	 * Tìm TinTuc theo LoaiTinTuc
	 * 
	 * @param idLoaiTinTuc
	 *            id của LoaiTinTuc
	 * @return Danh sách TinTuc tìm được. Danh sách rỗng nếu không tìm thấy.
	 */
	@SuppressWarnings("unchecked")
	public List<TinTuc> findByLoaiTinTuc(int idLoaiTinTuc) {
		return factory
				.getCurrentSession()
				.createQuery(
						"from TinTuc t where t.loaiGopY.id = :id and t.xoa = false")
				.setInteger("id", idLoaiTinTuc).list();
	}

	public List<TinTuc> findByNgayDang(Date dFrom, Date dTo) {
		throw new NotImplementedException();
	}

	/**
	 * Thêm mới hoặc cập nhật một tin tức. (ID sẽ được cập nhật nếu thêm mới)
	 * 
	 * @param t
	 *            TinTuc cần được thêm hoặc cập nhật
	 * @return TinTuc vừa mới được thêm hoặc cập nhật
	 */
	public TinTuc makePersistent(TinTuc t) {
		factory.getCurrentSession().saveOrUpdate(t);
		factory.getCurrentSession().flush();
		return t;
	}

	/**
	 * Xóa (vĩnh viễn) một tin tức
	 * 
	 * @param t
	 *            TinTuc bị xóa
	 */
	public void makeTransient(TinTuc t) {
		// remove all association before deleting
		if (t.getLoaiTinTuc() != null) {
			t.getLoaiTinTuc().getDsTinTuc().remove(t);
		}
		t.setLoaiTinTuc(null);

		factory.getCurrentSession().delete(t);
	}

	/**
	 * Đánh dấu xóa một TinTuc. TinTuc chỉ bị đánh dấu xóa chứ không bị xóa thật
	 * sự.
	 * 
	 * @param t
	 *            TinTuc bị đánh dấu xóa
	 */
	public void markAsDeleted(TinTuc t) {
		if (t != null) {
			t.setXoa(true);
			makePersistent(t);
		}
	}

}
