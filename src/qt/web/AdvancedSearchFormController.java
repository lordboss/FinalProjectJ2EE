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
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import qt.bus.DienThoaiBUS;
import qt.dto.DienThoai;
import qt.dto.PhoneCriteria;

/**
 * @author tqthe
 * 
 */
@SuppressWarnings("deprecation")
public class AdvancedSearchFormController extends SimpleFormController {

	protected final Log logger = LogFactory.getLog(getClass());
	private DienThoaiBUS dienThoaiBUS;

	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {

		// get the command
		PhoneCriteria pc = (PhoneCriteria) command;
		if (pc == null) {
			logger.error("Can not get command object!");
		}
		logger.info("Handle advanced search at " + new Date());

		// get camera range
		try {
			int range = Integer.parseInt(request.getParameter("cameraRange"));
			if (pc != null) {
				pc.setCameraRange(range);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Invalid camera range parameter!");
		}

		// perform advanced search
		List<DienThoai> result = dienThoaiBUS.advancedSearch(pc);

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("result", result);

		ModelAndView mv = new ModelAndView(getSuccessView(), "model", model);
		mv.addAllObjects(errors.getModel()); // must have this line of code

		return mv;
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

}
