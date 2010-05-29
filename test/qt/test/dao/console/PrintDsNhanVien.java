/**
 * 
 */
package qt.test.dao.console;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import qt.dao.NhanVienDAO;
import qt.dto.NhanVien;

/**
 * @author tqthe
 * 
 */
public class PrintDsNhanVien {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"test-context.xml");

		NhanVienDAO nDao = (NhanVienDAO) context.getBean("nhanVienDAO");
		List<NhanVien> dsNhanVien = nDao.findAll();
		for (NhanVien e : dsNhanVien) {
			printNhanVien(e);
		}
	}

	private static void printNhanVien(NhanVien e) {
		System.out.println(e.getId() + ": " + e.getClass().getName() + ": "
				+ e.getUsername() + ": " + e.isXoa());
		System.out.println("   + DsPhieuNhapDienThoai: "
				+ e.getDsPhieuNhapDienThoai().size());
		System.out.println("   + DsPhieuNhapPhuKien: "
				+ e.getDsPhieuNhapPhuKien().size());
	}
}
