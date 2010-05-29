/**
 * 
 */
package qt.test.dao.console;

import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import qt.dao.DonHangDAO;
import qt.dto.ChiTietDonHang;
import qt.dto.DonHang;

/**
 * @author tqthe
 * 
 */
public class PrintDsDonHang {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"test-context.xml");

		DonHangDAO dDao = (DonHangDAO) context.getBean("donHangDAO");
		List<DonHang> ds = dDao.findAll();
		printDsDonHang(ds);

		double[] dailyStatistic = dDao.dailyStatistic(5, 2010);
		for (double d : dailyStatistic) {
			System.out.print(d + " ");
		}

		System.out.println("\nBOOOM!!!");
		double[] monthlyStatistic = dDao.monthlyStatistic(2010);
		for (double d : monthlyStatistic) {
			System.out.print(d + " ");
		}

		System.out.println("\nBOOOM BOOOM!!!");
		double rangeStatistic = dDao.rangeStatistic(1, 1, 2010, 31, 12, 2010);
		System.out.println(rangeStatistic);

	}

	private static void printDsDonHang(List<DonHang> ds) {
		for (DonHang d : ds) {
			printDonHang(d);
		}
	}

	private static void printDonHang(DonHang d) {
		System.out.println(d.getId() + ": " + d.getNgayTao());
		Set<ChiTietDonHang> ds = d.getDsChiTietDonHang();
		for (ChiTietDonHang c : ds) {
			printChiTietDonHang(c);
		}
	}

	private static void printChiTietDonHang(ChiTietDonHang c) {
		System.out.println("   + " + c.getSanPham().getTen() + ": "
				+ c.getSoLuong() + " : " + c.getSanPham().getGiaHienHanh());
	}

}
