/**
 * 
 */
package qt.bus;

import java.util.Date;
import java.util.List;

import qt.dao.TinTucDAO;
import qt.dto.TinTuc;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * @author tqthe
 * 
 */
public class TinTucBUS {

	private TinTucDAO tinTucDAO;

	/**
	 * @param tinTucDAO
	 *            the tinTucDAO to set
	 */
	public void setTinTucDAO(TinTucDAO tinTucDAO) {
		this.tinTucDAO = tinTucDAO;
	}

	/**
	 * @return the tinTucDAO
	 */
	public TinTucDAO getTinTucDAO() {
		return tinTucDAO;
	}

	/**
	 * Lấy tất cả tin tức
	 * 
	 * @return Danh sách tin tức.
	 */
	public List<TinTuc> findAll() {
		return tinTucDAO.findAll();
	}

	/**
	 * Tìm một TinTuc theo id
	 * 
	 * @param id
	 *            id của TinTuc cần tìm
	 * @return Một TinTuc hoặc null nếu không tìm thấy
	 */
	public TinTuc findById(int id) {
		return tinTucDAO.findById(id);
	}

	/**
	 * Tìm TinTuc theo LoaiTinTuc
	 * 
	 * @param idLoaiTinTuc
	 *            id của LoaiTinTuc
	 * @return Danh sách TinTuc tìm được. Danh sách rỗng nếu không tìm thấy.
	 */
	public List<TinTuc> findByLoaiTinTuc(int idLoaiTinTuc) {
		return tinTucDAO.findByLoaiTinTuc(idLoaiTinTuc);
	}

	public List<TinTuc> findByNgayDang(Date dFrom, Date dTo) {
		throw new NotImplementedException();
	}

	/**
	 * Thêm mới hoặc cập nhật một tin tức. (ID sẽ được cập nhật nếu thêm mới)
	 * 
	 * @param t
	 *            TinTuc cần được thêm hoặc cập nhật
	 * @return TinTuc vừa mới được thêm hoặc cập nhật
	 */
	public TinTuc makePersistent(TinTuc t) {
		tinTucDAO.makePersistent(t);
		return t;
	}

	/**
	 * Xóa (vĩnh viễn) một tin tức
	 * 
	 * @param t
	 *            TinTuc bị xóa
	 */
	public void makeTransient(TinTuc t) {
		tinTucDAO.makeTransient(t);
	}

	/**
	 * Đánh dấu xóa một TinTuc. TinTuc chỉ bị đánh dấu xóa chứ không bị xóa thật
	 * sự.
	 * 
	 * @param t
	 *            TinTuc bị đánh dấu xóa
	 */
	public void markAsDeleted(TinTuc t) {
		tinTucDAO.markAsDeleted(t);
	}
}
