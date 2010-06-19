/**
 * 
 */
package qt.bus;

import qt.dao.CongTyDAO;
import qt.dto.CongTy;

/**
 * @author tqthe
 * 
 */
public class CongTyBUS {
	private CongTyDAO congTyDAO;

	/**
	 * Thêm mới hay cập nhật thông tin CongTy.
	 * 
	 * @param c
	 *            CongTy sẽ được thêm hay cập nhật.
	 * @return CongTy sau khi được thêm hay cập nhật.
	 */
	public CongTy makePersistent(CongTy c) {
		if (c != null) {
			congTyDAO.makePersistent(c);
		}
		return c;
	}

	/**
	 * Trả về thông tin công ty.
	 * 
	 * @return CongTy tìm được.
	 */
	public CongTy getCongTy() {
		return congTyDAO.getCongTy();
	}

	/**
	 * @param congTyDAO
	 *            the congTyDAO to set
	 */
	public void setCongTyDAO(CongTyDAO congTyDAO) {
		this.congTyDAO = congTyDAO;
	}

	/**
	 * @return the congTyDAO
	 */
	public CongTyDAO getCongTyDAO() {
		return congTyDAO;
	}
}
