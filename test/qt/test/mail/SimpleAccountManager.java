/**
 * 
 */
package qt.test.mail;

import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;

/**
 * @author tqthe
 * 
 */
public class SimpleAccountManager implements IAccountManager {

	private MyMailSender myMailSender;
	private SimpleMailMessage templateMessage;

	@Override
	public void sendMail() {

		// Do the business calculations...

		// Call the collaborators to persist the order...

		// Create a thread safe "copy" of the template message and customize it
		SimpleMailMessage msg = new SimpleMailMessage(this.templateMessage);
		msg.setFrom("ADMIN BUOI<tran.q.the@gmail.com>");
		msg.setTo("the_pv2002@yahoo.com");
		msg.setText("Test Spring mail. :)");

		try {
			myMailSender.send(msg);
			
			System.out.println("Send mail done!");
		} catch (MailException ex) {
			// simply log it and go on...
			System.err.println(ex.getMessage());
		}

	}

	public void setMyMailSender(MyMailSender myMailSender) {
		this.myMailSender = myMailSender;
	}

	public void setTemplateMessage(SimpleMailMessage templateMessage) {
		this.templateMessage = templateMessage;
	}

}
