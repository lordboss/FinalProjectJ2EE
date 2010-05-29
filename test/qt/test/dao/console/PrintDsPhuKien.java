/**
 * 
 */
package qt.test.dao.console;

import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import qt.dao.PhuKienDAO;
import qt.dto.ChiTietHinhAnh;
import qt.dto.PhuKien;

/**
 * @author tqthe
 * 
 */
public class PrintDsPhuKien {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"test-context.xml");

		PhuKienDAO tDao = (PhuKienDAO) context.getBean("phuKienDAO");
		List<PhuKien> ds = tDao.findAll();
		printDsPhuKien(ds);

	}

	private static void printDsPhuKien(List<PhuKien> ds) {
		for (PhuKien t : ds) {
			printPhuKien(t);
		}
	}

	private static void printPhuKien(PhuKien t) {
		System.out.println(t.getId() + ": " + t.getTen() + " : "
				+ t.getGiaHienHanh());
		System.out.println("Danh sách hình ảnh:");
		Set<ChiTietHinhAnh> ds = t.getDsHinhAnh();
		for (ChiTietHinhAnh ct : ds) {
			System.out.println("   + " + ct.getHinhAnh());
		}
	}

}
