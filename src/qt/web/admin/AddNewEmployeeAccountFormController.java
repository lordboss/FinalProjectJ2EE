/**
 * 
 */
package qt.web.admin;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import qt.bus.AccountBUS;
import qt.bus.NhanVienBUS;
import qt.dto.Account;
import qt.dto.NhanVien;
import qt.dto.NhanVienBanHang;
import qt.dto.NhanVienQuanLy;
import qt.dto.NhanVienQuanTri;
import qt.util.HashHelper;

/**
 * @author tqthe
 * 
 */
@SuppressWarnings("deprecation")
public class AddNewEmployeeAccountFormController extends SimpleFormController {

	protected Log logger = LogFactory.getLog(getClass());
	private AccountBUS accountBUS;
	private NhanVienBUS nhanVienBUS;

	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		
		logger.info("Handle update company info at " + new Date());

		// make login
		HttpSession session = request.getSession(false);
		boolean valid = true;
		if (session == null) {
			logger.error("Session is null.");
			valid = false;
		} else {
			Object s = session.getAttribute("accountId");
			if (s == null) {
				valid = false;
			} else {
				int aid = (Integer) s;
				Account a = accountBUS.findById(aid);
				if (a == null) {
					valid = false;
				} else {
					if (!a.getClass().equals(NhanVienQuanTri.class)) {
						valid = false;
					}
				}
			}
		}

		if (!valid) {
			logger.error("Not login detected! When update company info");
			return new ModelAndView(new RedirectView("requiredLogin.html"));
		}
		
		Map<String, Object> model = new HashMap<String, Object>();
		
		NhanVien e = (NhanVien) command;
		
		try {
			int eType = Integer.parseInt(request.getParameter("employeeType"));
			
			NhanVien e1 = null;
			
			if (eType == 1) {
				e1 = saveAsNhanVienBanHang(e);
			} else {
				e1 = saveAsNhanVienQuanLy(e);
			}
			
			// persist 
			nhanVienBUS.makePersistent(e1);
			
			logger.info("Persist " + NhanVien.class.getName() + " done!");
			
			model.put("isSuccess", "yes");
			model.put("status", "Tạo tài khoản thành công");
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("Can not persist " + NhanVien.class.getName());
			model.put("isSuccess", "no");
			model.put("status", "Lỗi khi tạo tài khoản");
		}
		
		ModelAndView mv = new ModelAndView(getSuccessView(), "model", model);
		mv.addAllObjects(errors.getModel());
		
		return mv;
	}

	private NhanVienBanHang saveAsNhanVienBanHang(NhanVien base) throws Exception {
		NhanVienBanHang e = new NhanVienBanHang();
		
		e.setCmnd(base.getCmnd());
		e.setDem(base.getDem());
		e.setDiaChi(base.getDiaChi());
		e.setDienThoai(base.getDienThoai());
		e.setEmail(base.getEmail());
		e.setGioiTinh(base.getGioiTinh());
		e.setHo(base.getHo());
		e.setLuong(base.getLuong());
		e.setNgaySinh(base.getNgaySinh());
		e.setTen(base.getTen());
		e.setTrangThai(0); // not active
		e.setUsername(base.getUsername());
		e.setXoa(false); 
		
		e.setPass(HashHelper.getInstance().hash("123"));
		
		return e;
	}
	
	private NhanVienQuanLy saveAsNhanVienQuanLy(NhanVien base) throws Exception {
		NhanVienQuanLy e = new NhanVienQuanLy();
		
		e.setCmnd(base.getCmnd());
		e.setDem(base.getDem());
		e.setDiaChi(base.getDiaChi());
		e.setDienThoai(base.getDienThoai());
		e.setEmail(base.getEmail());
		e.setGioiTinh(base.getGioiTinh());
		e.setHo(base.getHo());
		e.setLuong(base.getLuong());
		e.setNgaySinh(base.getNgaySinh());
		e.setTen(base.getTen());
		e.setTrangThai(0); // not active
		e.setUsername(base.getUsername());
		e.setXoa(false); 
		
		e.setPass(HashHelper.getInstance().hash("123"));
		
		return e;
	}
	
	/**
	 * @param nhanVienBUS the nhanVienBUS to set
	 */
	public void setNhanVienBUS(NhanVienBUS nhanVienBUS) {
		this.nhanVienBUS = nhanVienBUS;
	}

	/**
	 * @return the nhanVienBUS
	 */
	public NhanVienBUS getNhanVienBUS() {
		return nhanVienBUS;
	}

	/**
	 * @param accountBUS the accountBUS to set
	 */
	public void setAccountBUS(AccountBUS accountBUS) {
		this.accountBUS = accountBUS;
	}

	/**
	 * @return the accountBUS
	 */
	public AccountBUS getAccountBUS() {
		return accountBUS;
	}

}
