/**
 * 
 */
package qt.test.dao.console;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import qt.dao.TrangThaiDonHangDAO;
import qt.dto.TrangThaiDonHang;

/**
 * @author tqthe
 *
 */
public class PrintDsTrangThaiDonHang {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
		"test-context.xml");
		
		TrangThaiDonHangDAO tDao = (TrangThaiDonHangDAO) context.getBean("trangThaiDonHangDAO");
		TrangThaiDonHang t = tDao.findById(1);
		System.out.println(t.toString());
	}

}
