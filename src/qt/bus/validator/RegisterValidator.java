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

import qt.bus.AccountBUS;
import qt.dto.KhachHang;

/**
 * @author tqthe
 * 
 */
public class RegisterValidator implements Validator {

	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());
	private AccountBUS accountBUS;

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

			// check for required fields
			if (k.getHo() == null || k.getHo().isEmpty()) {
				errors.rejectValue("ho", "error.lastname-required",
						new Object[] { k.getPass() },
						"Chưa nhập họ");
			}
			if (k.getTen() == null || k.getTen().isEmpty()) {
				errors.rejectValue("ten", "error.firstname-required",
						new Object[] { k.getPass() },
						"Chưa nhập tên");
			}
			if (k.getUsername() == null || k.getUsername().isEmpty()) {
				errors.rejectValue("username", "error.username-required",
						new Object[] { k.getPass() },
						"Chưa nhập username");
			}
			if (k.getPass() == null || k.getPass().isEmpty()) {
				errors.rejectValue("pass", "error.pass-required",
						new Object[] { k.getPass() },
						"Chưa nhập password");
			}
			if (k.getPass2() == null || k.getPass2().isEmpty()) {
				errors.rejectValue("pass2", "error.confirm-password-required",
						new Object[] { k.getPass2() },
						"Chưa xác nhận lại password");
			}
			if (k.getEmail() == null || k.getEmail().isEmpty()) {
				errors.rejectValue("email", "error.email-required",
						new Object[] { k.getPass() },
						"Chưa nhập email");
			}
			
			// check if username is in valid format ;)
			
			// check if username has already existed
			if (accountBUS.checkUsername(k.getUsername())) {
				errors.rejectValue("username", "error.username-exist",
						new Object[] { k.getUsername() },
						"Username đã tồn tại");
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
			
			// check if email has already existed
			if (accountBUS.checkEmail(k.getEmail())) {
				errors.rejectValue("email", "error.email-exist",
						new Object[] { k.getEmail() }, "Email đã tồn tại");
			}
			
			// check if password confirmation is correct
			if (k.getPass() != null && k.getPass2() != null) {
				if (k.getPass().compareTo(k.getPass2()) != 0) {
					errors.rejectValue("pass2", "error.pass-not-match",
							new Object[] { k.getPass() },
							"Xác nhận password chưa đúng");
				}
			}
		}
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
