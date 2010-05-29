/**
 * 
 */
package qt.bus;

import java.util.List;

import qt.dao.PhieuNhapDienThoaiDAO;
import qt.dto.PhieuNhapDienThoai;

/**
 * @author tqthe
 * 
 */
public class PhieuNhapDienThoaiBUS {

	private PhieuNhapDienThoaiDAO phieuNhapDienThoaiDAO;

	/**
	 * @param phieuNhapDienThoaiDAO
	 *            the phieuNhapDienThoaiDAO to set
	 */
	public void setPhieuNhapDienThoaiDAO(
			PhieuNhapDienThoaiDAO phieuNhapDienThoaiDAO) {
		this.phieuNhapDienThoaiDAO = phieuNhapDienThoaiDAO;
	}

	/**
	 * @return the phieuNhapDienThoaiDAO
	 */
	public PhieuNhapDienThoaiDAO getPhieuNhapDienThoaiDAO() {
		return phieuNhapDienThoaiDAO;
	}

	/**
	 * Đánh dấu xóa một PhieuNhapDienThoai. PhieuNhapDienThoai bị đánh dấu xóa
	 * sẽ không thực sự bị xóa.
	 * 
	 * @param p
	 *            PhieuNhapDienThoai sẽ bị đánh dấu xóa.
	 */
	public void markAsDeleted(PhieuNhapDienThoai p) {
		phieuNhapDienThoaiDAO.markAsDeleted(p);
	}

	/**
	 * Xóa (vĩnh viễn) một PhieuNhapDienThoai. Các ChiTietPhieuNhapDienThoai
	 * thuộc về PhieuNhapDienThoai sẽ bị xóa theo.
	 * 
	 * @param p
	 *            PhieuNhapDienThoai sẽ bị xóa.
	 */
	public void makeTransient(PhieuNhapDienThoai p) {
		phieuNhapDienThoaiDAO.makeTransient(p);
	}

	/**
	 * Thêm mới hoặc cập nhật một PhieuNhapDienThoai. Việc thêm mới hay cập nhật
	 * phụ thuộc vào giá trị ID.
	 * 
	 * @param p
	 *            PhieuNhapDienThoai sẽ được thêm mới hay cập nhật.
	 * @return PhieuNhapDienThoai vừa được thêm mới hay cập nhật.
	 */
	public PhieuNhapDienThoai makePersistent(PhieuNhapDienThoai p) {
		phieuNhapDienThoaiDAO.makePersistent(p);
		return p;
	}

	/**
	 * Tìm tất cả PhieuNhapDienThoai của một NhanVien.
	 * 
	 * @param id
	 *            id của NhanVien cần tìm PhieuNhapDienThoai.
	 * @return Danh sách PhieuNhapDienThoai của NhanVien.
	 */
	public List<PhieuNhapDienThoai> findByNhanVien(int id) {
		return phieuNhapDienThoaiDAO.findByNhanVien(id);
	}

	/**
	 * Tìm tất cả PhieuNhapDienThoai của một NhaCungCap.
	 * 
	 * @param id
	 *            id của NhaCungCap cần tìm danh sách PhieuNhapDienThoai.
	 * @return Danh sách PhieuNhapDienThoai của NhaCungCap.
	 */
	public List<PhieuNhapDienThoai> findByNhapCungCap(int id) {
		return phieuNhapDienThoaiDAO.findByNhapCungCap(id);
	}

	/**
	 * Tìm một PhieuNhapDienThoai theo ID.
	 * 
	 * @param id
	 *            id của PhieuNhapDienThoai cần tìm.
	 * @return PhieuNhapDienThoai tìm được. Nếu không tìm thấy trả về null.
	 */
	public PhieuNhapDienThoai findById(int id) {
		return phieuNhapDienThoaiDAO.findById(id);
	}

	/**
	 * Tìm tất cả PhieuNhapDienThoai.
	 * 
	 * @return Danh sách PhieuNhapDienThoai tìm được.
	 */
	public List<PhieuNhapDienThoai> findAll() {
		return phieuNhapDienThoaiDAO.findAll();
	}
}
