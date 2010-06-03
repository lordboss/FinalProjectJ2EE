/**
 * 
 */
package qt.web;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import qt.bus.DienThoaiBUS;
import qt.dto.DienThoai;

/**
 * @author tqthe
 * 
 */
public class PhoneListController implements Controller {

	private Log logger = LogFactory.getLog(getClass());
	private DienThoaiBUS dienThoaiBUS;

	@SuppressWarnings("unchecked")
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.info("Process PhoneList.html at " + new Date().toString());

		String page = request.getParameter("page");
		PagedListHolder<DienThoai> phoneList = null;

		if (page == null) {
			phoneList = new PagedListHolder<DienThoai>(dienThoaiBUS.findAll());

			phoneList.setPageSize(7);
			phoneList.setMaxLinkedPages(5);

			request.getSession().setAttribute("phoneList", phoneList);
		} else {
			phoneList = (PagedListHolder<DienThoai>) request.getSession()
					.getAttribute("phoneList");
			int maxPage = phoneList.getPageCount();
			
			logger.info("Page value: " + page);

			if (page.equals("next")) {
				phoneList.nextPage();
			} else if (page.equals("prev")) {
				phoneList.previousPage();
			} else if (page.equals("first")) {
				phoneList.setPage(1);
				phoneList.previousPage();
			} else if (page.equals("last")) {
				phoneList.setPage(maxPage - 1);
				phoneList.nextPage();
			} else {
				// specificed page
				try {
					int pageValue = Integer.parseInt(page);

					if (pageValue >= 0 && pageValue < maxPage - 1) {
						phoneList.setPage(pageValue + 1);
						phoneList.previousPage();
					} else if (pageValue == maxPage - 1) {
						phoneList.setPage(pageValue - 1);
						phoneList.nextPage();
					}
				} catch (Exception e) {
					logger.error("Invalid page value! This may be a hack atempt");
					phoneList.setPage(1);
					phoneList.previousPage();
				}
			}
		}
		return new ModelAndView("phoneList", "model", phoneList);
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
