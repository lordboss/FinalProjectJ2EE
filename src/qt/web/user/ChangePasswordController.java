/**
 * 
 */
package qt.web.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import qt.bus.AccountBUS;
import qt.bus.KhachHangBUS;

/**
 * @author tqthe
 *
 */
public class ChangePasswordController implements Controller {

	protected final Log logger = LogFactory.getLog(getClass());
	private KhachHangBUS khachHangBUS; 
	private AccountBUS accountBUS; 
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		return null;
	}

	/**
	 * @param khachHangBUS the khachHangBUS to set
	 */
	public void setKhachHangBUS(KhachHangBUS khachHangBUS) {
		this.khachHangBUS = khachHangBUS;
	}

	/**
	 * @return the khachHangBUS
	 */
	public KhachHangBUS getKhachHangBUS() {
		return khachHangBUS;
	}

	/**
	 * @param accountBUS the accountBUS to set
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
