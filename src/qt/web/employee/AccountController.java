/**
 * 
 */
package qt.web.employee;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import qt.bus.NhanVienBUS;
import qt.dto.NhanVien;

/**
 * @author tqthe
 *
 */
public class AccountController implements Controller {

	protected final Log logger = LogFactory.getLog(getClass());
	private NhanVienBUS nhanVienBUS; 
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		logger.info("Handle view account request at " + new Date());
		
		// get current HttpSession to store a cart item
		HttpSession session = request.getSession(false);

		if (session == null) {
			return new ModelAndView("employee/accountError", "message", "Lỗi phiên làm việc!");
		}
		
		int id = -1; 
		
		try {
			id = (Integer)session.getAttribute("accountId");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Can not parse account id! Invalid format!");
		}
		
		// find an account with given id 
		NhanVien e = nhanVienBUS.findById(id); 
		
		if (e == null) {
			logger.error("Can not find Account with id = " + id);
		}
		
		return new ModelAndView("employee/viewAccount", "e", e);
	}

	/**
	 * @param nhanVienBUS the nhanVienBUS to set
	 */
	public void setNhanVienBUS(NhanVienBUS nhanVienBUS) {
		this.nhanVienBUS = nhanVienBUS;
	}

	/**
	 * @return the nhanVienBUS
	 */
	public NhanVienBUS getNhanVienBUS() {
		return nhanVienBUS;
	}

}
