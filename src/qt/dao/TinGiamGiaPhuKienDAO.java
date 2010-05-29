/**
 * 
 */
package qt.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import qt.dto.TinGiamGiaPhuKien;

/**
 * @author tqthe
 * 
 */
@Transactional
public class TinGiamGiaPhuKienDAO {

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
	 * Đánh dấu xóa một TinGiamGiaPhuKien. TinGiamGiaPhuKien sẽ không bị xóa
	 * thật sự.
	 * 
	 * @param tinGiamGiaPhuKien
	 *            TinGiamGiaPhuKien sẽ bị đánh dấu xóa.
	 */
	public void markAsDeleted(TinGiamGiaPhuKien tinGiamGiaPhuKien) {
		tinGiamGiaPhuKien.setXoa(true);
		makePersistent(tinGiamGiaPhuKien);
	}

	/**
	 * Xóa (vĩnh viễn) một TinGiamGiaPhuKien.
	 * 
	 * @param t
	 *            TinGiamGiaPhuKien sẽ bị xóa.
	 */
	public void makeTransient(TinGiamGiaPhuKien t) {
		// remove all association before deleting
		if (t.getPhuKien() != null) {
			t.getPhuKien().getDsTinGiamGiaPhuKien().remove(t);
			t.setPhuKien(null);
		}

		factory.getCurrentSession().delete(t);
	}

	/**
	 * Thêm mới hoặc cập nhật TinGiamGiaPhuKien. Việc thêm mới hay cập nhật phụ
	 * thuộc vào giá trị ID.
	 * 
	 * @param t
	 *            TinGiamGiaPhuKien sẽ được thêm hoặc cập nhật.
	 * @return TinGiamGiaPhuKien vừa được thêm hoặc cập nhật. Trong trường hợp
	 *         thêm mới giá trị ID sẽ được cập nhật tương ứng.
	 */
	public TinGiamGiaPhuKien makePersistent(TinGiamGiaPhuKien t) {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(t);
		session.flush();
		return t;
	}

	/**
	 * Tìm các TinGiamGiaPhuKien của một PhuKien.
	 * 
	 * @param id
	 *            id của PhuKien cần tìm TinGiamGiaPhuKien.
	 * @return Danh sách TinGiamGiaPhuKien của một PhuKien.
	 */
	@SuppressWarnings("unchecked")
	public List<TinGiamGiaPhuKien> findByPhuKien(int id) {
		return factory
				.getCurrentSession()
				.createQuery(
						"from TinGiamGiaPhuKien t where t.phuKien.id = :id and t.xoa = false")
				.setInteger("id", id).list();
	}

	/**
	 * Tìm một TinGiamGiaPhuKien theo ID.
	 * 
	 * @param id
	 *            id của TinGiamGiaPhuKien cần tìm.
	 * @return TinGiamGiaPhuKien tìm được. Nếu không tìm thấy trả về null.
	 */
	public TinGiamGiaPhuKien findById(int id) {
		TinGiamGiaPhuKien t = (TinGiamGiaPhuKien) factory.getCurrentSession()
				.get(TinGiamGiaPhuKien.class, id);
		return t.isXoa() ? null : t;
	}

	/**
	 * Tìm tất cả TinGiamGiaPhuKien
	 * 
	 * @return Danh sách TinGiamGiaPhuKien tìm được.
	 */
	@SuppressWarnings("unchecked")
	public List<TinGiamGiaPhuKien> findAll() {
		return factory.getCurrentSession().createCriteria(
				TinGiamGiaPhuKien.class).add(Restrictions.eq("xoa", false))
				.list();
	}
}
