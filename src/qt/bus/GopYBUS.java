/**
 * 
 */
package qt.bus;

import java.util.List;

import qt.dao.GopYDAO;
import qt.dto.GopY;

/**
 * @author tqthe
 * 
 */
public class GopYBUS {

	private GopYDAO gopYDAO;

	/**
	 * @param gopYDAO
	 *            the gopYDAO to set
	 */
	public void setGopYDAO(GopYDAO gopYDAO) {
		this.gopYDAO = gopYDAO;
	}

	/**
	 * @return the gopYDAO
	 */
	public GopYDAO getGopYDAO() {
		return gopYDAO;
	}

	/**
	 * Lấy danh sách GopY
	 * 
	 * @return danh sách GopY
	 */
	public List<GopY> findAll() {
		return gopYDAO.findAll();
	}

	/**
	 * Lấy danh sách GopY theo trạng thái góp ý
	 * 
	 * @param idTrangThai
	 *            id của trạng thái góp ý
	 * @return Danh sách GopY
	 */
	public List<GopY> findByTrangThai(int idTrangThai) {
		return gopYDAO.findByTrangThai(idTrangThai);
	}

	/**
	 * Tìm danh sách GopY của một KhachHang.
	 * 
	 * @param accountId
	 *            id của KhachHang.
	 * @return Danh sách GopY tìm được.
	 */
	public List<GopY> findByAccountId(int accountId) {
		return gopYDAO.findByAccountId(accountId);
	}
	
	/**
	 * Tìm một GopY theo Id
	 * 
	 * @param id
	 *            id của GopY
	 * @return GopY nếu tìm thấy. Ngược lại trả về null
	 */
	public GopY findById(int id) {
		return gopYDAO.findById(id);
	}

	/**
	 * Thêm mới hoặc cập nhật một GopY.
	 * 
	 * @param g
	 *            GopY cần thêm hoặc cập nhật
	 * @return gopY Trong trường hợp thêm mới id của gopY sẽ được cập nhật
	 */
	public GopY makePersistent(GopY g) {
		gopYDAO.makePersistent(g);
		return g;
	}

	/**
	 * Xóa (vĩnh viễn) một GopY.
	 * 
	 * @param g
	 *            gopY sẽ bị xóa
	 */
	public void makeTransient(GopY g) {
		gopYDAO.makeTransient(g);
	}

	/**
	 * Đánh dấu xóa cho gopY. Góp ý chỉ bị đánh dấu xóa chứ không thực sự bị
	 * xóa. Muốn xóa thực sự dùng method <code>makeTransient</code>
	 * 
	 * @param g
	 *            được đánh dấu xóa
	 */
	public void markAsDeleted(GopY g) {
		gopYDAO.markAsDeleted(g);
	}
}
