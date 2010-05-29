/**
 * 
 */
package qt.test.dao.console;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import qt.dao.AccountDAO;
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
		AccountDAO aDao = (AccountDAO) context.getBean("accountDAO");
		List<Account> dsAccount = aDao.findAll();

		for (Account a : dsAccount) {
			printAccount(a);
		}
	}

	private static void printAccount(Account a) {
		System.out.println(a.getId() + ": " + a.getClass().getSimpleName()
				+ ": Username: " + a.getUsername() + "; Password: "
				+ a.getPass() + "; Email: " + a.getEmail());
	}
}
