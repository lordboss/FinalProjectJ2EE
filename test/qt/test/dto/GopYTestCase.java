/**
 * 
 */
package qt.test.dto;

import junit.framework.TestCase;
import qt.dto.GopY;
import qt.dto.TrangThaiGopY;

/**
 * @author tqthe
 *
 */
public class GopYTestCase extends TestCase {
	private GopY gopY;


	@Override
	protected void setUp() throws Exception {
		gopY = new GopY();
	}
	
	public void testGetAndSetNoiDung() {
		String noiDung = "Trang Web quá cùi bắp";
		
		assertNull(gopY.getNoiDung());
		gopY.setNoiDung(noiDung);
		assertEquals(gopY.getNoiDung(), noiDung);
	}
	
	public void testGetAndSetHienThi() {
		boolean hienThi = true; 
		
		assertEquals(gopY.isHienThi(), false);
		
		gopY.setHienThi(hienThi);
		assertEquals(gopY.isHienThi(), hienThi);
	}
	
	public void testGetAndSetXoa() {
		boolean xoa = true;
		
		assertEquals(gopY.isXoa(), false);
		gopY.setXoa(xoa);
		assertEquals(gopY.isXoa(), xoa);
	}
	
	public void testGetAndSetTrangThaiGopY() {
		TrangThaiGopY trangThaiGopY = new TrangThaiGopY();
		
		assertNull(gopY.getTrangThaiGopY());
		
		gopY.setTrangThaiGopY(trangThaiGopY);
		assertEquals(gopY.getTrangThaiGopY(), trangThaiGopY);
	}
	
}
