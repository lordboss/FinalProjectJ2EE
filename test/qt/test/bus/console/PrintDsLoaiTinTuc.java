/**
 * 
 */
package qt.test.bus.console;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import qt.bus.LoaiTinTucBUS;
import qt.dto.LoaiTinTuc;
import qt.dto.TinTuc;

/**
 * @author tqthe
 * 
 */
public class PrintDsLoaiTinTuc {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"test-context.xml");

		LoaiTinTucBUS lBus = (LoaiTinTucBUS) context.getBean("loaiTinTucBUS");
		List<LoaiTinTuc> ds = lBus.findAll();
		printDsLoaiTinTuc(ds);
	}

	private static void printDsLoaiTinTuc(List<LoaiTinTuc> ds) {
		for (LoaiTinTuc loai : ds) {
			printLoaiTinTuc(loai);
			for (TinTuc t : loai.getDsTinTuc()) {
				printTinTuc(t);
			}
		}
	}

	private static void printLoaiTinTuc(LoaiTinTuc loaiTinTuc) {
		System.out.println("Id: " + loaiTinTuc.getId() + ": "
				+ loaiTinTuc.getLoaiTin());
	}

	private static void printTinTuc(TinTuc t) {
		System.out.println("  + Id: " + t.getId() + "; Nôi dung: "
				+ t.getNoiDung() + "; Loại tin: "
				+ t.getLoaiTinTuc().getLoaiTin());
	}
}
