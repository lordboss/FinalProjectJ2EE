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
import qt.bus.HangDienThoaiBUS;
import qt.dto.DienThoai;
import qt.dto.HangDienThoai;

/**
 * @author tqthe
 * 
 */
public class QuickSearchController implements Controller {

	protected final Log logger = LogFactory.getLog(getClass());
	private DienThoaiBUS dienThoaiBUS;
	private HangDienThoaiBUS hangDienThoaiBUS;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.info("\n\nPerform quick search at " + new Date().toString()
				+ "\n\n");

		String phoneName = request.getParameter("ten");
		int manufactureId = Integer.parseInt(request
				.getParameter("hangDienThoai"));
		double minPrice = Double.parseDouble(request.getParameter("giaTu"));
		double maxPrice = Double.parseDouble(request.getParameter("giaDen"));

		logger.error(phoneName);
		logger.error(minPrice);
		logger.error(maxPrice);
		logger.error(manufactureId);
		
		List<DienThoai> result = dienThoaiBUS.quickSearch(manufactureId,
				phoneName, minPrice, maxPrice);
		List<HangDienThoai> dsHangDienThoai = hangDienThoaiBUS.findAll();

		logger.error("Quick Search: Result size " + result.size());
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("kq", result);
		model.put("dsHangDienThoai", dsHangDienThoai);

		return new ModelAndView("quickSearchResult", "model", model);
	}

	/**
	 * @param dienThoaiBUS
	 *            the dienThoaiBUS to set
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
	 * @param hangDienThoaiBUS
	 *            the hangDienThoaiBUS to set
	 */
	public void setHangDienThoaiBUS(HangDienThoaiBUS hangDienThoaiBUS) {
		this.hangDienThoaiBUS = hangDienThoaiBUS;
	}

	/**
	 * @return the hangDienThoaiBUS
	 */
	public HangDienThoaiBUS getHangDienThoaiBUS() {
		return hangDienThoaiBUS;
	}

}
