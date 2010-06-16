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

import qt.bus.DonHangBUS;
import qt.dto.DonHang;

/**
 * @author tqthe
 *
 */
public class ViewBillWithPagingController implements Controller {

	protected final Log logger = LogFactory.getLog(getClass());
	private DonHangBUS donHangBUS;

	@SuppressWarnings("unchecked")
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.info("Handle view all bills request at " + new Date());

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
		PagedListHolder<DonHang> model = null;
		
		if (page == null) {
			// get all bills
			List<DonHang> bills = donHangBUS.findAll();
			// and store in page list holder
			model = new PagedListHolder<DonHang>(bills);
			
			model.setPageSize(5); // 5 items per page
			model.setMaxLinkedPages(10); // 10 links in navigation
			
			// associate to current session
			request.getSession().setAttribute("billList", model);
		} else {
			model = (PagedListHolder<DonHang>) request.getSession().getAttribute("billList");
			
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
					logger.error("Invalid page value! This may be a hack atempt");
					model.setPage(1);
					model.previousPage();
				}
			}
		}
		
		return new ModelAndView("employee/viewBillWithPaging", "model", model);
	}

	/**
	 * @param donHangBUS
	 *            the donHangBUS to set
	 */
	public void setDonHangBUS(DonHangBUS donHangBUS) {
		this.donHangBUS = donHangBUS;
	}

	/**
	 * @return the donHangBUS
	 */
	public DonHangBUS getDonHangBUS() {
		return donHangBUS;
	}


}
