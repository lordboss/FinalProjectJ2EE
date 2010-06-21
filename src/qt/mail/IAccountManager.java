/**
 * 
 */
package qt.mail;

import qt.dto.Email;

/**
 * @author tqthe
 * 
 */
public interface IAccountManager {
	/**
	 * Send email
	 * 
	 * @param email
	 *            An email being sent
	 */
	public void sendMail(Email email);

	/**
	 * News-letter
	 * 
	 * @param to
	 *            User's email address
	 * @param subject
	 *            Email subject
	 * @param body
	 *            Email content
	 */
	public void sendMail(String to, String subject, String body);

	/**
	 * Reset password notification
	 * 
	 * @param to
	 *            User's email address
	 * @param subject
	 *            Email subject
	 * @param newPassword
	 *            : new password in plain text
	 */
	public void sendNewPassword(String to, String subject, String newPassword);
	
	public Email createMail(String to, String subject, String body);
	public Email createResetPasswordMail(String to, String subject, String newPassword);
}
