/**
 * 
 */
package qt.bus.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import qt.dto.TinTuc;

/**
 * @author tqthe
 *
 */
public class UpdateNewsValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return TinTuc.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		TinTuc t = (TinTuc) target;
		
		if (t == null) {
			errors.reject("null");
		} else {
			if (t.getTieuDe() == null || t.getTieuDe().isEmpty()) {
				errors.rejectValue("tieuDe", "title-required", "Chưa nhập tiêu đề"); 
			}
			if (t.getNoiDung() == null || t.getNoiDung().isEmpty()) {
				errors.rejectValue("noiDung", "content-required", "Chưa nhập nội dung tin");
			}
		}
	}

}
