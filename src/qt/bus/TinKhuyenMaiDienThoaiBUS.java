/**
 * 
 */
package qt.bus;

import java.util.List;

import qt.dao.TinKhuyenMaiDienThoaiDAO;
import qt.dto.TinKhuyenMaiDienThoai;

/**
 * @author tqthe
 * 
 */
public class TinKhuyenMaiDienThoaiBUS {

	private TinKhuyenMaiDienThoaiDAO tinKhuyenMaiDienThoaiDAO;

	/**
	 * @param tinKhuyenMaiDienThoaiDAO
	 *            the tinKhuyenMaiDienThoaiDAO to set
	 */
	public void setTinKhuyenMaiDienThoaiDAO(
			TinKhuyenMaiDienThoaiDAO tinKhuyenMaiDienThoaiDAO) {
		this.tinKhuyenMaiDienThoaiDAO = tinKhuyenMaiDienThoaiDAO;
	}

	/**
	 * @return the tinKhuyenMaiDienThoaiDAO
	 */
	public TinKhuyenMaiDienThoaiDAO getTinKhuyenMaiDienThoaiDAO() {
		return tinKhuyenMaiDienThoaiDAO;
	}

	/**
	 * Xóa (vĩnh viễn) một TinKhuyenMaiDienThoai. Các
	 * ChiTietTinKhuyenMaiDienThoai thuộc về TinKhuyenMaiDienThoai này sẽ bị xóa
	 * theo.
	 * 
	 * @param t
	 *            TinKhuyenMaiDienThoai sẽ bị xóa.
	 */
	public void makeTransient(TinKhuyenMaiDienThoai t) {
		tinKhuyenMaiDienThoaiDAO.makeTransient(t);
	}

	/**
	 * Đánh dấu xóa TinKhuyenMaiDienThoai. Một TinKhuyenMaiDienThoai bị đánh dấu
	 * xóa sẽ không bị xóa thực sự. Các ChiTietTinKhuyenMaiDienThoai thuộc về
	 * TinKhuyenMaiDienThoai này sẽ bị đánh dấu xóa theo.
	 * 
	 * @param t
	 *            TinKhuyenMaiDienThoai sẽ bị dánh dấu xóa.
	 */
	public void markAsDeleted(TinKhuyenMaiDienThoai t) {
		tinKhuyenMaiDienThoaiDAO.markAsDeleted(t);
	}

	/**
	 * Thêm hoặc cập nhật một TinKhuyenMaiDienThoai. Việc thêm hay cập nhật phụ
	 * thuộc vào giá trị ID.
	 * 
	 * @param t
	 *            TinKhuyenMaiDienThoai sẽ được thêm hoặc cập nhật.
	 * @return TinKhuyenMaiDienThoai TinKhuyenMaiDienThoai đã được thêm hoặc cập
	 *         nhật. Trong trường hợp thêm mới giá trị ID sẽ được cập nhật tương
	 *         ứng.
	 */
	public TinKhuyenMaiDienThoai makePersistent(TinKhuyenMaiDienThoai t) {
		tinKhuyenMaiDienThoaiDAO.makePersistent(t);
		return t;
	}

	/**
	 * Tìm một TinKhuyenMaiDienThoai theo ID
	 * 
	 * @param id
	 *            id của TinKhuyenMaiDienThoai cần tìm.
	 * @return TinKhuyenMaiDienThoai tìm được
	 */
	public TinKhuyenMaiDienThoai findById(int id) {
		return tinKhuyenMaiDienThoaiDAO.findById(id);
	}

	/**
	 * Tìm tất cả các TinKhuyenMaiDienThoai
	 * 
	 * @return Danh sách TinKhuyenMaiDienThoai tìm được.
	 */
	public List<TinKhuyenMaiDienThoai> findAll() {
		return tinKhuyenMaiDienThoaiDAO.findAll();
	}
}
