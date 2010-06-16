/**
 * 
 */
package qt.bus.validator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import qt.bus.NhanVienBUS;
import qt.dto.NhanVien;

/**
 * @author tqthe
 *
 */
public class ChangeEmployeePasswordValidator implements Validator {

	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());
	private NhanVienBUS nhanVienBUS;

	@Override
	public boolean supports(Class<?> clazz) {
		return NhanVien.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		NhanVien e = (NhanVien) target;

		if (e == null) {
			errors.rejectValue("*", "error.not-specified", null,
					"Value required!");
		} else {
			logger.info("Validate with " + e.getClass().getName());

			if (e.getPass() == null || e.getPass().isEmpty()) {
				errors.rejectValue("pass", "error.pass-required",
						new Object[] { e.getPass() },
						"Chưa nhập mật khẩu");
			}
			if (e.getPass2() == null || e.getPass2().isEmpty()) {
				errors.rejectValue("pass2", "error.confirm-password-required",
						new Object[] { e.getPass2() },
						"Chưa xác nhận lại mật khẩu");
			}
			// check if password confirmation is correct
			if (e.getPass() != null && e.getPass2() != null) {
				if (e.getPass().compareTo(e.getPass2()) != 0) {
					errors.rejectValue("pass2", "error.pass-not-match",
							new Object[] { e.getPass() },
							"Xác nhận mật khẩu chưa đúng");
				}
			}
		}
	}

	/**
	 * @param nhanVienBUS the nhanVienBUS to set
	 */
	public void setNhanVienBUS(NhanVienBUS nhanVienBUS) {
		this.nhanVienBUS = nhanVienBUS;
	}

	/**
	 * @return the nhanVienBUS
	 */
	public NhanVienBUS getNhanVienBUS() {
		return nhanVienBUS;
	}



}
