/**
 * 
 */
package qt.test.dao;

import java.util.List;

import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

import qt.dao.ChiTietTinKhuyenMaiDienThoaiDAO;
import qt.dto.ChiTietTinKhuyenMaiDienThoai;

/**
 * @author tqthe
 * 
 */
@SuppressWarnings("deprecation")
public class ChiTietTinKhuyenMaiDienThoaiDAOTestCase extends
		AbstractTransactionalDataSourceSpringContextTests {

	private ChiTietTinKhuyenMaiDienThoaiDAO chiTietTinKhuyenMaiDienThoaiDAO;

	/**
	 * @param chiTietTinKhuyenMaiDienThoaiDAO
	 *            the chiTietTinKhuyenMaiDienThoaiDAO to set
	 */
	public void setChiTietTinKhuyenMaiDienThoaiDAO(
			ChiTietTinKhuyenMaiDienThoaiDAO chiTietTinKhuyenMaiDienThoaiDAO) {
		this.chiTietTinKhuyenMaiDienThoaiDAO = chiTietTinKhuyenMaiDienThoaiDAO;
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

	public void testFindByTinKhuyenMai() {
		List<ChiTietTinKhuyenMaiDienThoai> ds = chiTietTinKhuyenMaiDienThoaiDAO
				.findByTinKhuyenMai(1);
		assertEquals(ds.size(), 1);
	}

	public void testFindByDienThoai() {
		List<ChiTietTinKhuyenMaiDienThoai> ds = chiTietTinKhuyenMaiDienThoaiDAO
				.findByDienThoai(1);
		assertEquals(ds.size(), 1);
	}

	public void testFindById() {
		ChiTietTinKhuyenMaiDienThoai c = chiTietTinKhuyenMaiDienThoaiDAO
				.findById(1);
		assertNotNull(c);
	}

	public void testFindAll() {
		List<ChiTietTinKhuyenMaiDienThoai> ds = chiTietTinKhuyenMaiDienThoaiDAO
				.findAll();
		assertEquals(ds.size(), 1);
	}
}
