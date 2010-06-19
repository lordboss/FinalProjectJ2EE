/**
 * 
 */
package qt.web.employee;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import qt.bus.NhanXetDienThoaiBUS;
import qt.dto.NhanXetDienThoai;

/**
 * @author tqthe
 *
 */
public class ViewCommentByUserController implements Controller {

	protected Log logger = LogFactory.getLog(getClass());
	private NhanXetDienThoaiBUS nhanXetDienThoaiBUS; 
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		logger.info("Handle view comment by user at " + new Date());
		
		int uid = -1;
		List<NhanXetDienThoai> result = null;
		
		try {
			String uidString = request.getParameter("uid");
			if (uidString != null) {
				uid = Integer.parseInt(uidString);
			}
			result = nhanXetDienThoaiBUS.findByKhachHang(uid);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Handle view comment by user: " + e.getMessage());
		}
		
		return new ModelAndView("employee/viewCommentByUser", "model", result);
	}

	/**
	 * @param nhanXetDienThoaiBUS the nhanXetDienThoaiBUS to set
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

}
