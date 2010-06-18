/**
 * 
 */
package qt.web.employee.ajax;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import qt.bus.LoaiTinTucBUS;
import qt.bus.TinTucBUS;
import qt.dto.LoaiTinTuc;
import qt.dto.TinTuc;

/**
 * @author tqthe
 * 
 */
public class SetNewsTypeController implements Controller {

	protected final Log logger = LogFactory.getLog(getClass());
	private LoaiTinTucBUS loaiTinTucBUS;
	private TinTucBUS tinTucBUS;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.info("Handle Ajax request: set news type at " + new Date());

		try {
			int id = Integer.parseInt(request.getParameter("id"));
			int newsTypeId = Integer.parseInt(request.getParameter("tid"));

			TinTuc t = tinTucBUS.findById(id);

			if (t != null) {

				LoaiTinTuc lt = loaiTinTucBUS.findById(newsTypeId);
				if (lt != null) {
					t.setLoaiTinTuc(lt);
				}
				
				// save changes
				tinTucBUS.makePersistent(t);
				logger.info("Set news type done!");

				// response to client new suggestion status
				String responseText = t.getLoaiTinTuc().getLoaiTin();

				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(responseText);
				response.getWriter().close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Can not parse id and tid parameter: "
					+ e.getMessage());
		}
		
		return null;
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

}
