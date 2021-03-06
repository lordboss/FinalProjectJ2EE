package qt.dto;

// Generated Jun 21, 2010 1:02:40 AM by Hibernate Tools 3.3.0.GA

import java.util.HashSet;
import java.util.Set;

/**
 * HinhThucThanhToan generated by hbm2java
 */
public class HinhThucThanhToan implements java.io.Serializable {

	private Integer id;
	private String hinhThuc;
	private Set<DonHang> dsDonHang = new HashSet<DonHang>(0);

	public HinhThucThanhToan() {
	}

	public HinhThucThanhToan(String hinhThuc) {
		this.hinhThuc = hinhThuc;
	}

	public HinhThucThanhToan(String hinhThuc, Set<DonHang> dsDonHang) {
		this.hinhThuc = hinhThuc;
		this.dsDonHang = dsDonHang;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHinhThuc() {
		return this.hinhThuc;
	}

	public void setHinhThuc(String hinhThuc) {
		this.hinhThuc = hinhThuc;
	}

	public Set<DonHang> getDsDonHang() {
		return this.dsDonHang;
	}

	public void setDsDonHang(Set<DonHang> dsDonHang) {
		this.dsDonHang = dsDonHang;
	}

}
