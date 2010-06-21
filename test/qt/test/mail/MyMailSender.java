/**
 * 
 */
package qt.test.mail;

import java.util.Properties;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * @author tqthe
 *
 */
public class MyMailSender extends JavaMailSenderImpl implements
		InitializingBean {

	private Boolean smtpSSLEnabled;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		Properties properties = new Properties();
		if (smtpSSLEnabled) {
			properties.setProperty("mail.smtp.auth", "true");
			properties.setProperty("mail.smtp.starttls.enable", "true");
			properties.setProperty("mail.smtp.timeout", "8500");
			setJavaMailProperties(properties);
		}
	}

	/**
	 * @param smtpSSLEnabled the smtpSSLEnabled to set
	 */
	public void setSmtpSSLEnabled(Boolean smtpSSLEnabled) {
		this.smtpSSLEnabled = smtpSSLEnabled;
	}

	/**
	 * @return the smtpSSLEnabled
	 */
	public Boolean getSmtpSSLEnabled() {
		return smtpSSLEnabled;
	}

}
