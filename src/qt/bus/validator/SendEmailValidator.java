/**
 * 
 */
package qt.bus.validator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import qt.dto.Email;

/**
 * @author tqthe
 * 
 */
public class SendEmailValidator implements Validator {
	
	protected Log logger = LogFactory.getLog(getClass());
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Email.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Email e = (Email) target;

		if (e == null) {
			errors.reject("null");
		} else {
			if (e.getSubject() == null || e.getSubject().isEmpty()) {
				errors.rejectValue("subject", "subject-required",
						"Subject is required");
			}
			if (e.getTo() == null || e.getTo().isEmpty()) {
				errors.rejectValue("to", "to-required",
						"Email address is required");
			}
			if (e.getBody() == null || e.getBody().isEmpty()) {
				errors.rejectValue("body", "body-required",
						"Email content is required");
			}
		}
	}

}
