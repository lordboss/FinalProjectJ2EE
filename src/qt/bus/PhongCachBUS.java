/**
 * 
 */
package qt.bus;

import java.util.List;

import qt.dao.PhongCachDAO;
import qt.dto.PhongCach;

/**
 * @author tqthe
 * 
 */
public class PhongCachBUS {

	private PhongCachDAO phongCachDAO;

	/**
	 * @param phongCachDAO
	 *            the phongCachDAO to set
	 */
	public void setPhongCachDAO(PhongCachDAO phongCachDAO) {
		this.phongCachDAO = phongCachDAO;
	}

	/**
	 * @return the phongCachDAO
	 */
	public PhongCachDAO getPhongCachDAO() {
		return phongCachDAO;
	}

	/**
	 * Tìm tất cả PhongCach
	 * 
	 * @return Danh sách PhongCach
	 */
	public List<PhongCach> findAll() {
		return phongCachDAO.findAll();
	}

	/**
	 * Tìm một PhongCach theo ID
	 * 
	 * @param id
	 *            id của PhongCach cần tìm
	 * @return PhongCach tìm được. Nếu không tìm thấy trả về null
	 */
	public PhongCach findById(int id) {
		return phongCachDAO.findById(id);
	}

	/**
	 * Tìm một PhongCach theo tên
	 * 
	 * @param name
	 *            Tên của PhongCach cần tìm.
	 * @return PhongCach tìm được. Nếu không tìm thấy trả về null.
	 */
	public PhongCach findByName(String name) {
		return phongCachDAO.findByName(name);
	}

	/**
	 * Thêm mới hoặc cập nhật PhongCach. Việc thêm mới hay cập nhật được căn cứ
	 * vào ID.
	 * 
	 * @param p
	 *            PhongCach sẽ được thêm mới hoặc cập nhật.
	 * @return PhongCach vừa được thêm mới hoặc cập nhật. Trong trường hợp thêm
	 *         mới giá trị ID sẽ được cập nhật.
	 */
	public PhongCach makePersistent(PhongCach p) {
		phongCachDAO.makePersistent(p);
		return p;
	}

	/**
	 * Xóa (vĩnh viễn) một PhongCach.
	 * 
	 * @param p
	 *            : PhongCach sẽ bị xóa
	 */
	public void makeTransient(PhongCach p) {
		phongCachDAO.makeTransient(p);
	}
}
