/**
 * 
 */
package qt.web.user;

import java.util.Date;
import java.util.Map;

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
public class RemoveFromCartController implements Controller {

	protected final Log logger = LogFactory.getLog(getClass());
	
	@SuppressWarnings("unchecked")
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.info("Handle remove cart item request at " + new Date());

		// get current HttpSession to store a cart item
		HttpSession session = request.getSession(false);

		if (session == null) {
			return new ModelAndView(new RedirectView("requiredLogin.html"));
		}

		int productId = -1;

		try {
			productId = Integer.parseInt(request.getParameter("id"));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Can not parse id parameter! Invalid format!");
		}

		// get current cart. If it does not exist, create new one
		Map<Integer, Object> cart = (Map<Integer, Object>) session
				.getAttribute("cart");
		
		if (cart == null) {
			return new ModelAndView("user/cartError", "message", "Không khởi tạo được giỏ hàng");
		}

		// remove cart item
		cart.remove(productId);

		return new ModelAndView(new RedirectView("viewCart.html"));
	}

}
