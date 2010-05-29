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
