/**
 * 
 */
package qt.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import qt.dto.NhanVienBanHang;

/**
 * @author tqthe
 *
 */
@Transactional
public class NhanVienBanHangDAO {

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
	 * Đánh dấu xóa một NhanVienBanHang.
	 * 
	 * @param e
	 *            NhanVienBanHang sẽ bị đánh dấu xóa.
	 */
	public void markAsDeleted(NhanVienBanHang e) {
		e.setXoa(true);
		makePersistent(e);
	}

	/**
	 * Xóa (vĩnh viễn) một NhanVienBanHang.
	 * 
	 * @param e
	 *            NhanVienBanHang sẽ bị xóa.
	 * @param force
	 *            Nếu <code>force=true</code> thực hiện xóa NhanVienBanHang và các
	 *            dsPhieuNhapDienThoai, dsPhieuNhapPhuKien. <br>
	 *            Nếu <code>force=false</code> chỉ xóa nếu NhanVienBanHang không có bất
	 *            kì danh sách phiếu nhập điện thoại hoặc phụ kiện nào.
	 * @throws Exception
	 *             Nếu NhanVienBanHang đã có danh sách phiếu nhập điện thoại hoạc phụ
	 *             kiện và tham số <code>force=false</code>
	 */
	public void makeTransient(NhanVienBanHang e, boolean force) throws Exception {
		if ((e.getDsPhieuNhapDienThoai().size() > 0 || e
				.getDsPhieuNhapPhuKien().size() > 0)
				&& !force) {
			throw new Exception(
					"Không thể xóa nhân viên đã có danh sách phiếu nhập điện thoại hoặc phụ kiện");
		}

		factory.getCurrentSession().delete(e);
	}

	/**
	 * Thêm mới hoặc cập nhật một NhanVienBanHang.
	 * 
	 * @param e
	 *            NhanVienBanHang sẽ được thêm mới hay cập nhật.
	 * @return NhanVienBanHang đã được thêm mới hay cập nhật.
	 */
	public NhanVienBanHang makePersistent(NhanVienBanHang e) {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(e);
		session.flush();
		return e;
	}

	/**
	 * Tìm một NhanVienBanHang theo ID.
	 * 
	 * @param id
	 *            id của NhanVienBanHang cần tìm.
	 * @return NhanVienBanHang tỉm được. Nếu không tìm thấy trả về null.
	 */
	public NhanVienBanHang findById(int id) {
		NhanVienBanHang e = (NhanVienBanHang) factory.getCurrentSession().get(NhanVienBanHang.class,
				id);
		return e.isXoa() ? null : e;
	}

	/**
	 * Tìm tất cả các NhanVienBanHang.
	 * 
	 * @return Danh sách NhanVienBanHang.
	 */
	@SuppressWarnings("unchecked")
	public List<NhanVienBanHang> findAll() {
		return factory.getCurrentSession().createCriteria(NhanVienBanHang.class).add(
				Restrictions.eq("xoa", false)).list();
	}
	
}
