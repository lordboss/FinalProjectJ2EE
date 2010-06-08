/**
 * 
 */
package qt.web;

import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import qt.bus.PhuKienBUS;
import qt.dto.PhuKien;
import qt.dto.TinGiamGiaPhuKien;

/**
 * @author tqthe
 * 
 */
public class AccessoryDetailController implements Controller {

	private Log logger = LogFactory.getLog(getClass());
	private PhuKienBUS phuKienBUS;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.info("Handle accessory detail at " + new Date());

		int id = 0;
		PhuKien a = null;

		try {
			id = Integer.parseInt(request.getParameter("id"));

			// perform searching by accessory id
			a = phuKienBUS.findById(id);

			if (a != null) {
				removeExpiredPromotions(a.getDsTinGiamGiaPhuKien());
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Invalid accessory id!");
		}

		return new ModelAndView("accessoryDetails", "a", a);
	}

	private void removeExpiredPromotions(Set<TinGiamGiaPhuKien> s) {
		Iterator<TinGiamGiaPhuKien> iter = s.iterator();

		while (iter.hasNext()) {
			TinGiamGiaPhuKien t = iter.next();
			
			if (!t.isHienThi() || t.isXoa()
					|| t.getNgayKetThuc().compareTo(new Date()) < 0) {
				iter.remove();
			}
		}
	}

	/**
	 * @param phuKienBUS
	 *            the phuKienBUS to set
	 */
	public void setPhuKienBUS(PhuKienBUS phuKienBUS) {
		this.phuKienBUS = phuKienBUS;
	}

	/**
	 * @return the phuKienBUS
	 */
	public PhuKienBUS getPhuKienBUS() {
		return phuKienBUS;
	}

}
