/**
 * 
 */
package qt.web;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import qt.bus.DienThoaiBUS;
import qt.dto.DienThoai;

/**
 * @author tqthe
 *
 */
public class PhoneDetailController implements Controller {

	private Log logger = LogFactory.getLog(getClass());
	private DienThoaiBUS dienThoaiBUS;
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		logger.info("Handle phone detail view at " + new Date());
		
		int id = 0;
		DienThoai p = null;
		
		try {
			id = Integer.parseInt(request.getParameter("id"));
			
			// perform search phone by id
			p = dienThoaiBUS.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Invalid id parameter!");
		}
		
		return new ModelAndView("phoneDetails", "p", p);
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

}
