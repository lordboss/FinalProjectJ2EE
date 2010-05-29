/**
 * 
 */
package qt.bus;

import java.util.List;

import qt.dao.TinhNangNoiBatDAO;
import qt.dto.TinhNangNoiBat;

/**
 * @author tqthe
 * 
 */
public class TinhNangNoiBatBUS {

	private TinhNangNoiBatDAO tinhNangNoiBatDAO;

	/**
	 * @param tinhNangNoiBatDAO
	 *            the tinhNangNoiBatDAO to set
	 */
	public void setTinhNangNoiBatDAO(TinhNangNoiBatDAO tinhNangNoiBatDAO) {
		this.tinhNangNoiBatDAO = tinhNangNoiBatDAO;
	}

	/**
	 * @return the tinhNangNoiBatDAO
	 */
	public TinhNangNoiBatDAO getTinhNangNoiBatDAO() {
		return tinhNangNoiBatDAO;
	}

	/**
	 * Đánh dấu xóa một TinhNangNoiBat.
	 * 
	 * @param t
	 *            TinhNangNoiBat sẽ bị đánh dấu xóa.
	 */
	public void markAsDeleted(TinhNangNoiBat t) {
		tinhNangNoiBatDAO.markAsDeleted(t);
	}

	/**
	 * Xóa (vĩnh viễn) một TinhNangNoiBat.
	 * 
	 * @param t
	 *            TinhNangNoiBat sẽ được xóa.
	 */
	public void makeTransient(TinhNangNoiBat t) {
		tinhNangNoiBatDAO.makeTransient(t);
	}

	/**
	 * Thêm mới hoặc cập nhật một TinhNangNoiBat.
	 * 
	 * @param t
	 *            TinhNangNoiBat được thêm mới hay cập nhật.
	 * @return TinhNangNoiBat vừa được thêm mới hay cập nhật.
	 */
	public TinhNangNoiBat makePersistent(TinhNangNoiBat t) {
		tinhNangNoiBatDAO.makePersistent(t);
		return t;
	}

	/**
	 * Tìm một TinhNangNoiBat theo ID
	 * 
	 * @param id
	 *            id của TinhNangNoiBat.
	 * @return TinhNangNoiBat tìm được. Nếu không tìm thấy trả về null.
	 */
	public TinhNangNoiBat findById(int id) {
		return tinhNangNoiBatDAO.findById(id);
	}

	/**
	 * Tìm tất cả TinhNangNoiBat.
	 * 
	 * @return Danh sách TinhNangNoiBat.
	 */
	public List<TinhNangNoiBat> findAll() {
		return tinhNangNoiBatDAO.findAll();
	}

	/**
	 * Tìm các TinhNangNoiBat của một điện thoại.
	 * 
	 * @param idDienThoai
	 *            id của DienThoai cần tìm tính năng nỗi bật.
	 * @return Danh sách TinhNangNoiBat của một DienThoai.
	 */
	public List<TinhNangNoiBat> findByDienThoai(int idDienThoai) {
		return tinhNangNoiBatDAO.findByDienThoai(idDienThoai);
	}
}
