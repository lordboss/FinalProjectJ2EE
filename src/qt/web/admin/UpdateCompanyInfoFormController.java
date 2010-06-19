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
import qt.bus.CongTyBUS;
import qt.dto.Account;
import qt.dto.CongTy;
import qt.dto.NhanVienQuanTri;

/**
 * @author tqthe
 * 
 */
@SuppressWarnings("deprecation")
public class UpdateCompanyInfoFormController extends SimpleFormController {

	protected Log logger = LogFactory.getLog(getClass());
	private CongTyBUS congTyBUS;
	private AccountBUS accountBUS;

	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {

		logger.info("Handle update company info at " + new Date());

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
				Account a = getAccountBUS().findById(aid);
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
		
		try {
			CongTy c = (CongTy) command;
			congTyBUS.makePersistent(c);
			logger.info("Persist " + CongTy.class.getName() + " done!");
			model.put("isSuccess", "yes");
			model.put("status", "Cập nhật thành công");
		} catch (Exception e) {
			e.printStackTrace();
			model.put("isSuccess", "no");
			model.put("status", "Cập nhật thất bại");
			logger.error("Can not persist " + CongTy.class.getName()
					+ "; Error: " + e.getMessage());
		}
		
		ModelAndView mv = new ModelAndView(getSuccessView(), "model", model);
		mv.addAllObjects(errors.getModel());
		
		return mv;
	}

	@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		
		CongTy c = congTyBUS.getCongTy();
		return c;
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
