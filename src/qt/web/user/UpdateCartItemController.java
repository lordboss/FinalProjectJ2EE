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

import qt.dto.CartItem;

/**
 * @author tqthe
 *
 */
public class UpdateCartItemController implements Controller {

	protected final Log logger = LogFactory.getLog(getClass());
	
	@SuppressWarnings("unchecked")
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.info("Handle update cart item request at " + new Date());

		// get current HttpSession to store a cart item
		HttpSession session = request.getSession(false);

		if (session == null) {
			return new ModelAndView(new RedirectView("home.html"));
		}

		int productId = -1;
		int newQuanity = -1;
		try {
			productId = Integer.parseInt(request.getParameter("id"));
			newQuanity = Integer.parseInt(request.getParameter("quantity"));
			
			if (newQuanity <= 0) {
				logger.error("Invalid item quantity!");
				return new ModelAndView("user/viewCart");
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Can not parse id or quantity parameter! Invalid format!");
			
			// im lặng là vàng
			return new ModelAndView("user/viewCart");
			//return new ModelAndView("user/cartError", "message", "Số lượng cập nhật không hợp lệ");
		}

		// get current cart. If it does not exist, create new one
		Map<Integer, Object> cart = (Map<Integer, Object>) session
				.getAttribute("cart");
		
		if (cart == null) {
			return new ModelAndView("user/cartError", "message", "Không khởi tạo được giỏ hàng");
		}
		
		// check if cart item already existed. Otherwise, create new one
		CartItem item = (CartItem) cart.get(productId);
		
		if (item != null) {
			item.setQuantity(newQuanity);
		} else {
			return new ModelAndView("user/cartError", "message", "Không tìm thấy sản phẩm để cập nhật số lượng");
		}
		
		return new ModelAndView(new RedirectView("viewCart.html"));
	}

}
