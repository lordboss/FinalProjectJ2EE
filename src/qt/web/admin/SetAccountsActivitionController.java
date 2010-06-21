/**
 * 
 */
package qt.web.admin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.view.RedirectView;

import qt.bus.AccountBUS;
import qt.dto.Account;

/**
 * @author tqthe
 * 
 */
public class SetAccountsActivitionController implements Controller {

	protected Log logger = LogFactory.getLog(getClass());
	private AccountBUS accountBUS;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.info("Handle deactive accounts at " + new Date());

		try {
			// get minId and maxId --- cách này của mình trâu bò :(
			// int minId = Integer.parseInt(request.getParameter("minId"));
			// int maxId = Integer.parseInt(request.getParameter("maxId"));

			// get selected accoutns
			List<Integer> selectedAccounts = new ArrayList<Integer>();
			String[] accounts = request.getParameterValues("account");
			for (String acc : accounts) {
				selectedAccounts.add(Integer.parseInt(acc));
			}

			for (Integer id : selectedAccounts) {
				Account a = accountBUS.findById(id);
				if (a != null) {
					accountBUS.deactivate(a);
				}
			}

			logger.info("Deactivating accounts done!");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("An error occurs when deactivating accounts: "
					+ e.getMessage());
		}

		return new ModelAndView(new RedirectView("viewAccounts.html"));
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
