/**
 * 
 */
package qt.test.dao;

import java.util.List;

import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

import qt.dao.PhieuNhapPhuKienDAO;
import qt.dto.PhieuNhapPhuKien;

/**
 * @author tqthe
 * 
 */
@SuppressWarnings("deprecation")
public class PhieuNhapPhuKienDAOTestCase extends
		AbstractTransactionalDataSourceSpringContextTests {

	private PhieuNhapPhuKienDAO phieuNhapPhuKienDAO;

	/**
	 * @param phieuNhapPhuKienDAO
	 *            the phieuNhapPhuKienDAO to set
	 */
	public void setPhieuNhapPhuKienDAO(PhieuNhapPhuKienDAO phieuNhapPhuKienDAO) {
		this.phieuNhapPhuKienDAO = phieuNhapPhuKienDAO;
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

	public void testFindByNhanVien() {
		List<PhieuNhapPhuKien> ds = phieuNhapPhuKienDAO.findByNhanVien(1);
		assertEquals(ds.size(), 0);
	}

	public void testFindByNhaCungCap() {
		List<PhieuNhapPhuKien> ds = phieuNhapPhuKienDAO.findByNhaCungCap(1);
		assertEquals(ds.size(), 0);
	}

	public void testFindById() {
		PhieuNhapPhuKien p = phieuNhapPhuKienDAO.findById(1);
		assertNull(p);
	}

	public void testFindAll() {
		List<PhieuNhapPhuKien> ds = phieuNhapPhuKienDAO.findAll();
		assertEquals(ds.size(), 0);
	}

}
