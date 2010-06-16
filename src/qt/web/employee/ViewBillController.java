/**
 * 
 */
package qt.web.employee;

import java.util.Date;
import java.util.List;

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
public class ViewBillController implements Controller {

	protected final Log logger = LogFactory.getLog(getClass());
	private DonHangBUS donHangBUS;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.info("Handle view all bills request at " + new Date());

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
		
		// get all bills
		List<DonHang> bills = donHangBUS.findAll();

		return new ModelAndView("employee/viewBill", "model", bills);
	}

	/**
	 * @param donHangBUS
	 *            the donHangBUS to set
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
