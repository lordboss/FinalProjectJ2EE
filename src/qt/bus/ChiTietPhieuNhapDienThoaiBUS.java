/**
 * 
 */
package qt.bus;

import java.util.List;

import qt.dao.ChiTietPhieuNhapDienThoaiDAO;
import qt.dto.ChiTietPhieuNhapDienThoai;

/**
 * @author tqthe
 * 
 */
public class ChiTietPhieuNhapDienThoaiBUS {

	private ChiTietPhieuNhapDienThoaiDAO chiTietPhieuNhapDienThoaiDAO;

	/**
	 * @param chiTietPhieuNhapDienThoaiDAO
	 *            the chiTietPhieuNhapDienThoaiDAO to set
	 */
	public void setChiTietPhieuNhapDienThoaiDAO(
			ChiTietPhieuNhapDienThoaiDAO chiTietPhieuNhapDienThoaiDAO) {
		this.chiTietPhieuNhapDienThoaiDAO = chiTietPhieuNhapDienThoaiDAO;
	}

	/**
	 * @return the chiTietPhieuNhapDienThoaiDAO
	 */
	public ChiTietPhieuNhapDienThoaiDAO getChiTietPhieuNhapDienThoaiDAO() {
		return chiTietPhieuNhapDienThoaiDAO;
	}

	/**
	 * Đánh dấu xóa một ChiTietPhieuNhapDienThoai. ChiTietPhieuNhapDienThoai bị
	 * đánh dấu xóa sẽ không bị xóa thực sự.
	 * 
	 * @param c
	 *            ChiTietPhieuNhapDienThoai sẽ bị đánh dấu xóa.
	 */
	public void markAsDeleted(ChiTietPhieuNhapDienThoai c) {
		chiTietPhieuNhapDienThoaiDAO.markAsDeleted(c);
	}

	/**
	 * Xóa (vĩnh viễn) một ChiTietPhieuNhapDienThoai.
	 * 
	 * @param c
	 *            ChiTietPhieuNhapDienThoai sẽ bị xóa
	 */
	public void makeTransient(ChiTietPhieuNhapDienThoai c) {
		chiTietPhieuNhapDienThoaiDAO.makeTransient(c);
	}

	/**
	 * Thêm mới hoặc cập nhật ChiTietPhieuNhapDienThoai. Việc thêm mới hay cập
	 * nhật phụ thuộc vào giá trị ID.
	 * 
	 * @param c
	 *            ChiTietPhieuNhapDienThoai sẽ được thêm mới hoặc cập nhật.
	 * @return ChiTietPhieuNhapDienThoai đã được thêm mới hoặc cập nhật. Trong
	 *         trường hợp thêm mới giá trị ID sẽ được cập nhật tương ứng.
	 */
	public ChiTietPhieuNhapDienThoai makePersistent(ChiTietPhieuNhapDienThoai c) {
		chiTietPhieuNhapDienThoaiDAO.makePersistent(c);
		return c;
	}

	/**
	 * Tìm các ChiTietPhieuNhapDienThoai của một DienThoai.
	 * 
	 * @param idDienThoai
	 *            id của DienThoai
	 * @return Danh sách ChiTietPhieuNhapDienThoai của DienThoai.
	 */
	public List<ChiTietPhieuNhapDienThoai> findByDienThoai(int idDienThoai) {
		return chiTietPhieuNhapDienThoaiDAO.findByDienThoai(idDienThoai);
	}

	/**
	 * Tìm các ChiTietPhieuNhapDienThoai của một PhieuNhapDienThoai.
	 * 
	 * @param idPhieuNhapDienThoai
	 *            id của PhieuNhapDienThoai.
	 * @return Danh sách ChiTietPhieuNhapDienThoai của PhieuNhapDienThoai.
	 */
	public List<ChiTietPhieuNhapDienThoai> findByPhieuNhapDienThoai(
			int idPhieuNhapDienThoai) {
		return chiTietPhieuNhapDienThoaiDAO
				.findByPhieuNhapDienThoai(idPhieuNhapDienThoai);
	}

	/**
	 * Tìm một ChiTietPhieuNhapDienThoai theo ID.
	 * 
	 * @param id
	 *            id của ChiTietPhieuNhapDienThoai cần tìm.
	 * @return ChiTietPhieuNhapDienThoai tìm được nếu không tìm thấy trả về
	 *         null.
	 */
	public ChiTietPhieuNhapDienThoai findById(int id) {
		return chiTietPhieuNhapDienThoaiDAO.findById(id);
	}

	/**
	 * Tìm tất cả ChiTietPhieuNhapDienThoai.
	 * 
	 * @return Danh sách ChiTietPhieuNhapDienThoai tìm được.
	 */
	public List<ChiTietPhieuNhapDienThoai> findAll() {
		return chiTietPhieuNhapDienThoaiDAO.findAll();
	}
}
