/**
 * 
 */
package qt.test.dao.console;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import qt.dao.TinTucDAO;
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

		TinTucDAO tDao = (TinTucDAO) context.getBean("tinTucDAO");
		List<TinTuc> ds = tDao.findAll();
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
