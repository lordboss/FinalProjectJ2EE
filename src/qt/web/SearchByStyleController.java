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
import qt.bus.PhongCachBUS;
import qt.dto.DienThoai;

/**
 * @author tqthe
 *
 */
public class SearchByStyleController implements Controller {

	private Log logger = LogFactory.getLog(getClass());
	private DienThoaiBUS dienThoaiBUS;
	private PhongCachBUS phongCachBUS;
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		logger.info("Handle search by style at " + new Date().toString());
		
		int styleId = 1; // default in case invalid id
		
		try {
			styleId = Integer.parseInt(request.getParameter("styleId"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<DienThoai> result = dienThoaiBUS.findByPhongCach(styleId);
		String style = phongCachBUS.findById(styleId).getTen();
		
		Map<String, Object> model = new HashMap<String, Object>();

		model.put("result", result);
		model.put("style", style);
		
		return new ModelAndView("searchByStyleResult", "model", model);
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
	 * @param phongCachBUS the phongCachBUS to set
	 */
	public void setPhongCachBUS(PhongCachBUS phongCachBUS) {
		this.phongCachBUS = phongCachBUS;
	}

	/**
	 * @return the phongCachBUS
	 */
	public PhongCachBUS getPhongCachBUS() {
		return phongCachBUS;
	}

}
