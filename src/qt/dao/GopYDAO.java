/**
 * 
 */
package qt.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import qt.dto.GopY;

/**
 * @author tqthe
 * 
 */
@Transactional
public class GopYDAO {

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
	 * Lấy danh sách GopY
	 * 
	 * @return danh sách GopY
	 */
	@SuppressWarnings("unchecked")
	public List<GopY> findAll() {
		return factory.getCurrentSession().createCriteria(GopY.class).add(
				Restrictions.eq("xoa", false)).list();
	}

	/**
	 * Lấy danh sách GopY theo trạng thái góp ý
	 * 
	 * @param idTrangThai
	 *            id của trạng thái góp ý
	 * @return Danh sách GopY
	 */
	@SuppressWarnings("unchecked")
	public List<GopY> findByTrangThai(int idTrangThai) {
		return factory.getCurrentSession().createQuery(
				"from GopY g where g.trangThaiGopY.id = :id and g.xoa = false")
				.setInteger("id", idTrangThai).list();
	}

	/**
	 * Tìm một GopY theo Id
	 * 
	 * @param id
	 *            id của GopY
	 * @return GopY nếu tìm thấy. Ngược lại trả về null
	 */
	public GopY findById(int id) {
		GopY g = (GopY) factory.getCurrentSession().get(GopY.class, id);
		return g.isXoa() ? null : g;
	}

	/**
	 * Thêm mới hoặc cập nhật một GopY.
	 * 
	 * @param g
	 *            GopY cần thêm hoặc cập nhật
	 * @return gopY Trong trường hợp thêm mới id của gopY sẽ được cập nhật
	 */
	public GopY makePersistent(GopY g) {
		factory.getCurrentSession().saveOrUpdate(g);
		factory.getCurrentSession().flush();
		return g;
	}

	/**
	 * Xóa (vĩnh viễn) một GopY.
	 * 
	 * @param g
	 *            gopY sẽ bị xóa
	 */
	public void makeTransient(GopY g) {
		// remove all association before deleting.
		if (g.getKhachHang() != null) {
			g.getKhachHang().getDsGopY().remove(g);
		}
		if (g.getTrangThaiGopY() != null) {
			g.getTrangThaiGopY().getDsGopY().remove(g);
		}
		g.setKhachHang(null);
		g.setTrangThaiGopY(null);

		factory.getCurrentSession().delete(g);
	}

	/**
	 * Đánh dấu xóa cho gopY. Góp ý chỉ bị đánh dấu xóa chứ không thực sự bị
	 * xóa. Muốn xóa thực sự dùng method <code>makeTransient</code>
	 * 
	 * @param g
	 *            được đánh dấu xóa
	 */
	public void markAsDeleted(GopY g) {
		g.setXoa(true);
		makePersistent(g);
	}

}
