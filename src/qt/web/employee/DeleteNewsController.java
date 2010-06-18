/**
 * 
 */
package qt.web.employee;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.view.RedirectView;

import qt.bus.TinTucBUS;
import qt.dto.TinTuc;

/**
 * @author tqthe
 * 
 */
public class DeleteNewsController implements Controller {

	protected final Log logger = LogFactory.getLog(getClass());
	private TinTucBUS tinTucBUS;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		logger.info("Handle delete news at " + new Date()); 
		
		// get current HttpSession to store a cart item
		HttpSession session = request.getSession(false);

		if (session == null) {
			logger.error("Current session is null. Login is required!");
			return new ModelAndView(new RedirectView("requiredLogin.html"));
		}

		if (session.getAttribute("accountId") == null) {
			logger.error("Login is required!");
			return new ModelAndView(new RedirectView("requiredLogin.html"));
		}
		
		int nid = -1; 
		
		try {
			logger.error("DEBUG: " + request.getParameter("nid"));
			nid = Integer.parseInt(request.getParameter("nid"));
			TinTuc t = tinTucBUS.findById(nid);
			if (t != null) {
				// mark as deleted and save change
				tinTucBUS.markAsDeleted(t);
			}
		} catch (Exception e) {
			e.printStackTrace(); 
			logger.error(e.getMessage());
		}
		
		return new ModelAndView(new RedirectView("manageNews.html"));
	}
	
	/**
	 * @param tinTucBUS
	 *            the tinTucBUS to set
	 */
	public void setTinTucBUS(TinTucBUS tinTucBUS) {
		this.tinTucBUS = tinTucBUS;
	}

	/**
	 * @return the tinTucBUS
	 */
	public TinTucBUS getTinTucBUS() {
		return tinTucBUS;
	}

}
