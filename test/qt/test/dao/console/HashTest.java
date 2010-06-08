/**
 * 
 */
package qt.test.dao.console;

import qt.util.HashHelper;

/**
 * @author tqthe
 *
 */
public class HashTest {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		String pass1 = "user02";
		String pass2 = "123";
		
		HashHelper h = HashHelper.getInstance();
		
		String hashedPass1 = h.hash(pass1);
		String hashedPass2 = h.hash(pass2);
		
		System.out.println(hashedPass1);
		System.out.println(hashedPass2);
		
		if (hashedPass1.equals(hashedPass2)) {
			System.out.println("BOOM!!!");
		}
	}

}
