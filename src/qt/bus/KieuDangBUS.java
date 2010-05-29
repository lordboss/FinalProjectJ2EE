/**
 * 
 */
package qt.bus;

import java.util.List;

import qt.dao.KieuDangDAO;
import qt.dto.KieuDang;

/**
 * @author tqthe
 * 
 */
public class KieuDangBUS {

	private KieuDangDAO kieuDangDAO;

	/**
	 * @param kieuDangDAO
	 *            the kieuDangDAO to set
	 */
	public void setKieuDangDAO(KieuDangDAO kieuDangDAO) {
		this.kieuDangDAO = kieuDangDAO;
	}

	/**
	 * @return the kieuDangDAO
	 */
	public KieuDangDAO getKieuDangDAO() {
		return kieuDangDAO;
	}

	/**
	 * Tìm tất cả KieuDang
	 * 
	 * @return Danh sách KieuDang
	 */
	public List<KieuDang> findAll() {
		return kieuDangDAO.findAll();
	}

	/**
	 * Tìm một KieuDang theo ID
	 * 
	 * @param id
	 *            id của KieuDang cần tìm
	 * @return KieuDang tìm được. Nếu không tìm thấy trả về null
	 */
	public KieuDang findById(int id) {
		return kieuDangDAO.findById(id);
	}

	/**
	 * Tìm một KieuDang theo tên
	 * 
	 * @param name
	 *            Tên của KieuDang cần tìm.
	 * @return KieuDang tìm được. Nếu không tìm thấy trả về null.
	 */
	public KieuDang findByName(String name) {
		return kieuDangDAO.findByName(name);
	}

	/**
	 * Thêm mới hoặc cập nhật KieuDang. Việc thêm mới hay cập nhật được căn cứ
	 * vào ID.
	 * 
	 * @param k
	 *            KieuDang sẽ được thêm mới hoặc cập nhật.
	 * @return KieuDang vừa được thêm mới hoặc cập nhật. Trong trường hợp thêm
	 *         mới giá trị ID sẽ được cập nhật.
	 */
	public KieuDang makePersistent(KieuDang k) {
		kieuDangDAO.makePersistent(k);
		return k;
	}

	/**
	 * Xóa (vĩnh viễn) một KieuDang.
	 * 
	 * @param k
	 *            : KieuDang sẽ bị xóa
	 */
	public void makeTransient(KieuDang k) {
		kieuDangDAO.makeTransient(k);
	}
}
