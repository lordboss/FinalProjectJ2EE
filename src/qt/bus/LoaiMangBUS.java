/**
 * 
 */
package qt.bus;

import java.util.List;

import qt.dao.LoaiMangDAO;
import qt.dto.LoaiMang;

/**
 * @author tqthe
 * 
 */
public class LoaiMangBUS {

	private LoaiMangDAO loaiMangDAO;

	/**
	 * @param loaiMangDAO
	 *            the loaiMangDAO to set
	 */
	public void setLoaiMangDAO(LoaiMangDAO loaiMangDAO) {
		this.loaiMangDAO = loaiMangDAO;
	}

	/**
	 * @return the loaiMangDAO
	 */
	public LoaiMangDAO getLoaiMangDAO() {
		return loaiMangDAO;
	}

	/**
	 * Tìm tất cả LoaiMang
	 * 
	 * @return Danh sách LoaiMang
	 */
	public List<LoaiMang> findAll() {
		return loaiMangDAO.findAll();
	}

	/**
	 * Tìm một LoaiMang theo ID
	 * 
	 * @param id
	 *            id của LoaiMang cần tìm
	 * @return LoaiMang tìm được. Nếu không tìm thấy trả về null
	 */
	public LoaiMang findById(int id) {
		return loaiMangDAO.findById(id);
	}

	/**
	 * Tìm một LoaiMang theo tên
	 * 
	 * @param name
	 *            Tên của LoaiMang cần tìm.
	 * @return LoaiMang tìm được. Nếu không tìm thấy trả về null.
	 */
	public LoaiMang findByName(String name) {
		return loaiMangDAO.findByName(name);
	}

	/**
	 * Thêm mới hoặc cập nhật LoaiMang. Việc thêm mới hay cập nhật được căn cứ
	 * vào ID.
	 * 
	 * @param n
	 *            LoaiMang sẽ được thêm mới hoặc cập nhật.
	 * @return LoaiMang vừa được thêm mới hoặc cập nhật. Trong trường hợp thêm
	 *         mới giá trị ID sẽ được cập nhật.
	 */
	public LoaiMang makePersistent(LoaiMang n) {
		loaiMangDAO.makePersistent(n);
		return n;
	}

	/**
	 * Xóa (vĩnh viễn) một PhongCach.
	 * 
	 * @param n
	 *            : LoaiMang sẽ bị xóa
	 */
	public void makeTransient(LoaiMang n) {
		loaiMangDAO.makeTransient(n);
	}
}
