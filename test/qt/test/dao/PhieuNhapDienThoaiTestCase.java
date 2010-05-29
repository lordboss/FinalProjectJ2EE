/**
 * 
 */
package qt.test.dao;

import java.util.List;

import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

import qt.dao.PhieuNhapDienThoaiDAO;
import qt.dto.PhieuNhapDienThoai;

/**
 * @author tqthe
 * 
 */
@SuppressWarnings("deprecation")
public class PhieuNhapDienThoaiTestCase extends
		AbstractTransactionalDataSourceSpringContextTests {

	private PhieuNhapDienThoaiDAO phieuNhapDienThoaiDAO;

	/**
	 * @param phieuNhapDienThoaiDAO
	 *            the phieuNhapDienThoaiDAO to set
	 */
	public void setPhieuNhapDienThoaiDAO(
			PhieuNhapDienThoaiDAO phieuNhapDienThoaiDAO) {
		this.phieuNhapDienThoaiDAO = phieuNhapDienThoaiDAO;
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
		List<PhieuNhapDienThoai> ds = phieuNhapDienThoaiDAO.findAll();
		assertEquals(ds.size(), 0);
	}
	
	public void testFindById() {
		PhieuNhapDienThoai p = phieuNhapDienThoaiDAO.findById(1);
		assertNull(p);
	}
	
	public void testFindByNhaCungCap() {
		List<PhieuNhapDienThoai> ds = phieuNhapDienThoaiDAO.findByNhapCungCap(1);
		assertEquals(ds.size(), 0);
	}
	
	public void testFindByNhanVien() {
		List<PhieuNhapDienThoai> ds = phieuNhapDienThoaiDAO.findByNhanVien(1);
		assertEquals(ds.size(), 0);
	}
}
