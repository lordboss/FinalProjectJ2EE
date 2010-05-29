/**
 * 
 */
package qt.test.dao.console;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import qt.dao.DienThoaiDAO;
import qt.dto.DienThoai;
import qt.dto.FunctionalityCriteria;
import qt.dto.PhoneCriteria;

/**
 * @author tqthe
 * 
 */
public class PrintDsDienThoai {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"test-context.xml");

		DienThoaiDAO tDao = (DienThoaiDAO) context.getBean("dienThoaiDAO");
		List<DienThoai> ds = tDao.findAll();
		printDsDienThoai(ds);

		System.out.println("BOOM!!!");
		// findByFuntionality(tDao);
		advancedSearch(tDao);
	}

	public static void findByFuntionality(DienThoaiDAO tDao) {
		FunctionalityCriteria c = new FunctionalityCriteria();

		// c.setHas2Sim(true);
		// c.setHas3G(true);
		// c.setHasBluetooth(true);
		// c.setHasCamera(true);
		// c.setHasFMRadio(hasFMRadio);
		// c.setHasGPS(true);
		// c.setHasJavaApps(true);
		// c.setHasMemoryCard(true);
		// c.setHasMusicPlayer(true);
		// c.setHasOfficeApps(true);
		// c.setHasTivi(true);
		// c.setHasTouchScreen(true);
		// c.setHasWifi(true);

		List<DienThoai> ds = tDao.findByFunctionality(c);
		printDsDienThoai(ds);
	}

	public static void advancedSearch(DienThoaiDAO tDao) {
		PhoneCriteria c = new PhoneCriteria();

		// c.getMediaCriteria().setHasFMRadio(true);
		// c.getMediaCriteria().setHasGame(true);
		// c.getMediaCriteria().setHasJavaApps(true);
		// c.getMediaCriteria().setHasMusicPlayer(true);
		// c.getMediaCriteria().setHasOfficeApps(true);
		// c.getMediaCriteria().setHasTivi(true);
		// c.getMediaCriteria().setHasVideoPlayer(true);
		// c.getMediaCriteria().setHasVideoRecoder(true);
		// c.getMediaCriteria().setHasVoiceRecoder(true);

		// ConnectivityCriteria cc = c.getConnectivityCriteria();
		// cc.setHas2Sim(true);
		// cc.setHas3G(true);
		// cc.setHasBluetooth(true);
		// cc.setHasGPRS(true);
		// cc.setHasGPS(true);
		// cc.setHasUSB(true);
		// cc.setHasWifi(true);
		
//		c.setHasMemoryCard(true);
//		c.setHasTouchScreen(true);
//		c.setManufactureId(4); // SonyEriccson
//		c.setMinCamera(5.0);
//		c.setMaxCamera(8.0);
//		c.setMinPrice(8000000.0);
//		c.setMaxPrice(10000000.0);
//		c.setMelody(64);
//		c.setName("N900");
//		c.setNetworkId(1); // gsm
//		c.setOsId(3); // android
//		c.setProductStatusId(1); // dang co hang
//		c.setStyleId(4); // nam tinh

		List<DienThoai> ds = tDao.advancedSearch(c);
		printDsDienThoai(ds);
	}

	private static void printDsDienThoai(List<DienThoai> ds) {
		for (DienThoai t : ds) {
			printDienThoai(t);
		}
	}

	private static void printDienThoai(DienThoai t) {
		System.out.println(t.getId() + ": " + t.getTen() + " : "
				+ t.getGiaHienHanh());
		/*
		 * System.out.println("Chi tiết hình ảnh:"); Set<ChiTietHinhAnh>
		 * dsHinhAnh = t.getDsHinhAnh(); for (ChiTietHinhAnh ct : dsHinhAnh) {
		 * System.out.println("   + " + ct.getHinhAnh()); }
		 * 
		 * System.out.println("Tính năng nổi bật:"); Set<TinhNangNoiBat>
		 * dsTinhNang = t.getDsTinhNangNoiBat(); for (TinhNangNoiBat tn :
		 * dsTinhNang) { System.out.println("   + " + tn.getTinhNang()); }
		 */
	}

}
