/**
 * 
 */
package qt.bus.validator;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import qt.dto.GopY;

/**
 * @author tqthe
 * 
 */
public class SuggestionValidator implements Validator {

	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());

	@Override
	public boolean supports(Class<?> clazz) {
		return GopY.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		GopY g = (GopY) target;
		
		
		if (g == null) {
			logger.error("Can not get GopY target for validation");
			errors.reject("target-null", "Target null");
		} else {
			logger.info("Begin validate GopY target at " + new Date());

			if (g.getTieuDe() == null || g.getTieuDe().isEmpty()) {
				errors.rejectValue("tieuDe", "title-required",
						"Vui lòng nhập tiêu đề cho góp ý");
			}
			if (g.getNoiDung() == null || g.getNoiDung().isEmpty()) {
				errors.rejectValue("noiDung", "content-required",
						"Vui lòng nhập nội dung góp ý");
			}
		}
	}
}
