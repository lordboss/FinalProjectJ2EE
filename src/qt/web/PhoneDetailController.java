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

import qt.bus.DienThoaiBUS;
import qt.dto.ChiTietTinKhuyenMaiDienThoai;
import qt.dto.DienThoai;

/**
 * @author tqthe
 * 
 */
public class PhoneDetailController implements Controller {

	private Log logger = LogFactory.getLog(getClass());
	private DienThoaiBUS dienThoaiBUS;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.info("Handle phone detail view at " + new Date());

		int id = 0;
		DienThoai p = null;

		try {
			id = Integer.parseInt(request.getParameter("id"));

			// perform search phone by id
			p = dienThoaiBUS.findById(id);

			if (p != null) {
				removeExpiredPromotions(p.getDsChiTietKhuyenMai());
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Invalid id parameter!");
		}

		return new ModelAndView("phoneDetails", "p", p);
	}

	private void removeExpiredPromotions(Set<ChiTietTinKhuyenMaiDienThoai> s) {
		Iterator<ChiTietTinKhuyenMaiDienThoai> iter = s.iterator();

		while (iter.hasNext()) {
			ChiTietTinKhuyenMaiDienThoai c = iter.next();

			if (c.isXoa()
					|| c.getTinKhuyenMai().isXoa()
					|| !c.getTinKhuyenMai().isHienThi()
					|| c.getTinKhuyenMai().getNgayKetThuc().compareTo(
							new Date()) < 0) {
				iter.remove();
			}
		}
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
