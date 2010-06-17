package qt.dto;

// Generated Jun 17, 2010 10:03:17 PM by Hibernate Tools 3.3.0.GA

import java.util.HashSet;
import java.util.Set;

/**
 * HangDienThoai generated by hbm2java
 */
public class HangDienThoai implements java.io.Serializable {

	private Integer id;
	private String ten;
	private Set<DienThoai> dsDienThoai = new HashSet<DienThoai>(0);

	public HangDienThoai() {
	}

	public HangDienThoai(String ten) {
		this.ten = ten;
	}

	public HangDienThoai(String ten, Set<DienThoai> dsDienThoai) {
		this.ten = ten;
		this.dsDienThoai = dsDienThoai;
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

	public Set<DienThoai> getDsDienThoai() {
		return this.dsDienThoai;
	}

	public void setDsDienThoai(Set<DienThoai> dsDienThoai) {
		this.dsDienThoai = dsDienThoai;
	}

}
