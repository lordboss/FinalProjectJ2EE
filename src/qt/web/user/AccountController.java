/**
 * 
 */
package qt.web.user;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import qt.bus.KhachHangBUS;
import qt.dto.KhachHang;

/**
 * @author tqthe
 *
 */
public class AccountController implements Controller {

	protected final Log logger = LogFactory.getLog(getClass());
	private KhachHangBUS khachHangBUS; 
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		logger.info("Handle view account request at " + new Date());
		
		// get current HttpSession to store a cart item
		HttpSession session = request.getSession(false);

		if (session == null) {
			return new ModelAndView("user/accountError", "message", "Lỗi phiên làm việc!");
		}
		
		int id = (Integer)session.getAttribute("accountId");
		// find an Account with given id 
		KhachHang k = khachHangBUS.findById(id);
		
		if (k == null) {
			logger.error("Can not parse account id! Invalid format!");
		}
		
		return new ModelAndView("user/viewAccount", "k", k);
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
}
