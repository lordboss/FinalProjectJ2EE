/**
 * 
 */
package qt.bus;

import java.util.List;

import qt.dao.NhanVienBanHangDAO;
import qt.dto.NhanVienBanHang;

/**
 * @author tqthe
 *
 */
public class NhanVienBanHangBUS {
	private NhanVienBanHangDAO nhanVienBanHangDAO;

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

		nhanVienBanHangDAO.makeTransient(e, force);
	}

	/**
	 * Thêm mới hoặc cập nhật một NhanVienBanHang.
	 * 
	 * @param e
	 *            NhanVienBanHang sẽ được thêm mới hay cập nhật.
	 * @return NhanVienBanHang đã được thêm mới hay cập nhật.
	 */
	public NhanVienBanHang makePersistent(NhanVienBanHang e) {
		return nhanVienBanHangDAO.makePersistent(e);
	}

	/**
	 * Tìm một NhanVienBanHang theo ID.
	 * 
	 * @param id
	 *            id của NhanVienBanHang cần tìm.
	 * @return NhanVienBanHang tỉm được. Nếu không tìm thấy trả về null.
	 */
	public NhanVienBanHang findById(int id) {
		return nhanVienBanHangDAO.findById(id);
	}

	/**
	 * Tìm tất cả các NhanVienBanHang.
	 * 
	 * @return Danh sách NhanVienBanHang.
	 */
	public List<NhanVienBanHang> findAll() {
		return nhanVienBanHangDAO.findAll();
	}
	
	/**
	 * @param nhanVienBanHangDAO the nhanVienBanHangDAO to set
	 */
	public void setNhanVienBanHangDAO(NhanVienBanHangDAO nhanVienBanHangDAO) {
		this.nhanVienBanHangDAO = nhanVienBanHangDAO;
	}

	/**
	 * @return the nhanVienBanHangDAO
	 */
	public NhanVienBanHangDAO getNhanVienBanHangDAO() {
		return nhanVienBanHangDAO;
	}
}	
