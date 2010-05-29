/**
 * 
 */
package qt.bus;

import java.util.List;

import qt.dao.TinhTrangSanPhamDAO;
import qt.dto.TinhTrangSanPham;

/**
 * @author tqthe
 * 
 */
public class TinhTrangSanPhamBUS {

	private TinhTrangSanPhamDAO tinhTrangSanPhamDAO;

	/**
	 * @param tinhTrangSanPhamDAO
	 *            the tinhTrangSanPhamDAO to set
	 */
	public void setTinhTrangSanPhamDAO(TinhTrangSanPhamDAO tinhTrangSanPhamDAO) {
		this.tinhTrangSanPhamDAO = tinhTrangSanPhamDAO;
	}

	/**
	 * @return the tinhTrangSanPhamDAO
	 */
	public TinhTrangSanPhamDAO getTinhTrangSanPhamDAO() {
		return tinhTrangSanPhamDAO;
	}

	/**
	 * Tìm tất cả TinhTrangSanPham
	 * 
	 * @return Danh sách TinhTrangSanPham
	 */
	public List<TinhTrangSanPham> findAll() {
		return tinhTrangSanPhamDAO.findAll();
	}

	/**
	 * Tìm một TinhTrangSanPham theo ID
	 * 
	 * @param id
	 *            id của TinhTrangSanPham cần tìm
	 * @return TinhTrangSanPham tìm thấy. Nếu không tìm thấy trả về null.
	 */
	public TinhTrangSanPham findById(int id) {
		return tinhTrangSanPhamDAO.findById(id);
	}

	/**
	 * Tìm một TinhTrangSanPham theo tên.
	 * 
	 * @param name
	 *            Tên của TinhTrangSanPham cần tìm.
	 * @return TinhTrangSanPham tìm được. Nếu không tìm thấy trả về null.
	 */
	public TinhTrangSanPham findByName(String name) {
		return tinhTrangSanPhamDAO.findByName(name);
	}

	/**
	 * Thêm mới hoặc cập nhật TinhTrangSanPham. Việc thêm mới hay cập nhật được
	 * căn cứ vào ID.
	 * 
	 * @param t
	 *            TinhTrangSanPham sẽ được thêm mới hay cập nhật.
	 * @return TinhTrangSanPham vừa được thêm mới hoặc cập nhật. Trong trường
	 *         hợp thêm mới giá trị ID sẽ được cập nhật.
	 */
	public TinhTrangSanPham makePersistent(TinhTrangSanPham t) {
		tinhTrangSanPhamDAO.makePersistent(t);
		return t;
	}

	/**
	 * Xóa (vĩnh viễn) một TinhTrangSanPham.
	 * 
	 * @param t
	 *            TinhTrangSanPham sẽ bị xóa.
	 */
	public void makeTransient(TinhTrangSanPham t) {
		tinhTrangSanPhamDAO.makeTransient(t);
	}
}
