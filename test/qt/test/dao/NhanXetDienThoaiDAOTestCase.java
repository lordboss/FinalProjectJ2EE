/**
 * 
 */
package qt.test.dao;

import java.util.List;

import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

import qt.dao.NhanXetDienThoaiDAO;
import qt.dto.NhanXetDienThoai;

/**
 * @author tqthe
 * 
 */
@SuppressWarnings("deprecation")
public class NhanXetDienThoaiDAOTestCase extends
		AbstractTransactionalDataSourceSpringContextTests {

	private NhanXetDienThoaiDAO nhanXetDienThoaiDAO;

	public void setNhanXetDienThoaiDAO(NhanXetDienThoaiDAO nhanXetDienThoaiDAO) {
		this.nhanXetDienThoaiDAO = nhanXetDienThoaiDAO;
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
	
	public void testFindByDienThoai() {
		List<NhanXetDienThoai> ds = nhanXetDienThoaiDAO.findByDienThoai(1);
		assertNotNull(ds);
		assertEquals(ds.size(), 0);
	}
	
	public void testFindByKhacHang() {
		List<NhanXetDienThoai> ds = nhanXetDienThoaiDAO.findByKhachHang(1);
		assertNotNull(ds);
		assertEquals(ds.size(), 0);
	}
	
	public void testFindAll() {
		List<NhanXetDienThoai> ds = nhanXetDienThoaiDAO.findAll();
		assertNotNull(ds);
		assertEquals(ds.size(), 0);
	}
	
	public void testFindById() {
		NhanXetDienThoai n = nhanXetDienThoaiDAO.findById(1);
		assertNull(n);
	}
}
