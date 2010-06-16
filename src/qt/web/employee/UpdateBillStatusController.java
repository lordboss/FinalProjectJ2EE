/**
 * 
 */
package qt.web.employee;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.view.RedirectView;

import qt.bus.DonHangBUS;
import qt.bus.TrangThaiDonHangBUS;
import qt.dto.DonHang;
import qt.dto.TrangThaiDonHang;

/**
 * @author tqthe
 * 
 */
public class UpdateBillStatusController implements Controller {

	protected final Log logger = LogFactory.getLog(getClass());
	private DonHangBUS donHangBUS;
	private TrangThaiDonHangBUS trangThaiDonHangBUS;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.info("Handle update bill request at " + new Date());

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

		int billId = -1;
		int newStatusId = -1;

		// try to get bill id and bill status id
		try {
			billId = Integer.parseInt(request.getParameter("billId"));
			newStatusId = Integer.parseInt(request.getParameter("newStatus"));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Can not parse parameters. Invalid format!");
		}

		Map<String, Object> model = new HashMap<String, Object>();

		DonHang d = donHangBUS.findById(billId);
		if (d != null) {
			TrangThaiDonHang t = getTrangThaiDonHangBUS().findById(newStatusId);
			if (t != null) {
				d.setTrangThai(t);

				try {
					// save change
					donHangBUS.makePersistent(d);
					model.put("bill", d);
					model.put("isSuccess", "1");
				} catch (Exception e) {
					e.printStackTrace();
					logger.error("Can not save change for DonHang!");
					model.put("isSuccess", "0");
				}
			}
		}

		// return new ModelAndView(new RedirectView("manageBill.html"));
		return new ModelAndView("forward:/updateOneBill.html", "model", model);
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

	/**
	 * @param trangThaiDonHangBUS
	 *            the trangThaiDonHangBUS to set
	 */
	public void setTrangThaiDonHangBUS(TrangThaiDonHangBUS trangThaiDonHangBUS) {
		this.trangThaiDonHangBUS = trangThaiDonHangBUS;
	}

	/**
	 * @return the trangThaiDonHangBUS
	 */
	public TrangThaiDonHangBUS getTrangThaiDonHangBUS() {
		return trangThaiDonHangBUS;
	}

}
