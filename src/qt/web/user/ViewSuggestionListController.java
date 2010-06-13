/**
 * 
 */
package qt.web.user;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import qt.bus.GopYBUS;
import qt.dto.GopY;

/**
 * @author tqthe
 *
 */
public class ViewSuggestionListController implements Controller {

	protected final Log logger = LogFactory.getLog(getClass());
	private GopYBUS gopYBUS;
	
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		logger.info("Handle view suggestion list at " + new Date());
		
		// get account id (associate with this session) 
		int aid = (Integer)request.getSession().getAttribute("accountId");
		List<GopY> result = gopYBUS.findByAccountId(aid);
		
		return new ModelAndView("user/suggestionList", "model", result);
	}


	/**
	 * @param gopYBUS the gopYBUS to set
	 */
	public void setGopYBUS(GopYBUS gopYBUS) {
		this.gopYBUS = gopYBUS;
	}


	/**
	 * @return the gopYBUS
	 */
	public GopYBUS getGopYBUS() {
		return gopYBUS;
	}

}
