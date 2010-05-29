/**
 * 
 */
package qt.test.dao;

import java.util.List;

import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

import qt.dao.TrangThaiGopYDAO;
import qt.dto.GopY;
import qt.dto.KhachHang;
import qt.dto.TrangThaiGopY;

/**
 * @author tqthe
 * 
 */
@SuppressWarnings("deprecation")
public class TrangThaiGopYDAOTestCase extends
		AbstractTransactionalDataSourceSpringContextTests {

	private TrangThaiGopYDAO trangThaiGopYDAO;

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
		System.out.println("Done executing script!");
	}

	public void testFindAll() {
		List<TrangThaiGopY> ds = trangThaiGopYDAO.findAll();
		assertEquals(ds.size(), 3);
		printDsTrangThai(ds);

		setComplete();
	}

	public void testFindById() {
		TrangThaiGopY tt = new TrangThaiGopY("Danh sách đen");
		KhachHang kh = createKhachHang();

		GopY g1 = createGopY(tt, kh, 1);
		GopY g2 = createGopY(tt, kh, 2);
		GopY g3 = createGopY(tt, kh, 3);
		tt.getDsGopY().add(g1);
		tt.getDsGopY().add(g2);
		tt.getDsGopY().add(g3);

		trangThaiGopYDAO.makePersistent(tt);

		TrangThaiGopY kq = trangThaiGopYDAO.findById(4);
		assertNotNull(kq);
		assertEquals(kq.getDsGopY().size(), 3);

		setComplete();
	}

	public void testMakePersistent() {

		TrangThaiGopY tt = new TrangThaiGopY("Danh sách đen");
		KhachHang kh = createKhachHang();

		GopY g1 = createGopY(tt, kh, 1);
		GopY g2 = createGopY(tt, kh, 2);
		GopY g3 = createGopY(tt, kh, 3);
		tt.getDsGopY().add(g1);
		tt.getDsGopY().add(g2);
		tt.getDsGopY().add(g3);
		trangThaiGopYDAO.makePersistent(tt);

		// insert another one
		tt = new TrangThaiGopY();
		tt.setTrangThai("Danh sách đỏ");
		kh = createKhachHang();

		GopY g4 = createGopY(tt, kh, 4);
		GopY g5 = createGopY(tt, kh, 5);
		GopY g6 = createGopY(tt, kh, 6);
		tt.getDsGopY().add(g4);
		tt.getDsGopY().add(g5);
		tt.getDsGopY().add(g6);
		trangThaiGopYDAO.makePersistent(tt);

		for (int i = 0; i < 3; i++) {
			tt = trangThaiGopYDAO.findById(i + 1);
			assertNotNull(tt);
			for (int j = 0; j < 10; j++) {
				GopY g = createGopY(tt, kh, j + i * 10);
				tt.getDsGopY().add(g);
			}
			trangThaiGopYDAO.makePersistent(tt);
		}

		List<TrangThaiGopY> ds = trangThaiGopYDAO.findAll();
		assertEquals(ds.size(), 5);
		printDsTrangThai(ds);

		setComplete();
	}

	public void testFindByTrangThaiGopY() {
		TrangThaiGopY tt = new TrangThaiGopY();
		tt.setTrangThai("Danh sách đen");
		KhachHang kh = createKhachHang();

		GopY g1 = createGopY(tt, kh, 1);
		GopY g2 = createGopY(tt, kh, 2);
		GopY g3 = createGopY(tt, kh, 3);
		tt.getDsGopY().add(g1);
		tt.getDsGopY().add(g2);
		tt.getDsGopY().add(g3);
		trangThaiGopYDAO.makePersistent(tt);

		// insert another one
		tt = new TrangThaiGopY();
		tt.setTrangThai("Danh sách đỏ");
		kh = createKhachHang();

		GopY g4 = createGopY(tt, kh, 4);
		GopY g5 = createGopY(tt, kh, 5);
		GopY g6 = createGopY(tt, kh, 6);
		tt.getDsGopY().add(g4);
		tt.getDsGopY().add(g5);
		tt.getDsGopY().add(g6);
		trangThaiGopYDAO.makePersistent(tt);

		for (int i = 0; i < 3; i++) {
			tt = trangThaiGopYDAO.findById(i + 1);
			assertNotNull(tt);
			for (int j = 0; j < 10; j++) {
				GopY g = createGopY(tt, kh, j + 7 + i * 10);

				// khi update phai associate nhu vay =.=
				tt.getDsGopY().add(g);
			}
			trangThaiGopYDAO.makePersistent(tt);
		}

		List<GopY> ds = trangThaiGopYDAO.findByTrangThaiGopY(4);
		assertEquals(ds.size(), 3);

		setComplete();
	}

	public void testMakeTransient() throws Exception {
		TrangThaiGopY tt = new TrangThaiGopY();
		tt.setTrangThai("Danh sách đen");
		KhachHang kh = createKhachHang();

		GopY g1 = createGopY(tt, kh, 1);
		GopY g2 = createGopY(tt, kh, 2);
		GopY g3 = createGopY(tt, kh, 3);
		tt.getDsGopY().add(g1);
		tt.getDsGopY().add(g2);
		tt.getDsGopY().add(g3);
		trangThaiGopYDAO.makePersistent(tt);

		// insert another one
		tt = new TrangThaiGopY();
		tt.setTrangThai("Danh sách đỏ");
		kh = createKhachHang();

		GopY g4 = createGopY(tt, kh, 4);
		GopY g5 = createGopY(tt, kh, 5);
		GopY g6 = createGopY(tt, kh, 6);
		tt.getDsGopY().add(g4);
		tt.getDsGopY().add(g5);
		tt.getDsGopY().add(g6);
		trangThaiGopYDAO.makePersistent(tt);

		for (int i = 0; i < 3; i++) {
			tt = trangThaiGopYDAO.findById(i + 1);
			assertNotNull(tt);
			for (int j = 0; j < 10; j++) {
				GopY g = createGopY(tt, kh, j + 7 + i * 10);

				// khi update phai associate nhu vay =.=
				tt.getDsGopY().add(g);
			}
			trangThaiGopYDAO.makePersistent(tt);
		}

		TrangThaiGopY t = trangThaiGopYDAO.findById(4);
		trangThaiGopYDAO.makeTransient(t, true);

		System.out.println(" ======= Test delete: ");
		List<TrangThaiGopY> ds = trangThaiGopYDAO.findAll();
		assertEquals(ds.size(), 4);
		printDsTrangThai(ds);

		setComplete();
	}

	private void printDsTrangThai(List<TrangThaiGopY> ds) {
		for (TrangThaiGopY tt : ds) {
			System.out.println(tt.getId() + ": " + tt.getTrangThai());
			for (GopY g : tt.getDsGopY()) {
				printGopY(g);
			}
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

	private KhachHang createKhachHang() {
		KhachHang kh = new KhachHang();

		kh.setHo("Tran");
		kh.setTen("The");
		kh.setEmail("tran.q.the@gmail.com");
		kh.setPass("xxxx");
		kh.setTrangThai(1);
		kh.setUsername("tqthe");

		return kh;
	}
}
