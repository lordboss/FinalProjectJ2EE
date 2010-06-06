/**
 * 
 */
package qt.web;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import qt.bus.DienThoaiBUS;
import qt.dto.DienThoai;
import qt.dto.FunctionalityCriteria;

/**
 * @author tqthe
 * 
 */
public class SearchByFunctionalityController implements Controller {

	private Log logger = LogFactory.getLog(getClass());
	private DienThoaiBUS dienThoaiBUS;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.info("Handle search by functionality at "
				+ new Date().toString());

		List<DienThoai> result = dienThoaiBUS
				.findByFunctionality(processParameter(request));

		return new ModelAndView("searchByFunctionalityResult", "result", result);
	}

	private FunctionalityCriteria processParameter(HttpServletRequest request) {
		FunctionalityCriteria c = new FunctionalityCriteria();

		String hasCamera = request.getParameter("hasCamera");
		String hasMusicPlayer = request.getParameter("hasMusicPlayer");
		String hasFM = request.getParameter("hasFM");
		String hasMemoryCard = request.getParameter("hasMemoryCard");
		String hasWifi = request.getParameter("hasWifi");
		String has3G = request.getParameter("has3G");
		String hasBluetooth = request.getParameter("hasBluetooth");
		String hasOfficeApp = request.getParameter("hasOfficeApp");
		String hasGPS = request.getParameter("hasGPS");
		String hasTouchscreen = request.getParameter("hasTouchscreen");
		String hasTivi = request.getParameter("hasTivi");
		String hasJavaApp = request.getParameter("hasJavaApp");
		String has2Sim = request.getParameter("has2Sim");

		if (hasCamera != null) {
			c.setHasCamera(hasCamera.equals("on"));
		}
		if (hasMusicPlayer != null) {
			c.setHasMusicPlayer(hasMusicPlayer.equals("on"));
		}
		if (hasFM != null) {
			c.setHasFMRadio(hasFM.equals("on"));
		}
		if (hasMemoryCard != null) {
			c.setHasMemoryCard(hasMemoryCard.equals("on"));
		}
		if (hasWifi != null) {
			c.setHasWifi(hasWifi.equals("on"));
		}
		if (has3G != null) {
			c.setHas3G(has3G.equals("on"));
		}
		if (hasBluetooth != null) {
			c.setHasBluetooth(hasBluetooth.equals("on"));
		}
		if (hasOfficeApp != null) {
			c.setHasOfficeApps(hasOfficeApp.equals("on"));
		}
		if (hasGPS != null) {
			c.setHasGPS(hasGPS.equals("on"));
		}
		if (hasTouchscreen != null) {
			c.setHasTouchScreen(hasTouchscreen.equals("on"));
		}
		if (hasTivi != null) {
			c.setHasTivi(hasTivi.equals("on"));
		}
		if (hasJavaApp != null) {
			c.setHasJavaApps(hasJavaApp.equals("on"));
		}
		if (has2Sim != null) {
			c.setHas2Sim(has2Sim.equals("on"));
		}

		return c;
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
