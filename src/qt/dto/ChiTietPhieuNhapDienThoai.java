package qt.dto;

// Generated Jun 21, 2010 1:02:40 AM by Hibernate Tools 3.3.0.GA

/**
 * ChiTietPhieuNhapDienThoai generated by hbm2java
 */
public class ChiTietPhieuNhapDienThoai implements java.io.Serializable {

	private Integer id;
	private PhieuNhapDienThoai phieuNhapDienThoai;
	private DienThoai dienThoai;
	private Integer soLuong;
	private boolean xoa;

	public ChiTietPhieuNhapDienThoai() {
	}

	public ChiTietPhieuNhapDienThoai(Integer soLuong, boolean xoa) {
		this.soLuong = soLuong;
		this.xoa = xoa;
	}

	public ChiTietPhieuNhapDienThoai(PhieuNhapDienThoai phieuNhapDienThoai,
			DienThoai dienThoai, Integer soLuong, boolean xoa) {
		this.phieuNhapDienThoai = phieuNhapDienThoai;
		this.dienThoai = dienThoai;
		this.soLuong = soLuong;
		this.xoa = xoa;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PhieuNhapDienThoai getPhieuNhapDienThoai() {
		return this.phieuNhapDienThoai;
	}

	public void setPhieuNhapDienThoai(PhieuNhapDienThoai phieuNhapDienThoai) {
		this.phieuNhapDienThoai = phieuNhapDienThoai;
	}

	public DienThoai getDienThoai() {
		return this.dienThoai;
	}

	public void setDienThoai(DienThoai dienThoai) {
		this.dienThoai = dienThoai;
	}

	public Integer getSoLuong() {
		return this.soLuong;
	}

	public void setSoLuong(Integer soLuong) {
		this.soLuong = soLuong;
	}

	public boolean isXoa() {
		return this.xoa;
	}

	public void setXoa(boolean xoa) {
		this.xoa = xoa;
	}

}
