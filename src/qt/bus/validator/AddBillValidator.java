/**
 * 
 */
package qt.bus.validator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import qt.dto.DonHang;

/**
 * @author tqthe
 * 
 */
public class AddBillValidator implements Validator {

	/**
	 * Logger for this class and subclasses
	 */
	protected final Log logger = LogFactory.getLog(getClass());

	@Override
	public boolean supports(Class<?> clazz) {
		return DonHang.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		logger.info("Begin validate DonHang");
		DonHang d = (DonHang) target;

		if (d == null) {
			errors.rejectValue("*", "nullReference", null,
					"Lỗi khởi tạo đơn hàng");
			logger.error("DonHang is null");
		} else {
			if (d.getNguoiNhan().getHoTen().isEmpty()) {
				errors.rejectValue("nguoiNhan.hoTen", "name-required",
						"Chưa nhập họ tên người nhận");
			}
			if (d.getNguoiNhan().getSoDienThoai().isEmpty()) {
				errors.rejectValue("nguoiNhan.soDienThoai", "phone-required",
						"Chưa nhập số điện thoại người nhận");
			}
			if (d.getDiaChiGiaoHang().isEmpty()) {
				errors.rejectValue("diaChiGiaoHang", "address-required",
						"Chưa nhập địa chỉ giao hàng người nhận");
			}
			if (d.getHinhThucThanhToan().getId() < 0) {
				errors.rejectValue("hinhThucThanhToan.id", "payment-required",
						"Chưa chọn hình thức thanh toán");
			}
		}
	}

}
