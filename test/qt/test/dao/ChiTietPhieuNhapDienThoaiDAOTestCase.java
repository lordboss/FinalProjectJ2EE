/**
 * 
 */
package qt.test.dao;

import java.util.List;

import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

import qt.dao.ChiTietPhieuNhapDienThoaiDAO;
import qt.dto.ChiTietPhieuNhapDienThoai;

/**
 * @author tqthe
 * 
 */
@SuppressWarnings("deprecation")
public class ChiTietPhieuNhapDienThoaiDAOTestCase extends
		AbstractTransactionalDataSourceSpringContextTests {

	private ChiTietPhieuNhapDienThoaiDAO chiTietPhieuNhapDienThoaiDAO;

	/**
	 * @param chiTietPhieuNhapDienThoaiDAO
	 *            the chiTietPhieuNhapDienThoaiDAO to set
	 */
	public void setChiTietPhieuNhapDienThoaiDAO(
			ChiTietPhieuNhapDienThoaiDAO chiTietPhieuNhapDienThoaiDAO) {
		this.chiTietPhieuNhapDienThoaiDAO = chiTietPhieuNhapDienThoaiDAO;
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

	public void testFindByPhieuNhapDienThoai() {
		List<ChiTietPhieuNhapDienThoai> ds = chiTietPhieuNhapDienThoaiDAO
				.findByPhieuNhapDienThoai(1);

		assertEquals(ds.size(), 0);
	}

	public void testFindByDienThoai() {
		List<ChiTietPhieuNhapDienThoai> ds = chiTietPhieuNhapDienThoaiDAO
				.findByDienThoai(1);

		assertEquals(ds.size(), 0);
	}

	public void testFindById() {
		ChiTietPhieuNhapDienThoai t = chiTietPhieuNhapDienThoaiDAO.findById(1);
		assertNull(t);
	}

	public void testFindAll() {
		List<ChiTietPhieuNhapDienThoai> ds = chiTietPhieuNhapDienThoaiDAO
				.findAll();
		assertEquals(ds.size(), 0);
	}
}
