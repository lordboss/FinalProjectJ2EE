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

import qt.bus.NhanXetDienThoaiBUS;
import qt.dto.NhanXetDienThoai;

/**
 * @author tqthe
 * 
 */
public class SetCommentVisibilityController implements Controller {

	protected final Log logger = LogFactory.getLog(getClass());
	private NhanXetDienThoaiBUS nhanXetDienThoaiBUS;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.info("Handle Ajax request: set product visibility at "
				+ new Date());

		try {
			int cid = Integer.parseInt(request.getParameter("cid"));
			NhanXetDienThoai c = nhanXetDienThoaiBUS.findById(cid);
			if (c != null) {
				c.setHienThi(!c.isHienThi());

				// save changes
				nhanXetDienThoaiBUS.makePersistent(c);
				logger.info("Set comment visibility done!");

				String responseText = "Hiển thị";
				if (c.isHienThi()) {
					responseText = "Không hiển thị";
				}
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(responseText);
				response.getWriter().close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Can not parse cid parameter: " + e.getMessage());
		}

		return null;
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

}
