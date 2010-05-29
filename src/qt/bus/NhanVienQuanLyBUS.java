/**
 * 
 */
package qt.bus;

import java.util.List;

import qt.dao.NhanVienQuanLyDAO;
import qt.dto.NhanVienQuanLy;

/**
 * @author tqthe
 * 
 */
public class NhanVienQuanLyBUS {

	private NhanVienQuanLyDAO nhanVienQuanLyDAO;

	/**
	 * @param nhanVienQuanLyDAO
	 *            the nhanVienQuanLyDAO to set
	 */
	public void setNhanVienQuanLyDAO(NhanVienQuanLyDAO nhanVienQuanLyDAO) {
		this.nhanVienQuanLyDAO = nhanVienQuanLyDAO;
	}

	/**
	 * @return the nhanVienQuanLyDAO
	 */
	public NhanVienQuanLyDAO getNhanVienQuanLyDAO() {
		return nhanVienQuanLyDAO;
	}

	/**
	 * Đánh dấu xóa một NhanVienQuanLy.
	 * 
	 * @param e
	 *            NhanVienQuanLy sẽ bị đánh dấu xóa.
	 */
	public void markAsDeleted(NhanVienQuanLy e) {
		nhanVienQuanLyDAO.markAsDeleted(e);
	}

	/**
	 * Xóa (vĩnh viễn) một NhanVienQuanLy.
	 * 
	 * @param e
	 *            NhanVienQuanLy sẽ bị xóa.
	 */
	public void makeTransient(NhanVienQuanLy e) {
		nhanVienQuanLyDAO.makeTransient(e);
	}

	/**
	 * Thêm mới hoặc cập nhật một NhanVienQuanLy.
	 * 
	 * @param e
	 *            NhanVienQuanLy sẽ được thêm mới hay cập nhật.
	 * @return NhanVienQuanLy đã được thêm mới hay cập nhật.
	 */
	public NhanVienQuanLy makePersistent(NhanVienQuanLy e) {
		nhanVienQuanLyDAO.makePersistent(e);
		return e;
	}

	/**
	 * Tìm một NhanVienQuanLy theo ID.
	 * 
	 * @param id
	 *            id của NhanVienQuanLy cần tìm.
	 * @return NhanVienQuanLy tỉm được. Nếu không tìm thấy trả về null.
	 */
	public NhanVienQuanLy findById(int id) {
		return nhanVienQuanLyDAO.findById(id);
	}

	/**
	 * Tìm tất cả các NhanVienQuanLy.
	 * 
	 * @return Danh sách NhanVienQuanLy.
	 */
	public List<NhanVienQuanLy> findAll() {
		return nhanVienQuanLyDAO.findAll();
	}
}
