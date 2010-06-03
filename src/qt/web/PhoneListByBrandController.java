/**
 * 
 */
package qt.web;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import qt.bus.DongSanPhamBUS;
import qt.dto.DongSanPham;

/**
 * Trả về model: Danh sách các DienThoai theo DongSanPham
 * 
 * @author tqthe
 * 
 */
public class PhoneListByBrandController implements Controller {

	private Log logger = LogFactory.getLog(getClass());
	private DongSanPhamBUS dongSanPhamBUS;
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.info("Process xxx.html at " + new Date().toString());
		List<DongSanPham> dsDongSanPham = dongSanPhamBUS.findAll();
		
		return new ModelAndView("phoneListByBrand", "model", dsDongSanPham);
	}

	/**
	 * @param dongSanPhamBUS the dongSanPhamBUS to set
	 */
	public void setDongSanPhamBUS(DongSanPhamBUS dongSanPhamBUS) {
		this.dongSanPhamBUS = dongSanPhamBUS;
	}

	/**
	 * @return the dongSanPhamBUS
	 */
	public DongSanPhamBUS getDongSanPhamBUS() {
		return dongSanPhamBUS;
	}

}
