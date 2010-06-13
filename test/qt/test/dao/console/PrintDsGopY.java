/**
 * 
 */
package qt.test.dao.console;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import qt.dao.GopYDAO;
import qt.dto.GopY;

/**
 * @author tqthe
 * 
 */
public class PrintDsGopY {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"test-context.xml");

		GopYDAO gDao = (GopYDAO) context.getBean("gopYDAO");
		List<GopY> ds = gDao.findAll();
		printDsGopY(ds);
		
		System.out.println("==============================");
		ds = gDao.findByAccountId(18);
		printDsGopY(ds);
	}

	private static void printDsGopY(List<GopY> ds) {
		for (GopY g : ds) {
			printGopY(g);
		}
	}
	
	private static void printGopY(GopY g) {
		System.out.println("+ " + g.getId() + ": " + g.getNoiDung()
				+ " thuộc loại: " + g.getTrangThaiGopY().getTrangThai()
				+ " của khách hàng: " + g.getKhachHang().getHo() + " "
				+ g.getKhachHang().getTen() + "; Bị đánh dấu xóa: " + g.isXoa());
	}
}
