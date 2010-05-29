/**
 * 
 */
package qt.test.dao;

import java.util.List;

import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

import qt.dao.DienThoaiDAO;
import qt.dto.DienThoai;

/**
 * @author tqthe
 *
 */
@SuppressWarnings("deprecation")
public class DienThoaiDAOTestCase extends
		AbstractTransactionalDataSourceSpringContextTests {

	private DienThoaiDAO dienThoaiDAO;
	
	public void setDienThoaiDAO(DienThoaiDAO dt) {
		dienThoaiDAO = dt;
	}
	
	@Override
	protected String[] getConfigLocations() {
		return new String[] { "classpath:test-context.xml" };
	}

	@Override
	protected void onSetUpInTransaction() throws Exception {
		// TODO Auto-generated method stub
		super.executeSqlScript("file:db/j2eeTest.sql", true);
		
		System.out.println("Executing mySQL script done!");
	}
	
	public void testFindAll() {
		List<DienThoai> ds  = dienThoaiDAO.findAll();
		assertEquals(ds.size(), 1);
		
		setComplete();
	}

}
