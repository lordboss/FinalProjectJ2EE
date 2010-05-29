/**
 * 
 */
package qt.test.bus.console;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import qt.bus.AccountBUS;
import qt.dto.Account;

/**
 * @author tqthe
 *
 */
public class PrintDsAccount {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"test-context.xml");
		AccountBUS aBus = (AccountBUS) context.getBean("accountBUS");
		List<Account> dsAccount = aBus.findAll();

		int i = 1000;
		for (Account a : dsAccount) {
			i++;
			aBus.resetPassword(a, Integer.toString(i));
			printAccount(a);
		}
	}

	private static void printAccount(Account a) {
		System.out.println(a.getId() + ": " + a.getClass().getSimpleName()
				+ ": Username: " + a.getUsername() + "; Password: "
				+ a.getPass() + "; Email: " + a.getEmail());
	}
}
