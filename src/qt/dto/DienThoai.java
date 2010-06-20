package qt.dto;

// Generated Jun 21, 2010 1:02:40 AM by Hibernate Tools 3.3.0.GA

import java.util.HashSet;
import java.util.Set;

/**
 * DienThoai generated by hbm2java
 */
public class DienThoai extends qt.dto.SanPham implements java.io.Serializable {

	private HangDienThoai hangDienThoai;
	private MultiMedia multiMedia;
	private Camera camera;
	private NhacChuong nhacChuong;
	private KieuDang kieuDang;
	private PhongCach phongCach;
	private LuuTru luuTru;
	private LoaiMang loaiMang;
	private KetNoi ketNoi;
	private boolean javaApp;
	private boolean office;
	private ManHinh manHinh;
	private Pin pin;
	private KichCo kichCo;
	private HeDieuHanh heDieuHanh;
	private DongSanPham dongSanPham;
	private String ngonNgu;
	private String boBanHangChuan;
	private Set<PhuKien> dsPhuKienTuongThich = new HashSet<PhuKien>(0);
	private Set<NhanXetDienThoai> dsNhanXet = new HashSet<NhanXetDienThoai>(0);
	private Set<TinhNangNoiBat> dsTinhNangNoiBat = new HashSet<TinhNangNoiBat>(
			0);
	private Set<ChiTietTinKhuyenMaiDienThoai> dsChiTietKhuyenMai = new HashSet<ChiTietTinKhuyenMaiDienThoai>(
			0);
	private Set<ChiTietPhieuNhapDienThoai> dsChiTietPhieuNhap = new HashSet<ChiTietPhieuNhapDienThoai>(
			0);

	public DienThoai() {
	}

	public DienThoai(String ten, double giaNhap, double giaHienHanh,
			LuuTru luuTru) {
		super(ten, giaNhap, giaHienHanh);
		this.luuTru = luuTru;
	}

	public DienThoai(String ten, double giaNhap, double giaHienHanh,
			int baoHanh, boolean hienThi, boolean xoa, String hinhAnh,
			Set<NhaCungCap> dsNhaCungCap, Set<ChiTietDonHang> dsChiTietDonHang,
			TinhTrangSanPham tinhTrangSanPham, Set<ChiTietHinhAnh> dsHinhAnh,
			HangDienThoai hangDienThoai, MultiMedia multiMedia, Camera camera,
			NhacChuong nhacChuong, KieuDang kieuDang, PhongCach phongCach,
			LuuTru luuTru, LoaiMang loaiMang, KetNoi ketNoi, boolean javaApp,
			boolean office, ManHinh manHinh, Pin pin, KichCo kichCo,
			HeDieuHanh heDieuHanh, DongSanPham dongSanPham, String ngonNgu,
			String boBanHangChuan, Set<PhuKien> dsPhuKienTuongThich,
			Set<NhanXetDienThoai> dsNhanXet,
			Set<TinhNangNoiBat> dsTinhNangNoiBat,
			Set<ChiTietTinKhuyenMaiDienThoai> dsChiTietKhuyenMai,
			Set<ChiTietPhieuNhapDienThoai> dsChiTietPhieuNhap) {
		super(ten, giaNhap, giaHienHanh, baoHanh, hienThi, xoa, hinhAnh,
				dsNhaCungCap, dsChiTietDonHang, tinhTrangSanPham, dsHinhAnh);
		this.hangDienThoai = hangDienThoai;
		this.multiMedia = multiMedia;
		this.camera = camera;
		this.nhacChuong = nhacChuong;
		this.kieuDang = kieuDang;
		this.phongCach = phongCach;
		this.luuTru = luuTru;
		this.loaiMang = loaiMang;
		this.ketNoi = ketNoi;
		this.javaApp = javaApp;
		this.office = office;
		this.manHinh = manHinh;
		this.pin = pin;
		this.kichCo = kichCo;
		this.heDieuHanh = heDieuHanh;
		this.dongSanPham = dongSanPham;
		this.ngonNgu = ngonNgu;
		this.boBanHangChuan = boBanHangChuan;
		this.dsPhuKienTuongThich = dsPhuKienTuongThich;
		this.dsNhanXet = dsNhanXet;
		this.dsTinhNangNoiBat = dsTinhNangNoiBat;
		this.dsChiTietKhuyenMai = dsChiTietKhuyenMai;
		this.dsChiTietPhieuNhap = dsChiTietPhieuNhap;
	}

	public HangDienThoai getHangDienThoai() {
		return this.hangDienThoai;
	}

	public void setHangDienThoai(HangDienThoai hangDienThoai) {
		this.hangDienThoai = hangDienThoai;
	}

	public MultiMedia getMultiMedia() {
		return this.multiMedia;
	}

	public void setMultiMedia(MultiMedia multiMedia) {
		this.multiMedia = multiMedia;
	}

	public Camera getCamera() {
		return this.camera;
	}

	public void setCamera(Camera camera) {
		this.camera = camera;
	}

	public NhacChuong getNhacChuong() {
		return this.nhacChuong;
	}

	public void setNhacChuong(NhacChuong nhacChuong) {
		this.nhacChuong = nhacChuong;
	}

	public KieuDang getKieuDang() {
		return this.kieuDang;
	}

	public void setKieuDang(KieuDang kieuDang) {
		this.kieuDang = kieuDang;
	}

	public PhongCach getPhongCach() {
		return this.phongCach;
	}

	public void setPhongCach(PhongCach phongCach) {
		this.phongCach = phongCach;
	}

	public LuuTru getLuuTru() {
		return this.luuTru;
	}

	public void setLuuTru(LuuTru luuTru) {
		this.luuTru = luuTru;
	}

	public LoaiMang getLoaiMang() {
		return this.loaiMang;
	}

	public void setLoaiMang(LoaiMang loaiMang) {
		this.loaiMang = loaiMang;
	}

	public KetNoi getKetNoi() {
		return this.ketNoi;
	}

	public void setKetNoi(KetNoi ketNoi) {
		this.ketNoi = ketNoi;
	}

	public boolean isJavaApp() {
		return this.javaApp;
	}

	public void setJavaApp(boolean javaApp) {
		this.javaApp = javaApp;
	}

	public boolean isOffice() {
		return this.office;
	}

	public void setOffice(boolean office) {
		this.office = office;
	}

	public ManHinh getManHinh() {
		return this.manHinh;
	}

	public void setManHinh(ManHinh manHinh) {
		this.manHinh = manHinh;
	}

	public Pin getPin() {
		return this.pin;
	}

	public void setPin(Pin pin) {
		this.pin = pin;
	}

	public KichCo getKichCo() {
		return this.kichCo;
	}

	public void setKichCo(KichCo kichCo) {
		this.kichCo = kichCo;
	}

	public HeDieuHanh getHeDieuHanh() {
		return this.heDieuHanh;
	}

	public void setHeDieuHanh(HeDieuHanh heDieuHanh) {
		this.heDieuHanh = heDieuHanh;
	}

	public DongSanPham getDongSanPham() {
		return this.dongSanPham;
	}

	public void setDongSanPham(DongSanPham dongSanPham) {
		this.dongSanPham = dongSanPham;
	}

	public String getNgonNgu() {
		return this.ngonNgu;
	}

	public void setNgonNgu(String ngonNgu) {
		this.ngonNgu = ngonNgu;
	}

	public String getBoBanHangChuan() {
		return this.boBanHangChuan;
	}

	public void setBoBanHangChuan(String boBanHangChuan) {
		this.boBanHangChuan = boBanHangChuan;
	}

	public Set<PhuKien> getDsPhuKienTuongThich() {
		return this.dsPhuKienTuongThich;
	}

	public void setDsPhuKienTuongThich(Set<PhuKien> dsPhuKienTuongThich) {
		this.dsPhuKienTuongThich = dsPhuKienTuongThich;
	}

	public Set<NhanXetDienThoai> getDsNhanXet() {
		return this.dsNhanXet;
	}

	public void setDsNhanXet(Set<NhanXetDienThoai> dsNhanXet) {
		this.dsNhanXet = dsNhanXet;
	}

	public Set<TinhNangNoiBat> getDsTinhNangNoiBat() {
		return this.dsTinhNangNoiBat;
	}

	public void setDsTinhNangNoiBat(Set<TinhNangNoiBat> dsTinhNangNoiBat) {
		this.dsTinhNangNoiBat = dsTinhNangNoiBat;
	}

	public Set<ChiTietTinKhuyenMaiDienThoai> getDsChiTietKhuyenMai() {
		return this.dsChiTietKhuyenMai;
	}

	public void setDsChiTietKhuyenMai(
			Set<ChiTietTinKhuyenMaiDienThoai> dsChiTietKhuyenMai) {
		this.dsChiTietKhuyenMai = dsChiTietKhuyenMai;
	}

	public Set<ChiTietPhieuNhapDienThoai> getDsChiTietPhieuNhap() {
		return this.dsChiTietPhieuNhap;
	}

	public void setDsChiTietPhieuNhap(
			Set<ChiTietPhieuNhapDienThoai> dsChiTietPhieuNhap) {
		this.dsChiTietPhieuNhap = dsChiTietPhieuNhap;
	}

}
