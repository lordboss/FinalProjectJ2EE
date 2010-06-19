/**
 * 
 */
package qt.bus;

import java.util.List;

import qt.dao.NhanXetDienThoaiDAO;
import qt.dto.NhanXetDienThoai;

/**
 * @author tqthe
 * 
 */
public class NhanXetDienThoaiBUS {

	private NhanXetDienThoaiDAO nhanXetDienThoaiDAO;

	/**
	 * @param nhanXetDienThoaiDAO
	 *            the nhanXetDienThoaiDAO to set
	 */
	public void setNhanXetDienThoaiDAO(NhanXetDienThoaiDAO nhanXetDienThoaiDAO) {
		this.nhanXetDienThoaiDAO = nhanXetDienThoaiDAO;
	}

	/**
	 * @return the nhanXetDienThoaiDAO
	 */
	public NhanXetDienThoaiDAO getNhanXetDienThoaiDAO() {
		return nhanXetDienThoaiDAO;
	}

	/**
	 * Đánh đấu xóa một NhanXetDienThoai. NhanXetDienThoai sẽ không bị xóa thật
	 * sự.
	 * 
	 * @param c
	 *            NhanXetDienThoai bị đánh dấu xóa.
	 */
	public void markAsDeleted(NhanXetDienThoai c) {
		nhanXetDienThoaiDAO.markAsDeleted(c);
	}

	/**
	 * Xóa vĩnh viễn một NhanXetDienThoai.
	 * 
	 * @param c
	 *            NhanXetDienThoai sẽ bị xóa.
	 */
	public void makeTransient(NhanXetDienThoai c) {
		nhanXetDienThoaiDAO.makeTransient(c);
	}

	/**
	 * Thêm mới hoặc cập nhật một NhanXetDienThoai. Việc thêm mới hay cập nhật
	 * được căn cứ trên giá trị ID.
	 * 
	 * @param c
	 *            NhanXetDienThoai sẽ được thêm mới hay cập nhật.
	 * @return NhanXetDienThoai vừa được thêm mới hay cập nhật. Trong trường hợp
	 *         thêm mới giá trị ID sẽ được cập nhật tương ứng.
	 */
	public NhanXetDienThoai makePersistent(NhanXetDienThoai c) {
		nhanXetDienThoaiDAO.makePersistent(c);
		return c;
	}

	/**
	 * Tìm tất cả NhanXetDienThoai của một KhachHang.
	 * 
	 * @param idKhachHang
	 *            id của KhachHang cần lấy danh sách NhanXetDienThoai.
	 * @return Danh sách NhanXetDienThoai của một KhachHang.
	 */
	public List<NhanXetDienThoai> findByKhachHang(int idKhachHang) {
		if (idKhachHang < 0) {
			return nhanXetDienThoaiDAO.findByAnonymous();
		}
		return nhanXetDienThoaiDAO.findByKhachHang(idKhachHang);
	}

	/**
	 * Tìm các NhanXetDienThoai của Anonymous
	 * 
	 * @return Danh sách NhanXetDienThoai của Anonymous
	 */
	public List<NhanXetDienThoai> findByAnonymous() {
		return nhanXetDienThoaiDAO.findByAnonymous();
	}
	
	/**
	 * Tìm tất cả NhanXetDienThoai của một loại DienThoai.
	 * 
	 * @param idDienThoai
	 *            id của DienThoai cần lấy nhận xét.
	 * @return Danh sách NhanXetDienThoai của một loại DienThoai.
	 */
	public List<NhanXetDienThoai> findByDienThoai(int idDienThoai) {
		return nhanXetDienThoaiDAO.findByDienThoai(idDienThoai);
	}

	/**
	 * Tìm một NhanXetDienThoai theo ID.
	 * 
	 * @param id
	 *            id của NhanXetDienThoai cần tìm.
	 * @return NhanXetDienThoai tìm được. Trả về null nếu không tìm thấy.
	 */
	public NhanXetDienThoai findById(int id) {
		return nhanXetDienThoaiDAO.findById(id);
	}

	/**
	 * Tìm tất cả NhanXetDienThoai.
	 * 
	 * @return Danh sách NhanXetDienThoai tìm được.
	 */
	public List<NhanXetDienThoai> findAll() {
		return nhanXetDienThoaiDAO.findAll();
	}
}
