/**
 * 
 */
package qt.bus;

import java.util.List;

import qt.dao.KhachHangDAO;
import qt.dto.KhachHang;

/**
 * @author tqthe
 * 
 */
public class KhachHangBUS {

	private KhachHangDAO khachHangDAO;

	/**
	 * @param khachHangDAO
	 *            the khachHangDAO to set
	 */
	public void setKhachHangDAO(KhachHangDAO khachHangDAO) {
		this.khachHangDAO = khachHangDAO;
	}

	/**
	 * @return the khachHangDAO
	 */
	public KhachHangDAO getKhachHangDAO() {
		return khachHangDAO;
	}

	/**
	 * Tìm một KhachHang theo ID.
	 * 
	 * @param id
	 *            id của KhachHang cần tìm.
	 * @return KhachHang tìm được. Nếu không tìm thấy trả về null.
	 */
	public KhachHang findById(int id) {
		return khachHangDAO.findById(id);
	}

	/**
	 * Tìm tất cả các KhachHang.
	 * 
	 * @return Danh sách KhachHang tìm được.
	 */
	public List<KhachHang> findAll() {
		return khachHangDAO.findAll();
	}

	/**
	 * Đánh dấu xóa một KhachHang.
	 * 
	 * @param k
	 *            KhachHang sẽ bị đánh dấu xóa.
	 */
	public void markAsDeleted(KhachHang k) {
		khachHangDAO.markAsDeleted(k);
	}

	/**
	 * Xóa (vĩnh viễn) một KhachHang.
	 * 
	 * @param k
	 *            KhachHang sẽ bị xóa.
	 * @param force
	 * <br>
	 *            Nếu <code>force=true</code> sẽ thực hiện xóa KhachHang và các
	 *            danh sách tương ứng như dsDonHang, dsGopY, dsNhanXetDienThoai. <br>
	 * <br>
	 *            Nếu <code>force=false</code> chỉ xóa được KhachHang nếu
	 *            KhachHang chưa có bất kì đơn hàng, nhận xét hay góp ý nào.
	 * @throws Exception
	 *             Nếu khách hàng đã có danh sách đơn hàng, góp ý hoặc nhận xét
	 *             và tham số <code>force=false</code>
	 */
	public void makeTransient(KhachHang k, boolean force) throws Exception {
		khachHangDAO.makeTransient(k, force);
	}

	/**
	 * Thêm mới hoặc cập nhật một KhachHang.
	 * 
	 * @param k
	 *            KhachHang sẽ được thêm mới
	 * @return KhachHang đã được thêm mới hay cập nhật.
	 */
	public KhachHang makePersistent(KhachHang k) {
		khachHangDAO.makePersistent(k);
		return k;
	}
}
