/**
 * 
 */
package qt.bus;

import java.util.List;

import qt.dao.TrangThaiGopYDAO;
import qt.dto.GopY;
import qt.dto.TrangThaiGopY;

/**
 * @author tqthe
 * 
 */
public class TrangThaiGopYBUS {

	private TrangThaiGopYDAO trangThaiGopYDAO;

	/**
	 * @param trangThaiGopYDAO
	 *            the trangThaiGopYDAO to set
	 */
	public void setTrangThaiGopYDAO(TrangThaiGopYDAO trangThaiGopYDAO) {
		this.trangThaiGopYDAO = trangThaiGopYDAO;
	}

	/**
	 * @return the trangThaiGopYDAO
	 */
	public TrangThaiGopYDAO getTrangThaiGopYDAO() {
		return trangThaiGopYDAO;
	}

	/**
	 * Lấy danh sách TrangThaiGopY
	 * 
	 * @return Danh sách TrangThaiGopY
	 */
	public List<TrangThaiGopY> findAll() {
		return trangThaiGopYDAO.findAll();
	}

	/**
	 * Tìm kiếm một TrangThaiGopY theo id
	 * 
	 * @param id
	 *            id dùng để tìm kiếm
	 * @return Một đối tượng TrangThaiTimKiem. Nếu không tìm thấy trả về null
	 */
	public TrangThaiGopY findById(int id) {
		return trangThaiGopYDAO.findById(id);
	}

	/**
	 * Thêm mới hoặc cập nhật một trạng thái góp ý. Nếu ID của trangThaiGopY
	 * chưa có trong CSDL (hoặc trùng với giá trị unsave-value trong
	 * TrangThaiGopY.hbm.xml) thi thực hiện thêm mới. Ngược lại thực hiện cập
	 * nhật
	 * 
	 * @param t
	 *            trạng thái góp ý cần được thêm mới hoặc cập nhật
	 * @return Trạng thái góp ý vừa được persist. (Nếu thêm mới và ID ở chế độ
	 *         auto trong CSDL thì giá trị ID được cập nhật)
	 */
	public TrangThaiGopY makePersistent(TrangThaiGopY t) {
		trangThaiGopYDAO.makePersistent(t);
		return t;
	}

	/**
	 * Xóa (vĩnh viễn) một TrangThaiGopY.
	 * 
	 * @param force
	 *            Nếu force=true xóa TrangThaiGopY và các GopY thuộc về
	 *            TrangThaiGopY. Nếu force=false throw Exception nếu
	 *            TrangThaiGopY đã có các GopY.
	 * @param t
	 *            TrangThaiGopY sẽ bị xóa.
	 * @throws Exception
	 *             Khi một TrangThaiGopY có nhiều GopY và tham số force=false
	 *             thì không xóa được.
	 */
	public void makeTransient(TrangThaiGopY t, boolean force) throws Exception {
		trangThaiGopYDAO.makeTransient(t, force);
	}

	/**
	 * Lấy danh sách góp ý của một loại trạng thái góp ý.
	 * 
	 * @param idTrangThaiGopY
	 *            - id của loại trạng thái góp ý
	 * @return Danh sách các góp ý. Danh sách rỗng nếu không tìm thấy.
	 */
	public List<GopY> findByTrangThaiGopY(int idTrangThaiGopY) {
		return trangThaiGopYDAO.findByTrangThaiGopY(idTrangThaiGopY);
	}

	/**
	 * Tìm một trạng thái theo tên
	 * 
	 * @param tenTrangThai
	 *            tên của trạng thái cần tìm
	 * @return TrangThaiGopY cần tìm. Null nếu không tìm thấy
	 */
	public TrangThaiGopY findByTenTrangThai(String tenTrangThai) {
		return trangThaiGopYDAO.findByTenTrangThai(tenTrangThai);
	}
}
