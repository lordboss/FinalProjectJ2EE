/**
 * 
 */
package qt.web;

import java.util.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.view.RedirectView;

/**
 * @author tqthe
 *
 */
public class LogoutController implements Controller {

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		logger.info("Handle logout request at " + new Date());
		
		HttpSession session = request.getSession(true);

		/*
		session.removeAttribute("userType");
		session.removeAttribute("accountId");
		session.removeAttribute("username");
		session.removeAttribute("isSuccess");
		session.removeAttribute("cart");
		*/
		Enumeration<String> e = session.getAttributeNames();
		while (e.hasMoreElements()) {
			session.removeAttribute((String) e.nextElement());
		}
		
		return new ModelAndView(new RedirectView("home.html"));
	}

}
