/**
 * 
 */
package qt.test.dao.console;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import qt.dao.NhanVienQuanTriDAO;
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

		NhanVienQuanTriDAO nDao = (NhanVienQuanTriDAO) context
				.getBean("nhanVienQuanTriDAO");
		List<NhanVienQuanTri> dsNhanVien = nDao.findAll();
		for (NhanVienQuanTri e : dsNhanVien) {
			printNhanVienQuanTri(e);
		}
	}

	private static void printNhanVienQuanTri(NhanVienQuanTri e) {
		System.out.println(e.getId() + ": " + e.getClass().getName() + ": "
				+ e.getUsername() + ": " + e.isXoa());
	}

}
