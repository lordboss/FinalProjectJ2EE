/**
 * 
 */
package qt.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import qt.dto.SanPham;

/**
 * @author tqthe
 * 
 */
@Transactional
public class SanPhamDAO {

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
	 * Xóa (vĩnh viễn) một SanPham.
	 * 
	 * @param p
	 *            SanPham sẽ bị xóa.
	 */
	public void makeTransient(SanPham p) {
		// remove all association before deleting
		if (p.getTinhTrangSanPham() != null) {
			p.getTinhTrangSanPham().getDsSanPham().remove(p);
			p.setTinhTrangSanPham(null);
		}
		p.setDsChiTietDonHang(null); 
		p.setDsNhaCungCap(null);

		factory.getCurrentSession().delete(p);
	}

	/**
	 * Thêm mới hoặc cập nhật một SanPham. Việc thêm mới hay cập nhật phụ thuộc
	 * vào giá trị ID.
	 * 
	 * @param p
	 *            SanPham sẽ được thêm mới hay cập nhật.
	 * @return SanPham đã được thêm mới hay cập nhật. Trong trường hợp thêm mới
	 *         giá trị ID sẽ thay đổi.
	 */
	public SanPham makePersistent(SanPham p) {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(p);
		session.flush();
		return p;
	}

	/**
	 * Tìm các SanPham theo TinhTrangSanPham
	 * 
	 * @param idTinhTrang
	 *            id của TinhTrangSanPham.
	 * @return Danh sách SanPham của TinhTrangSanPham.
	 */
	@SuppressWarnings("unchecked")
	public List<SanPham> findByTinhTrangSanPham(int idTinhTrang) {
		return factory.getCurrentSession().createQuery(
				"from SanPham p where p.tinhTrangSanPham.id = :id").setInteger(
				"id", idTinhTrang).list();
	}

	/**
	 * Tìm các SanPham của một NhaCungCap.
	 * 
	 * @param idNhaCungCap
	 *            id của NhaCungCap.
	 * @return Danh sách SanPham của NhaCungCap.
	 */
	@SuppressWarnings("unchecked")
	public List<SanPham> findByNhaCungCap(int idNhaCungCap) {
		return factory.getCurrentSession().createQuery(
				"from SanPham p join p.dsNhaCungCap s where s.id = :id")
				.setInteger("id", idNhaCungCap).list();
	}

	/**
	 * Tìm một SanPham theo ID.
	 * 
	 * @param id
	 *            id của SanPham cần tìm.
	 * @return SanPham tìm được. Nếu không tìm thấy trả về null.
	 */
	public SanPham findById(int id) {
		return (SanPham) factory.getCurrentSession().get(SanPham.class, id);
	}

	/**
	 * Tìm tất cả SanPham.
	 * 
	 * @return Danh sách SanPham tìm được.
	 */
	@SuppressWarnings("unchecked")
	public List<SanPham> findAll() {
		return factory.getCurrentSession().createCriteria(SanPham.class).list();
	}
}
