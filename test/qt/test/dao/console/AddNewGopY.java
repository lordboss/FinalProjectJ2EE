/**
 * 
 */
package qt.test.dao.console;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import qt.dao.GopYDAO;
import qt.dao.KhachHangDAO;
import qt.dao.TrangThaiGopYDAO;
import qt.dto.GopY;
import qt.dto.KhachHang;
import qt.dto.TrangThaiGopY;

/**
 * @author tqthe
 *
 */
public class AddNewGopY {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
		"test-context.xml");

		GopYDAO gDao = (GopYDAO) context.getBean("gopYDAO");
		TrangThaiGopYDAO ttDao = (TrangThaiGopYDAO) context.getBean("trangThaiGopYDAO");
		KhachHangDAO khDao = (KhachHangDAO) context.getBean("khachHangDAO");
		
		GopY g = new GopY();
		
		g.setNgayTao(new Date());
		g.setHienThi(true);
		g.setXoa(false);
		g.setTieuDe("Tieu De: " + new Date());
		g.setNoiDung("Noi Dung: " + new Date());
		
		TrangThaiGopY tt = ttDao.findById(1);
		g.setTrangThaiGopY(tt);
		tt.getDsGopY().add(g);
		KhachHang kh = khDao.findById(18);
		g.setKhachHang(kh);
		kh.getDsGopY().add(g);

		gDao.makePersistent(g);
		System.out.println("Done");
		
		//gDao.makeTransient(g);
		//System.out.println("Make transient done");
	}

}
