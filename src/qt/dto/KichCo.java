package qt.dto;

// Generated Jun 21, 2010 1:02:40 AM by Hibernate Tools 3.3.0.GA

/**
 * KichCo generated by hbm2java
 */
public class KichCo implements java.io.Serializable {

	private Integer chieuRongDienThoai;
	private Integer chieuDaiDienThoai;
	private Integer chieuCaoDienThoai;
	private Integer trongLuong;

	public KichCo() {
	}

	public KichCo(Integer chieuRongDienThoai, Integer chieuDaiDienThoai,
			Integer chieuCaoDienThoai, Integer trongLuong) {
		this.chieuRongDienThoai = chieuRongDienThoai;
		this.chieuDaiDienThoai = chieuDaiDienThoai;
		this.chieuCaoDienThoai = chieuCaoDienThoai;
		this.trongLuong = trongLuong;
	}

	public Integer getChieuRongDienThoai() {
		return this.chieuRongDienThoai;
	}

	public void setChieuRongDienThoai(Integer chieuRongDienThoai) {
		this.chieuRongDienThoai = chieuRongDienThoai;
	}

	public Integer getChieuDaiDienThoai() {
		return this.chieuDaiDienThoai;
	}

	public void setChieuDaiDienThoai(Integer chieuDaiDienThoai) {
		this.chieuDaiDienThoai = chieuDaiDienThoai;
	}

	public Integer getChieuCaoDienThoai() {
		return this.chieuCaoDienThoai;
	}

	public void setChieuCaoDienThoai(Integer chieuCaoDienThoai) {
		this.chieuCaoDienThoai = chieuCaoDienThoai;
	}

	public Integer getTrongLuong() {
		return this.trongLuong;
	}

	public void setTrongLuong(Integer trongLuong) {
		this.trongLuong = trongLuong;
	}

}
