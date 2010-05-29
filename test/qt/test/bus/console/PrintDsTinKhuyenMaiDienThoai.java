/**
 * 
 */
package qt.test.bus.console;

import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import qt.bus.TinKhuyenMaiDienThoaiBUS;
import qt.dto.ChiTietTinKhuyenMaiDienThoai;
import qt.dto.TinKhuyenMaiDienThoai;

/**
 * @author tqthe
 * 
 */
public class PrintDsTinKhuyenMaiDienThoai {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"test-context.xml");

		TinKhuyenMaiDienThoaiBUS tBUS = (TinKhuyenMaiDienThoaiBUS) context
				.getBean("tinKhuyenMaiDienThoaiBUS");
		List<TinKhuyenMaiDienThoai> ds = tBUS.findAll();
		printDs(ds);
		/*
		 * TinKhuyenMaiDienThoai t = tBUS.findById(1); if (t != null) {
		 * tBUS.markAsDeleted(t); }
		 * 
		 * System.out.println("After marking as deleted"); ds = tBUS.findAll();
		 * printDs(ds);
		 */
	}

	public static void printDs(List<TinKhuyenMaiDienThoai> ds) {
		for (TinKhuyenMaiDienThoai t : ds) {
			printTinKhuyenMai(t);
		}
	}

	private static void printTinKhuyenMai(TinKhuyenMaiDienThoai t) {
		System.out.println(t.getId() + ": " + t.getNoiDung());
		System.out.println("Chi tiết:");
		Set<ChiTietTinKhuyenMaiDienThoai> ds = t
				.getDsChiTietTinKhuyenMaiDienThoai();
		for (ChiTietTinKhuyenMaiDienThoai ct : ds) {
			if (ct.isXoa() == false) {
				System.out.println("    + " + ct.getDienThoai().getTen()
						+ " giảm " + ct.getMucGiam());
			}
		}
	}

}
