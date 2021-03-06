package qt.dto;

// Generated Jun 21, 2010 1:02:40 AM by Hibernate Tools 3.3.0.GA

import java.util.HashSet;
import java.util.Set;

/**
 * SanPham generated by hbm2java
 */
public class SanPham implements java.io.Serializable {

	private Integer id;
	private String ten;
	private double giaNhap;
	private double giaHienHanh;
	private int baoHanh;
	private boolean hienThi;
	private boolean xoa;
	private String hinhAnh;
	private Set<NhaCungCap> dsNhaCungCap = new HashSet<NhaCungCap>(0);
	private Set<ChiTietDonHang> dsChiTietDonHang = new HashSet<ChiTietDonHang>(
			0);
	private TinhTrangSanPham tinhTrangSanPham;
	private Set<ChiTietHinhAnh> dsHinhAnh = new HashSet<ChiTietHinhAnh>(0);

	public SanPham() {
	}

	public SanPham(String ten, double giaNhap, double giaHienHanh) {
		this.ten = ten;
		this.giaNhap = giaNhap;
		this.giaHienHanh = giaHienHanh;
	}

	public SanPham(String ten, double giaNhap, double giaHienHanh, int baoHanh,
			boolean hienThi, boolean xoa, String hinhAnh,
			Set<NhaCungCap> dsNhaCungCap, Set<ChiTietDonHang> dsChiTietDonHang,
			TinhTrangSanPham tinhTrangSanPham, Set<ChiTietHinhAnh> dsHinhAnh) {
		this.ten = ten;
		this.giaNhap = giaNhap;
		this.giaHienHanh = giaHienHanh;
		this.baoHanh = baoHanh;
		this.hienThi = hienThi;
		this.xoa = xoa;
		this.hinhAnh = hinhAnh;
		this.dsNhaCungCap = dsNhaCungCap;
		this.dsChiTietDonHang = dsChiTietDonHang;
		this.tinhTrangSanPham = tinhTrangSanPham;
		this.dsHinhAnh = dsHinhAnh;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTen() {
		return this.ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public double getGiaNhap() {
		return this.giaNhap;
	}

	public void setGiaNhap(double giaNhap) {
		this.giaNhap = giaNhap;
	}

	public double getGiaHienHanh() {
		return this.giaHienHanh;
	}

	public void setGiaHienHanh(double giaHienHanh) {
		this.giaHienHanh = giaHienHanh;
	}

	public int getBaoHanh() {
		return this.baoHanh;
	}

	public void setBaoHanh(int baoHanh) {
		this.baoHanh = baoHanh;
	}

	public boolean isHienThi() {
		return this.hienThi;
	}

	public void setHienThi(boolean hienThi) {
		this.hienThi = hienThi;
	}

	public boolean isXoa() {
		return this.xoa;
	}

	public void setXoa(boolean xoa) {
		this.xoa = xoa;
	}

	public String getHinhAnh() {
		return this.hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public Set<NhaCungCap> getDsNhaCungCap() {
		return this.dsNhaCungCap;
	}

	public void setDsNhaCungCap(Set<NhaCungCap> dsNhaCungCap) {
		this.dsNhaCungCap = dsNhaCungCap;
	}

	public Set<ChiTietDonHang> getDsChiTietDonHang() {
		return this.dsChiTietDonHang;
	}

	public void setDsChiTietDonHang(Set<ChiTietDonHang> dsChiTietDonHang) {
		this.dsChiTietDonHang = dsChiTietDonHang;
	}

	public TinhTrangSanPham getTinhTrangSanPham() {
		return this.tinhTrangSanPham;
	}

	public void setTinhTrangSanPham(TinhTrangSanPham tinhTrangSanPham) {
		this.tinhTrangSanPham = tinhTrangSanPham;
	}

	public Set<ChiTietHinhAnh> getDsHinhAnh() {
		return this.dsHinhAnh;
	}

	public void setDsHinhAnh(Set<ChiTietHinhAnh> dsHinhAnh) {
		this.dsHinhAnh = dsHinhAnh;
	}

}
