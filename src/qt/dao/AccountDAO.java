/**
 * 
 */
package qt.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import qt.dto.Account;
import qt.util.HashHelper;

/**
 * @author tqthe
 * 
 */
@Transactional
public class AccountDAO {

	private SessionFactory factory;

	/**
	 * @param factory
	 *            the factory to set
	 */
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	/**
	 * @return the factory
	 */
	public SessionFactory getFactory() {
		return factory;
	}

	/**
	 * Thực hiện kiểm tra việc đăng nhập.
	 * 
	 * @param username
	 *            username dùng để đăng nhập.
	 * @param password
	 *            password dùng để đăng nhập.
	 * @return Nếu đăng nhập thành công trả về Account tương ứng. Nếu thất bại
	 *         trả về null.
	 * @throws Exception
	 *             Có thể xảy ra trong quá trình hash password.
	 */
	public Account login(String username, String password) throws Exception {
		// validate username
		if (username == null) {
			return null;
		} else if (username.isEmpty()) {
			return null;
		}

		// validate password
		if (password == null) {
			return null;
		} else if (password.isEmpty()) {
			return null;
		}

		// hash plain password
		String hashedPassword = HashHelper.getInstance().hash(password);

		return (Account) factory.getCurrentSession().createCriteria(
				Account.class).add(Restrictions.eq("xoa", false)).add(
				Restrictions.eq("username", username)).add(
				Restrictions.eq("pass", hashedPassword)).uniqueResult();
	}

	/**
	 * Kiểm tra username đã tồn tại hay chưa.
	 * 
	 * @param username
	 *            Username cần kiểm tra.
	 * @return True: Đã tồn tại. False: Chưa tồn tại.
	 */
	public boolean checkUsername(String username) {
		if (username == null) {
			return false;
		}

		Account a = (Account) factory.getCurrentSession().createCriteria(
				Account.class).add(Restrictions.eq("username", username))
				.uniqueResult();

		return a != null;
	}

	/**
	 * Kiểm tra email đã tồn tại hay chưa.
	 * 
	 * @param email
	 *            email cần kiểm tra.
	 * @return True: Đã tồn tại. False: Chưa tồn tại.
	 */
	public boolean checkEmail(String email) {
		if (email == null) {
			return false;
		}

		Account a = (Account) factory.getCurrentSession().createCriteria(
				Account.class).add(Restrictions.eq("email", email))
				.uniqueResult();

		return a != null;
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
		try {
			String hashedPassword = HashHelper.getInstance().hash(newPassword);
			a.setPass(hashedPassword);
			makePersistent(a);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Kích hoạt một tài khoản.
	 * 
	 * @param a
	 *            Account được kích hoạt.
	 */
	public void activate(Account a) {
		a.setTrangThai(1);
		makePersistent(a);
	}

	/**
	 * Vô hiệu hóa một tài khoản.
	 * 
	 * @param a
	 *            Account bị vô hiệu hóa.
	 */
	public void deactivate(Account a) {
		a.setTrangThai(0);
		makePersistent(a);
	}

	/**
	 * Đánh dấu xóa một Account.
	 * 
	 * @param a
	 *            Account bị đánh dấu xóa.
	 */
	public void markAsDeleted(Account a) {
		a.setXoa(true);
		makePersistent(a);
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
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(a);
		session.flush();
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
		return (Account) factory.getCurrentSession().createCriteria(
				Account.class).add(Restrictions.eq("id", id)).add(
				Restrictions.eq("xoa", false)).uniqueResult();
		// return findByIdHelper(id);
	}

	@SuppressWarnings("unused")
	private Account findByIdHelper(int id) {
		Account a = (Account) factory.getCurrentSession()
				.get(Account.class, id);
		return a.isXoa() ? null : a;
	}

	/**
	 * Tìm tất cả Account
	 * 
	 * @return Danh sách Account
	 */
	@SuppressWarnings("unchecked")
	public List<Account> findAll() {
		return factory.getCurrentSession().createCriteria(Account.class).add(
				Restrictions.eq("xoa", false)).list();
	}
}
