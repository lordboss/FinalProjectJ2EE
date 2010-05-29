/**
 * 
 */
package qt.bus;

import java.util.List;

import qt.dao.TinGiamGiaPhuKienDAO;
import qt.dto.TinGiamGiaPhuKien;

/**
 * @author tqthe
 * 
 */
public class TinGiamGiaPhuKienBUS {

	private TinGiamGiaPhuKienDAO tinGiamGiaPhuKienDAO;

	/**
	 * @param tinGiamGiaPhuKienDAO
	 *            the tinGiamGiaPhuKienDAO to set
	 */
	public void setTinGiamGiaPhuKienDAO(
			TinGiamGiaPhuKienDAO tinGiamGiaPhuKienDAO) {
		this.tinGiamGiaPhuKienDAO = tinGiamGiaPhuKienDAO;
	}

	/**
	 * @return the tinGiamGiaPhuKienDAO
	 */
	public TinGiamGiaPhuKienDAO getTinGiamGiaPhuKienDAO() {
		return tinGiamGiaPhuKienDAO;
	}

	/**
	 * Đánh dấu xóa một TinGiamGiaPhuKien. TinGiamGiaPhuKien sẽ không bị xóa
	 * thật sự.
	 * 
	 * @param t
	 *            TinGiamGiaPhuKien sẽ bị đánh dấu xóa.
	 */
	public void markAsDeleted(TinGiamGiaPhuKien t) {
		tinGiamGiaPhuKienDAO.markAsDeleted(t);
	}

	/**
	 * Xóa (vĩnh viễn) một TinGiamGiaPhuKien.
	 * 
	 * @param t
	 *            TinGiamGiaPhuKien sẽ bị xóa.
	 */
	public void makeTransient(TinGiamGiaPhuKien t) {
		tinGiamGiaPhuKienDAO.makeTransient(t);
	}

	/**
	 * Thêm mới hoặc cập nhật TinGiamGiaPhuKien. Việc thêm mới hay cập nhật phụ
	 * thuộc vào giá trị ID.
	 * 
	 * @param t
	 *            TinGiamGiaPhuKien sẽ được thêm hoặc cập nhật.
	 * @return TinGiamGiaPhuKien vừa được thêm hoặc cập nhật. Trong trường hợp
	 *         thêm mới giá trị ID sẽ được cập nhật tương ứng.
	 */
	public TinGiamGiaPhuKien makePersistent(TinGiamGiaPhuKien t) {
		tinGiamGiaPhuKienDAO.makePersistent(t);
		return t;
	}

	/**
	 * Tìm các TinGiamGiaPhuKien của một PhuKien.
	 * 
	 * @param id
	 *            id của PhuKien cần tìm TinGiamGiaPhuKien.
	 * @return Danh sách TinGiamGiaPhuKien của một PhuKien.
	 */
	public List<TinGiamGiaPhuKien> findByPhuKien(int id) {
		return tinGiamGiaPhuKienDAO.findByPhuKien(id);
	}

	/**
	 * Tìm một TinGiamGiaPhuKien theo ID.
	 * 
	 * @param id
	 *            id của TinGiamGiaPhuKien cần tìm.
	 * @return TinGiamGiaPhuKien tìm được. Nếu không tìm thấy trả về null.
	 */
	public TinGiamGiaPhuKien findById(int id) {
		return tinGiamGiaPhuKienDAO.findById(id);
	}

	/**
	 * Tìm tất cả TinGiamGiaPhuKien
	 * 
	 * @return Danh sách TinGiamGiaPhuKien tìm được.
	 */
	public List<TinGiamGiaPhuKien> findAll() {
		return tinGiamGiaPhuKienDAO.findAll();
	}
}
