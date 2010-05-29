/**
 * 
 */
package qt.bus;

import java.util.List;

import qt.dao.NhaCungCapDAO;
import qt.dto.NhaCungCap;

/**
 * @author tqthe
 * 
 */
public class NhaCungCapBUS {

	private NhaCungCapDAO nhaCungCapDAO;

	/**
	 * @param nhaCungCapDAO
	 *            the nhaCungCapDAO to set
	 */
	public void setNhaCungCapDAO(NhaCungCapDAO nhaCungCapDAO) {
		this.nhaCungCapDAO = nhaCungCapDAO;
	}

	/**
	 * @return the nhaCungCapDAO
	 */
	public NhaCungCapDAO getNhaCungCapDAO() {
		return nhaCungCapDAO;
	}

	/**
	 * Đánh dấu xóa một NhaCungCap.
	 * 
	 * @param s
	 *            NhaCungCap sẽ bị đánh dấu xóa.
	 */
	public void markAsDeleted(NhaCungCap s) {
		nhaCungCapDAO.markAsDeleted(s);
	}

	/**
	 * Xóa (vĩnh viễn) một NhaCungCap.
	 * 
	 * @param s
	 *            NhaCungCap sẽ bị xóa.
	 * @param force
	 *            Nếu <code>force=true</code> thực hiện xóa NhaCungCap.
	 *            DsSanPham, dsPhuKien, dsDienThoai sẽ bị xóa theo. <b>Rất là
	 *            nguy hiểm! (Cascade delete)</b> <br>
	 *            Nếu <code>force=false</code> chỉ thực hiện xóa NhaCungCap nếu
	 *            NhaCungCap không có bất kì danh sách sản phẩm, phiếu nhập phụ
	 *            kiện hay điện thoại nào. <b>Khuyến khích dùng cái này!</b>
	 * @throws Exception
	 *             Nếu nhà cung cấp đã có danh sách sản phẩm, phiếu nhập phụ
	 *             kiện hoặc điện thoại và tham số <code>force=false</code>
	 */
	public void makeTransient(NhaCungCap s, boolean force) throws Exception {
		nhaCungCapDAO.makeTransient(s, force);
	}

	/**
	 * Thêm mới hoặc cập nhật một NhaCungCap. Việc thêm mới hay cập nhật phụ
	 * thuộc vào giá trị ID.
	 * 
	 * @param s
	 *            NhaCungCap sẽ được thêm mới hoặc cập nhật.
	 * @return NhaCungCap vừa được thêm mới hoặc cập nhật. Trong trường hợp thêm
	 *         mới giá trị ID sẽ được cập nhật tương ứng.
	 */
	public NhaCungCap makePersistent(NhaCungCap s) {
		nhaCungCapDAO.makePersistent(s);
		return s;
	}

	/**
	 * Tìm một NhaCungCap theo tên
	 * 
	 * @param name
	 *            Tên của NhaCungCap cần tìm
	 * @return NhaCungCap tìm được. Nếu không tìm thấy trả về null.
	 */
	public NhaCungCap findByName(String name) {
		return nhaCungCapDAO.findByName(name);
	}

	/**
	 * Tìm một NhaCungCap theo số điện thoại.
	 * 
	 * @param phone
	 *            Số điện thoại của NhaCungCap.
	 * @return NhaCungCap tìm được. Nếu không tìm thấy trả về null.
	 */
	public NhaCungCap findByPhone(String phone) {
		return nhaCungCapDAO.findByPhone(phone);
	}

	/**
	 * Tìm một NhaCungCap theo ID
	 * 
	 * @param id
	 *            id của NhaCungCap cần tìm.
	 * @return NhaCungCap tìm được. Nếu không tìm thấy trả về null.
	 */
	public NhaCungCap findById(int id) {
		return nhaCungCapDAO.findById(id);
	}

	/**
	 * Tìm tất cả NhaCungCap.
	 * 
	 * @return Danh sách NhaCungCap tìm được.
	 */
	public List<NhaCungCap> findAll() {
		return nhaCungCapDAO.findAll();
	}
}
