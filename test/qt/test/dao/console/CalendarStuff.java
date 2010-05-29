/**
 * 
 */
package qt.test.dao.console;

import java.util.Calendar;

/**
 * @author tqthe
 * 
 */
public class CalendarStuff {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		getTheNumberDaysOfMonth();
		testSetDate();
	}

	public static void getTheNumberDaysOfMonth() {
		Calendar calendar = Calendar.getInstance();
		int year = 2008;
		int month = Calendar.FEBRUARY;
		int date = 1;
		calendar.set(year, month, date);
		int days = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println("Number of Days: " + days);
	}

	public static void testSetDate() {
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.set(2010, 0, 1, 0, 0, 0);
		c2.set(2010, 11, 31, 23, 59, 59);

		System.out.println(c1.getTime().toString());
		System.out.println(c2.getTime().toString());
	}
}
