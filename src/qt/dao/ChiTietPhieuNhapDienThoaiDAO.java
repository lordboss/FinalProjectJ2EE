/**
 * 
 */
package qt.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import qt.dto.ChiTietPhieuNhapDienThoai;

/**
 * @author tqthe
 * 
 */
@Transactional
public class ChiTietPhieuNhapDienThoaiDAO {

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
	 * Đánh dấu xóa một ChiTietPhieuNhapDienThoai. ChiTietPhieuNhapDienThoai bị
	 * đánh dấu xóa sẽ không bị xóa thực sự.
	 * 
	 * @param c
	 *            ChiTietPhieuNhapDienThoai sẽ bị đánh dấu xóa.
	 */
	public void markAsDeleted(ChiTietPhieuNhapDienThoai c) {
		c.setXoa(true);
		makePersistent(c);
	}

	/**
	 * Xóa (vĩnh viễn) một ChiTietPhieuNhapDienThoai.
	 * 
	 * @param c
	 *            ChiTietPhieuNhapDienThoai sẽ bị xóa
	 */
	public void makeTransient(ChiTietPhieuNhapDienThoai c) {
		// remove all association before deleting
		if (c.getDienThoai() != null) {
			c.getDienThoai().getDsChiTietPhieuNhap().remove(c);
			c.setDienThoai(null);
		}
		if (c.getPhieuNhapDienThoai() != null) {
			c.getPhieuNhapDienThoai().getDsChiTietPhieuNhapDienThoai()
					.remove(c);
			c.setPhieuNhapDienThoai(null);
		}

		factory.getCurrentSession().delete(c);
	}

	/**
	 * Thêm mới hoặc cập nhật ChiTietPhieuNhapDienThoai. Việc thêm mới hay cập
	 * nhật phụ thuộc vào giá trị ID.
	 * 
	 * @param c
	 *            ChiTietPhieuNhapDienThoai sẽ được thêm mới hoặc cập nhật.
	 * @return ChiTietPhieuNhapDienThoai đã được thêm mới hoặc cập nhật. Trong
	 *         trường hợp thêm mới giá trị ID sẽ được cập nhật tương ứng.
	 */
	public ChiTietPhieuNhapDienThoai makePersistent(ChiTietPhieuNhapDienThoai c) {

		Session session = factory.getCurrentSession();
		session.saveOrUpdate(c);
		session.flush();
		return c;
	}

	/**
	 * Tìm các ChiTietPhieuNhapDienThoai của một DienThoai.
	 * 
	 * @param idDienThoai
	 *            id của DienThoai
	 * @return Danh sách ChiTietPhieuNhapDienThoai của DienThoai.
	 */
	@SuppressWarnings("unchecked")
	public List<ChiTietPhieuNhapDienThoai> findByDienThoai(int idDienThoai) {
		return factory
				.getCurrentSession()
				.createQuery(
						"from ChiTietPhieuNhapDienThoai ct where ct.dienThoai.id = :id and ct.xoa = false")
				.setInteger("id", idDienThoai).list();
	}

	/**
	 * Tìm các ChiTietPhieuNhapDienThoai của một PhieuNhapDienThoai.
	 * 
	 * @param idPhieuNhapDienThoai
	 *            id của PhieuNhapDienThoai.
	 * @return Danh sách ChiTietPhieuNhapDienThoai của PhieuNhapDienThoai.
	 */
	@SuppressWarnings("unchecked")
	public List<ChiTietPhieuNhapDienThoai> findByPhieuNhapDienThoai(
			int idPhieuNhapDienThoai) {
		return factory
				.getCurrentSession()
				.createQuery(
						"from ChiTietPhieuNhapDienThoai ct where ct.phieuNhapDienThoai.id = :id and ct.xoa = false")
				.setInteger("id", idPhieuNhapDienThoai).list();
	}

	/**
	 * Tìm một ChiTietPhieuNhapDienThoai theo ID.
	 * 
	 * @param id
	 *            id của ChiTietPhieuNhapDienThoai cần tìm.
	 * @return ChiTietPhieuNhapDienThoai tìm được nếu không tìm thấy trả về
	 *         null.
	 */
	public ChiTietPhieuNhapDienThoai findById(int id) {
		ChiTietPhieuNhapDienThoai c = (ChiTietPhieuNhapDienThoai) factory
				.getCurrentSession().get(ChiTietPhieuNhapDienThoai.class, id);
		return c.isXoa() ? null : c;
	}

	/**
	 * Tìm tất cả ChiTietPhieuNhapDienThoai.
	 * 
	 * @return Danh sách ChiTietPhieuNhapDienThoai tìm được.
	 */
	@SuppressWarnings("unchecked")
	public List<ChiTietPhieuNhapDienThoai> findAll() {
		return factory.getCurrentSession().createCriteria(
				ChiTietPhieuNhapDienThoai.class).add(
				Restrictions.eq("xoa", false)).list();
	}

}
