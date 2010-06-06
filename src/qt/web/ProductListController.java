/**
 * 
 */
package qt.web;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import qt.bus.DienThoaiBUS;
import qt.bus.HangDienThoaiBUS;
import qt.bus.LoaiPhuKienBUS;
import qt.bus.PhuKienBUS;
import qt.dto.DienThoai;
import qt.dto.LoaiPhuKien;
import qt.dto.PhuKien;

/**
 * @author tqthe
 *
 */
public class ProductListController implements Controller {

	private Log logger = LogFactory.getLog(getClass());
	private DienThoaiBUS dienThoaiBUS;
	private PhuKienBUS phuKienBUS;
	private LoaiPhuKienBUS loaiPhuKienBUS;
	
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		logger.info("Get all products at " + new Date().toString());
		
		Map<String, Object> model = new HashMap<String, Object>();
		
		List<DienThoai> dsDienThoai = dienThoaiBUS.findAll();
		List<PhuKien> dsPhuKien = phuKienBUS.findAll();
		List<LoaiPhuKien> dsLoaiPhuKien = loaiPhuKienBUS.findAll();
		
		model.put("dsDienThoai", dsDienThoai);
		model.put("dsPhuKien", dsPhuKien);
		model.put("dsLoaiPhuKien", dsLoaiPhuKien);
		
		return new ModelAndView("index", "model", model);
	}

	/**
	 * @param dienThoaiBUS the dienThoaiBUS to set
	 */
	public void setDienThoaiBUS(DienThoaiBUS dienThoaiBUS) {
		this.dienThoaiBUS = dienThoaiBUS;
	}

	/**
	 * @return the dienThoaiBUS
	 */
	public DienThoaiBUS getDienThoaiBUS() {
		return dienThoaiBUS;
	}

	/**
	 * @param phuKienBUS the phuKienBUS to set
	 */
	public void setPhuKienBUS(PhuKienBUS phuKienBUS) {
		this.phuKienBUS = phuKienBUS;
	}

	/**
	 * @return the phuKienBUS
	 */
	public PhuKienBUS getPhuKienBUS() {
		return phuKienBUS;
	}

	/**
	 * @param loaiPhuKienBUS the loaiPhuKienBUS to set
	 */
	public void setLoaiPhuKienBUS(LoaiPhuKienBUS loaiPhuKienBUS) {
		this.loaiPhuKienBUS = loaiPhuKienBUS;
	}

	/**
	 * @return the loaiPhuKienBUS
	 */
	public LoaiPhuKienBUS getLoaiPhuKienBUS() {
		return loaiPhuKienBUS;
	}

}
