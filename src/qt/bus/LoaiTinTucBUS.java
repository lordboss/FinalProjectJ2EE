/**
 * 
 */
package qt.bus;

import java.util.List;

import qt.dao.LoaiTinTucDAO;
import qt.dto.LoaiTinTuc;

/**
 * @author tqthe
 * 
 */
public class LoaiTinTucBUS {

	private LoaiTinTucDAO loaiTinTucDAO;

	/**
	 * @param loaiTinTucDAO
	 *            the loaiTinTucDAO to set
	 */
	public void setLoaiTinTucDAO(LoaiTinTucDAO loaiTinTucDAO) {
		this.loaiTinTucDAO = loaiTinTucDAO;
	}

	/**
	 * @return the loaiTinTucDAO
	 */
	public LoaiTinTucDAO getLoaiTinTucDAO() {
		return loaiTinTucDAO;
	}

	/**
	 * Tìm tất cả LoaiTinTuc
	 * 
	 * @return Danh sách LoaiTinTuc
	 */
	public List<LoaiTinTuc> findAll() {
		return loaiTinTucDAO.findAll();
	}

	/**
	 * Tìm một LoaiTinTuc theo id
	 * 
	 * @param idLoaiTinTuc
	 *            id của LoaiTinTuc cần tìm
	 * @return LoaiTinTuc nếu tìm thấy. Ngược lại trả về null
	 */
	public LoaiTinTuc findById(int idLoaiTinTuc) {
		return loaiTinTucDAO.findById(idLoaiTinTuc);
	}

	/**
	 * Thêm mới hoặc cập nhật một LoaiTinTuc. Việc thêm mới hay cập nhật phụ
	 * thục vào giá trị của id
	 * 
	 * @param c
	 *            LoaiTinTuc được thêm mới hoặc cập nhật.
	 * @return LoaiTinTuc vừa được thêm mới hoặc cập nhật. (Trong trường hợp
	 *         thêm mới giá trị id sẽ thay đổi).
	 */
	public LoaiTinTuc makePersistent(LoaiTinTuc c) {
		loaiTinTucDAO.makePersistent(c);
		return c;
	}

	/**
	 * Xóa (vĩnh viễn) một LoaiTinTuc.
	 * 
	 * @param c
	 *            LoaiTinTuc sẽ bị xóa
	 * @param force
	 *            Nếu force=true xóa LoaiTinTuc và các TinTuc thuộc về
	 *            LoaiTinTuc này. Nếu force=false, quá trình xóa có thể văng
	 *            Exception nếu LoaiTinTuc có danh sách các TinTuc.
	 * @throws Exception
	 *             LoaiTinTuc đã có danh sách TinTuc và tham số force=false.
	 */
	public void makeTransient(LoaiTinTuc c, boolean force) throws Exception {
		loaiTinTucDAO.makeTransient(c, force);
	}
}
