/**
 * 
 */
package qt.bus;

import java.util.List;

import qt.dao.AccountDAO;
import qt.dto.Account;

/**
 * @author tqthe
 *
 */
public class AccountBUS {

	private AccountDAO accountDAO;
	
	/**
	 * @param accountDAO the accountDAO to set
	 */
	public void setAccountDAO(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}

	/**
	 * @return the accountDAO
	 */
	public AccountDAO getAccountDAO() {
		return accountDAO;
	}

	/**
	 * Reset lại mật khẩu cho Account.
	 * 
	 * @param a
	 *            Account bị reset mật khẩu.
	 * @param newPassword
	 *            Mật khẩu mới dưới dạng plaintext.
	 */
	public void resetPassword(Account a, String newPassword) {
		accountDAO.resetPassword(a, newPassword);
	}

	/**
	 * Kích hoạt một tài khoản.
	 * 
	 * @param a
	 *            Account được kích hoạt.
	 */
	public void activate(Account a) {
		accountDAO.activate(a);
	}

	/**
	 * Vô hiệu hóa một tài khoản.
	 * 
	 * @param a
	 *            Account bị vô hiệu hóa.
	 */
	public void deactivate(Account a) {
		accountDAO.deactivate(a);
	}

	/**
	 * Đánh dấu xóa một Account.
	 * 
	 * @param a
	 *            Account bị đánh dấu xóa.
	 */
	public void markAsDeleted(Account a) {
		accountDAO.markAsDeleted(a);
	}

	/**
	 * Thêm mới hay cập nhật một Account. Việc thêm mới hay cập nhật phụ thuộc
	 * vào giá trị ID.
	 * 
	 * @param a
	 *            Account sẽ được thêm hay cập nhật.
	 * @return Account đã được thêm hay cập nhật. Trong trường hợp thêm mới giá
	 *         trị ID sẽ thay đổi.
	 */
	public Account makePersistent(Account a) {
		accountDAO.makePersistent(a);
		return a;
	}

	/**
	 * Tìm một Account theo ID
	 * 
	 * @param id
	 *            id của Account cần tìm.
	 * @return Account tìm được. Nếu không tìm thấy trả về null.
	 */
	public Account findById(int id) {
		return accountDAO.findById(id);
	}

	/**
	 * Tìm tất cả Account
	 * 
	 * @return Danh sách Account
	 */
	public List<Account> findAll() {
		return accountDAO.findAll();
	}
}
