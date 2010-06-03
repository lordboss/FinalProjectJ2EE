/**
 * 
 */
package qt.bus;

import java.util.List;

import qt.dao.DongSanPhamDAO;
import qt.dto.DongSanPham;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * @author tqthe
 * 
 */
public class DongSanPhamBUS {

	private DongSanPhamDAO dongSanPhamDAO;

	/**
	 * @param dongSanPhamDAO
	 *            the dongSanPhamDAO to set
	 */
	public void setDongSanPhamDAO(DongSanPhamDAO dongSanPhamDAO) {
		this.dongSanPhamDAO = dongSanPhamDAO;
	}

	/**
	 * @return the dongSanPhamDAO
	 */
	public DongSanPhamDAO getDongSanPhamDAO() {
		return dongSanPhamDAO;
	}

	/**
	 * Tìm tất cả các DongSanPham (DienThoai).
	 * 
	 * @return Danh sách DongSanPham tìm được.
	 */
	public List<DongSanPham> findAll() {
		return dongSanPhamDAO.findAll();
	}

	/**
	 * Tìm một DongSanPham theo ID.
	 * 
	 * @param id
	 *            Id của DongSanPham cần tìm.
	 * @return DongSanPham tìm được nếu không tìm thấy trả về NULL.
	 */
	public DongSanPham findById(int id) {
		return dongSanPhamDAO.findById(id);
	}

	/**
	 * Thêm mới hay cập nhật một DongSanPham. Việc thêm mới hay cập nhật phụ
	 * thuộc vào giá trị Id.
	 * 
	 * @param d
	 *            DongSanPham sẽ được thêm mới hay cập nhật.
	 * @return DongSanPham sau khi đã thêm mới hoặc cập nhật. Nếu thêm mới giá
	 *         trị id sẽ được cập nhật tương ứng.
	 */
	public DongSanPham makePersistent(DongSanPham d) {
		dongSanPhamDAO.makePersistent(d);
		return d;
	}

	/**
	 * <b style="color:red;">This method is intentionally left private for
	 * safety reason.</b>
	 * 
	 * @param d
	 */
	@SuppressWarnings("unused")
	private void makeTransient(DongSanPham d) {
		throw new NotImplementedException();
	}
}
