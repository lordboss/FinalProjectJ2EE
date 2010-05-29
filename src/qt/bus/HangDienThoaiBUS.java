/**
 * 
 */
package qt.bus;

import java.util.List;

import qt.dao.HangDienThoaiDAO;
import qt.dto.HangDienThoai;

/**
 * @author tqthe
 * 
 */
public class HangDienThoaiBUS {

	private HangDienThoaiDAO hangDienThoaiDAO;

	/**
	 * @param hangDienThoaiDAO
	 *            the hangDienThoaiDAO to set
	 */
	public void setHangDienThoaiDAO(HangDienThoaiDAO hangDienThoaiDAO) {
		this.hangDienThoaiDAO = hangDienThoaiDAO;
	}

	/**
	 * @return the hangDienThoaiDAO
	 */
	public HangDienThoaiDAO getHangDienThoaiDAO() {
		return hangDienThoaiDAO;
	}

	/**
	 * Tìm tất cả các HangDienThoai.
	 * 
	 * @return Danh sách các HangDienThoai
	 */
	public List<HangDienThoai> findAll() {
		return hangDienThoaiDAO.findAll();
	}

	/**
	 * Tìm một HangDienThoai theo id
	 * 
	 * @param id
	 *            id của HangDienThoai cần tìm
	 * @return HangDienThoai tìm được. Nếu không tìm thấy trả về null
	 */
	public HangDienThoai findById(int id) {
		return hangDienThoaiDAO.findById(id);
	}

	/**
	 * Thêm mới hoặc cập nhật một HangDienThoai. Việc thêm mới hay cập nhật được
	 * căn cứ trên ID.
	 * 
	 * @param h
	 *            HangDienThoai sẽ được thêm mới hoặc cập nhật.
	 * @return HangDienThoai đã được thêm mới hoặc cập nhật. Giá trị id sẽ được
	 *         cập nhật trong trường hợp thêm mới.
	 */
	public HangDienThoai makePersistent(HangDienThoai h) {
		hangDienThoaiDAO.makePersistent(h);
		return h;
	}

	/**
	 * Xóa (vĩnh viễn) một HangDienThoai.
	 * 
	 * @param h
	 *            HangDienThoai sẽ bị xóa
	 */
	public void makeTransient(HangDienThoai h) {
		hangDienThoaiDAO.makeTransient(h);
	}

}
