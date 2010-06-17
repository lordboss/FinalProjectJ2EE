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

import qt.bus.GopYBUS;
import qt.bus.TrangThaiGopYBUS;
import qt.dto.GopY;
import qt.dto.TrangThaiGopY;

/**
 * @author tqthe
 * 
 */
public class SetSuggestionStatusController implements Controller {

	protected final Log logger = LogFactory.getLog(getClass());
	private GopYBUS gopYBUS;
	private TrangThaiGopYBUS trangThaiGopYBUS;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.info("Handle Ajax request: set suggestion status at "
				+ new Date());

		try {
			int id = Integer.parseInt(request.getParameter("id"));
			int newStatusId = Integer.parseInt(request.getParameter("sid"));

			GopY g = gopYBUS.findById(id);

			if (g != null) {

				TrangThaiGopY t = trangThaiGopYBUS.findById(newStatusId);
				if (t != null) {
					g.setTrangThaiGopY(t);
				}
				
				// save changes
				gopYBUS.makePersistent(g);
				logger.info("Set suggestion status done!");

				// response to client new suggestion status
				String responseText = g.getTrangThaiGopY().getTrangThai();

				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(responseText);
				response.getWriter().close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Can not parse id and sid parameter: "
					+ e.getMessage());
		}

		return null;
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

}
