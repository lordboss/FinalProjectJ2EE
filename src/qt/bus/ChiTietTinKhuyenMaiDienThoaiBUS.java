/**
 * 
 */
package qt.bus;

import java.util.List;

import qt.dao.ChiTietTinKhuyenMaiDienThoaiDAO;
import qt.dto.ChiTietTinKhuyenMaiDienThoai;

/**
 * @author tqthe
 * 
 */
public class ChiTietTinKhuyenMaiDienThoaiBUS {

	private ChiTietTinKhuyenMaiDienThoaiDAO chiTietTinKhuyenMaiDienThoaiDAO;

	/**
	 * @param chiTietTinKhuyenMaiDienThoaiDAO
	 *            the chiTietTinKhuyenMaiDienThoaiDAO to set
	 */
	public void setChiTietTinKhuyenMaiDienThoaiDAO(
			ChiTietTinKhuyenMaiDienThoaiDAO chiTietTinKhuyenMaiDienThoaiDAO) {
		this.chiTietTinKhuyenMaiDienThoaiDAO = chiTietTinKhuyenMaiDienThoaiDAO;
	}

	/**
	 * @return the chiTietTinKhuyenMaiDienThoaiDAO
	 */
	public ChiTietTinKhuyenMaiDienThoaiDAO getChiTietTinKhuyenMaiDienThoaiDAO() {
		return chiTietTinKhuyenMaiDienThoaiDAO;
	}

	/**
	 * Đánh dấu xóa một ChiTietTinKhuyenMaiDienThoai.
	 * ChiTietTinKhuyenMaiDienThoai bị đánh dấu xóa sẽ không bị xóa thật sự.
	 * 
	 * @param c
	 *            ChiTietTinKhuyenMaiDienThoai sẽ bị đánh dấu xóa.
	 */
	public void markAsDeleted(ChiTietTinKhuyenMaiDienThoai c) {
		chiTietTinKhuyenMaiDienThoaiDAO.markAsDeleted(c);
	}

	/**
	 * Xóa (vĩnh viễn) một ChiTietTinKhuyenMaiDienThoai.
	 * 
	 * @param c
	 *            ChiTietTinKhuyenMaiDienThoai sẽ bị xóa.
	 */
	public void makeTransient(ChiTietTinKhuyenMaiDienThoai c) {
		chiTietTinKhuyenMaiDienThoaiDAO.makeTransient(c);
	}

	/**
	 * Thêm mới hoặc cập nhật một ChiTietTinKhuyenMaiDienThoai. Việc thêm mới
	 * hay cập nhật được căn cứ trên giá trị ID.
	 * 
	 * @param c
	 *            ChiTietTinKhuyenMaiDienThoai sẽ được thêm mới hay cập nhật.
	 * @return ChiTietTinKhuyenMaiDienThoai đã được thêm mới hoặc cập nhật.
	 *         Trong trường hợp thêm mới giá trị ID sẽ được cập nhật tương ứng.
	 */
	public ChiTietTinKhuyenMaiDienThoai makePersistent(
			ChiTietTinKhuyenMaiDienThoai c) {

		chiTietTinKhuyenMaiDienThoaiDAO.makePersistent(c);
		return c;
	}

	/**
	 * Tìm các ChiTietTinKhuyenMaiDienThoai của một TinKhuyenMaiDienThoai
	 * 
	 * @param idTinKhuyenMai
	 *            id của TinKhuyenMaiDienThoai.
	 * @return Danh sách ChiTietTinKhuyenMaiDienThoai tìm được.
	 */
	public List<ChiTietTinKhuyenMaiDienThoai> findByTinKhuyenMai(
			int idTinKhuyenMai) {
		return chiTietTinKhuyenMaiDienThoaiDAO
				.findByTinKhuyenMai(idTinKhuyenMai);
	}

	/**
	 * Tìm các ChiTietTinKhuyenMaiDienThoai của một DienThoai.
	 * 
	 * @param idDienThoai
	 *            id của DienThoai.
	 * @return Danh sách ChiTietTinKhuyenMaiDienThoai của DienThoai.
	 */
	public List<ChiTietTinKhuyenMaiDienThoai> findByDienThoai(int idDienThoai) {
		return chiTietTinKhuyenMaiDienThoaiDAO.findByDienThoai(idDienThoai);
	}

	/**
	 * Tìm một ChiTietTinKhuyenMaiDienThoai theo ID.
	 * 
	 * @param id
	 *            id của ChiTietTinKhuyenMaiDienThoai cần tìm.
	 * @return ChiTietTinKhuyenMaiDienThoai tìm được. Nếu không tìm thấy trả về
	 *         null.
	 */
	public ChiTietTinKhuyenMaiDienThoai findById(int id) {
		return chiTietTinKhuyenMaiDienThoaiDAO.findById(id);
	}

	/**
	 * Tìm tất cả các ChiTietTinKhuyenMaiDienThoai.
	 * 
	 * @return Danh sách ChiTietTinKhuyenMaiDienThoai tìm được.
	 */
	public List<ChiTietTinKhuyenMaiDienThoai> findAll() {
		return chiTietTinKhuyenMaiDienThoaiDAO.findAll();
	}
}
