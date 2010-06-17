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

import qt.bus.SanPhamBUS;
import qt.dto.SanPham;

/**
 * @author tqthe
 *
 */
public class SetVisibilityProductController implements Controller {

	protected final Log logger = LogFactory.getLog(getClass());
	private SanPhamBUS sanPhamBUS; 
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		logger.info("Handle Ajax request: set product visibility at " + new Date());
		
		try {
			int pid = Integer.parseInt(request.getParameter("pid"));
			SanPham p = sanPhamBUS.findById(pid);
			if (p != null) {
				p.setHienThi(!p.isHienThi());
				
				// save changes
				sanPhamBUS.makePersistent(p);
				logger.info("Set visibility done!");
				
				String responseText = "Hiển thị";
				if (p.isHienThi()) {
					responseText = "Ẩn";
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
	 * @param sanPhamBUS the sanPhamBUS to set
	 */
	public void setSanPhamBUS(SanPhamBUS sanPhamBUS) {
		this.sanPhamBUS = sanPhamBUS;
	}

	/**
	 * @return the sanPhamBUS
	 */
	public SanPhamBUS getSanPhamBUS() {
		return sanPhamBUS;
	}

}
