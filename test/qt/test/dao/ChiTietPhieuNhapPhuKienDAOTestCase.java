/**
 * 
 */
package qt.test.dao;

import java.util.List;

import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

import qt.dao.ChiTietPhieuNhapPhuKienDAO;
import qt.dto.ChiTietPhieuNhapPhuKien;

/**
 * @author tqthe
 * 
 */
@SuppressWarnings("deprecation")
public class ChiTietPhieuNhapPhuKienDAOTestCase extends
		AbstractTransactionalDataSourceSpringContextTests {

	private ChiTietPhieuNhapPhuKienDAO chiTietPhieuNhapPhuKienDAO;

	/**
	 * @param chiTietPhieuNhapPhuKienDAO
	 *            the chiTietPhieuNhapPhuKienDAO to set
	 */
	public void setChiTietPhieuNhapPhuKienDAO(
			ChiTietPhieuNhapPhuKienDAO chiTietPhieuNhapPhuKienDAO) {
		this.chiTietPhieuNhapPhuKienDAO = chiTietPhieuNhapPhuKienDAO;
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

	public void testFindByPhuKien() {
		List<ChiTietPhieuNhapPhuKien> ds = chiTietPhieuNhapPhuKienDAO
				.findByPhuKien(1);
		assertEquals(ds.size(), 0);
	}

	public void testFindByPhieuNhapPhuKien() {
		List<ChiTietPhieuNhapPhuKien> ds = chiTietPhieuNhapPhuKienDAO
				.findByPhieuNhapPhuKien(1);
		assertEquals(ds.size(), 0);
	}

	public void testFindById() {
		ChiTietPhieuNhapPhuKien t = chiTietPhieuNhapPhuKienDAO.findById(1);
		assertNull(t);
	}

	public void testFindAll() {
		List<ChiTietPhieuNhapPhuKien> ds = chiTietPhieuNhapPhuKienDAO.findAll();
		assertEquals(ds.size(), 0);
	}

}
