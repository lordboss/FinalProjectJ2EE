/**
 * 
 */
package qt.web;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import qt.bus.DienThoaiBUS;
import qt.bus.KhachHangBUS;
import qt.bus.NhanXetDienThoaiBUS;
import qt.dto.DienThoai;
import qt.dto.KhachHang;
import qt.dto.NhanXetDienThoai;

/**
 * @author tqthe
 * 
 */
@SuppressWarnings("deprecation")
public class AddCommentFormController extends SimpleFormController {

	protected final Log logger = LogFactory.getLog(getClass());
	private NhanXetDienThoaiBUS nhanXetDienThoaiBUS;
	private KhachHangBUS khachHangBUS;
	private DienThoaiBUS dienThoaiBUS;

	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {

		logger.info("Handle add comment request at " + new Date());

		Map<String, Object> model = new HashMap<String, Object>();

		ModelAndView mv = new ModelAndView(getSuccessView(), "model", model);
		mv.addAllObjects(errors.getModel());

		// get form object
		NhanXetDienThoai c = (NhanXetDienThoai) command;

		if (c == null) {
			logger.error("Can not get NhanXetDienThoai command object!");
			model.put("status", "Lỗi khi thêm nhận xét");
		} else {
			// save changes
			try {
				HttpSession session = request.getSession();
				
				// set KhachHang if available
				String uidString = (String) session.getAttribute("accountId");
				if (uidString != null) {
					int uid = Integer.parseInt(uidString);
					KhachHang user = khachHangBUS.findById(uid);
					c.setKhachHang(user);
					
					logger.info("addComment: isLogin: yes");
				} else {
					logger.error("addComment: anonymous");
				}
				
				int pid = Integer.parseInt(request.getParameter("pid"));
				DienThoai phone = dienThoaiBUS.findById(pid);
				if (phone != null) {
					c.setDienThoai(phone);
				}
				
				c.setThoiGian(new Date());
				c.setHienThi(true);
				c.setXoa(false);
				
				nhanXetDienThoaiBUS.makePersistent(c);
				logger.info("Persist " + c.getClass().getName() + " done!");
				model.put("status", "Thêm nhận xét thành công");
				model.put("isSuccess", "yes");
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("Can not persist " + c.getClass().getName());
				model.put("isSuccess", "no");
			}
		}

		return mv;
	}

	/**
	 * @param nhanXetDienThoaiBUS
	 *            the nhanXetDienThoaiBUS to set
	 */
	public void setNhanXetDienThoaiBUS(NhanXetDienThoaiBUS nhanXetDienThoaiBUS) {
		this.nhanXetDienThoaiBUS = nhanXetDienThoaiBUS;
	}

	/**
	 * @return the nhanXetDienThoaiBUS
	 */
	public NhanXetDienThoaiBUS getNhanXetDienThoaiBUS() {
		return nhanXetDienThoaiBUS;
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

	/**
	 * @param dienThoaiBUS
	 *            the dienThoaiBUS to set
	 */
	public void setDienThoaiBUS(DienThoaiBUS dienThoaiBUS) {
		this.dienThoaiBUS = dienThoaiBUS;
	}

	/**
	 * @return the dienThoaiBUS
	 */
	public DienThoaiBUS getDienThoaiBUS() {
		return dienThoaiBUS;
	}

}
