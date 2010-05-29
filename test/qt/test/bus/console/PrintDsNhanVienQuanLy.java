/**
 * 
 */
package qt.test.bus.console;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import qt.bus.NhanVienQuanLyBUS;
import qt.dto.NhanVienQuanLy;

/**
 * @author tqthe
 * 
 */
public class PrintDsNhanVienQuanLy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"test-context.xml");

		NhanVienQuanLyBUS nBUS = (NhanVienQuanLyBUS) context
				.getBean("nhanVienQuanLyBUS");
		List<NhanVienQuanLy> dsNhanVien = nBUS.findAll();
		for (NhanVienQuanLy e : dsNhanVien) {
			printNhanVienQuanLy(e);
		}
	}

	private static void printNhanVienQuanLy(NhanVienQuanLy e) {
		System.out.println(e.getId() + ": " + e.getClass().getName() + ": "
				+ e.getUsername() + ": " + e.isXoa());
	}

}
