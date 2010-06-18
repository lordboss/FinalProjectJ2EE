/**
 * 
 */
package qt.web.employee;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import qt.bus.LoaiTinTucBUS;
import qt.bus.TinTucBUS;
import qt.dto.TinTuc;

/**
 * @author tqthe
 * 
 */
@SuppressWarnings("deprecation")
public class UpdateNewsFormController extends SimpleFormController {

	protected final Log logger = LogFactory.getLog(getClass());
	private TinTucBUS tinTucBUS;
	private LoaiTinTucBUS loaiTinTucBUS;

	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {

		logger.info("Handle update news request at " + new Date());

		// get form object
		TinTuc t = (TinTuc) command;

		if (t == null) {
			logger.error("Can not get KhachHang command object!");
			return new ModelAndView("employee/newsError", "message",
					"Lỗi trong quá trình cập nhật tin tức!");
		}

		// save changes
		try {
			tinTucBUS.makePersistent(t);
			logger.info("Persist " + t.getClass().getName() + " done!");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Can not persist " + t.getClass().getName());
		}

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("status", "Cập nhật thành công");

		ModelAndView mv = new ModelAndView(getSuccessView(), "model", model);
		mv.addAllObjects(errors.getModel());

		return mv;
	}

	@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		int nid = Integer.parseInt(request.getParameter("nid"));
		TinTuc t = tinTucBUS.findById(nid);
		return t;
	}

	/**
	 * @param tinTucBUS
	 *            the tinTucBUS to set
	 */
	public void setTinTucBUS(TinTucBUS tinTucBUS) {
		this.tinTucBUS = tinTucBUS;
	}

	/**
	 * @return the tinTucBUS
	 */
	public TinTucBUS getTinTucBUS() {
		return tinTucBUS;
	}

	/**
	 * @param loaiTinTucBUS
	 *            the loaiTinTucBUS to set
	 */
	public void setLoaiTinTucBUS(LoaiTinTucBUS loaiTinTucBUS) {
		this.loaiTinTucBUS = loaiTinTucBUS;
	}

	/**
	 * @return the loaiTinTucBUS
	 */
	public LoaiTinTucBUS getLoaiTinTucBUS() {
		return loaiTinTucBUS;
	}

}
