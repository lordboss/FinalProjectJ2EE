/**
 * 
 */
package qt.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import qt.dto.NhaCungCap;

/**
 * @author tqthe
 * 
 */
@Transactional
public class NhaCungCapDAO {

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
	 * Đánh dấu xóa một NhaCungCap.
	 * 
	 * @param s
	 *            NhaCungCap sẽ bị đánh dấu xóa.
	 */
	public void markAsDeleted(NhaCungCap s) {
		s.setXoa(true);
		makePersistent(s);
	}

	/**
	 * Xóa (vĩnh viễn) một NhaCungCap.
	 * 
	 * @param s
	 *            NhaCungCap sẽ bị xóa.
	 * @param force
	 *            Nếu <code>force=true</code> thực hiện xóa NhaCungCap.
	 *            DsSanPham, dsPhuKien, dsDienThoai sẽ bị xóa theo. <b>Rất là
	 *            nguy hiểm! (Cascade delete)</b> <br>
	 *            Nếu <code>force=false</code> chỉ thực hiện xóa NhaCungCap nếu
	 *            NhaCungCap không có bất kì danh sách sản phẩm, phiếu nhập phụ
	 *            kiện hay điện thoại nào. <b>Khuyến khích dùng cái này!</b>
	 * @throws Exception
	 *             Nếu nhà cung cấp đã có danh sách sản phẩm, phiếu nhập phụ
	 *             kiện hoặc điện thoại và tham số <code>force=false</code>
	 */
	public void makeTransient(NhaCungCap s, boolean force) throws Exception {
		if ((s.getDsSanPham().size() > 0
				|| s.getDsPhieuNhapDienThoai().size() > 0 || s
				.getDsPhieuNhapPhuKien().size() > 0)
				&& !force) {
			throw new Exception(
					"Không thể xóa nhà cung cấp đã có danh sách sản phẩm, phiếu nhập phụ kiện hoặc điện thoại.");
		}

		factory.getCurrentSession().delete(s);
	}

	/**
	 * Thêm mới hoặc cập nhật một NhaCungCap. Việc thêm mới hay cập nhật phụ
	 * thuộc vào giá trị ID.
	 * 
	 * @param s
	 *            NhaCungCap sẽ được thêm mới hoặc cập nhật.
	 * @return NhaCungCap vừa được thêm mới hoặc cập nhật. Trong trường hợp thêm
	 *         mới giá trị ID sẽ được cập nhật tương ứng.
	 */
	public NhaCungCap makePersistent(NhaCungCap s) {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(s);
		session.flush();
		return s;
	}

	/**
	 * Tìm một NhaCungCap theo tên
	 * 
	 * @param name
	 *            Tên của NhaCungCap cần tìm
	 * @return NhaCungCap tìm được. Nếu không tìm thấy trả về null.
	 */
	public NhaCungCap findByName(String name) {
		return (NhaCungCap) factory.getCurrentSession().createQuery(
				"from NhaCungCap s where s.ten = :name and s.xoa = false")
				.setString("name", name).uniqueResult();
	}

	/**
	 * Tìm một NhaCungCap theo số điện thoại.
	 * 
	 * @param phone
	 *            Số điện thoại của NhaCungCap.
	 * @return NhaCungCap tìm được. Nếu không tìm thấy trả về null.
	 */
	public NhaCungCap findByPhone(String phone) {
		return (NhaCungCap) factory
				.getCurrentSession()
				.createQuery(
						"from NhaCungCap s where s.dienThoai = :phone and s.xoa = false")
				.setString("phone", phone).uniqueResult();
	}

	/**
	 * Tìm một NhaCungCap theo ID
	 * 
	 * @param id
	 *            id của NhaCungCap cần tìm.
	 * @return NhaCungCap tìm được. Nếu không tìm thấy trả về null.
	 */
	public NhaCungCap findById(int id) {
		NhaCungCap s = (NhaCungCap) factory.getCurrentSession().get(
				NhaCungCap.class, id);
		return s.isXoa() ? null : s;
	}

	/**
	 * Tìm tất cả NhaCungCap.
	 * 
	 * @return Danh sách NhaCungCap tìm được.
	 */
	@SuppressWarnings("unchecked")
	public List<NhaCungCap> findAll() {
		return factory.getCurrentSession().createCriteria(NhaCungCap.class)
				.add(Restrictions.eq("xoa", false)).list();
	}
}
