/**
 * 
 */
package qt.web.user;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import qt.bus.DonHangBUS;
import qt.bus.KhachHangBUS;
import qt.bus.TrangThaiDonHangBUS;
import qt.dto.CartItem;
import qt.dto.ChiTietDonHang;
import qt.dto.DonHang;

/**
 * @author tqthe
 * 
 */
@SuppressWarnings("deprecation")
public class AddBillFormController extends SimpleFormController {

	protected final Log logger = LogFactory.getLog(getClass());
	private DonHangBUS donHangBUS;
	private TrangThaiDonHangBUS trangThaiDonHangBUS;
	private KhachHangBUS khachHangBUS;

	@SuppressWarnings("unchecked")
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {

		DonHang d = (DonHang) command;
		if (d == null) {
			logger.error("Can not get DonHang object");
		}

		// get bill details
		HttpSession session = request.getSession(false);

		if (session == null) {
			return new ModelAndView(new RedirectView("requiredLogin.html"));
		}

		Map<Integer, Object> cart = (Map<Integer, Object>) session
				.getAttribute("cart");

		if (cart == null) {
			return new ModelAndView(new RedirectView("requiredLogin.html"));
		}

		Map<String, Object> model = new HashMap<String, Object>();

		// default: "Chưa duyệt"
		d.setTrangThai(trangThaiDonHangBUS.findById(1));
		// created date is current time
		d.setNgayTao(new Date());
		// set customer
		int aid = (Integer) session.getAttribute("accountId");
		d.setKhachHang(khachHangBUS.findById(aid));
		// set bill details
		d.setDsChiTietDonHang(getBillDetails(cart, d));

		// make persistent
		try {
			donHangBUS.makePersistent(d);

			model.put("success", "1");
			model.put("status", "Thêm thành công đơn hàng");
			logger.info("Persist DonHang object done...");
		} catch (Exception e) {
			e.printStackTrace();
			model.put("success", "0");
			model.put("status", "Lỗi khi tạo đơn hàng!");
			logger.error("Can not persist DonHang!");
		}

		ModelAndView mv = new ModelAndView(getSuccessView(), "model", model);
		mv.addAllObjects(errors.getModel()); // must have this line of code

		return mv;
	}

	@SuppressWarnings("unchecked")
	private Set<ChiTietDonHang> getBillDetails(Map<Integer, Object> cart,
			DonHang d) {
		Set<ChiTietDonHang> details = new HashSet<ChiTietDonHang>();
		Iterator iter = cart.values().iterator();
		while (iter.hasNext()) {
			CartItem cartItem = (CartItem) iter.next();
			ChiTietDonHang detail = new ChiTietDonHang();

			detail.setDonHang(d);
			detail.setSanPham(cartItem.getProduct());
			detail.setSoLuong(cartItem.getQuantity());
			detail.setXoa(false);

			details.add(detail);
		}
		return details;
	}

	/**
	 * @param donHangBUS
	 *            the donHangBUS to set
	 */
	public void setDonHangBUS(DonHangBUS donHangBUS) {
		this.donHangBUS = donHangBUS;
	}

	/**
	 * @return the donHangBUS
	 */
	public DonHangBUS getDonHangBUS() {
		return donHangBUS;
	}

	/**
	 * @param trangThaiDonHangBUS
	 *            the trangThaiDonHangBUS to set
	 */
	public void setTrangThaiDonHangBUS(TrangThaiDonHangBUS trangThaiDonHangBUS) {
		this.trangThaiDonHangBUS = trangThaiDonHangBUS;
	}

	/**
	 * @return the trangThaiDonHangBUS
	 */
	public TrangThaiDonHangBUS getTrangThaiDonHangBUS() {
		return trangThaiDonHangBUS;
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
