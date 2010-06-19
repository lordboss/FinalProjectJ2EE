/**
 * 
 */
package qt.web.employee;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.view.RedirectView;

import qt.bus.TinTucBUS;
import qt.dto.TinTuc;

/**
 * @author tqthe
 *
 */
public class ViewNewsController implements Controller {

	protected final Log logger = LogFactory.getLog(getClass());
	private TinTucBUS tinTucBUS; 
	
	@SuppressWarnings("unchecked")
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		logger.info("Handle view news list at " + new Date());

		// get current HttpSession to store a cart item
		HttpSession session = request.getSession(false);

		if (session == null) {
			logger.error("Current session is null. Login is required!");
			return new ModelAndView(new RedirectView("requiredLogin.html"));
		}

		if (session.getAttribute("accountId") == null) {
			logger.error("Login is required!");
			return new ModelAndView(new RedirectView("requiredLogin.html"));
		}
		
		String page = request.getParameter("page");
		PagedListHolder<TinTuc> model = null; 
		
		if (page == null) {
			// get all suggestions
			List<TinTuc> result = tinTucBUS.findAll();
			// store in page list holder
			model = new PagedListHolder<TinTuc>(result);

			model.setPageSize(5); // 5 items per page
			model.setMaxLinkedPages(10); // 10 links in navigation

			// associate to current session
			session.setAttribute("newsList", model);
		} else {
			model = (PagedListHolder<TinTuc>) session
					.getAttribute("newsList");

			int maxPage = model.getPageCount();

			logger.info("Page value: " + page);

			if (page.equals("next")) {
				model.nextPage();
			} else if (page.equals("prev")) {
				model.previousPage();
			} else if (page.equals("first")) {
				model.setPage(1);
				model.previousPage();
			} else if (page.equals("last")) {
				model.setPage(maxPage - 1);
				model.nextPage();
			} else {
				// specificed page
				try {
					int pageValue = Integer.parseInt(page);

					if (pageValue >= 0 && pageValue < maxPage - 1) {
						model.setPage(pageValue + 1);
						model.previousPage();
					} else if (pageValue == maxPage - 1) {
						model.setPage(pageValue - 1);
						model.nextPage();
					}
				} catch (Exception e) {
					logger
							.error("Invalid page value! This may be a hack atempt");
					model.setPage(1);
					model.previousPage();
				}
			}
		}
		
		return new ModelAndView("employee/manageNews", "model", model);
	}

	/**
	 * @param tinTucBUS the tinTucBUS to set
	 */
	public void setTinTucBUS(TinTucBUS tinTucBUS) {
		this.tinTucBUS = tinTucBUS;
	}

	/**
	 * @return the tinTucBUS
	 */
	public TinTucBUS getTinTucBUS() {
		return tinTucBUS;
	}

}
