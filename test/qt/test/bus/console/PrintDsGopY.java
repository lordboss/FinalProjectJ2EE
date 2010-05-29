/**
 * 
 */
package qt.test.bus.console;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import qt.bus.GopYBUS;
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

		GopYBUS gBus = (GopYBUS) context.getBean("gopYBUS");
		List<GopY> ds = gBus.findAll();
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
