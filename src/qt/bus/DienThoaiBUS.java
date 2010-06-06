/**
 * 
 */
package qt.bus;

import java.util.List;

import qt.dao.DienThoaiDAO;
import qt.dto.DienThoai;
import qt.dto.FunctionalityCriteria;
import qt.dto.PhoneCriteria;
import qt.dto.QuickSearchCriteria;

/**
 * @author tqthe
 * 
 */
public class DienThoaiBUS {

	private DienThoaiDAO dienThoaiDAO;

	/**
	 * @param dienThoaiDAO
	 *            the dienThoaiDAO to set
	 */
	public void setDienThoaiDAO(DienThoaiDAO dienThoaiDAO) {
		this.dienThoaiDAO = dienThoaiDAO;
	}

	/**
	 * @return the dienThoaiDAO
	 */
	public DienThoaiDAO getDienThoaiDAO() {
		return dienThoaiDAO;
	}

	/**
	 * Đánh dấu xóa một DienThoai.
	 * 
	 * @param p
	 *            DienThoai sẽ bị đánh dấu xóa.
	 */
	public void markAsDeleted(DienThoai p) {
		dienThoaiDAO.markAsDeleted(p);
	}

	/**
	 * Xóa vĩnh viễn một DienThoai. DsTinhNangNoiBat, DsTinKhuyenMai, DsNhanXet
	 * sẽ bị xóa theo.
	 * 
	 * @param p
	 *            DienThoai sẽ bị xóa
	 * @param force
	 *            Nếu <code>force=true</code> thực hiện xóa DienThoai và danh
	 *            sách đơn hàng, phiếu nhập liên quan. <b>Rất là nguy hiềm =.=
	 *            </b> <br>
	 *            Nếu <code>force=false</code> chỉ thực hiện xóa nếu DienThoai
	 *            chưa có bất kì đơn hàng hay phiếu nhập nào. <b>An toàn hơn</b>
	 * @throws Exception
	 *             Nếu điện thoại đã có danh sách đơn hàng hoặc phiếu nhập và
	 *             tham số <code>force=false</code>
	 */
	public void makeTransient(DienThoai p, boolean force) throws Exception {
		dienThoaiDAO.makeTransient(p, force);
	}

	/**
	 * Thêm mới hoặc cập nhật một DienThoai. Việc thê mới hay cập nhật phụ thuộc
	 * vào giá trị của ID.
	 * 
	 * @param p
	 *            DienThoai sẽ được thêm mới hay cập nhật.
	 * @return DienThoai đã được thêm mới hay cập nhật. Giá trị ID sẽ được cập
	 *         nhật nếu thêm mới.
	 */
	public DienThoai makePersistent(DienThoai p) {
		dienThoaiDAO.makePersistent(p);
		return p;
	}

	/**
	 * Tìm kiếm nâng cao theo nhiều tiêu chí.
	 * 
	 * @param c
	 *            Tiêu chí tìm kiếm.
	 * @return Danh sách DienThoai thỏa tiêu chí tìm kiếm.
	 */
	public List<DienThoai> advancedSearch(PhoneCriteria c) {
		return dienThoaiDAO.advancedSearch(c);
	}

	/**
	 * Tìm kiếm chuyên sâu theo chức năng.
	 * 
	 * @param c
	 *            Tiêu chí tìm kiếm.
	 * @return Danh sách DienThoai thỏa yêu cầu.
	 */
	public List<DienThoai> findByFunctionality(FunctionalityCriteria c) {
		return dienThoaiDAO.findByFunctionality(c);
	}

	/**
	 * Tìm kiếm nhanh
	 * 
	 * @param idHangDienThoai
	 *            id của HangDienThoai.
	 * @param ten
	 *            tên DienThoai.
	 * @param giaTu
	 *            giá chặn dưới.
	 * @param giaDen
	 *            giá chặn trên.
	 * @return Danh sách DienThoai thỏa tiêu chí tìm kiếm.
	 */
	public List<DienThoai> quickSearch(int idHangDienThoai, String ten,
			double giaTu, double giaDen) {

		return dienThoaiDAO.quickSearch(idHangDienThoai, ten, giaTu, giaDen);
	}

	/**
	 * Tìm kiếm nhanh
	 * 
	 * @param c
	 *            Tiêu chí tìm kiếm
	 * @return Danh sách các điện thoại thỏa tiêu chí tìm kiếm
	 */
	public List<DienThoai> quickSearch(QuickSearchCriteria c) {
		return dienThoaiDAO.quickSearch(c);
	}
	
	/**
	 * Tìm các DienThoai theo DongSanPham.
	 * 
	 * @param idDongSanPham
	 *            id của DongSanPham.
	 * @return Danh sách DienThoai.
	 */
	public List<DienThoai> findByDongSanPham(int idDongSanPham) {
		return dienThoaiDAO.findByDongSanPham(idDongSanPham);
	}

	/**
	 * Tìm các DienThoai theo PhongCach.
	 * 
	 * @param idPhongCach
	 *            id của PhongCach
	 * @return Danh sách DienThoai.
	 */
	public List<DienThoai> findByPhongCach(int idPhongCach) {
		return dienThoaiDAO.findByPhongCach(idPhongCach);
	}

	/**
	 * Tìm các DienThoai theo KieuDang.
	 * 
	 * @param idKieuDang
	 *            id của KieuDang
	 * @return Danh sách DienThoai.
	 */
	public List<DienThoai> findByKieuDang(int idKieuDang) {
		return dienThoaiDAO.findByKieuDang(idKieuDang);
	}

	/**
	 * Tìm các DienThoai theo HangDienThoai.
	 * 
	 * @param idHang
	 *            id của HangDienThoai.
	 * @return Danh sách các DienThoai của HangDienThoai.
	 */
	public List<DienThoai> findByHang(int idHang) {
		return dienThoaiDAO.findByHang(idHang);
	}

	/**
	 * Tìm một DienThoai theo ID
	 * 
	 * @param id
	 *            id của DienThoai cần tìm.
	 * @return DienThoai tìm được. Nếu không tìm thấy trả về null.
	 */
	public DienThoai findById(int id) {
		return dienThoaiDAO.findById(id);
	}

	/**
	 * Tìm tất cả các DienThoai.
	 * 
	 * @return Danh sách các DienThoai tìm được.
	 */
	public List<DienThoai> findAll() {
		return dienThoaiDAO.findAll();
	}
}
