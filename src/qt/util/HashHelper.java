/**
 * 
 */
package qt.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

/**
 * Utility class to hash password
 * 
 * @author tqthe
 * 
 */
public class HashHelper {

	private static HashHelper instance;
	private static String salt = "buoi";

	private HashHelper() {

	}

	/**
	 * Perform hasing String
	 * 
	 * @param plainText
	 *            input string
	 * @return the hashed string of the input
	 * @throws Exception
	 *             Error occurs during hashing process.
	 */
	public synchronized String hash(String plainText) throws Exception {
		MessageDigest md = null;
		plainText = plainText + salt;

		try {
			md = MessageDigest.getInstance("SHA");
		} catch (NoSuchAlgorithmException e) {
			throw new Exception(e.getMessage());
		}

		try {
			md.update(plainText.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			throw new Exception(e.getMessage());
		}

		byte raw[] = md.digest();
		String hash = (new BASE64Encoder()).encode(raw);
		return hash;
	}

	/**
	 * Get HashHelper instance
	 * 
	 * @return A singleton instance of HashHelper
	 */
	public static synchronized HashHelper getInstance() {
		if (instance == null) {
			return new HashHelper();
		} else {
			return instance;
		}
	}
}
