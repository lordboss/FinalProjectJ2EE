/**
 * 
 */
package qt.web.employee;

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
import qt.bus.NhanVienBUS;
import qt.dto.NhanVien;
import qt.util.HashHelper;

/**
 * @author tqthe
 * 
 */
@SuppressWarnings("deprecation")
public class ChangeEmployeePasswordFormController extends SimpleFormController {

	protected final Log logger = LogFactory.getLog(getClass());
	private NhanVienBUS nhanVienBUS;
	private AccountBUS accountBUS;

	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {

		logger.info("Handle change employee password request at " + new Date());

		// get form object
		NhanVien e = (NhanVien) command;

		if (e == null) {
			logger.error("Can not get NhanVien command object!");
			return new ModelAndView("employee/accountError", "message",
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
		NhanVien e = getNhanVienBUS().findById(accountId);

		return e.getPass().equals(HashHelper.getInstance().hash(oldPassword));
	}

	@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		int accountId = (Integer) request.getSession()
				.getAttribute("accountId");
		NhanVien k = getNhanVienBUS().findById(accountId);

		return k;
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

	/**
	 * @param nhanVienBUS
	 *            the nhanVienBUS to set
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
