/**
 * 
 */
package qt.web.admin;

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

import qt.bus.AccountBUS;
import qt.dto.Account;
import qt.dto.Email;
import qt.dto.NhanVienQuanTri;
import qt.mail.SimpleAccountManager;

/**
 * @author tqthe
 * 
 */
public class ResetPasswordController implements Controller {

	protected Log logger = LogFactory.getLog(getClass());
	private AccountBUS accountBUS;
	private static final String TITLE = "Thông báo reset mật khẩu";
	/**
	 * Mail helper (using GMail)
	 */
	private SimpleAccountManager mailHelper;

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

		Email email = null; 
		
		try {
			int aid = Integer.parseInt(request.getParameter("aid"));
			Account a = accountBUS.findById(aid);

			if (a != null) {
				// genarate new password
				String newPassword = generateNewPassword();

				// set new password and save change
				accountBUS.resetPassword(a, newPassword);

				email = mailHelper.createResetPasswordMail(a.getEmail(), TITLE, newPassword);
				
				logger.info("Reset password for account: " + a.getUsername()
						+ " done!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("An error occurs when reseting account password at "
					+ new Date());
		}
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("email", email);
		
		request.setAttribute("email", email);
		
		return new ModelAndView("forward:/sendEmail.html", "model", model);
	}

	private String generateNewPassword() {
		return "123";
	}

	@SuppressWarnings("unused")
	private void sendMail(Account a, String newPassword) {
		mailHelper.sendNewPassword(a.getEmail(), TITLE, newPassword);
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

	/**
	 * @param mailHelper the mailHelper to set
	 */
	public void setMailHelper(SimpleAccountManager mailHelper) {
		this.mailHelper = mailHelper;
	}

	/**
	 * @return the mailHelper
	 */
	public SimpleAccountManager getMailHelper() {
		return mailHelper;
	}

}
