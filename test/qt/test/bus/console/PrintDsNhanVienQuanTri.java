/**
 * 
 */
package qt.test.bus.console;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import qt.bus.NhanVienQuanTriBUS;
import qt.dto.NhanVienQuanTri;

/**
 * @author tqthe
 *
 */
public class PrintDsNhanVienQuanTri {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"test-context.xml");

		NhanVienQuanTriBUS nBUS = (NhanVienQuanTriBUS) context
				.getBean("nhanVienQuanTriBUS");
		List<NhanVienQuanTri> dsNhanVien = nBUS.findAll();
		for (NhanVienQuanTri e : dsNhanVien) {
			printNhanVienQuanTri(e);
		}
	}

	private static void printNhanVienQuanTri(NhanVienQuanTri e) {
		System.out.println(e.getId() + ": " + e.getClass().getName() + ": "
				+ e.getUsername() + ": " + e.isXoa());
	}

}
