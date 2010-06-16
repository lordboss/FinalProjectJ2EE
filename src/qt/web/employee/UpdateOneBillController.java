/**
 * 
 */
package qt.web.employee;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * @author tqthe
 *
 */
public class UpdateOneBillController implements Controller {

	protected final Log logger = LogFactory.getLog(getClass());
	
	@SuppressWarnings("unchecked")
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		logger.info("Handle update one bill at " + new Date());
		
		Map<String, Object> model = (Map<String, Object>) request.getAttribute("model");
		
		return new ModelAndView("employee/updateOneBill", "model", model);
	}

}
