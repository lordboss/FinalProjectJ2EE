/**
 * 
 */
package qt.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import qt.dto.GopY;
import qt.dto.TrangThaiGopY;

/**
 * @author tqthe
 * 
 */
@Transactional
public class TrangThaiGopYDAO {

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
	 * Lấy danh sách TrangThaiGopY
	 * 
	 * @return Danh sách TrangThaiGopY
	 */
	@SuppressWarnings("unchecked")
	public List<TrangThaiGopY> findAll() {
		return factory.getCurrentSession().createCriteria(TrangThaiGopY.class)
				.list();
	}

	/**
	 * Tìm kiếm một TrangThaiGopY theo id
	 * 
	 * @param id
	 *            id dùng để tìm kiếm
	 * @return Một đối tượng TrangThaiTimKiem. Nếu không tìm thấy trả về null
	 */
	public TrangThaiGopY findById(int id) {
		return (TrangThaiGopY) factory.getCurrentSession().get(
				TrangThaiGopY.class, id);
	}

	/**
	 * Thêm mới hoặc cập nhật một trạng thái góp ý. Nếu ID của trangThaiGopY
	 * chưa có trong CSDL (hoặc trùng với giá trị unsave-value trong
	 * TrangThaiGopY.hbm.xml) thi thực hiện thêm mới. Ngược lại thực hiện cập
	 * nhật
	 * 
	 * @param t
	 *            trạng thái góp ý cần được thêm mới hoặc cập nhật
	 * @return Trạng thái góp ý vừa được persist. (Nếu thêm mới và ID ở chế độ
	 *         auto trong CSDL thì giá trị ID được cập nhật)
	 */
	public TrangThaiGopY makePersistent(TrangThaiGopY t) {
		factory.getCurrentSession().saveOrUpdate(t);
		factory.getCurrentSession().flush();
		return t;
	}

	/**
	 * Xóa (vĩnh viễn) một TrangThaiGopY.
	 * 
	 * @param force
	 *            Nếu force=true xóa TrangThaiGopY và các GopY thuộc về
	 *            TrangThaiGopY. Nếu force=false throw Exception nếu
	 *            TrangThaiGopY đã có các GopY.
	 * @param t
	 *            TrangThaiGopY sẽ bị xóa.
	 * @throws Exception
	 *             Khi một TrangThaiGopY có nhiều GopY và tham số force=false
	 *             thì không xóa được.
	 */
	public void makeTransient(TrangThaiGopY t, boolean force) throws Exception {
		if (t.getDsGopY().size() > 0 && !force) {
			throw new Exception(
					"Không thể xóa một trạng thái góp ý đã có danh sách góp ý!");
		}

		factory.getCurrentSession().delete(t);
	}

	/**
	 * Lấy danh sách góp ý của một loại trạng thái góp ý.
	 * 
	 * @param idTrangThaiGopY
	 *            - id của loại trạng thái góp ý
	 * @return Danh sách các góp ý. Danh sách rỗng nếu không tìm thấy.
	 */
	@SuppressWarnings("unchecked")
	public List<GopY> findByTrangThaiGopY(int idTrangThaiGopY) {
		return factory.getCurrentSession().createQuery(
				"from GopY g where g.trangThaiGopY.id = :id").setInteger("id",
				idTrangThaiGopY).list();
	}

	/**
	 * Tìm một trạng thái theo tên
	 * 
	 * @param tenTrangThai
	 *            tên của trạng thái cần tìm
	 * @return TrangThaiGopY cần tìm. Null nếu không tìm thấy
	 */
	public TrangThaiGopY findByTenTrangThai(String tenTrangThai) {
		return (TrangThaiGopY) factory.getCurrentSession().createQuery(
				"from TrangThaiGopY t where t.trangThai = :ten").setString(
				"ten", tenTrangThai).uniqueResult();
	}
}
