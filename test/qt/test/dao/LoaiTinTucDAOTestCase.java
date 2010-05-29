/**
 * 
 */
package qt.test.dao;

import java.util.Date;
import java.util.List;

import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

import qt.dao.LoaiTinTucDAO;
import qt.dto.LoaiTinTuc;
import qt.dto.TinTuc;

/**
 * @author tqthe
 * 
 */
@SuppressWarnings("deprecation")
public class LoaiTinTucDAOTestCase extends
		AbstractTransactionalDataSourceSpringContextTests {

	private LoaiTinTucDAO loaiTinTucDAO;

	public void setLoaiGopYDAO(LoaiTinTucDAO loaiTinTucDAO) {
		this.loaiTinTucDAO = loaiTinTucDAO;
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

	public void testMakeTransient() throws Exception {
		insertData(); // total 3

		LoaiTinTuc loaiTinTuc = loaiTinTucDAO.findById(1);
		loaiTinTucDAO.makeTransient(loaiTinTuc, true);

		List<LoaiTinTuc> ds = loaiTinTucDAO.findAll();
		assertEquals(ds.size(), 2);
		printDsLoaiTinTuc(ds);

		loaiTinTuc = loaiTinTucDAO.findById(2);
		loaiTinTucDAO.makeTransient(loaiTinTuc, true);

		ds = loaiTinTucDAO.findAll();
		assertEquals(ds.size(), 1);
		printDsLoaiTinTuc(ds);

		setComplete();
	}

	public void testFindAll() {
		insertData();
		List<LoaiTinTuc> ds = loaiTinTucDAO.findAll();
		assertEquals(ds.size(), 3);
		printDsLoaiTinTuc(ds);

		setComplete();
	}

	public void testFindById() {
		insertData();
		System.out.println("Test FindById:");
		
		List<LoaiTinTuc> ds = loaiTinTucDAO.findAll();
		assertEquals(ds.size(), 3);
		
		LoaiTinTuc loaiTinTuc = loaiTinTucDAO.findById(1);
		assertNotNull(loaiTinTuc);

		loaiTinTuc = loaiTinTucDAO.findById(2);
		assertNotNull(loaiTinTuc);

		loaiTinTuc = loaiTinTucDAO.findById(3);
		assertNotNull(loaiTinTuc);

		setComplete();
	}

	public void testMakePersistent() {
		insertData();

		LoaiTinTuc loaiTinTuc = new LoaiTinTuc("Buoi");
		TinTuc t = createTinTuc(100);
		// associate
		loaiTinTuc.getDsTinTuc().add(t);
		t.setLoaiTinTuc(loaiTinTuc);

		loaiTinTucDAO.makePersistent(loaiTinTuc);

		assertNotNull(loaiTinTuc);
		assertEquals(loaiTinTuc.getDsTinTuc().size(), 1);

		List<LoaiTinTuc> ds = loaiTinTucDAO.findAll();
		assertEquals(ds.size(), 4);
		printDsLoaiTinTuc(ds);

		setComplete();
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
	

	private void printDsLoaiTinTuc(List<LoaiTinTuc> ds) {
		for (LoaiTinTuc loai : ds) {
			printLoaiTinTuc(loai);
			for (TinTuc t : loai.getDsTinTuc()) {
				printTinTuc(t);
			}
		}
	}

	private void printLoaiTinTuc(LoaiTinTuc loaiTinTuc) {
		System.out.println("Id: " + loaiTinTuc.getId() + ": "
				+ loaiTinTuc.getLoaiTin());
	}

	private void printTinTuc(TinTuc t) {
		System.out.println("  + Id: " + t.getId() + "; Nôi dung: "
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
