/**
 * 
 */
package qt.web.user;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.view.RedirectView;

import qt.bus.SanPhamBUS;
import qt.dto.CartItem;
import qt.dto.SanPham;

/**
 * @author tqthe
 * 
 */
public class AddToCartController implements Controller {

	protected final Log logger = LogFactory.getLog(getClass());
	private SanPhamBUS sanPhamBUS;

	@SuppressWarnings("unchecked")
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.info("Handle add to cart request at " + new Date());

		// get current HttpSession to store a cart item
		HttpSession session = request.getSession(false);

		if (session == null) {
			return new ModelAndView(new RedirectView("home.html"));
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
			cart = new HashMap<Integer, Object>();
			session.setAttribute("cart", cart);
		}

		// find the product to add to cart
		SanPham p = sanPhamBUS.findById(productId);
		
		if (p == null) {
			return new ModelAndView("user/cartError", "message", "Không tìm thấy sản phẩm để thêm vào giỏ hàng");
		}
		
		// check if cart item already existed. Otherwise, create new one
		CartItem item = (CartItem) cart.get(p.getId());
		
		if (item != null) {
			item.setQuantity(item.getQuantity() + 1);
		} else {
			item = new CartItem(p, 1);
			cart.put(p.getId(), item);
		}
		
		return new ModelAndView(new RedirectView("viewCart.html"));
	}

	/**
	 * @param sanPhamBUS
	 *            the sanPhamBUS to set
	 */
	public void setSanPhamBUS(SanPhamBUS sanPhamBUS) {
		this.sanPhamBUS = sanPhamBUS;
	}

	/**
	 * @return the sanPhamBUS
	 */
	public SanPhamBUS getSanPhamBUS() {
		return sanPhamBUS;
	}

}
