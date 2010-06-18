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

import qt.bus.TinTucBUS;
import qt.dto.TinTuc;

/**
 * @author tqthe
 *
 */
public class SetVisibilityNewsController implements Controller {

	protected final Log logger = LogFactory.getLog(getClass());
	private TinTucBUS tinTucBUS;
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.info("Handle Ajax request: set news visibility at " + new Date());
		
		try {
			int nid = Integer.parseInt(request.getParameter("nid"));
			TinTuc t = tinTucBUS.findById(nid);
			if (t != null) {
				t.setHienThi(!t.isHienThi());
				
				// save changes
				tinTucBUS.makePersistent(t);
				logger.info("Set news visibility done!");
				
				String responseText = "Hiển thị";
				if (t.isHienThi()) {
					responseText = "Không hiển thị";
				}
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(responseText);
				response.getWriter().close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Can not parse pid parameter: " + e.getMessage());
		}
		return null;
	}

	/**
	 * @param tinTucBUS the tinTucBUS to set
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
