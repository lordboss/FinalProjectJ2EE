/**
 * 
 */
package qt.bus;

import java.util.List;

import qt.dao.PhuKienDAO;
import qt.dto.PhuKien;

/**
 * @author tqthe
 * 
 */
public class PhuKienBUS {

	private PhuKienDAO phuKienDAO;

	/**
	 * @param phuKienDAO
	 *            the phuKienDAO to set
	 */
	public void setPhuKienDAO(PhuKienDAO phuKienDAO) {
		this.phuKienDAO = phuKienDAO;
	}

	/**
	 * @return the phuKienDAO
	 */
	public PhuKienDAO getPhuKienDAO() {
		return phuKienDAO;
	}

	/**
	 * Tìm các PhuKien theo LoaiPhuKien.
	 * 
	 * @param idLoaiPhuKien
	 *            id của LoaiPhuKien.
	 * @return Danh sách PhuKien của LoaiPhuKien.
	 */
	public List<PhuKien> findByLoaiPhuKien(int idLoaiPhuKien) {
		return phuKienDAO.findByLoaiPhuKien(idLoaiPhuKien);
	}

	/**
	 * Đánh dấu xóa một PhuKien
	 * 
	 * @param p
	 *            PhuKien sẽ bị đánh dấu xóa.
	 */
	public void markAsDeleted(PhuKien p) {
		phuKienDAO.markAsDeleted(p);
	}

	/**
	 * Xóa (vĩnh viễn) một PhuKien. Danh sách HinhAnh và danh sách
	 * TinGiamGiaPhuKien bị xóa theo.
	 * 
	 * @param p
	 *            PhuKien bị xóa.
	 * @param force
	 *            Nếu <code>force=true</code> thực hiện xóa PhuKien và
	 *            dsDonHang, dsChiTietPhieuNhapPhuKien. <b>Rất là nguy hiểm</b> <br>
	 *            Nếu <code>force=false</code> chĩ hiện xóa PhuKien nếu PhuKien
	 *            không có bất kì danh sách đơn hàng hoặc phiếu nhập nào.
	 * @throws Exception
	 *             Nếu phụ kiện đã có danh sách đơn hàng hoặc phiếu nhập và tham
	 *             số <code>force=false</code>
	 */
	public void makeTransient(PhuKien p, boolean force) throws Exception {
		phuKienDAO.makeTransient(p, force);
	}

	/**
	 * Thêm mới hoặc cập nhật một PhuKien. Việc thêm mới hay cập nhật phụ thuộc
	 * vào giá trị ID.
	 * 
	 * @param p
	 *            PhuKien sẽ được thêm mới hay cập nhật.
	 * @return PhuKien đã được thêm mới hay cập nhật. Trong trường hợp thêm mới
	 *         giá trị của ID sẽ được cập nhật.
	 */
	public PhuKien makePersistent(PhuKien p) {
		phuKienDAO.makePersistent(p);
		return p;
	}

	/**
	 * Tìm một PhuKien theo ID.
	 * 
	 * @param id
	 *            id của PhuKien cần tìm.
	 * @return PhuKien tìm được.
	 */
	public PhuKien findById(int id) {
		return phuKienDAO.findById(id);
	}

	/**
	 * Tìm tất cả PhuKien.
	 * 
	 * @return Danh sách PhuKien tìm được.
	 */
	public List<PhuKien> findAll() {
		return phuKienDAO.findAll();
	}
}
