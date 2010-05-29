/**
 * 
 */
package qt.bus;

import java.util.List;

import qt.dao.HeDieuHanhDAO;
import qt.dto.HeDieuHanh;

/**
 * @author tqthe
 *
 */
public class HeDieuHanhBUS {

	private HeDieuHanhDAO heDieuHanhDAO;

	/**
	 * @param heDieuHanhDAO the heDieuHanhDAO to set
	 */
	public void setHeDieuHanhDAO(HeDieuHanhDAO heDieuHanhDAO) {
		this.heDieuHanhDAO = heDieuHanhDAO;
	}

	/**
	 * @return the heDieuHanhDAO
	 */
	public HeDieuHanhDAO getHeDieuHanhDAO() {
		return heDieuHanhDAO;
	} 
	
	/**
	 * Tìm tất cả HeDieuHanh
	 * 
	 * @return Danh sách HeDieuHanh
	 */
	public List<HeDieuHanh> findAll() {
		return heDieuHanhDAO.findAll();
	}

	/**
	 * Tìm một HeDieuHanh theo id
	 * 
	 * @param id
	 *            id của HeDieuHanh cần tìm
	 * @return HeDieuHanh tìm được. Nếu không tìm thấy trả về null.
	 */
	public HeDieuHanh findById(int id) {
		return heDieuHanhDAO.findById(id);
	}

	/**
	 * Tìm một HeDieuHanh theo tên.
	 * 
	 * @param name
	 *            Tên của HeDieuHanh cần tìm.
	 * @return HeDieuHanh tìm được. Nếu không tìm thấy trả về null.
	 */
	public HeDieuHanh findByName(String name) {
		return heDieuHanhDAO.findByName(name);
	}

	/**
	 * Thêm mới hoặc cập nhật một HeDieuHanh. Việc thêm mới hay cập nhật được
	 * căn cứ theo ID.
	 * 
	 * @param h
	 *            HeDieuHanh sẽ được thêm mới hay cập nhật.
	 * @return HeDieuHanh vừa được thêm mới hay cập nhật. Trong trường hợp thêm
	 *         mới giá trị id được cập nhật.
	 */
	public HeDieuHanh makePersistent(HeDieuHanh h) {
		heDieuHanhDAO.makePersistent(h);
		return h;
	}

	/**
	 * Xóa (vĩnh viễn) một HeDieuHanh.
	 * 
	 * @param h
	 *            HeDieuHanh sẽ bị xóa.
	 */
	public void makeTransient(HeDieuHanh h) {
		heDieuHanhDAO.makeTransient(h);
	}
}
