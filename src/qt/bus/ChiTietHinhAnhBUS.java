/**
 * 
 */
package qt.bus;

import java.util.List;

import qt.dao.ChiTietHinhAnhDAO;
import qt.dto.ChiTietHinhAnh;

/**
 * @author tqthe
 * 
 */
public class ChiTietHinhAnhBUS {

	private ChiTietHinhAnhDAO chiTietHinhAnhDAO;

	/**
	 * @param chiTietHinhAnhDAO
	 *            the chiTietHinhAnhDAO to set
	 */
	public void setChiTietHinhAnhDAO(ChiTietHinhAnhDAO chiTietHinhAnhDAO) {
		this.chiTietHinhAnhDAO = chiTietHinhAnhDAO;
	}

	/**
	 * @return the chiTietHinhAnhDAO
	 */
	public ChiTietHinhAnhDAO getChiTietHinhAnhDAO() {
		return chiTietHinhAnhDAO;
	}

	/**
	 * Đánh dấu xóa một ChiTietHinhAnh
	 * 
	 * @param c
	 *            ChiTietHinhAnh bị đánh dấu xóa.
	 */
	public void markAsDeleted(ChiTietHinhAnh c) {
		chiTietHinhAnhDAO.markAsDeleted(c);
	}

	/**
	 * Xóa (vĩnh viễn) một ChiTietHinhAnh.
	 * 
	 * @param c
	 *            ChiTietHinhAnh sẽ bị xóa.
	 */
	public void makeTransient(ChiTietHinhAnh c) {
		chiTietHinhAnhDAO.makeTransient(c);
	}

	/**
	 * Thêm mới hoặc cập nhật ChiTietHinhAnh. Việc thêm mới hay cập nhật phụ
	 * thuộc vào ID.
	 * 
	 * @param c
	 *            ChiTietHinhAnh sẽ được thêm mới hay cập nhật.
	 * @return ChiTietHinhAnh vừa được thêm mới hay cập nhật. Trong trường hợp
	 *         thêm mới giá trị của ID sẽ được cập nhật tương ứng.
	 */
	public ChiTietHinhAnh makePersistent(ChiTietHinhAnh c) {
		chiTietHinhAnhDAO.makePersistent(c);
		return c;
	}

	/**
	 * Tìm các ChiTietHinhAnh của một SanPham.
	 * 
	 * @param id
	 *            id của SanPham cần tìm danh sách ChiTietHinhAnh.
	 * @return Danh sách ChiTietHinhAnh của SanPham.
	 */
	public List<ChiTietHinhAnh> findBySanPham(int id) {
		return chiTietHinhAnhDAO.findBySanPham(id);
	}

	/**
	 * Tìm một ChiTietHinhAnh theo ID
	 * 
	 * @param id
	 *            id của ChiTietHinhAnh cần tìm.
	 * @return ChiTietHinhAnh tìm được. Nếu không tìm thấy trả về null.
	 */
	public ChiTietHinhAnh findById(int id) {
		return chiTietHinhAnhDAO.findById(id);
	}

	/**
	 * Tìm tất cả ChiTietHinhAnh.
	 * 
	 * @return Danh sách ChiTietHinhAnh tìm được.
	 */
	public List<ChiTietHinhAnh> findAll() {
		return chiTietHinhAnhDAO.findAll();
	}
}
