/**
 * 
 */
package qt.bus.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import qt.dto.CongTy;

/**
 * @author tqthe
 * 
 */
public class EditCompanyInfoValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return CongTy.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		CongTy c = (CongTy) target;

		if (c == null) {
			errors.reject("null");
		} else {
			if (c.getDiaChi() == null || c.getDiaChi().isEmpty()) {
				errors.rejectValue("diaChi", "address-required",
						"Chưa nhập địa chỉ");
			}
			if (c.getDienThoai() == null || c.getDienThoai().isEmpty()) {
				errors.rejectValue("dienThoai", "phone-required",
						"Chưa nhập số điện thoại");
			}
			if (c.getEmail() == null || c.getEmail().isEmpty()) {
				errors
						.rejectValue("email", "email-required",
								"Chưa nhập email");
			}
			if (c.getTen() == null || c.getTen().isEmpty()) {
				errors.rejectValue("ten", "name-required",
						"Chưa nhập tên công ty");
			}
			if (c.getThongTinChung() == null || c.getThongTinChung().isEmpty()) {
				errors.rejectValue("thongTinChung", "gerneralInfo-required",
						"Chưa nhập thông tin chung");
			}

			// check if email is in valid format ;)
			String emailRegex = "(\\w+)@(\\w+\\.)(\\w+)(\\.\\w+)*";
			Pattern pattern = Pattern.compile(emailRegex);
			Matcher matcher = pattern.matcher(c.getEmail());
			if (!matcher.find()) {
				errors.rejectValue("email", "error.invalid-email-format",
						new Object[] { c.getEmail() },
						"Định dạng email không đúng");
			}
		}
	}

}
