/**
 * 
 */
package qt.web.user;

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

import qt.bus.KhachHangBUS;
import qt.dto.KhachHang;

/**
 * @author tqthe
 * 
 */
@SuppressWarnings("deprecation")
public class UpdateAccountFormController extends SimpleFormController {
	protected final Log logger = LogFactory.getLog(getClass());
	private KhachHangBUS khachHangBUS;

	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {

		logger.info("Handle update account request at " + new Date());

		// get form object
		KhachHang k = (KhachHang) command;

		if (k == null) {
			logger.error("Can not get KhachHang command object!");
			return new ModelAndView("user/accountError", "message",
					"Lỗi trong quá trình cập nhật tài khoản!");
		}

		// update change
		khachHangBUS.makePersistent(k);

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("status", "Cập nhật thành công");

		ModelAndView mv = new ModelAndView(getSuccessView(), "model", model);
		mv.addAllObjects(errors.getModel());
		
		return mv;
		//return new ModelAndView(new RedirectView(getSuccessView()));
	}

	@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		int accountId = (Integer) request.getSession()
				.getAttribute("accountId");
		KhachHang k = khachHangBUS.findById(accountId);

		return k;
	}

	/**
	 * @param khachHangBUS
	 *            the khachHangBUS to set
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
