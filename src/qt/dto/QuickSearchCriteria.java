/**
 * 
 */
package qt.dto;

import java.io.Serializable;

/**
 * @author tqthe
 * 
 */
@SuppressWarnings("serial")
public class QuickSearchCriteria implements Serializable {

	private String tenDienThoai;
	private int idHangDienThoai;
	private double giaTu;
	private double giaDen;

	/**
	 * 
	 */
	public QuickSearchCriteria() {
		super();
	}

	/**
	 * @param tenDienThoai
	 * @param idHangDienThoai
	 * @param giaTu
	 * @param giaDen
	 */
	public QuickSearchCriteria(String tenDienThoai, int idHangDienThoai,
			double giaTu, double giaDen) {
		this.tenDienThoai = tenDienThoai;
		this.idHangDienThoai = idHangDienThoai;
		this.giaTu = giaTu;
		this.giaDen = giaDen;
	}

	/**
	 * @param tenDienThoai
	 *            the tenDienThoai to set
	 */
	public void setTenDienThoai(String tenDienThoai) {
		this.tenDienThoai = tenDienThoai;
	}

	/**
	 * @return the tenDienThoai
	 */
	public String getTenDienThoai() {
		return tenDienThoai;
	}

	/**
	 * @param idHangDienThoai
	 *            the idHangDienThoai to set
	 */
	public void setIdHangDienThoai(int idHangDienThoai) {
		this.idHangDienThoai = idHangDienThoai;
	}

	/**
	 * @return the idHangDienThoai
	 */
	public int getIdHangDienThoai() {
		return idHangDienThoai;
	}

	/**
	 * @param giaTu
	 *            the giaTu to set
	 */
	public void setGiaTu(double giaTu) {
		this.giaTu = giaTu;
	}

	/**
	 * @return the giaTu
	 */
	public double getGiaTu() {
		return giaTu;
	}

	/**
	 * @param giaDen
	 *            the giaDen to set
	 */
	public void setGiaDen(double giaDen) {
		this.giaDen = giaDen;
	}

	/**
	 * @return the giaDen
	 */
	public double getGiaDen() {
		return giaDen;
	}

}
