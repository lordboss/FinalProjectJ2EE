package qt.dto;

// Generated Jun 21, 2010 1:02:40 AM by Hibernate Tools 3.3.0.GA

/**
 * NhacChuong generated by hbm2java
 */
public class NhacChuong implements java.io.Serializable {

	private Integer nhacChuong;
	private String dinhDangNhacChuong;
	private boolean taiNhacChuong;
	private boolean baoRung;

	public NhacChuong() {
	}

	public NhacChuong(Integer nhacChuong, String dinhDangNhacChuong,
			boolean taiNhacChuong, boolean baoRung) {
		this.nhacChuong = nhacChuong;
		this.dinhDangNhacChuong = dinhDangNhacChuong;
		this.taiNhacChuong = taiNhacChuong;
		this.baoRung = baoRung;
	}

	public Integer getNhacChuong() {
		return this.nhacChuong;
	}

	public void setNhacChuong(Integer nhacChuong) {
		this.nhacChuong = nhacChuong;
	}

	public String getDinhDangNhacChuong() {
		return this.dinhDangNhacChuong;
	}

	public void setDinhDangNhacChuong(String dinhDangNhacChuong) {
		this.dinhDangNhacChuong = dinhDangNhacChuong;
	}

	public boolean isTaiNhacChuong() {
		return this.taiNhacChuong;
	}

	public void setTaiNhacChuong(boolean taiNhacChuong) {
		this.taiNhacChuong = taiNhacChuong;
	}

	public boolean isBaoRung() {
		return this.baoRung;
	}

	public void setBaoRung(boolean baoRung) {
		this.baoRung = baoRung;
	}

}
