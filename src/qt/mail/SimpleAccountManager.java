/**
 * 
 */
package qt.mail;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;

import qt.dto.Email;
import qt.test.mail.MyMailSender;

/**
 * @author tqthe
 * 
 */
public class SimpleAccountManager implements IAccountManager {

	protected Log logger = LogFactory.getLog(getClass());
	private MyMailSender myMailSender;
	private SimpleMailMessage templateMessage;
	private static final String FROM = "TGDD Admin<tran.q.the@gmail.com>";

	private void setUnicodeEncoding() {
		myMailSender.setDefaultEncoding("UTF-8");
	}

	@Override
	public void sendMail(String to, String subject, String body) {

		setUnicodeEncoding();

		// Create a thread safe "copy" of the template message and customize it
		SimpleMailMessage msg = new SimpleMailMessage(this.templateMessage);

		msg.setSubject(subject);
		msg.setFrom(FROM);
		msg.setTo(to);
		msg.setText(body);

		try {
			// send mail
			myMailSender.send(msg);

			logger.info("Send mail to " + to + " done!");
		} catch (MailException ex) {
			ex.printStackTrace();
			logger.error("Error when sending email: " + ex.getMessage());
		}
	}

	@Override
	public void sendMail(Email email) {

		setUnicodeEncoding();

		// Create a thread safe "copy" of the template message and customize it
		SimpleMailMessage msg = new SimpleMailMessage(this.templateMessage);

		msg.setSubject(email.getSubject());
		msg.setFrom(FROM);
		msg.setTo(email.getTo());
		msg.setText(email.getBody());

		try {
			// send mail
			myMailSender.send(msg);

			logger.info("Send mail to " + email.getTo() + " done!");
		} catch (MailException ex) {
			ex.printStackTrace();
			logger.error("Error when sending email: " + ex.getMessage());
		}
	}

	@Override
	public void sendNewPassword(String to, String subject, String newPassword) {

		setUnicodeEncoding();

		// Create a thread safe "copy" of the template message and customize it
		SimpleMailMessage msg = new SimpleMailMessage(this.templateMessage);

		msg.setSubject(subject);
		msg.setFrom(FROM);
		msg.setTo(to);
		msg.setText(composeMessage(newPassword));

		try {
			// send mail
			myMailSender.send(msg);

			logger.info("Send mail to " + to + " done!");
		} catch (MailException ex) {
			ex.printStackTrace();
			logger.error("Error when sending email: " + ex.getMessage());
		}
	}

	@Override
	public Email createMail(String to, String subject, String body) {
		Email e = new Email();

		e.setTo(to);
		e.setSubject(subject);
		e.setBody(body);

		return e;
	}

	@Override
	public Email createResetPasswordMail(String to, String subject,
			String newPassword) {
		Email e = new Email();

		e.setTo(to);
		e.setSubject(subject);
		e.setBody(composeMessage(newPassword));

		return e;
	}

	private String composeMessage(String password) {
		StringBuilder sb = new StringBuilder();

		sb
				.append("Tài khoản của quý khách đã được reset mật khẩu thành công.\n");
		sb.append("Mật khẩu mới: ");
		sb.append(password);
		sb.append("\n\n");
		sb.append("Cảm ơn quý khách!\n\n");
		sb.append("Admin");

		return sb.toString();
	}

	public void setMyMailSender(MyMailSender myMailSender) {
		this.myMailSender = myMailSender;
	}

	public void setTemplateMessage(SimpleMailMessage templateMessage) {
		this.templateMessage = templateMessage;
	}

}
