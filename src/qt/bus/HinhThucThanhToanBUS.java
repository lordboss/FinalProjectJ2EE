/**
 * 
 */
package qt.bus;

import java.util.List;

import qt.dao.HinhThucThanhToanDAO;
import qt.dto.HinhThucThanhToan;

/**
 * @author tqthe
 * 
 */
public class HinhThucThanhToanBUS {

	private HinhThucThanhToanDAO hinhThucThanhToanDAO;

	/**
	 * @param hinhThucThanhToanDAO
	 *            the hinhThucThanhToanDAO to set
	 */
	public void setHinhThucThanhToanDAO(
			HinhThucThanhToanDAO hinhThucThanhToanDAO) {
		this.hinhThucThanhToanDAO = hinhThucThanhToanDAO;
	}

	/**
	 * @return the hinhThucThanhToanDAO
	 */
	public HinhThucThanhToanDAO getHinhThucThanhToanDAO() {
		return hinhThucThanhToanDAO;
	}

	/**
	 * Xóa (vĩnh viễn) một HinhThucThanhToan.
	 * 
	 * @param h
	 *            HinhThucThanhToan sẽ bị xóa.
	 */
	public void makeTransient(HinhThucThanhToan h) {
		hinhThucThanhToanDAO.makeTransient(h);
	}

	/**
	 * Thêm mới hoặc cập nhật một HinhThucThanhToan. Việc thêm mới hay cập nhật
	 * được căn cứ vào ID.
	 * 
	 * @param h
	 *            HinhThucThanhToan sẽ được thêm hoặc cập nhật.
	 * @return HinhThucThanhToan vừa được thêm hoặc cập nhật. Giá trị ID sẽ được
	 *         cập nhật trong trường hợp thêm mới.
	 */
	public HinhThucThanhToan makePersistent(HinhThucThanhToan h) {
		hinhThucThanhToanDAO.makePersistent(h);
		return h;
	}

	/**
	 * Tìm một HinhThucThanhToan theo tên.
	 * 
	 * @param name
	 *            tên của HinhThucThanhToan cần tìm.
	 * @return HinhThucThanhToan tìm được. Nếu không tìm thấy trả về null.
	 */
	public HinhThucThanhToan findByName(String name) {
		return hinhThucThanhToanDAO.findByName(name);
	}

	/**
	 * Tìm một HinhThucThanhToan theo ID.
	 * 
	 * @param id
	 *            id của HinhThucThanhToan cần tìm.
	 * @return HinhThucThanhToan tìm được. Nếu không tìm thấy trả về null.
	 */
	public HinhThucThanhToan findById(int id) {
		return hinhThucThanhToanDAO.findById(id);
	}

	/**
	 * Tìm tất cả HinhThucThanhToan.
	 * 
	 * @return Danh sách HinhThucThanhToan.
	 */
	public List<HinhThucThanhToan> findAll() {
		return hinhThucThanhToanDAO.findAll();
	}
}
