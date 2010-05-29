/**
 * 
 */
package qt.bus;

import java.util.List;

import qt.dao.ChiTietPhieuNhapPhuKienDAO;
import qt.dto.ChiTietPhieuNhapPhuKien;

/**
 * @author tqthe
 * 
 */
public class ChiTietPhieuNhapPhuKienBUS {
	private ChiTietPhieuNhapPhuKienDAO chiTietPhieuNhapPhuKienDAO;

	/**
	 * @param chiTietPhieuNhapPhuKienDAO
	 *            the chiTietPhieuNhapPhuKienDAO to set
	 */
	public void setChiTietPhieuNhapPhuKienDAO(
			ChiTietPhieuNhapPhuKienDAO chiTietPhieuNhapPhuKienDAO) {
		this.chiTietPhieuNhapPhuKienDAO = chiTietPhieuNhapPhuKienDAO;
	}

	/**
	 * @return the chiTietPhieuNhapPhuKienDAO
	 */
	public ChiTietPhieuNhapPhuKienDAO getChiTietPhieuNhapPhuKienDAO() {
		return chiTietPhieuNhapPhuKienDAO;
	}

	/**
	 * Đánh dấu xóa một ChiTietPhieuNhapPhuKien. ChiTietPhieuNhapPhuKien sẽ
	 * không bị xóa thực sự.
	 * 
	 * @param c
	 *            ChiTietPhieuNhapPhuKien sẽ bị đánh dấu xóa.
	 */
	public void markAsDeleted(ChiTietPhieuNhapPhuKien c) {
		chiTietPhieuNhapPhuKienDAO.markAsDeleted(c);
	}

	/**
	 * Xóa (vĩnh viễn) một ChiTietPhieuNhapPhuKien.
	 * 
	 * @param c
	 *            ChiTietPhieuNhapPhuKien sẽ bị xóa.
	 */
	public void makeTransient(ChiTietPhieuNhapPhuKien c) {
		chiTietPhieuNhapPhuKienDAO.makeTransient(c);
	}

	/**
	 * Thêm mới hoặc cập nhật ChiTietPhieuNhapPhuKien. Việc thêm mới hay cập
	 * nhật phụ thuộc vào giá trị của ID.
	 * 
	 * @param c
	 *            ChiTietPhieuNhapPhuKien sẽ được thêm mới hay cập nhật.
	 * @return ChiTietPhieuNhapPhuKien vừa được thêm mới hoặc cập nhật. Trong
	 *         trường hợp thêm mới giá trị của ID sẽ được cập nhật.
	 */
	public ChiTietPhieuNhapPhuKien makePersistent(ChiTietPhieuNhapPhuKien c) {
		chiTietPhieuNhapPhuKienDAO.makePersistent(c);
		return c;
	}

	/**
	 * Tìm các ChiTietPhieuNhapPhuKien của PhieuNhapPhuKien
	 * 
	 * @param idPhieuNhapPhuKien
	 *            id của PhieuNhapPhuKien
	 * @return Danh sách ChiTietPhieuNhapPhuKien của PhieuNhapPhuKien.
	 */
	public List<ChiTietPhieuNhapPhuKien> findByPhieuNhapPhuKien(
			int idPhieuNhapPhuKien) {
		return chiTietPhieuNhapPhuKienDAO
				.findByPhieuNhapPhuKien(idPhieuNhapPhuKien);
	}

	/**
	 * Tìm các ChiTietPhieuNhapPhuKien của một PhuKien.
	 * 
	 * @param idPhuKien
	 *            id của PhuKien.
	 * @return Danh sách ChiTietPhieuNhapPhuKien của PhuKien.
	 */
	public List<ChiTietPhieuNhapPhuKien> findByPhuKien(int idPhuKien) {
		return chiTietPhieuNhapPhuKienDAO.findByPhuKien(idPhuKien);
	}

	/**
	 * Tìm một ChiTietPhieuNhapPhuKien theo ID.
	 * 
	 * @param id
	 *            id của ChiTietPhieuNhapPhuKien cần tìm.
	 * @return ChiTietPhieuNhapPhuKien cần tìm. Nếu không tìm thấy trả về null.
	 */
	public ChiTietPhieuNhapPhuKien findById(int id) {
		return chiTietPhieuNhapPhuKienDAO.findById(id);
	}

	/**
	 * Tìm tất cả ChiTietPhieuNhapPhuKien.
	 * 
	 * @return Danh sách ChiTietPhieuNhapPhuKien tìm được.
	 */
	public List<ChiTietPhieuNhapPhuKien> findAll() {
		return chiTietPhieuNhapPhuKienDAO.findAll();
	}
}
