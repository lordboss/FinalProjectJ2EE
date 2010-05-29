/**
 * 
 */
package qt.test.dao;

import java.util.List;

import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

import qt.dao.GopYDAO;
import qt.dao.TrangThaiGopYDAO;
import qt.dto.GopY;
import qt.dto.KhachHang;
import qt.dto.TrangThaiGopY;

/**
 * @author tqthe
 * 
 */
@SuppressWarnings("deprecation")
public class GopYDAOTestCase extends
		AbstractTransactionalDataSourceSpringContextTests {

	private GopYDAO gopYDAO;
	private TrangThaiGopYDAO trangThaiGopYDAO;

	public void setGopYDAO(GopYDAO g) {
		gopYDAO = g;
	}

	public void setTrangThaiGopYDAO(TrangThaiGopYDAO trangThaiGopYDAO) {
		this.trangThaiGopYDAO = trangThaiGopYDAO;
	}

	@Override
	protected String[] getConfigLocations() {
		return new String[] { "classpath:test-context.xml" };
	}

	@Override
	protected void onSetUpInTransaction() throws Exception {
		super.executeSqlScript("file:db/j2eeTest.sql", true);
		super.executeSqlScript("file:db/data.sql", true);
		System.out.println("Done executing script!");
	}

	public void testFindAll() {
		insertData();

		List<GopY> ds = gopYDAO.findAll();
		assertNotNull(ds);
		assertEquals(ds.size(), 15);
		printDsGopY(ds);

		// test cho nay lai dung =.=
		GopY g = gopYDAO.findById(2);
		assertNotNull(g);
		assertEquals(g.getId().intValue(), 2);
		System.out.println("Buoi:");
		printGopY(g);

		setComplete();
	}

	public void testFindDsGopYTheoTrangThai() {
		insertData();

		List<GopY> ds = gopYDAO.findByTrangThai(2);
		assertNotNull(ds);
		assertEquals(ds.size(), 5);

		printDsGopY(ds);

		setComplete();
	}

	public void testFindById() {
		insertData();

		GopY g = gopYDAO.findById(2);
		assertNotNull(g);
		assertEquals(g.getId().intValue(), 2);
		printGopY(g);

		setComplete();
	}

	public void testPersist() {
		System.out.println("Begin testPersist");
		insertData();

		TrangThaiGopY tt = new TrangThaiGopY("Buoi");
		KhachHang kh = createKhachHang("Nguyen", "Thong");
		GopY g = createGopY(tt, kh, 100);

		gopYDAO.makePersistent(g);
		gopYDAO.markAsDeleted(g);

		List<GopY> ds = trangThaiGopYDAO.findByTrangThaiGopY(4);
		assertNotNull(ds);
		assertEquals(ds.size(), 1);

		for (int i = 1; i <= 5; i++) {
			g = gopYDAO.findById(i);
			// da lam may cai nay trong DAO
//			g.getKhachHang().getDsGopY().remove(g);
//			g.getTrangThaiGopY().getDsGopY().remove(g);
//			g.setKhachHang(null);
//			g.setTrangThaiGopY(null);

			gopYDAO.makeTransient(g);
		}

		System.out.println("End testPersist");

		setComplete();

	}

	private void insertData() {
		TrangThaiGopY tt;
		KhachHang kh = createKhachHang("Bui", "Buoi");
		for (int i = 0; i < 3; i++) {
			tt = trangThaiGopYDAO.findById(i + 1);
			for (int j = 0; j < 5; j++) {
				GopY g = createGopY(tt, kh, j + i * 5);
				tt.getDsGopY().add(g);
			}
			trangThaiGopYDAO.makePersistent(tt);
		}
	}

	private void printDsGopY(List<GopY> ds) {
		for (GopY g : ds) {
			printGopY(g);
		}
	}

	private void printGopY(GopY g) {
		System.out.println("  + " + g.getId() + ": " + g.getNoiDung());
	}

	private GopY createGopY(TrangThaiGopY tt, KhachHang kh, int i) {
		GopY g = new GopY();
		g.setNoiDung("Day la gop y " + i);
		g.setHienThi(true);
		g.setXoa(false);
		g.setTrangThaiGopY(tt);
		g.setKhachHang(kh);
		return g;
	}

	private KhachHang createKhachHang(String ho, String ten) {
		KhachHang kh = new KhachHang();

		kh.setHo(ho);
		kh.setTen(ten);
		kh.setEmail(ho.toLowerCase() + "." + ten.toLowerCase() + "@gmail.com");
		kh.setPass("xxxx");
		kh.setTrangThai(1);
		kh.setUsername(ho.substring(0, 1).toLowerCase() + ten.toLowerCase());

		return kh;
	}
}
