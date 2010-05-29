/**
 * 
 */
package qt.bus;

import java.util.List;

import qt.dao.PhieuNhapPhuKienDAO;
import qt.dto.PhieuNhapPhuKien;

/**
 * @author tqthe
 * 
 */
public class PhieuNhapPhuKienBUS {

	private PhieuNhapPhuKienDAO phieuNhapPhuKienDAO;

	/**
	 * @param phieuNhapPhuKienDAO
	 *            the phieuNhapPhuKienDAO to set
	 */
	public void setPhieuNhapPhuKienDAO(PhieuNhapPhuKienDAO phieuNhapPhuKienDAO) {
		this.phieuNhapPhuKienDAO = phieuNhapPhuKienDAO;
	}

	/**
	 * @return the phieuNhapPhuKienDAO
	 */
	public PhieuNhapPhuKienDAO getPhieuNhapPhuKienDAO() {
		return phieuNhapPhuKienDAO;
	}

	/**
	 * Đánh dấu xóa PhieuNhapPhuKien. Các ChiTietPhieuNhapPhuKien thuộc về
	 * PhieuNhapPhuKien sẽ bị đánh dấu xóa theo.
	 * 
	 * @param p
	 *            PhieuNhapPhuKien bi đánh dấu xóa.
	 */
	public void markAsDeleted(PhieuNhapPhuKien p) {
		phieuNhapPhuKienDAO.markAsDeleted(p);
	}

	/**
	 * Xóa (vĩnh viễn) một PhieuNhapPhuKien.
	 * 
	 * @param p
	 *            PhieuNhapPhuKien sẽ bị xóa.
	 */
	public void makeTransient(PhieuNhapPhuKien p) {
		phieuNhapPhuKienDAO.makeTransient(p);
	}

	/**
	 * Thêm mới hoặc cập nhật PhieuNhapPhuKien. Việc thêm mới hay cập nhật phụ
	 * thuộc vào giá trị ID.
	 * 
	 * @param p
	 *            PhieuNhapPhuKien sẽ được thêm mới hoặc cập nhật.
	 * @return PhieuNhapPhuKien đã được thêm mới hoặc cập nhật. Trong trường hợp
	 *         thêm mới giá trị ID sẽ được cập nhật tương ứng.
	 */
	public PhieuNhapPhuKien makePersistent(PhieuNhapPhuKien p) {
		phieuNhapPhuKienDAO.makePersistent(p);
		return p;
	}

	/**
	 * Tìm các PhieuNhapPhuKien của một NhaCungCap.
	 * 
	 * @param idNhaCungCap
	 *            id của NhaCungCap.
	 * @return Danh sách PhieuNhapPhuKien của NhaCungCap.
	 */
	public List<PhieuNhapPhuKien> findByNhaCungCap(int idNhaCungCap) {
		return phieuNhapPhuKienDAO.findByNhaCungCap(idNhaCungCap);
	}

	/**
	 * Tìm các PhieuNhapPhuKien của một NhanVien.
	 * 
	 * @param idNhanVien
	 *            id của NhanVien.
	 * @return Danh sách PhieuNhapPhuKien của NhanVien.
	 */
	public List<PhieuNhapPhuKien> findByNhanVien(int idNhanVien) {
		return phieuNhapPhuKienDAO.findByNhanVien(idNhanVien);
	}

	/**
	 * Tìm một PhieuNhapPhuKien theo ID
	 * 
	 * @param id
	 *            id của PhieuNhapPhuKien cần tìm.
	 * @return PhieuNhapPhuKien tìm được. Nếu không tìm thấy trả về null.
	 */
	public PhieuNhapPhuKien findById(int id) {
		return phieuNhapPhuKienDAO.findById(id);
	}

	/**
	 * Tìm tất cả PhieuNhapPhuKien.
	 * 
	 * @return Danh sách PhieuNhapPhuKien tìm được.
	 */
	public List<PhieuNhapPhuKien> findAll() {
		return phieuNhapPhuKienDAO.findAll();
	}
}
