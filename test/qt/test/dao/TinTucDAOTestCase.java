/**
 * 
 */
package qt.test.dao;

import java.util.Date;
import java.util.List;

import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

import qt.dao.LoaiTinTucDAO;
import qt.dao.TinTucDAO;
import qt.dto.LoaiTinTuc;
import qt.dto.TinTuc;

/**
 * @author tqthe
 * 
 */
@SuppressWarnings("deprecation")
public class TinTucDAOTestCase extends
		AbstractTransactionalDataSourceSpringContextTests {

	private LoaiTinTucDAO loaiTinTucDAO;
	private TinTucDAO tinTucDAO;

	public void setLoaiTinTucDAO(LoaiTinTucDAO loaiTinTucDAO) {
		this.loaiTinTucDAO = loaiTinTucDAO;
	}

	public void setTinTucDAO(TinTucDAO tinTucDAO) {
		this.tinTucDAO = tinTucDAO;
	}

	public void testFind() {
		insertData();

		List<TinTuc> ds = tinTucDAO.findAll();
		assertEquals(ds.size(), 10);

		printDsTinTuc(ds);

		System.out.println("Test findById()");
		for (int i = 1; i <= 10; i++) {
			TinTuc t = tinTucDAO.findById(i);
			assertNotNull(t);
		}

		for (int i = 11; i <= 20; i++) {
			TinTuc t = tinTucDAO.findById(i);
			assertNull(t);
		}

		setComplete();
	}

	public void testMakePersistent() {
		LoaiTinTuc p = new LoaiTinTuc("Buoi");
		TinTuc t1 = createTinTuc(100);
		TinTuc t2 = createTinTuc(200);
		t1.setLoaiTinTuc(p);
		t2.setLoaiTinTuc(p);

		LoaiTinTuc p1 = new LoaiTinTuc("Chuoi");
		TinTuc t3 = createTinTuc(300);
		TinTuc t4 = createTinTuc(400);
		t3.setLoaiTinTuc(p1);
		t4.setLoaiTinTuc(p1);

		tinTucDAO.makePersistent(t1);
		tinTucDAO.makePersistent(t2);
		tinTucDAO.makePersistent(t3);
		tinTucDAO.makePersistent(t4);

		List<TinTuc> ds = tinTucDAO.findAll();
		assertEquals(ds.size(), 4);

		setComplete();
	}

	public void testMakeTransient() {
		insertData();

		TinTuc t1 = tinTucDAO.findById(1);
//		t1.getLoaiTinTuc().getDsTinTuc().remove(t1);
//		t1.setLoaiTinTuc(null); // ko comment dong nay thi no xoa day chuyen het
								// => tong so tintuc con lai chi la 5 =.=

		tinTucDAO.makeTransient(t1);

		TinTuc t2 = tinTucDAO.findById(10);
		t2.getLoaiTinTuc().getDsTinTuc().remove(t2);
		t2.setLoaiTinTuc(null);
		
		List<TinTuc> ds = tinTucDAO.findAll();
		assertEquals(ds.size(), 8);
		printDsTinTuc(ds);
		setComplete();
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

	private void insertData() {
		List<LoaiTinTuc> ds = loaiTinTucDAO.findAll();
		for (LoaiTinTuc loaiTinTuc : ds) {
			for (int i = 0; i < 5; i++) {
				TinTuc t = createTinTuc(i + loaiTinTuc.getId() * 5);
				loaiTinTuc.getDsTinTuc().add(t);
				t.setLoaiTinTuc(loaiTinTuc);
			}
			loaiTinTucDAO.makePersistent(loaiTinTuc);
		}
	}

	@SuppressWarnings("unused")
	private void printDsLoaiTinTuc(List<LoaiTinTuc> ds) {
		for (LoaiTinTuc loai : ds) {
			printLoaiTinTuc(loai);
			for (TinTuc t : loai.getDsTinTuc()) {
				printTinTuc(t);
			}
		}
	}

	private void printDsTinTuc(List<TinTuc> ds) {
		for (TinTuc t : ds) {
			printTinTuc(t);
		}
	}

	private void printLoaiTinTuc(LoaiTinTuc loaiTinTuc) {
		System.out.println("Id: " + loaiTinTuc.getId() + ": "
				+ loaiTinTuc.getLoaiTin());
	}

	private void printTinTuc(TinTuc t) {
		System.out.println("+ Id: " + t.getId() + "; Nôi dung: "
				+ t.getNoiDung() + "; Loại tin: "
				+ t.getLoaiTinTuc().getLoaiTin());
	}

	private TinTuc createTinTuc(int i) {
		TinTuc t = new TinTuc();
		t.setHienThi(true);
		t.setXoa(false);
		t.setNoiDung("Day la tin tuc có mã số bằng " + i);
		t.setNgayDang(new Date());

		return t;
	}
}
