/**
 * 
 */
package qt.web;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import qt.bus.KhachHangBUS;
import qt.dto.KhachHang;
import qt.util.HashHelper;

/**
 * @author tqthe
 * 
 */
@SuppressWarnings("deprecation")
public class RegisterFormController extends SimpleFormController {

	protected final Log logger = LogFactory.getLog(getClass());
	private KhachHangBUS khachHangBUS;
	
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {

		// get the command 
		KhachHang a = (KhachHang) command;
		if (a == null) {
			logger.error("Can not get command object!");
		}
		logger.info("Handle user's register at " + new Date());
		
		if (a != null) {
			a.setTrangThai(1); // assume account active right now ;)
			a.setXoa(false);
			
			// hash password
			a.setPass(HashHelper.getInstance().hash(a.getPass()));
			
			// add new
			khachHangBUS.makePersistent(a);
			
			// login also ;)
			HttpSession session = request.getSession(true);
			String userType = a.getClass().getSimpleName();

			session.setAttribute("userType", userType);
			session.setAttribute("username", a.getUsername());
		}
		
		return new ModelAndView(new RedirectView(getSuccessView()));
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
