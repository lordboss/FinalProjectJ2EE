/**
 * 
 */
package qt.test.dto;

import junit.framework.TestCase;
import qt.dto.Account;

/**
 * @author tqthe
 *
 */
public class AccountTestCase extends TestCase {

	private Account a;
	
	@Override
	protected void setUp() throws Exception {
		a = new Account();
	}

	public void testGetAndSetUsername() {
		String username = "tqthe";
		assertNull(a.getUsername());
		
		a.setUsername(username);
		assertEquals(a.getUsername(), username);
		
		a.setUsername(null);
		assertNull(a.getUsername());
	}
	
	public void testGetAndSetPass() {
		String pass = "x3455sghfgasdlf";
		assertNull(a.getPass());
		
		a.setPass(pass);
		assertEquals(a.getPass(), pass);
	}
	
	public void testGetAndSetHo() {
		String ho = "Trần";
		assertNull(a.getHo());
		
		a.setHo(ho);
		assertEquals(a.getHo(), ho);
	}
	
	public void testGetAndSetTen() {
		String ten = "Thể";
		assertNull(a.getTen());
		a.setTen(ten);
		assertEquals(a.getTen(), ten);
	}
	
	public void testGetAndSetDem() {
		String dem = "Quang";
		assertNull(a.getDem());
		a.setDem(dem);
		assertEquals(a.getDem(), dem);
	}
	
	public void testGetAndSetEmail() {
		String email = "tran.q.the@gmail.com";
		assertNull(a.getEmail());
		a.setEmail(email);
		assertEquals(a.getEmail(), email);
	}
	
	public void testGetAndSetTrangThai() {
		int s = 1;
		assertNull(a.getTrangThai());
		a.setTrangThai(s);
		assertEquals(a.getTrangThai().intValue(), s);
	}
	
}
