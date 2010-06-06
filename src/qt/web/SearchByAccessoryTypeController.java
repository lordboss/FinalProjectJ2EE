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

import qt.bus.LoaiPhuKienBUS;
import qt.bus.PhuKienBUS;
import qt.dto.LoaiPhuKien;
import qt.dto.PhuKien;

/**
 * @author tqthe
 *
 */
public class SearchByAccessoryTypeController implements Controller {

	private Log logger = LogFactory.getLog(getClass());
	private PhuKienBUS phuKienBUS;
	private LoaiPhuKienBUS loaiPhuKienBUS;
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		logger.info("Handle search by accessory type at " + new Date());
		
		int id = 1; // default
		String name = "Bao da";
		
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Can not parse accessory type id!");
		}
		
		Map<String, Object> model = new HashMap<String, Object>();
		
		List<PhuKien> result = phuKienBUS.findByLoaiPhuKien(id);
		LoaiPhuKien t = loaiPhuKienBUS.findById(id);
		if (t != null) {
			name = t.getTen();
		}
		
		model.put("result", result);
		model.put("name", name);
		
		return new ModelAndView("searchByAccessoryTypeResult", "model", model);
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
