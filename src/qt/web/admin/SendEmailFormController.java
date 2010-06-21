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
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
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
@SuppressWarnings("deprecation")
public class SendEmailFormController extends SimpleFormController {

	protected Log logger = LogFactory.getLog(getClass());

	private AccountBUS accountBUS;

	/**
	 * Mail helper (using GMail)
	 */
	private SimpleAccountManager mailHelper;

	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {

		logger.info("Handle reset account password at " + new Date());

		// make sure login
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

		Map<String, Object> model = new HashMap<String, Object>();

		Email email = (Email) command;

		try {
			mailHelper.sendMail(email);

			model.put("isSuccess", "yes");
			model.put("status", "Sending email done!");

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Can not send email to " + email.getTo() + "; Error: "
					+ e.getMessage());

			model.put("isSuccess", "no");
			model.put("status", "Can not send email to " + email.getTo());
		}

		ModelAndView mv = new ModelAndView(getSuccessView(), "model", model);
		mv.addAllObjects(errors.getModel());

		return mv;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {

		// get user's email 
		int aid = -1; 
		String userEmail = null;
		try {
			Object obj = request.getParameter("aid"); 
			if (obj != null) {
				aid = Integer.parseInt((String)obj);
				Account a = accountBUS.findById(aid);
				if (a != null) {
					userEmail = a.getEmail();
				} else {
					logger.error("Can not find account with id = " + aid);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Map<String, Object> model = (Map<String, Object>) request
				.getAttribute("model");
		Email e = null;
		if (model != null) {
			e = (Email) model.get("email");
		} else {
			e = new Email();
			if (userEmail != null) {
				e.setTo(userEmail);
			}
		}
		return e;
	}

	/**
	 * @param mailHelper
	 *            the mailHelper to set
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
