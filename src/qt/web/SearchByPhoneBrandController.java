/**
 * 
 */
package qt.web;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import qt.bus.DienThoaiBUS;
import qt.bus.DongSanPhamBUS;
import qt.dto.DienThoai;
import qt.dto.DongSanPham;

/**
 * @author tqthe
 *
 */
public class SearchByPhoneBrandController implements Controller {

	private Log logger = LogFactory.getLog(getClass());
	private DienThoaiBUS dienThoaiBUS;
	private DongSanPhamBUS dongSanPhamBUS;
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		logger.info("Handle search by phone brand at " + new Date());
		
		int id = 1; 
		String name = "Cao cấp";
		
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Can not parse id parameter!");
		}
		
		List<DienThoai> result = dienThoaiBUS.findByDongSanPham(id);
		DongSanPham b = dongSanPhamBUS.findById(id);
		if (b != null) {
			name = b.getTen();
		}
		
		Map<String, Object> model = new HashMap<String, Object>(); 
		model.put("result", result); 
		model.put("name", name);
		
		return new ModelAndView("searchByPhoneBrandResult", "model", model);
	}

	/**
	 * @param dienThoaiBUS the dienThoaiBUS to set
	 */
	public void setDienThoaiBUS(DienThoaiBUS dienThoaiBUS) {
		this.dienThoaiBUS = dienThoaiBUS;
	}

	/**
	 * @return the dienThoaiBUS
	 */
	public DienThoaiBUS getDienThoaiBUS() {
		return dienThoaiBUS;
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
