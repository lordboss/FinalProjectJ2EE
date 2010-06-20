/**
 * 
 */
package qt.bus.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import qt.bus.AccountBUS;
import qt.dto.NhanVien;

/**
 * @author tqthe
 * 
 */
public class AddEmployeeAccountValidator implements Validator {

	private AccountBUS accountBUS;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return NhanVien.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		NhanVien e = (NhanVien) target;
		
		if (e == null) {
			errors.reject("null");
		} else {
			if (e.getUsername() == null || e.getUsername().isEmpty()) {
				errors.rejectValue("username", "username-required", "Chưa nhập tên đăng nhập");
			}
			if (e.getHo() == null || e.getHo().isEmpty()) {
				errors.rejectValue("ho", "firstName-required", "Chưa nhập họ");
			}
			if (e.getTen() == null || e.getTen().isEmpty()) {
				errors.rejectValue("ten", "lastName-required", "Chưa nhập tên");
			}
			if (e.getGioiTinh() < 1 || e.getGioiTinh() > 2) {
				errors.rejectValue("gioiTinh", "sex-required", "Chưa chọn giới tính");
			}
			if (e.getCmnd() == null || e.getCmnd().isEmpty()) {
				errors.rejectValue("cmnd", "id-required", "Chưa nhập CMND");
			}
			if (e.getDiaChi() == null || e.getDiaChi().isEmpty()) {
				errors.rejectValue("cmnd", "address-required", "Chưa nhập địa chỉ");
			}
			if (e.getDienThoai() == null || e.getDienThoai().isEmpty()) {
				errors.rejectValue("dienThoai", "phone-required", "Chưa nhập điện thoại");
			}
			if (e.getEmail() == null || e.getEmail().isEmpty()) {
				errors.rejectValue("email", "email-required", "Chưa nhập địa chỉ email");
			}
			
			// check if email is in valid format ;)
			String emailRegex = "(\\w+)@(\\w+\\.)(\\w+)(\\.\\w+)*";
			Pattern pattern = Pattern.compile(emailRegex);
			Matcher matcher = pattern.matcher(e.getEmail());
			if (!matcher.find()) {
				errors.rejectValue("email", "invalid-email-format",
						new Object[] { e.getEmail() },
						"Định dạng email không đúng");
			}
			
			// check username 
			if (accountBUS.checkUsername(e.getUsername())) {
				errors.rejectValue("username", "username-exist", "Tên đăng nhập đã tồn tại");
			} 
			
			// check email
			if (accountBUS.checkEmail(e.getEmail())) {
				errors.rejectValue("email", "email-exist", "Email đã tồn tại");
			}
		}
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
