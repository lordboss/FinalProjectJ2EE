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
import qt.bus.KieuDangBUS;
import qt.dto.DienThoai;
import qt.dto.KieuDang;

/**
 * @author tqthe
 *
 */
public class SearchByDesignController implements Controller {

	private Log logger = LogFactory.getLog(getClass());
	private DienThoaiBUS dienThoaiBUS;
	private KieuDangBUS kieuDangBUS;
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		logger.info("Handler search by design at " + new Date().toString());
		
		int designId = 2;
		
		try {
			designId = Integer.parseInt(request.getParameter("designId"));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Invalid designId");
		}
		
		List<DienThoai> result = dienThoaiBUS.findByKieuDang(designId);
		String design = "Nấp gập";
		KieuDang d = kieuDangBUS.findById(designId);
		if (d != null) {
			design = d.getTen();
		}
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("result", result);
		model.put("design", design);
		
		return new ModelAndView("searchByDesignResult", "model", model);
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
	 * @param kieuDangBUS the kieuDangBUS to set
	 */
	public void setKieuDangBUS(KieuDangBUS kieuDangBUS) {
		this.kieuDangBUS = kieuDangBUS;
	}


	/**
	 * @return the kieuDangBUS
	 */
	public KieuDangBUS getKieuDangBUS() {
		return kieuDangBUS;
	}

}
