/**
 * 
 */
package qt.web.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.view.RedirectView;

import qt.bus.AccountBUS;
import qt.bus.CongTyBUS;
import qt.dto.Account;
import qt.dto.CongTy;
import qt.dto.NhanVienQuanTri;

/**
 * @author tqthe
 * 
 */
public class ViewCompanyInfoController implements Controller {

	protected final Log logger = LogFactory.getLog(getClass());
	private CongTyBUS congTyBUS;
	private AccountBUS accountBUS;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

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
			return new ModelAndView(new RedirectView("requiredLogin.html"));
		}

		CongTy c = congTyBUS.getCongTy();
		return new ModelAndView("admin/manageCompanyInfo", "model", c);
	}

	/**
	 * @param congTyBUS
	 *            the congTyBUS to set
	 */
	public void setCongTyBUS(CongTyBUS congTyBUS) {
		this.congTyBUS = congTyBUS;
	}

	/**
	 * @return the congTyBUS
	 */
	public CongTyBUS getCongTyBUS() {
		return congTyBUS;
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
