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

import qt.bus.LoaiPhuKienBUS;
import qt.dto.LoaiPhuKien;

/**
 * Trả về Model: Danh sách các LoaiPhuKien. Mỗi LoaiPhuKien có danh sách các
 * PhuKien.
 * 
 * @author tqthe
 * 
 */
public class AccessoryListController implements Controller {

	private Log logger = LogFactory.getLog(getClass());
	private LoaiPhuKienBUS loaiPhuKienBUS;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.info("Get all accessories at " + new Date().toString());
		List<LoaiPhuKien> dsLoaiPhuKien = loaiPhuKienBUS.findAll();

		return new ModelAndView("accessoryList", "model", dsLoaiPhuKien);
	}

	/**
	 * @param loaiPhuKienBUS the loaiPhuKienBUS to set
	 */
	public void setLoaiPhuKienBUS(LoaiPhuKienBUS loaiPhuKienBUS) {
		this.loaiPhuKienBUS = loaiPhuKienBUS;
	}

	/**
	 * @return the loaiPhuKienBUS
	 */
	public LoaiPhuKienBUS getLoaiPhuKienBUS() {
		return loaiPhuKienBUS;
	}

}
