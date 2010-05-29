/**
 * 
 */
package qt.test.dao;

import java.util.List;

import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

import qt.dao.ChiTietDonHangDAO;
import qt.dto.ChiTietDonHang;

/**
 * @author tqthe
 * 
 */
@SuppressWarnings("deprecation")
public class ChiTietDonHangDAOTestCase extends
		AbstractTransactionalDataSourceSpringContextTests {

	private ChiTietDonHangDAO chiTietDonHangDAO;

	/**
	 * @param chiTietDonHangDAO
	 *            the chiTietDonHangDAO to set
	 */
	public void setChiTietDonHangDAO(ChiTietDonHangDAO chiTietDonHangDAO) {
		this.chiTietDonHangDAO = chiTietDonHangDAO;
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

	public void testFindByDonHang() {
		List<ChiTietDonHang> ds = chiTietDonHangDAO.findByDonHang(1);
		assertEquals(ds.size(), 0);
	}

	public void testFindBySanPham() {
		List<ChiTietDonHang> ds = chiTietDonHangDAO.findBySanPham(1);
		assertEquals(ds.size(), 0);
	}

	public void testFindById() {
		ChiTietDonHang c = chiTietDonHangDAO.findById(1);
		assertNull(c);
	}

	public void testFindAll() {
		List<ChiTietDonHang> ds = chiTietDonHangDAO.findAll();
		assertEquals(ds.size(), 0);
	}

}
