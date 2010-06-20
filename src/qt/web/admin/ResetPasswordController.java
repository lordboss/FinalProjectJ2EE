/**
 * 
 */
package qt.web.admin;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.view.RedirectView;

import qt.bus.AccountBUS;
import qt.dto.Account;
import qt.dto.NhanVienQuanTri;

/**
 * @author tqthe
 * 
 */
public class ResetPasswordController implements Controller {

	protected Log logger = LogFactory.getLog(getClass());
	private AccountBUS accountBUS;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.info("Handle reset account password at " + new Date());

		// make login
		HttpSession session = request.getSession(false);
		boolean valid = true;
		if (session == null) {
			logger.error("Session is null.");
			valid = false;
		} else {
			Object s = session.getAttribute("accountId");
			if (s == null) {
				valid = false;
			} else {
				int aid = (Integer) s;
				Account a = accountBUS.findById(aid);
				if (a == null) {
					valid = false;
				} else {
					if (!a.getClass().equals(NhanVienQuanTri.class)) {
						valid = false;
					}
				}
			}
		}

		if (!valid) {
			logger.error("Not login detected! When update company info");
			return new ModelAndView(new RedirectView("requiredLogin.html"));
		}

		try {
			int aid = Integer.parseInt(request.getParameter("aid"));
			Account a = accountBUS.findById(aid);

			if (a != null) {
				// genarate new password
				String newPassword = generateNewPassword();

				// set new password and save change
				accountBUS.resetPassword(a, newPassword);

				logger.info("Reset password for account: " + a.getUsername()
						+ " done!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("An error occurs when reseting account password at "
					+ new Date());
		}

		return new ModelAndView(new RedirectView("viewAccounts.html"));
	}

	private String generateNewPassword() {
		return "123";
	}

	/**
	 * @param accountBUS
	 *            the accountBUS to set
	 */
	public void setAccountBUS(AccountBUS accountBUS) {
		this.accountBUS = accountBUS;
	}

	/**
	 * @return the accountBUS
	 */
	public AccountBUS getAccountBUS() {
		return accountBUS;
	}

}
