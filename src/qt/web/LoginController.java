/**
 * 
 */
package qt.web;

import java.util.Date;
import java.util.Enumeration;

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

/**
 * Kiểm tra việc đăng nhập, tạo cái biến Session cần thiết nếu đăng nhập thành
 * công.
 * 
 * @author tqthe
 * 
 */
public class LoginController implements Controller {

	protected final Log logger = LogFactory.getLog(getClass());
	private AccountBUS accountBUS;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.info("Handle login request at " + new Date());

		String username = null;
		String password = null;
		
		String view = "home.html";
		HttpSession session = request.getSession(true);
		
		try {
			username = request.getParameter("username");
			password = request.getParameter("password");

			Account a = accountBUS.login(username, password);

			// login successful
			if (a != null) {
				logger.info("Login successful!");

				String userType = a.getClass().getSimpleName();

				// reset all session variables
				Enumeration<String> e = session.getAttributeNames();
				while (e.hasMoreElements()) {
					session.removeAttribute((String) e.nextElement());
				}
				
				session.setAttribute("accountId", a.getId());
				session.setAttribute("userType", userType);
				session.setAttribute("username", username);
				session.setAttribute("isSuccess", "Y");
				
				view = "home.html";
			} else {
				// failed
				logger.error("Login failed");
				session.setAttribute("isSuccess", "N");
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Invalid username and password parameter!");
		}
		return new ModelAndView(new RedirectView(view));
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
