/**
 * 
 */
package qt.web.admin;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import qt.bus.AccountBUS;
import qt.bus.NhanVienQuanTriBUS;
import qt.dto.NhanVienQuanTri;
import qt.util.HashHelper;

/**
 * @author tqthe
 *
 */
@SuppressWarnings("deprecation")
public class ChangeAdminPasswordFormController extends SimpleFormController {
	protected final Log logger = LogFactory.getLog(getClass());
	private NhanVienQuanTriBUS nhanVienQuanTriBUS;
	private AccountBUS accountBUS;
	
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {

		logger.info("Handle change admin password request at " + new Date());

		// get form object
		NhanVienQuanTri e = (NhanVienQuanTri) command;

		if (e == null) {
			logger.error("Can not get "  + NhanVienQuanTri.class.getName() + " command object!");
			return new ModelAndView("admin/accountError", "message",
					"Lỗi trong quá trình cập nhật tài khoản!");
		}

		Map<String, Object> model = new HashMap<String, Object>();
		ModelAndView mv = new ModelAndView(getSuccessView(), "model", model);
		mv.addAllObjects(errors.getModel());

		String oldPassword = request.getParameter("oldPassword");
		// check old password
		if (!checkOldPassword(request, oldPassword)) {
			model.put("status", "Mật khẩu hiện tại không đúng");
			model.put("success", "0");
			// return new ModelAndView("user/passwordError", "message",
			// "Mật khẩu không đúng");
		} else {
			model.put("status", "Cập nhật mật khẩu thành công");
			model.put("success", "1");

			// change password and save
			accountBUS.resetPassword(e, e.getPass());
		}

		return mv;
	}
	

	private boolean checkOldPassword(HttpServletRequest request,
			String oldPassword) throws Exception {
		int accountId = (Integer) request.getSession()
				.getAttribute("accountId");
		NhanVienQuanTri e = nhanVienQuanTriBUS.findById(accountId);

		return e.getPass().equals(HashHelper.getInstance().hash(oldPassword));
	}

	@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		int accountId = (Integer) request.getSession()
				.getAttribute("accountId");
		NhanVienQuanTri k = nhanVienQuanTriBUS.findById(accountId);

		return k;
	}
	
	/**
	 * @param nhanVienQuanTriBUS the nhanVienQuanTriBUS to set
	 */
	public void setNhanVienQuanTriBUS(NhanVienQuanTriBUS nhanVienQuanTriBUS) {
		this.nhanVienQuanTriBUS = nhanVienQuanTriBUS;
	}
	/**
	 * @return the nhanVienQuanTriBUS
	 */
	public NhanVienQuanTriBUS getNhanVienQuanTriBUS() {
		return nhanVienQuanTriBUS;
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
