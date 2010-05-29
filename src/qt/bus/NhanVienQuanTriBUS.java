/**
 * 
 */
package qt.bus;

import java.util.List;

import qt.dao.NhanVienQuanTriDAO;
import qt.dto.NhanVienQuanTri;

/**
 * @author tqthe
 * 
 */
public class NhanVienQuanTriBUS {

	private NhanVienQuanTriDAO nhanVienQuanTriDAO;

	/**
	 * @param nhanVienQuanTriDAO
	 *            the nhanVienQuanTriDAO to set
	 */
	public void setNhanVienQuanTriDAO(NhanVienQuanTriDAO nhanVienQuanTriDAO) {
		this.nhanVienQuanTriDAO = nhanVienQuanTriDAO;
	}

	/**
	 * @return the nhanVienQuanTriDAO
	 */
	public NhanVienQuanTriDAO getNhanVienQuanTriDAO() {
		return nhanVienQuanTriDAO;
	}

	/**
	 * Đánh dấu xóa một NhanVienQuanTri.
	 * 
	 * @param e
	 *            NhanVienQuanTri sẽ bị đánh dấu xóa.
	 */
	public void markAsDeleted(NhanVienQuanTri e) {
		nhanVienQuanTriDAO.markAsDeleted(e);
	}

	/**
	 * Xóa (vĩnh viễn) một NhanVienQuanTri.
	 * 
	 * @param e
	 *            NhanVienQuanTri sẽ bị xóa.
	 */
	public void makeTransient(NhanVienQuanTri e) {
		nhanVienQuanTriDAO.makeTransient(e);
	}

	/**
	 * Thêm mới hoặc cập nhật một NhanVienQuanTri.
	 * 
	 * @param e
	 *            NhanVienQuanTri sẽ được thêm mới hay cập nhật.
	 * @return NhanVienQuanTri đã được thêm mới hay cập nhật.
	 */
	public NhanVienQuanTri makePersistent(NhanVienQuanTri e) {
		nhanVienQuanTriDAO.makePersistent(e);
		return e;
	}

	/**
	 * Tìm một NhanVienQuanTri theo ID.
	 * 
	 * @param id
	 *            id của NhanVienQuanTri cần tìm.
	 * @return NhanVienQuanTri tỉm được. Nếu không tìm thấy trả về null.
	 */
	public NhanVienQuanTri findById(int id) {
		return nhanVienQuanTriDAO.findById(id);
	}

	/**
	 * Tìm tất cả các NhanVienQuanTri.
	 * 
	 * @return Danh sách NhanVienQuanTri.
	 */
	public List<NhanVienQuanTri> findAll() {
		return nhanVienQuanTriDAO.findAll();
	}
}
