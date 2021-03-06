/**
 * 
 */
package qt.test.dao.console;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import qt.dao.TrangThaiGopYDAO;
import qt.dto.GopY;
import qt.dto.TrangThaiGopY;

/**
 * @author tqthe
 * 
 */
public class PrintDsTrangThaiGopY {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"test-context.xml");

		TrangThaiGopYDAO trangThaiGopYDAO = (TrangThaiGopYDAO) context
				.getBean("trangThaiGopYDAO");
		System.out.println("BOOM!!!");
		List<TrangThaiGopY> ds = trangThaiGopYDAO.findAll();
		printDsTrangThai(ds);
	}

	private static void printDsTrangThai(List<TrangThaiGopY> ds) {
		for (TrangThaiGopY tt : ds) {
			System.out.println(tt.getId() + ": " + tt.getTrangThai());
			for (GopY g : tt.getDsGopY()) {
				printGopY(g);
			}
		}
	}

	private static void printGopY(GopY g) {
		System.out.println("  + "
				+ g.getId()
				+ ": "
				+ g.getNoiDung()
				+ " của khách hàng "
				+ g.getKhachHang().getHo()
				+ " "
				+ (g.getKhachHang().getDem() != null ? g.getKhachHang()
						.getDem() : "") + " " + g.getKhachHang().getTen());
	}

}
