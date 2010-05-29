/**
 * 
 */
package qt.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import qt.dto.LoaiTinTuc;

/**
 * @author tqthe
 * 
 */
@Transactional
public class LoaiTinTucDAO {
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
	 * Tìm tất cả LoaiTinTuc
	 * 
	 * @return Danh sách LoaiTinTuc
	 */
	@SuppressWarnings("unchecked")
	public List<LoaiTinTuc> findAll() {
		return factory.getCurrentSession().createCriteria(LoaiTinTuc.class)
				.list();
	}

	/**
	 * Tìm một LoaiTinTuc theo id
	 * 
	 * @param idLoaiTinTuc
	 *            id của LoaiTinTuc cần tìm
	 * @return LoaiTinTuc nếu tìm thấy. Ngược lại trả về null
	 */
	public LoaiTinTuc findById(int idLoaiTinTuc) {
		return (LoaiTinTuc) factory.getCurrentSession().get(LoaiTinTuc.class,
				idLoaiTinTuc);
	}

	/**
	 * Thêm mới hoặc cập nhật một LoaiTinTuc. Việc thêm mới hay cập nhật phụ
	 * thục vào giá trị của id
	 * 
	 * @param c
	 *            LoaiTinTuc được thêm mới hoặc cập nhật.
	 * @return LoaiTinTuc vừa được thêm mới hoặc cập nhật. (Trong trường hợp
	 *         thêm mới giá trị id sẽ thay đổi).
	 */
	public LoaiTinTuc makePersistent(LoaiTinTuc c) {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(c);
		session.flush();
		return c;
	}

	/**
	 * Xóa (vĩnh viễn) một LoaiTinTuc.
	 * 
	 * @param c
	 *            LoaiTinTuc sẽ bị xóa
	 * @param force
	 *            Nếu force=true xóa LoaiTinTuc và các TinTuc thuộc về
	 *            LoaiTinTuc này. Nếu force=false, quá trình xóa có thể văng
	 *            Exception nếu LoaiTinTuc có danh sách các TinTuc.
	 * @throws Exception
	 *             LoaiTinTuc đã có danh sách TinTuc và tham số force=false.
	 */
	public void makeTransient(LoaiTinTuc c, boolean force) throws Exception {
		if (c.getDsTinTuc().size() > 0 && !force) {
			throw new Exception(
					"Không thể xóa LoaiTinTuc đã có danh sách TinTuc!");
		}
		factory.getCurrentSession().delete(c);
	}
}
