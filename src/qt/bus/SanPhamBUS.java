/**
 * 
 */
package qt.bus;

import java.util.List;

import qt.dao.SanPhamDAO;
import qt.dto.SanPham;

/**
 * @author tqthe
 * 
 */
public class SanPhamBUS {

	private SanPhamDAO sanPhamDAO;

	/**
	 * @param sanPhamDAO
	 *            the sanPhamDAO to set
	 */
	public void setSanPhamDAO(SanPhamDAO sanPhamDAO) {
		this.sanPhamDAO = sanPhamDAO;
	}

	/**
	 * @return the sanPhamDAO
	 */
	public SanPhamDAO getSanPhamDAO() {
		return sanPhamDAO;
	}

	/**
	 * Xóa (vĩnh viễn) một SanPham.
	 * 
	 * @param p
	 *            SanPham sẽ bị xóa.
	 */
	public void makeTransient(SanPham p) {
		sanPhamDAO.makeTransient(p);
	}

	/**
	 * Thêm mới hoặc cập nhật một SanPham. Việc thêm mới hay cập nhật phụ thuộc
	 * vào giá trị ID.
	 * 
	 * @param p
	 *            SanPham sẽ được thêm mới hay cập nhật.
	 * @return SanPham đã được thêm mới hay cập nhật. Trong trường hợp thêm mới
	 *         giá trị ID sẽ thay đổi.
	 */
	public SanPham makePersistent(SanPham p) {
		sanPhamDAO.makePersistent(p);
		return p;
	}

	/**
	 * Tìm các SanPham theo TinhTrangSanPham
	 * 
	 * @param idTinhTrang
	 *            id của TinhTrangSanPham.
	 * @return Danh sách SanPham của TinhTrangSanPham.
	 */
	public List<SanPham> findByTinhTrangSanPham(int idTinhTrang) {
		return sanPhamDAO.findByTinhTrangSanPham(idTinhTrang);
	}

	/**
	 * Tìm các SanPham của một NhaCungCap.
	 * 
	 * @param idNhaCungCap
	 *            id của NhaCungCap.
	 * @return Danh sách SanPham của NhaCungCap.
	 */
	public List<SanPham> findByNhaCungCap(int idNhaCungCap) {
		return sanPhamDAO.findByNhaCungCap(idNhaCungCap);
	}

	/**
	 * Tìm một SanPham theo ID.
	 * 
	 * @param id
	 *            id của SanPham cần tìm.
	 * @return SanPham tìm được. Nếu không tìm thấy trả về null.
	 */
	public SanPham findById(int id) {
		return sanPhamDAO.findById(id);
	}

	/**
	 * Tìm tất cả SanPham.
	 * 
	 * @return Danh sách SanPham tìm được.
	 */
	public List<SanPham> findAll() {
		return sanPhamDAO.findAll();
	}
}
