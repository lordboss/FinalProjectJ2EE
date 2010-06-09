/**
 * 
 */
package qt.web.user;

import java.util.Date;

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
public class ViewCartController implements Controller {

	protected final Log logger = LogFactory.getLog(getClass());

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.info("Handle view cart request at " + new Date());
		
		return new ModelAndView("user/viewCart");
	}

}
