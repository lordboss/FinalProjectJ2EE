/**
 * 
 */
package qt.bus;

import java.util.List;

import qt.dao.LoaiPhuKienDAO;
import qt.dto.LoaiPhuKien;

/**
 * @author tqthe
 * 
 */
public class LoaiPhuKienBUS {

	private LoaiPhuKienDAO loaiPhuKienDAO;

	/**
	 * @param loaiPhuKienDAO
	 *            the loaiPhuKienDAO to set
	 */
	public void setLoaiPhuKienDAO(LoaiPhuKienDAO loaiPhuKienDAO) {
		this.loaiPhuKienDAO = loaiPhuKienDAO;
	}

	/**
	 * @return the loaiPhuKienDAO
	 */
	public LoaiPhuKienDAO getLoaiPhuKienDAO() {
		return loaiPhuKienDAO;
	}

	/**
	 * Xóa (vĩnh viễn) một LoaiPhuKien. <b>Cascade delete có thể xảy ra!!!</b>
	 * 
	 * @param c
	 *            LoaiPhuKien sẽ được xóa.
	 */
	public void makeTransient(LoaiPhuKien c) {
		loaiPhuKienDAO.makeTransient(c);
	}

	/**
	 * Thêm mới hoặc cập nhật một LoaiPhuKien. Việc thêm mới hay cập nhật được
	 * căn cứ vào ID.
	 * 
	 * @param c
	 *            LoaiPhuKien sẽ được thêm mới hoặc cập nhật.
	 * @return LoaiPhuKien đã được thêm mới hoặc cập nhật. Trong trường hợp thêm
	 *         mới giá trị ID sẽ được cập nhật.
	 */
	public LoaiPhuKien makePersistent(LoaiPhuKien c) {
		loaiPhuKienDAO.makePersistent(c);
		return c;
	}

	/**
	 * Tìm một LoaiPhuKien theo tên.
	 * 
	 * @param name
	 *            Tên của LoaiPhuKien cần tìm.
	 * @return LoaiPhuKien cần tìm. Nếu không tìm thấy trả về null.
	 */
	public LoaiPhuKien findByName(String name) {
		return loaiPhuKienDAO.findByName(name);
	}

	/**
	 * Tìm một LoaiPhuKien theo ID.
	 * 
	 * @param id
	 *            id của LoaiPhuKien cần tìm.
	 * @return LoaiPhuKien tìm được. Nếu không tìm thấy trả về null.
	 */
	public LoaiPhuKien findById(int id) {
		return loaiPhuKienDAO.findById(id);
	}

	/**
	 * Tìm tất cả LoaiPhuKien.
	 * 
	 * @return Danh sách LoaiPhuKien.
	 */
	public List<LoaiPhuKien> findAll() {
		return loaiPhuKienDAO.findAll();
	}
}
