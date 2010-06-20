/**
 * 
 */
package qt.web.admin;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
import qt.dto.KhachHang;
import qt.dto.NhanVienBanHang;
import qt.dto.NhanVienQuanLy;
import qt.dto.NhanVienQuanTri;

/**
 * @author tqthe
 * 
 */
public class ViewAccountsController implements Controller {

	protected Log logger = LogFactory.getLog(getClass());
	private AccountBUS accountBUS;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.info("Handle view all accounts at " + new Date());

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

		List<Account> accounts = accountBUS.findAll();
		
		Map<String, Object> model = new HashMap<String, Object>();
		List<Account> users = new ArrayList<Account>();
		List<Account> sales = new ArrayList<Account>();
		List<Account> managers = new ArrayList<Account>();
		
		for (Account acc : accounts) {
			if (acc instanceof KhachHang) {
				users.add(acc);
			} else if (acc instanceof NhanVienBanHang) {
				sales.add(acc);
			} else if (acc instanceof NhanVienQuanLy) {
				managers.add(acc);
			}
		}
		
		List<List<Account>> accountTypes = new ArrayList<List<Account>>();
		
		accountTypes.add(users);
		accountTypes.add(sales);
		accountTypes.add(managers);
		
		model.put("accountTypes", accountTypes);
		
		model.put("users", users);
		model.put("sales", sales);
		model.put("managers", managers);
		
		return new ModelAndView("admin/manageAccount", "model", model);
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
