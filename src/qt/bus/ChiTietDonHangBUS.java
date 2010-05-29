/**
 * 
 */
package qt.bus;

import java.util.List;

import qt.dao.ChiTietDonHangDAO;
import qt.dto.ChiTietDonHang;

/**
 * @author tqthe
 * 
 */
public class ChiTietDonHangBUS {

	private ChiTietDonHangDAO chiTietDonHangDAO;

	/**
	 * @param chiTietDonHangDAO
	 *            the chiTietDonHangDAO to set
	 */
	public void setChiTietDonHangDAO(ChiTietDonHangDAO chiTietDonHangDAO) {
		this.chiTietDonHangDAO = chiTietDonHangDAO;
	}

	/**
	 * @return the chiTietDonHangDAO
	 */
	public ChiTietDonHangDAO getChiTietDonHangDAO() {
		return chiTietDonHangDAO;
	}

	/**
	 * Đánh dấu xóa một ChiTietDonHang
	 * 
	 * @param c
	 *            ChiTietDonHang sẽ bị đánh dấu xóa.
	 */
	public void markAsDeleted(ChiTietDonHang c) {
		chiTietDonHangDAO.markAsDeleted(c);
	}

	/**
	 * Xóa (vĩnh viễn) một ChiTietDonHang.
	 * 
	 * @param c
	 *            ChiTietDonHang sẽ bị xóa.
	 */
	public void makeTransient(ChiTietDonHang c) {
		chiTietDonHangDAO.makeTransient(c);
	}

	/**
	 * Thêm mới hay cập nhật một ChiTietDonHang. Việc thêm mới hay cập nhật phụ
	 * thuộc vào giá trị ID.
	 * 
	 * @param c
	 *            ChiTietDonHang sẽ được thêm mới hoặc cập nhật.
	 * @return ChiTietDonHang đã được thêm mới hoặc cập nhật. Trong trường hợp
	 *         thêm mới giá trị ID sẽ được cập nhật tương ứng.
	 */
	public ChiTietDonHang makePersistent(ChiTietDonHang c) {
		chiTietDonHangDAO.makePersistent(c);
		return c;
	}

	/**
	 * Tìm các ChiTietDonHang của một SanPham
	 * 
	 * @param idSanPham
	 *            id của SanPham.
	 * @return Danh sách ChiTietDonHang của SanPham.
	 */
	public List<ChiTietDonHang> findBySanPham(int idSanPham) {
		return chiTietDonHangDAO.findBySanPham(idSanPham);
	}

	/**
	 * Tìm các ChiTietDonHang của một DonHang.
	 * 
	 * @param idDonHang
	 *            id của DonHang.
	 * @return Danh sách ChiTietDonHang của DonHang.
	 */
	public List<ChiTietDonHang> findByDonHang(int idDonHang) {
		return chiTietDonHangDAO.findByDonHang(idDonHang);
	}

	/**
	 * Tìm một ChiTietDonHang theo ID
	 * 
	 * @param id
	 *            id của ChiTietDonHang cần tìm.
	 * @return ChiTietDonHang tìm được. Nếu không tìm thấy trả về null.
	 */
	public ChiTietDonHang findById(int id) {
		return chiTietDonHangDAO.findById(id);
	}

	/**
	 * Tìm tất cả ChiTietDonHang.
	 * 
	 * @return Danh sách ChiTietDonHang tìm được.
	 */
	public List<ChiTietDonHang> findAll() {
		return chiTietDonHangDAO.findAll();
	}
}
