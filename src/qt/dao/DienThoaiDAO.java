/**
 * 
 */
package qt.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import qt.dto.ConnectivityCriteria;
import qt.dto.DienThoai;
import qt.dto.FunctionalityCriteria;
import qt.dto.MediaCriteria;
import qt.dto.PhoneCriteria;
import qt.dto.QuickSearchCriteria;

/**
 * @author tqthe
 * 
 */
@Transactional
public class DienThoaiDAO {
	private SessionFactory factory;

	/**
	 * @param factory
	 *            the factory to set
	 */
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	/**
	 * @return the factory
	 */
	public SessionFactory getFactory() {
		return factory;
	}

	/**
	 * Đánh dấu xóa một DienThoai.
	 * 
	 * @param p
	 *            DienThoai sẽ bị đánh dấu xóa.
	 */
	public void markAsDeleted(DienThoai p) {
		p.setXoa(true);
		makePersistent(p);
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

		if ((p.getDsChiTietDonHang().size() > 0 || p.getDsChiTietPhieuNhap()
				.size() > 0)
				&& !force) {
			throw new Exception(
					"Không thể xóa điện thoại đã có danh sách đơn hàng hoặc phiếu nhập");
		}

		// many-to-many
		p.setDsPhuKienTuongThich(null);
		p.setDsNhaCungCap(null);

		// one-to-many
		if (p.getTinhTrangSanPham() != null) {
			p.getTinhTrangSanPham().getDsSanPham().remove(p);
			p.setTinhTrangSanPham(null);
		}
		if (p.getHangDienThoai() != null) {
			p.getHangDienThoai().getDsDienThoai().remove(p);
			p.setHangDienThoai(null);
		}
		if (p.getKieuDang() != null) {
			p.getKieuDang().getDsDienThoai().remove(p);
			p.setKieuDang(null);
		}
		if (p.getHeDieuHanh() != null) {
			p.getHeDieuHanh().getDsDienThoai().remove(p);
			p.setHeDieuHanh(null);
		}
		if (p.getPhongCach() != null) {
			p.getPhongCach().getDsDienThoai().remove(p);
			p.setPhongCach(null);
		}
		if (p.getLoaiMang() != null) {
			p.getLoaiMang().getDsDienThoai().remove(p);
			p.setLoaiMang(null);
		}
		if (p.getDongSanPham() != null) {
			p.getDongSanPham().getDsDienThoai().remove(p);
			p.setDongSanPham(null);
		}

		factory.getCurrentSession().delete(p);
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
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(p);
		session.flush();
		return p;
	}

	/**
	 * Tìm kiếm nâng cao theo nhiều tiêu chí.
	 * 
	 * @param c
	 *            Tiêu chí tìm kiếm.
	 * @return Danh sách DienThoai thỏa tiêu chí tìm kiếm.
	 */
	@SuppressWarnings("unchecked")
	public List<DienThoai> advancedSearch(PhoneCriteria c) {
		Session session = factory.getCurrentSession();
		Criteria criteria = session.createCriteria(DienThoai.class).add(
				Restrictions.eq("xoa", false));

		if (c.getName() != null && c.getName().trim().length() > 0) {
			Criterion name = Restrictions.like("ten", "%" + c.getName() + "%");
			criteria.add(name);
		}

		if (c.getMinPrice() >= 0 && c.getMaxPrice() >= 0.0) {
			Criterion minPrice = Restrictions
					.ge("giaHienHanh", c.getMinPrice());
			Criterion maxPrice = Restrictions
					.le("giaHienHanh", c.getMaxPrice());
			criteria.add(minPrice);
			criteria.add(maxPrice);
		}

		if (c.getManufactureId() > 0) {
			Criterion manufacture = Restrictions.eq("hangDienThoai.id", c
					.getManufactureId());
			criteria.add(manufacture);
		}

		if (c.getStyleId() > 0) {
			Criterion style = Restrictions.eq("phongCach.id", c.getStyleId());
			criteria.add(style);
		}

		if (c.getMelody() > 0) {
			Criterion melody = Restrictions.ge("nhacChuong.nhacChuong", c
					.getMelody());
			criteria.add(melody);
		}

		if (c.getMinCamera() > 0.0 && c.getMaxCamera() > 0.0) {
			Criterion minCamera = Restrictions.ge("camera.doPhanGiaiMayAnh", c
					.getMinCamera());
			Criterion maxCamera = Restrictions.le("camera.doPhanGiaiMayAnh", c
					.getMaxCamera());
			criteria.add(minCamera);
			criteria.add(maxCamera);
		}

		if (c.getNetworkId() > 0) {
			Criterion network = Restrictions
					.eq("loaiMang.id", c.getNetworkId());
			criteria.add(network);
		}

		if (c.getOsId() > 0) {
			Criterion os = Restrictions.eq("heDieuHanh.id", c.getOsId());
			criteria.add(os);
		}

		if (c.isHasTouchScreen()) {
			Criterion touchScreen = Restrictions.eq("manHinh.camUng", true);
			criteria.add(touchScreen);
		}

		if (c.isHasMemoryCard()) {
			Criterion memoryCard = Restrictions.isNotNull("luuTru.theNho");
			criteria.add(memoryCard);

		}

		if (c.getProductStatusId() > 0) {
			Criterion status = Restrictions.eq("tinhTrangSanPham.id", c
					.getProductStatusId());
			criteria.add(status);
		}

		processMediaCriteria(criteria, c.getMediaCriteria());
		processConnectivityCriteria(criteria, c.getConnectivityCriteria());

		return criteria.list();
	}

	/**
	 * Xử lý các tiêu chí tìm kiếm theo connectivity
	 * 
	 * @param criteria
	 *            Bộ lọc tiêu chí
	 * @param c
	 *            Tiêu chí tìm kiếm theo connectivity
	 */
	private void processConnectivityCriteria(Criteria criteria,
			ConnectivityCriteria c) {
		if (c.isHas2Sim()) {
			criteria.add(Restrictions.eq("ketNoi.haiSim", true));
		}
		if (c.isHas3G()) {
			criteria.add(Restrictions.isNotNull("ketNoi.hoTro3G"));
		}
		if (c.isHasBluetooth()) {
			criteria.add(Restrictions.eq("ketNoi.bluetooth", true));
		}
		if (c.isHasGPRS()) {
			criteria.add(Restrictions.eq("ketNoi.GPRS", true));
		}
		if (c.isHasGPS()) {
			criteria.add(Restrictions.isNotNull("ketNoi.GPS"));
		}
		if (c.isHasUSB()) {
			criteria.add(Restrictions.eq("ketNoi.USB", true));
		}
		if (c.isHasWifi()) {
			criteria.add(Restrictions.isNotNull("ketNoi.wifi"));
		}
	}

	/**
	 * Xử lý các tiêu chí tìm kiếm theo multi-media
	 * 
	 * @param criteria
	 *            Bộ lọc tiêu chí
	 * @param c
	 *            Tiêu chí tìm kiếm theo multi-media
	 */
	private void processMediaCriteria(Criteria criteria, MediaCriteria c) {
		if (c.isHasFMRadio()) {
			criteria.add(Restrictions.eq("multiMedia.FMRadio", true));
		}
		if (c.isHasGame()) {
			criteria.add(Restrictions.isNotNull("multiMedia.troChoi"));
		}
		if (c.isHasJavaApps()) {
			criteria.add(Restrictions.eq("javaApp", true));
		}
		if (c.isHasMusicPlayer()) {
			criteria.add(Restrictions.isNotNull("multiMedia.ngheNhac"));
		}
		if (c.isHasOfficeApps()) {
			criteria.add(Restrictions.eq("office", true));
		}
		if (c.isHasTivi()) {
			criteria.add(Restrictions.eq("multiMedia.xemTivi", true));
		}
		if (c.isHasVideoPlayer()) {
			criteria.add(Restrictions.isNotNull("multiMedia.xemPhim"));
		}
		if (c.isHasVideoRecoder()) {
			criteria.add(Restrictions.isNotNull("multiMedia.quayPhim"));
		}
		if (c.isHasVoiceRecoder()) {
			criteria.add(Restrictions.isNotNull("multiMedia.ghiAm"));
		}
	}

	/**
	 * Tìm kiếm chuyên sâu theo chức năng.
	 * 
	 * @param c
	 *            Tiêu chí tìm kiếm.
	 * @return Danh sách DienThoai thỏa yêu cầu.
	 */
	@SuppressWarnings("unchecked")
	public List<DienThoai> findByFunctionality(FunctionalityCriteria c) {

		Session session = factory.getCurrentSession();
		Criteria criteria = session.createCriteria(DienThoai.class).add(
				Restrictions.eq("xoa", false));

		if (c.isHasCamera()) {
			Criterion hasCamera = Restrictions
					.isNotNull("camera.doPhanGiaiMayAnh");
			criteria.add(hasCamera);
		}

		if (c.isHasFMRadio()) {
			Criterion hasFMRadio = Restrictions.eq("multiMedia.FMRadio", true);
			criteria.add(hasFMRadio);
		}

		if (c.isHasMusicPlayer()) {
			Criterion hasMusicPlayer = Restrictions
					.isNotNull("multiMedia.ngheNhac");
			criteria.add(hasMusicPlayer);
		}

		if (c.isHasMemoryCard()) {
			Criterion hasMemoryCard = Restrictions.isNotNull("luuTru.theNho");
			criteria.add(hasMemoryCard);
		}

		if (c.isHasWifi()) {
			Criterion hasWifi = Restrictions.isNotNull("ketNoi.wifi");
			criteria.add(hasWifi);
		}

		if (c.isHas3G()) {
			Criterion has3G = Restrictions.isNotNull("ketNoi.hoTro3G");
			criteria.add(has3G);
		}

		if (c.isHasBluetooth()) {
			Criterion hasBluetooth = Restrictions.eq("ketNoi.bluetooth", true);
			criteria.add(hasBluetooth);
		}

		if (c.isHasOfficeApps()) {
			Criterion hasOfficeApps = Restrictions.eq("office", true);
			criteria.add(hasOfficeApps);
		}

		if (c.isHasGPS()) {
			Criterion hasGPS = Restrictions.isNotNull("ketNoi.GPS");
			criteria.add(hasGPS);
		}

		if (c.isHasTouchScreen()) {
			Criterion hasTouchScreen = Restrictions.eq("manHinh.camUng", true);
			criteria.add(hasTouchScreen);
		}

		if (c.isHasTivi()) {
			Criterion hasTivi = Restrictions.eq("multiMedia.xemTivi", true);
			criteria.add(hasTivi);
		}

		if (c.isHasJavaApps()) {
			Criterion hasJavaApps = Restrictions.eq("javaApp", true);
			criteria.add(hasJavaApps);
		}

		if (c.isHas2Sim()) {
			Criterion has2Sim = Restrictions.eq("ketNoi.haiSim", true);
			criteria.add(has2Sim);
		}

		return criteria.list();
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
	@SuppressWarnings("unchecked")
	public List<DienThoai> quickSearch(int idHangDienThoai, String ten,
			double giaTu, double giaDen) {

		Session session = factory.getCurrentSession();
		Criteria criteria = session.createCriteria(DienThoai.class);

		if (idHangDienThoai > 0) {
			Criterion manufacture = Restrictions.eq("hangDienThoai.id",
					idHangDienThoai);
			criteria.add(manufacture);
		}

		if (ten != null) {
			Criterion name = Restrictions.like("ten", "%" + ten + "%");
			criteria.add(name);
		}

		if (giaTu >= 0.0) {
			Criterion minPrice = Restrictions.ge("giaHienHanh", giaTu);
			criteria.add(minPrice);
		}

		if (giaDen >= 0.0) {
			Criterion maxPrice = Restrictions.le("giaHienHanh", giaDen);
			criteria.add(maxPrice);
		}
		criteria.add(Restrictions.eq("xoa", false));

		return criteria.list();
	}

	/**
	 * Tìm kiếm nhanh
	 * 
	 * @param c
	 *            Tiêu chí tìm kiếm
	 * @return Danh sách các điện thoại thỏa tiêu chí tìm kiếm
	 */
	@SuppressWarnings("unchecked")
	public List<DienThoai> quickSearch(QuickSearchCriteria c) {

		Session session = factory.getCurrentSession();
		Criteria criteria = session.createCriteria(DienThoai.class);

		if (c.getIdHangDienThoai() > 0) {
			Criterion manufacture = Restrictions.eq("hangDienThoai.id", c
					.getIdHangDienThoai());
			criteria.add(manufacture);
		}

		if (c.getTenDienThoai() != null) {
			Criterion name = Restrictions.like("ten", "%" + c.getTenDienThoai()
					+ "%");
			criteria.add(name);
		}

		if (c.getGiaTu() >= 0.0) {
			Criterion minPrice = Restrictions.ge("giaHienHanh", c.getGiaTu());
			criteria.add(minPrice);
		}

		if (c.getGiaDen() >= 0.0) {
			Criterion maxPrice = Restrictions.le("giaHienHanh", c.getGiaDen());
			criteria.add(maxPrice);
		}
		criteria.add(Restrictions.eq("xoa", false));

		return criteria.list();
	}

	/**
	 * Tìm các DienThoai theo DongSanPham.
	 * 
	 * @param idDongSanPham
	 *            id của DongSanPham.
	 * @return Danh sách DienThoai.
	 */
	@SuppressWarnings("unchecked")
	public List<DienThoai> findByDongSanPham(int idDongSanPham) {
		return factory
				.getCurrentSession()
				.createQuery(
						"from DienThoai p where p.dongSanPham.id = :id and p.xoa = false")
				.setInteger("id", idDongSanPham).list();
	}

	/**
	 * Tìm các DienThoai theo PhongCach.
	 * 
	 * @param idPhongCach
	 *            id của PhongCach
	 * @return Danh sách DienThoai.
	 */
	@SuppressWarnings("unchecked")
	public List<DienThoai> findByPhongCach(int idPhongCach) {
		return factory
				.getCurrentSession()
				.createQuery(
						"from DienThoai p where p.phongCach.id = :id and p.xoa = false")
				.setInteger("id", idPhongCach).list();
	}

	/**
	 * Tìm các DienThoai theo KieuDang.
	 * 
	 * @param idKieuDang
	 *            id của KieuDang
	 * @return Danh sách DienThoai.
	 */
	@SuppressWarnings("unchecked")
	public List<DienThoai> findByKieuDang(int idKieuDang) {
		return factory.getCurrentSession().createQuery(
				"from DienThoai p where p.kieuDang.id = :id and p.xoa = false")
				.setInteger("id", idKieuDang).list();
	}

	/**
	 * Tìm các DienThoai theo HangDienThoai.
	 * 
	 * @param idHang
	 *            id của HangDienThoai.
	 * @return Danh sách các DienThoai của HangDienThoai.
	 */
	@SuppressWarnings("unchecked")
	public List<DienThoai> findByHang(int idHang) {
		return factory
				.getCurrentSession()
				.createQuery(
						"from DienThoai p where p.hangDienThoai.id = :id and p.xoa = false")
				.setInteger("id", idHang).list();
	}

	/**
	 * Tìm một DienThoai theo ID
	 * 
	 * @param id
	 *            id của DienThoai cần tìm.
	 * @return DienThoai tìm được. Nếu không tìm thấy trả về null.
	 */
	public DienThoai findById(int id) {
		DienThoai p = (DienThoai) factory.getCurrentSession().get(
				DienThoai.class, id);
		return p.isXoa() ? null : p;
	}

	/**
	 * Tìm tất cả các DienThoai.
	 * 
	 * @return Danh sách các DienThoai tìm được.
	 */
	@SuppressWarnings("unchecked")
	public List<DienThoai> findAll() {
		return factory.getCurrentSession().createCriteria(DienThoai.class).add(
				Restrictions.eq("xoa", false)).list();
	}
}
