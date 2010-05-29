/**
 * 
 */
package qt.test.dto;

import java.util.HashSet;
import java.util.Set;

import qt.dto.GopY;
import qt.dto.TrangThaiGopY;
import junit.framework.TestCase;

/**
 * @author tqthe
 * 
 */
public class TrangThaiGopYTestCase extends TestCase {

	private TrangThaiGopY trangThaiGopY;

	@Override
	protected void setUp() throws Exception {
		trangThaiGopY = new TrangThaiGopY();
	}

	public void testGetAndSetTrangThai() {
		String trangThai = "Chưa được giải quyết Bưởi ơi";
		assertNull(trangThaiGopY.getTrangThai());
		trangThaiGopY.setTrangThai(trangThai);
		assertEquals(trangThaiGopY.getTrangThai(), trangThai);
	}

	public void testGetAndSetDsGopY() {
		Set<GopY> dsGopY = new HashSet<GopY>();
		for (int i = 0; i < 10; i++) {
			dsGopY.add(new GopY());
		}
		assertEquals(trangThaiGopY.getDsGopY().size(), 0);
		trangThaiGopY.setDsGopY(dsGopY);
		assertEquals(trangThaiGopY.getDsGopY().size(), 10);
	}
	
}
