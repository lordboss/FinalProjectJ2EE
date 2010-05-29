/**
 * 
 */
package qt.bus;

import java.util.List;

import qt.dao.TrangThaiDonHangDAO;
import qt.dto.TrangThaiDonHang;

/**
 * @author tqthe
 * 
 */
public class TrangThaiDonHangBUS {

	private TrangThaiDonHangDAO trangThaiDonHangDAO;

	/**
	 * @param trangThaiDonHangDAO
	 *            the trangThaiDonHangDAO to set
	 */
	public void setTrangThaiDonHangDAO(TrangThaiDonHangDAO trangThaiDonHangDAO) {
		this.trangThaiDonHangDAO = trangThaiDonHangDAO;
	}

	/**
	 * @return the trangThaiDonHangDAO
	 */
	public TrangThaiDonHangDAO getTrangThaiDonHangDAO() {
		return trangThaiDonHangDAO;
	}

	/**
	 * Thêm hoặc cập nhật một TrangThaiDonHang. Việc thêm hay cập nhật được căn
	 * cứ theo giá trị ID.
	 * 
	 * @param t
	 *            TrangThaiDonHang sẽ được thêm hoặc cập nhật.
	 * @return TrangThaiDonHang vừa được thêm hoặc cập nhật. Trong trường hợp
	 *         thêm mới, giá trị ID sẽ được cập nhật.
	 */
	public TrangThaiDonHang makePersistent(TrangThaiDonHang t) {
		trangThaiDonHangDAO.makePersistent(t);
		return t;
	}

	/**
	 * Xóa (vĩnh viễn) một TrangThaiDonHang.
	 * 
	 * @param t
	 *            TrangThaiDonHang sẽ bị xóa.
	 */
	public void makeTransient(TrangThaiDonHang t) {
		trangThaiDonHangDAO.makeTransient(t);
	}

	/**
	 * Tìm một TrangThaiDonHang theo tên.
	 * 
	 * @param name
	 *            Tên của TrangThaiDonHang cần tìm.
	 * @return TrangThaiDonHang tìm được. Nếu không tìm thấy trả về null.
	 */
	public TrangThaiDonHang findByName(String name) {
		return trangThaiDonHangDAO.findByName(name);
	}

	/**
	 * Tìm một TrangThaiDonHang theo ID.
	 * 
	 * @param id
	 *            id của TrangThaiDonHang cần tìm.
	 * @return TrangThaiDonHang tìm được. Nếu không tìm thấy trả về null.
	 */
	public TrangThaiDonHang findById(int id) {
		return trangThaiDonHangDAO.findById(id);
	}

	/**
	 * Tìm tất cả TrangThaiDonHang.
	 * 
	 * @return Danh sách TrangThaiDonHang.
	 */
	public List<TrangThaiDonHang> findAll() {
		return trangThaiDonHangDAO.findAll();
	}
}
