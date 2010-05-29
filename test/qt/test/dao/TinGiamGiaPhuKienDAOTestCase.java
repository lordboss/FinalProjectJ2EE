/**
 * 
 */
package qt.test.dao;

import java.util.List;

import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

import qt.dao.TinGiamGiaPhuKienDAO;
import qt.dto.TinGiamGiaPhuKien;

/**
 * @author tqthe
 *
 */
@SuppressWarnings("deprecation")
public class TinGiamGiaPhuKienDAOTestCase extends
		AbstractTransactionalDataSourceSpringContextTests {

	private TinGiamGiaPhuKienDAO tinGiamGiaPhuKienDAO;
	
	public void setTinGiamGiaPhuKien(TinGiamGiaPhuKienDAO tinGiamGiaPhuKienDAO) {
		this.tinGiamGiaPhuKienDAO = tinGiamGiaPhuKienDAO;
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
		List<TinGiamGiaPhuKien> ds = tinGiamGiaPhuKienDAO.findAll();
		assertNotNull(ds);
		assertEquals(ds.size(), 0);
	}
	
	public void testFindByPhuKien() {
		List<TinGiamGiaPhuKien> ds = tinGiamGiaPhuKienDAO.findByPhuKien(1);
		assertNotNull(ds);
		assertEquals(ds.size(), 0);
	}
	
	public void testFindById() {
		TinGiamGiaPhuKien t = tinGiamGiaPhuKienDAO.findById(1);
		assertNull(t);
	}
	
}
