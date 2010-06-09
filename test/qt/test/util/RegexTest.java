/**
 * 
 */
package qt.test.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author tqthe
 *
 */
public class RegexTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String emailRegex = "(\\w+)@(\\w+\\.)(\\w+)(\\.\\w+)*";
		Pattern pattern = Pattern.compile(emailRegex);
		Matcher matcher = pattern.matcher("tran.q.the@gmail.com");

		if (matcher.find()) {
			System.out.println("Email valid");
		} else {
			System.out.println("Email invalid");
		}
	}

}
