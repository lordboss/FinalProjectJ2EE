/**
 * 
 */
package qt.bus.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
public class UpdateAccountValidator implements Validator {

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

			if (k.getGioiTinh() == 0) {
				errors
						.rejectValue("gioiTinh", "error.sex-required",
								new Object[] { k.getGioiTinh() },
								"Chưa chọn giới tính");
			}

			if (k.getUsername() == null || k.getUsername().isEmpty()) {
				errors.rejectValue("username", "error.username-required",
						new Object[] { k.getPass() }, "Chưa nhập username");
			}

			if (k.getEmail() == null || k.getEmail().isEmpty()) {
				errors.rejectValue("email", "error.email-required",
						new Object[] { k.getPass() }, "Chưa nhập email");
			}

			// check if email is in valid format ;)
			String emailRegex = "(\\w+)@(\\w+\\.)(\\w+)(\\.\\w+)*";
			Pattern pattern = Pattern.compile(emailRegex);
			Matcher matcher = pattern.matcher(k.getEmail());
			if (!matcher.find()) {
				errors.rejectValue("email", "error.invalid-email-format",
						new Object[] { k.getEmail() },
						"Định dạng email không đúng");
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
