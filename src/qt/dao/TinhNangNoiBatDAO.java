/**
 * 
 */
package qt.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import qt.dto.TinhNangNoiBat;

/**
 * @author tqthe
 * 
 */
@Transactional
public class TinhNangNoiBatDAO {

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
	 * Đánh dấu xóa một TinhNangNoiBat.
	 * 
	 * @param t
	 *            TinhNangNoiBat sẽ bị đánh dấu xóa.
	 */
	public void markAsDeleted(TinhNangNoiBat t) {
		t.setXoa(true);
		makePersistent(t);
	}

	/**
	 * Xóa (vĩnh viễn) một TinhNangNoiBat.
	 * 
	 * @param t
	 *            TinhNangNoiBat sẽ được xóa.
	 */
	public void makeTransient(TinhNangNoiBat t) {
		// remove all association before deleting
		if (t.getDienThoai() != null) {
			t.getDienThoai().getDsTinhNangNoiBat().remove(t);
			t.setDienThoai(null);
		}

		factory.getCurrentSession().delete(t);
	}

	/**
	 * Thêm mới hoặc cập nhật một TinhNangNoiBat.
	 * 
	 * @param t
	 *            TinhNangNoiBat được thêm mới hay cập nhật.
	 * @return TinhNangNoiBat vừa được thêm mới hay cập nhật.
	 */
	public TinhNangNoiBat makePersistent(TinhNangNoiBat t) {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(t);
		session.flush();
		return t;
	}

	/**
	 * Tìm một TinhNangNoiBat theo ID
	 * 
	 * @param id
	 *            id của TinhNangNoiBat.
	 * @return TinhNangNoiBat tìm được. Nếu không tìm thấy trả về null.
	 */
	public TinhNangNoiBat findById(int id) {
		TinhNangNoiBat t = (TinhNangNoiBat) factory.getCurrentSession().get(
				TinhNangNoiBat.class, id);
		return t.isXoa() ? null : t;
	}

	/**
	 * Tìm tất cả TinhNangNoiBat.
	 * 
	 * @return Danh sách TinhNangNoiBat.
	 */
	@SuppressWarnings("unchecked")
	public List<TinhNangNoiBat> findAll() {
		return factory.getCurrentSession().createCriteria(TinhNangNoiBat.class)
				.add(Restrictions.eq("xoa", false)).list();
	}

	/**
	 * Tìm các TinhNangNoiBat của một điện thoại.
	 * 
	 * @param idDienThoai
	 *            id của DienThoai cần tìm tính năng nỗi bật.
	 * @return Danh sách TinhNangNoiBat của một DienThoai.
	 */
	@SuppressWarnings("unchecked")
	public List<TinhNangNoiBat> findByDienThoai(int idDienThoai) {
		return factory
				.getCurrentSession()
				.createQuery(
						"from TinhNangNoiBat t where t.dienThoai.id = :id and t.xoa = false")
				.setInteger("id", idDienThoai).list();
	}

}
