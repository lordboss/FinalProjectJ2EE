/**
 * 
 */
package qt.bus;

import java.util.List;

import qt.dao.NhanVienDAO;
import qt.dto.NhanVien;

/**
 * @author tqthe
 * 
 */
public class NhanVienBUS {

	private NhanVienDAO nhanVienDAO;

	/**
	 * @param nhanVienDAO
	 *            the nhanVienDAO to set
	 */
	public void setNhanVienDAO(NhanVienDAO nhanVienDAO) {
		this.nhanVienDAO = nhanVienDAO;
	}

	/**
	 * @return the nhanVienDAO
	 */
	public NhanVienDAO getNhanVienDAO() {
		return nhanVienDAO;
	}

	/**
	 * Đánh dấu xóa một NhanVien.
	 * 
	 * @param e
	 *            NhanVien sẽ bị đánh dấu xóa.
	 */
	public void markAsDeleted(NhanVien e) {
		nhanVienDAO.markAsDeleted(e);
	}

	/**
	 * Xóa (vĩnh viễn) một NhanVien.
	 * 
	 * @param e
	 *            NhanVien sẽ bị xóa.
	 * @param force
	 *            Nếu <code>force=true</code> thực hiện xóa NhanVien và các
	 *            dsPhieuNhapDienThoai, dsPhieuNhapPhuKien. <br>
	 *            Nếu <code>force=false</code> chỉ xóa nếu NhanVien không có bất
	 *            kì danh sách phiếu nhập điện thoại hoặc phụ kiện nào.
	 * @throws Exception
	 *             Nếu NhanVien đã có danh sách phiếu nhập điện thoại hoạc phụ
	 *             kiện và tham số <code>force=false</code>
	 */
	public void makeTransient(NhanVien e, boolean force) throws Exception {
		nhanVienDAO.makeTransient(e, force);
	}

	/**
	 * Thêm mới hoặc cập nhật một NhanVien.
	 * 
	 * @param e
	 *            NhanVien sẽ được thêm mới hay cập nhật.
	 * @return NhanVien đã được thêm mới hay cập nhật.
	 */
	public NhanVien makePersistent(NhanVien e) {
		nhanVienDAO.makePersistent(e);
		return e;
	}

	/**
	 * Tìm một NhanVien theo ID.
	 * 
	 * @param id
	 *            id của NhanVien cần tìm.
	 * @return NhanVien tỉm được. Nếu không tìm thấy trả về null.
	 */
	public NhanVien findById(int id) {
		return nhanVienDAO.findById(id);
	}

	/**
	 * Tìm tất cả các NhanVien.
	 * 
	 * @return Danh sách NhanVien.
	 */
	public List<NhanVien> findAll() {
		return nhanVienDAO.findAll();
	}
}
