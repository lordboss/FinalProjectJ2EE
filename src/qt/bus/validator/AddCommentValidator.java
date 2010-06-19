/**
 * 
 */
package qt.bus.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import qt.dto.NhanXetDienThoai;

/**
 * @author tqthe
 *
 */
public class AddCommentValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return NhanXetDienThoai.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		NhanXetDienThoai c = (NhanXetDienThoai) target;
		if (c == null) {
			errors.reject("null", "Null pointer");
		} else {
			if (c.getTongQuan() == null || c.getTongQuan().isEmpty()) {
				errors.rejectValue("tongQuan", "general-required", "Chưa viết tổng quan");
			} 
			if (c.getUuDiem() == null || c.getUuDiem().isEmpty()) {
				errors.rejectValue("uuDiem", "advanced-required", "Chưa viết ưu điểm");
			}
			if (c.getNhuocDiem() == null || c.getNhuocDiem().isEmpty()) {
				errors.rejectValue("nhuocDiem", "disadvanced-required", "Chưa viết nhược điểm");
			}
		}
	}

}
