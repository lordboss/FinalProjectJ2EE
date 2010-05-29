/**
 * 
 */
package qt.test.bus.console;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import qt.bus.KhachHangBUS;
import qt.dto.KhachHang;

/**
 * @author tqthe
 * 
 */
public class PrintDsKhachHang {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"test-context.xml");

		KhachHangBUS kBus = (KhachHangBUS) context.getBean("khachHangBUS");
		List<KhachHang> dsKhachHang = kBus.findAll();
		for (KhachHang k : dsKhachHang) {
			printKhachHang(k);
		}

		findById(kBus);
	}

	public static void findById(KhachHangBUS kDao) {
		int id1 = 1;
		int id2 = 2;
		
		KhachHang k1 = kDao.findById(id1);
		KhachHang k2 = kDao.findById(id2);
		
		if (k1 != null) {
			printKhachHang(k1);
		}
		if (k2 != null) {
			printKhachHang(k2);
		}
	}
	
	private static void printKhachHang(KhachHang k) {
		System.out.println(k.getId() + ": " + k.getClass().getName()
				+ "; Email: " + k.getEmail() + "; Xoa: " + k.isXoa());
	}

}
