/**
 * 
 */
package qt.test.mail;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author tqthe
 *
 */
public class TestSendMail {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
		"test-context.xml");

		IAccountManager manager = (IAccountManager) context.getBean("accountManager");
		manager.sendMail();
		
	}

}
