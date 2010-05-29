/**
 * 
 */
package qt.test.bus.console;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import qt.bus.TinTucBUS;
import qt.dto.TinTuc;

/**
 * @author tqthe
 * 
 */
public class PrintDsTinTuc {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"test-context.xml");

		TinTucBUS tBUS = (TinTucBUS) context.getBean("tinTucBUS");
		List<TinTuc> ds = tBUS.findAll();
		printDsTinTuc(ds);
	}

	private static void printDsTinTuc(List<TinTuc> ds) {
		for (TinTuc t : ds) {
			printTinTuc(t);
		}
	}

	private static void printTinTuc(TinTuc t) {
		System.out.println("+ Id: " + t.getId() + "; Nôi dung: "
				+ t.getNoiDung() + "; Loại tin: "
				+ t.getLoaiTinTuc().getLoaiTin());
	}
}
