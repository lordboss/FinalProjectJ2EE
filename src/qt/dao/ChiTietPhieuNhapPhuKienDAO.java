/**
 * 
 */
package qt.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import qt.dto.ChiTietPhieuNhapPhuKien;

/**
 * @author tqthe
 * 
 */
@Transactional
public class ChiTietPhieuNhapPhuKienDAO {

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
	 * Đánh dấu xóa một ChiTietPhieuNhapPhuKien. ChiTietPhieuNhapPhuKien sẽ
	 * không bị xóa thực sự.
	 * 
	 * @param c
	 *            ChiTietPhieuNhapPhuKien sẽ bị đánh dấu xóa.
	 */
	public void markAsDeleted(ChiTietPhieuNhapPhuKien c) {
		c.setXoa(true);
		makePersistent(c);
	}

	/**
	 * Xóa (vĩnh viễn) một ChiTietPhieuNhapPhuKien.
	 * 
	 * @param c
	 *            ChiTietPhieuNhapPhuKien sẽ bị xóa.
	 */
	public void makeTransient(ChiTietPhieuNhapPhuKien c) {
		// remove all association before deleting
		if (c.getPhuKien() != null) {
			c.getPhuKien().getDsChiTietNhapPhuKien().remove(c);
			c.setPhuKien(null);
		}
		if (c.getPhieuNhapPhuKien() != null) {
			c.getPhieuNhapPhuKien().getDsChiTietPhieuNhapPhuKien().remove(c);
			c.setPhieuNhapPhuKien(null);
		}

		factory.getCurrentSession().delete(c);
	}

	/**
	 * Thêm mới hoặc cập nhật ChiTietPhieuNhapPhuKien. Việc thêm mới hay cập
	 * nhật phụ thuộc vào giá trị của ID.
	 * 
	 * @param c
	 *            ChiTietPhieuNhapPhuKien sẽ được thêm mới hay cập nhật.
	 * @return ChiTietPhieuNhapPhuKien vừa được thêm mới hoặc cập nhật. Trong
	 *         trường hợp thêm mới giá trị của ID sẽ được cập nhật.
	 */
	public ChiTietPhieuNhapPhuKien makePersistent(ChiTietPhieuNhapPhuKien c) {

		Session session = factory.getCurrentSession();
		session.saveOrUpdate(c);
		session.flush();
		return c;
	}

	/**
	 * Tìm các ChiTietPhieuNhapPhuKien của PhieuNhapPhuKien
	 * 
	 * @param idPhieuNhapPhuKien
	 *            id của PhieuNhapPhuKien
	 * @return Danh sách ChiTietPhieuNhapPhuKien của PhieuNhapPhuKien.
	 */
	@SuppressWarnings("unchecked")
	public List<ChiTietPhieuNhapPhuKien> findByPhieuNhapPhuKien(
			int idPhieuNhapPhuKien) {
		return factory
				.getCurrentSession()
				.createQuery(
						"from ChiTietPhieuNhapPhuKien c where c.phieuNhapPhuKien.id = :id and c.xoa = false")
				.setInteger("id", idPhieuNhapPhuKien).list();
	}

	/**
	 * Tìm các ChiTietPhieuNhapPhuKien của một PhuKien.
	 * 
	 * @param idPhuKien
	 *            id của PhuKien.
	 * @return Danh sách ChiTietPhieuNhapPhuKien của PhuKien.
	 */
	@SuppressWarnings("unchecked")
	public List<ChiTietPhieuNhapPhuKien> findByPhuKien(int idPhuKien) {
		return factory
				.getCurrentSession()
				.createQuery(
						"from ChiTietPhieuNhapPhuKien c where c.phuKien.id = :id and c.xoa = false")
				.setInteger("id", idPhuKien).list();
	}

	/**
	 * Tìm một ChiTietPhieuNhapPhuKien theo ID.
	 * 
	 * @param id
	 *            id của ChiTietPhieuNhapPhuKien cần tìm.
	 * @return ChiTietPhieuNhapPhuKien cần tìm. Nếu không tìm thấy trả về null.
	 */
	public ChiTietPhieuNhapPhuKien findById(int id) {
		ChiTietPhieuNhapPhuKien c = (ChiTietPhieuNhapPhuKien) factory
				.getCurrentSession().get(ChiTietPhieuNhapPhuKien.class, id);
		return c.isXoa() ? null : c;
	}

	/**
	 * Tìm tất cả ChiTietPhieuNhapPhuKien.
	 * 
	 * @return Danh sách ChiTietPhieuNhapPhuKien tìm được.
	 */
	@SuppressWarnings("unchecked")
	public List<ChiTietPhieuNhapPhuKien> findAll() {
		return factory.getCurrentSession().createCriteria(
				ChiTietPhieuNhapPhuKien.class).add(
				Restrictions.eq("xoa", false)).list();
	}
}
