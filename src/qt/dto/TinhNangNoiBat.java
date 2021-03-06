package qt.dto;

// Generated Jun 21, 2010 1:02:40 AM by Hibernate Tools 3.3.0.GA

/**
 * TinhNangNoiBat generated by hbm2java
 */
public class TinhNangNoiBat implements java.io.Serializable {

	private Integer id;
	private DienThoai dienThoai;
	private String tinhNang;
	private boolean xoa;

	public TinhNangNoiBat() {
	}

	public TinhNangNoiBat(String tinhNang, boolean xoa) {
		this.tinhNang = tinhNang;
		this.xoa = xoa;
	}

	public TinhNangNoiBat(DienThoai dienThoai, String tinhNang, boolean xoa) {
		this.dienThoai = dienThoai;
		this.tinhNang = tinhNang;
		this.xoa = xoa;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public DienThoai getDienThoai() {
		return this.dienThoai;
	}

	public void setDienThoai(DienThoai dienThoai) {
		this.dienThoai = dienThoai;
	}

	public String getTinhNang() {
		return this.tinhNang;
	}

	public void setTinhNang(String tinhNang) {
		this.tinhNang = tinhNang;
	}

	public boolean isXoa() {
		return this.xoa;
	}

	public void setXoa(boolean xoa) {
		this.xoa = xoa;
	}

}
