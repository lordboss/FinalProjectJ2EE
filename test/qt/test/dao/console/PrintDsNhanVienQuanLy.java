/**
 * 
 */
package qt.test.dao.console;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import qt.dao.NhanVienQuanLyDAO;
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

		NhanVienQuanLyDAO nDao = (NhanVienQuanLyDAO) context
				.getBean("nhanVienQuanLyDAO");
		List<NhanVienQuanLy> dsNhanVien = nDao.findAll();
		for (NhanVienQuanLy e : dsNhanVien) {
			printNhanVienQuanLy(e);
		}
	}

	private static void printNhanVienQuanLy(NhanVienQuanLy e) {
		System.out.println(e.getId() + ": " + e.getClass().getName() + ": "
				+ e.getUsername() + ": " + e.isXoa());
	}

}
