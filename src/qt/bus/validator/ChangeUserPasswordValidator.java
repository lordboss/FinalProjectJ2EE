/**
 * 
 */
package qt.bus.validator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import qt.bus.KhachHangBUS;
import qt.dto.KhachHang;

/**
 * @author tqthe
 * 
 */
public class ChangeUserPasswordValidator implements Validator {

	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());
	private KhachHangBUS khachHangBUS;

	@Override
	public boolean supports(Class<?> clazz) {
		return KhachHang.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		KhachHang k = (KhachHang) target;

		if (k == null) {
			errors.rejectValue("*", "error.not-specified", null,
					"Value required!");
		} else {
			logger.info("Validate with " + k.getClass().getName());

			if (k.getPass() == null || k.getPass().isEmpty()) {
				errors.rejectValue("pass", "error.pass-required",
						new Object[] { k.getPass() },
						"Chưa nhập mật khẩu");
			}
			if (k.getPass2() == null || k.getPass2().isEmpty()) {
				errors.rejectValue("pass2", "error.confirm-password-required",
						new Object[] { k.getPass2() },
						"Chưa xác nhận lại mật khẩu");
			}
			// check if password confirmation is correct
			if (k.getPass() != null && k.getPass2() != null) {
				if (k.getPass().compareTo(k.getPass2()) != 0) {
					errors.rejectValue("pass2", "error.pass-not-match",
							new Object[] { k.getPass() },
							"Xác nhận mật khẩu chưa đúng");
				}
			}
		}
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
