/**
 * 
 */
package qt.test.dao;

import java.util.List;

import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

import qt.dao.DonHangDAO;
import qt.dto.DonHang;

/**
 * @author tqthe
 * 
 */
@SuppressWarnings("deprecation")
public class DonHangDAOTestCase extends
		AbstractTransactionalDataSourceSpringContextTests {

	private DonHangDAO donHangDAO;

	/**
	 * @param donHangDAO
	 *            the donHangDAO to set
	 */
	public void setDonHangDAO(DonHangDAO donHangDAO) {
		this.donHangDAO = donHangDAO;
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
	
	public void testFindByKhachHang() {
		List<DonHang> ds = donHangDAO.findByKhachHang(1);
		assertEquals(ds.size(), 0);
		setComplete();
	}
	
	public void testFindByHinhThucThanhToan() {
		List<DonHang> ds = donHangDAO.findByHinhThucThanhToan(1);
		assertEquals(ds.size(), 0);
		setComplete();
	}
	
	public void testFindByTrangThai() {
		List<DonHang> ds = donHangDAO.findByTrangThai(1);
		assertEquals(ds.size(), 0);
		setComplete();
	}
	
	public void testFindById() {
		DonHang d = donHangDAO.findById(1);
		assertNull(d);
		setComplete();
	}
	
	public void testFindAll() {
		List<DonHang> ds = donHangDAO.findAll();
		assertEquals(ds.size(), 0);
		setComplete();
	}

}
