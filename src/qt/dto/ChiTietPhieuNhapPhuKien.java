package qt.dto;

// Generated Jun 21, 2010 1:02:40 AM by Hibernate Tools 3.3.0.GA

/**
 * ChiTietPhieuNhapPhuKien generated by hbm2java
 */
public class ChiTietPhieuNhapPhuKien implements java.io.Serializable {

	private Integer id;
	private PhieuNhapPhuKien phieuNhapPhuKien;
	private PhuKien phuKien;
	private Integer soLuong;
	private boolean xoa;

	public ChiTietPhieuNhapPhuKien() {
	}

	public ChiTietPhieuNhapPhuKien(Integer soLuong, boolean xoa) {
		this.soLuong = soLuong;
		this.xoa = xoa;
	}

	public ChiTietPhieuNhapPhuKien(PhieuNhapPhuKien phieuNhapPhuKien,
			PhuKien phuKien, Integer soLuong, boolean xoa) {
		this.phieuNhapPhuKien = phieuNhapPhuKien;
		this.phuKien = phuKien;
		this.soLuong = soLuong;
		this.xoa = xoa;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PhieuNhapPhuKien getPhieuNhapPhuKien() {
		return this.phieuNhapPhuKien;
	}

	public void setPhieuNhapPhuKien(PhieuNhapPhuKien phieuNhapPhuKien) {
		this.phieuNhapPhuKien = phieuNhapPhuKien;
	}

	public PhuKien getPhuKien() {
		return this.phuKien;
	}

	public void setPhuKien(PhuKien phuKien) {
		this.phuKien = phuKien;
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
