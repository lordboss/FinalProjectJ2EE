/**
 * 
 */
package qt.dao;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import qt.dto.CongTy;

/**
 * @author tqthe
 * 
 */
@Transactional
public class CongTyDAO {

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
	 * Thêm mới hay cập nhật thông tin CongTy.
	 * 
	 * @param c
	 *            CongTy sẽ được thêm hay cập nhật.
	 * @return CongTy sau khi được thêm hay cập nhật.
	 */
	public CongTy makePersistent(CongTy c) {
		factory.getCurrentSession().saveOrUpdate(c);
		factory.getCurrentSession().flush();
		return c;
	}

	/**
	 * Trả về thông tin công ty.
	 * 
	 * @return CongTy tìm được.
	 */
	public CongTy getCongTy() {
		return findById(1);
	}

	/**
	 * Tìm một công ty theo id.
	 * 
	 * @param id
	 *            ID của công ty.
	 * @return CongTy tìm được.
	 */
	private CongTy findById(int id) {
		return (CongTy) factory.getCurrentSession().get(CongTy.class, id);
	}

}
