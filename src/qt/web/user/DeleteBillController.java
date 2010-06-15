/**
 * 
 */
package qt.web.user;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.view.RedirectView;

import qt.bus.DonHangBUS;
import qt.dto.DonHang;

/**
 * @author tqthe
 *
 */
public class DeleteBillController implements Controller {

	protected final Log logger = LogFactory.getLog(getClass());
	private DonHangBUS donHangBUS;
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		logger.info("Handle delete bill request at " + new Date());

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
		
		// try to parse billId
		int id = -1;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Can not parse bill id parameter. Invalid format!");
		}
		
		if (id == -1) {
			return new ModelAndView(new RedirectView("home.html"));
		}
		
		// perform deleting 
		DonHang d = donHangBUS.findById(id);
		if (d != null) {
			donHangBUS.markAsDeleted(d);
		} else {
			logger.error("DonHang is null");
		}
		
		return new ModelAndView(new RedirectView("viewBill.html"));
	}

	/**
	 * @param donHangBUS the donHangBUS to set
	 */
	public void setDonHangBUS(DonHangBUS donHangBUS) {
		this.donHangBUS = donHangBUS;
	}

	/**
	 * @return the donHangBUS
	 */
	public DonHangBUS getDonHangBUS() {
		return donHangBUS;
	}

}
