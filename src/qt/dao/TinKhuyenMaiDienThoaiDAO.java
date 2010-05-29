/**
 * 
 */
package qt.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import qt.dto.ChiTietTinKhuyenMaiDienThoai;
import qt.dto.TinKhuyenMaiDienThoai;

/**
 * @author tqthe
 * 
 */
@Transactional
public class TinKhuyenMaiDienThoaiDAO {

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
	 * Xóa (vĩnh viễn) một TinKhuyenMaiDienThoai. Các
	 * ChiTietTinKhuyenMaiDienThoai thuộc về TinKhuyenMaiDienThoai này sẽ bị xóa
	 * theo.
	 * 
	 * @param t
	 *            TinKhuyenMaiDienThoai sẽ bị xóa.
	 */
	public void makeTransient(TinKhuyenMaiDienThoai t) {
		factory.getCurrentSession().delete(t);
	}

	/**
	 * Đánh dấu xóa TinKhuyenMaiDienThoai. Một TinKhuyenMaiDienThoai bị đánh dấu
	 * xóa sẽ không bị xóa thực sự. Các ChiTietTinKhuyenMaiDienThoai thuộc về
	 * TinKhuyenMaiDienThoai này sẽ bị đánh dấu xóa theo.
	 * 
	 * @param t
	 *            TinKhuyenMaiDienThoai sẽ bị dánh dấu xóa.
	 */
	public void markAsDeleted(TinKhuyenMaiDienThoai t) {
		t.setXoa(true);

		Set<ChiTietTinKhuyenMaiDienThoai> ds = t
				.getDsChiTietTinKhuyenMaiDienThoai();
		for (ChiTietTinKhuyenMaiDienThoai d : ds) {
			d.setXoa(true);
		}

		makePersistent(t);
	}

	/**
	 * Thêm hoặc cập nhật một TinKhuyenMaiDienThoai. Việc thêm hay cập nhật phụ
	 * thuộc vào giá trị ID.
	 * 
	 * @param t
	 *            TinKhuyenMaiDienThoai sẽ được thêm hoặc cập nhật.
	 * @return TinKhuyenMaiDienThoai TinKhuyenMaiDienThoai đã được thêm hoặc cập
	 *         nhật. Trong trường hợp thêm mới giá trị ID sẽ được cập nhật tương
	 *         ứng.
	 */
	public TinKhuyenMaiDienThoai makePersistent(TinKhuyenMaiDienThoai t) {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(t);
		session.flush();
		return t;
	}

	/**
	 * Tìm một TinKhuyenMaiDienThoai theo ID
	 * 
	 * @param id
	 *            id của TinKhuyenMaiDienThoai cần tìm.
	 * @return TinKhuyenMaiDienThoai tìm được
	 */
	public TinKhuyenMaiDienThoai findById(int id) {
		TinKhuyenMaiDienThoai t = (TinKhuyenMaiDienThoai) factory
				.getCurrentSession().get(TinKhuyenMaiDienThoai.class, id);
		return t.isXoa() ? null : t;
	}

	/**
	 * Tìm tất cả các TinKhuyenMaiDienThoai
	 * 
	 * @return Danh sách TinKhuyenMaiDienThoai tìm được.
	 */
	@SuppressWarnings("unchecked")
	public List<TinKhuyenMaiDienThoai> findAll() {
		return factory.getCurrentSession().createCriteria(
				TinKhuyenMaiDienThoai.class).add(Restrictions.eq("xoa", false))
				.list();
	}
}
