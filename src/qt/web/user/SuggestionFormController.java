/**
 * 
 */
package qt.web.user;

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

import qt.bus.GopYBUS;
import qt.bus.KhachHangBUS;
import qt.bus.TrangThaiGopYBUS;
import qt.dto.GopY;
import qt.dto.KhachHang;
import qt.dto.TrangThaiGopY;

/**
 * @author tqthe
 * 
 */
@SuppressWarnings("deprecation")
public class SuggestionFormController extends SimpleFormController {

	protected final Log logger = LogFactory.getLog(getClass());
	private GopYBUS gopYBUS;
	private TrangThaiGopYBUS trangThaiGopYBUS;
	private KhachHangBUS khachHangBUS;

	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {

		logger.info("Handle add new suggestion at " + new Date());

		Map<String, Object> model = new HashMap<String, Object>();

		try {
			GopY g = (GopY) command;

			g.setId(null);
			g.setNgayTao(new Date());
			g.setHienThi(true);
			g.setXoa(false);
			
			// default status is unread (id = 1)
			TrangThaiGopY tt = trangThaiGopYBUS.findById(1);
			g.setTrangThaiGopY(tt);
			//tt.getDsGopY().add(g);
			
			// (required login) to get user id
			int aid = (Integer) request.getSession().getAttribute("accountId");
			KhachHang kh = khachHangBUS.findById(aid);
			g.setKhachHang(kh);
			//kh.getDsGopY().add(g);
			
			// add new suggestion
			gopYBUS.makePersistent(g);
			
			logger.info("Add new suggestion done!");
			model.put("isSuccess", "yes");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Can not persist GopY");
			model.put("isSuccess", "no");
		}

		ModelAndView mv = new ModelAndView(getSuccessView(), "model", model);
		mv.addAllObjects(errors.getModel());

		return mv;
	}

	/**
	 * @param gopYBUS
	 *            the gopYBUS to set
	 */
	public void setGopYBUS(GopYBUS gopYBUS) {
		this.gopYBUS = gopYBUS;
	}

	/**
	 * @return the gopYBUS
	 */
	public GopYBUS getGopYBUS() {
		return gopYBUS;
	}

	/**
	 * @param trangThaiGopYBUS
	 *            the trangThaiGopYBUS to set
	 */
	public void setTrangThaiGopYBUS(TrangThaiGopYBUS trangThaiGopYBUS) {
		this.trangThaiGopYBUS = trangThaiGopYBUS;
	}

	/**
	 * @return the trangThaiGopYBUS
	 */
	public TrangThaiGopYBUS getTrangThaiGopYBUS() {
		return trangThaiGopYBUS;
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
