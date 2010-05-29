/**
 * 
 */
package qt.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import qt.dto.ChiTietPhieuNhapPhuKien;
import qt.dto.PhieuNhapPhuKien;

/**
 * @author tqthe
 * 
 */
@Transactional
public class PhieuNhapPhuKienDAO {

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
	 * Đánh dấu xóa PhieuNhapPhuKien. Các ChiTietPhieuNhapPhuKien thuộc về
	 * PhieuNhapPhuKien sẽ bị đánh dấu xóa theo.
	 * 
	 * @param p
	 *            PhieuNhapPhuKien bi đánh dấu xóa.
	 */
	public void markAsDeleted(PhieuNhapPhuKien p) {
		p.setXoa(true);

		Set<ChiTietPhieuNhapPhuKien> ds = p.getDsChiTietPhieuNhapPhuKien();

		for (ChiTietPhieuNhapPhuKien t : ds) {
			t.setXoa(true);
		}

		makePersistent(p);
	}

	/**
	 * Xóa (vĩnh viễn) một PhieuNhapPhuKien.
	 * 
	 * @param p
	 *            PhieuNhapPhuKien sẽ bị xóa.
	 */
	public void makeTransient(PhieuNhapPhuKien p) {
		// remove all association before deleting
		if (p.getNhaCungCap() != null) {
			p.getNhaCungCap().getDsPhieuNhapPhuKien().remove(p);
			p.setNhaCungCap(null);
		}
		if (p.getNhanVien() != null) {
			p.getNhanVien().getDsPhieuNhapPhuKien().remove(p);
			p.setNhanVien(null);
		}

		factory.getCurrentSession().delete(p);
	}

	/**
	 * Thêm mới hoặc cập nhật PhieuNhapPhuKien. Việc thêm mới hay cập nhật phụ
	 * thuộc vào giá trị ID.
	 * 
	 * @param p
	 *            PhieuNhapPhuKien sẽ được thêm mới hoặc cập nhật.
	 * @return PhieuNhapPhuKien đã được thêm mới hoặc cập nhật. Trong trường hợp
	 *         thêm mới giá trị ID sẽ được cập nhật tương ứng.
	 */
	public PhieuNhapPhuKien makePersistent(PhieuNhapPhuKien p) {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(p);
		session.flush();
		return p;
	}

	/**
	 * Tìm các PhieuNhapPhuKien của một NhaCungCap.
	 * 
	 * @param idNhaCungCap
	 *            id của NhaCungCap.
	 * @return Danh sách PhieuNhapPhuKien của NhaCungCap.
	 */
	@SuppressWarnings("unchecked")
	public List<PhieuNhapPhuKien> findByNhaCungCap(int idNhaCungCap) {
		return factory
				.getCurrentSession()
				.createQuery(
						"from PhieuNhapPhuKien p where p.nhaCungCap.id = :id and p.xoa = false")
				.setInteger("id", idNhaCungCap).list();
	}

	/**
	 * Tìm các PhieuNhapPhuKien của một NhanVien.
	 * 
	 * @param idNhanVien
	 *            id của NhanVien.
	 * @return Danh sách PhieuNhapPhuKien của NhanVien.
	 */
	@SuppressWarnings("unchecked")
	public List<PhieuNhapPhuKien> findByNhanVien(int idNhanVien) {
		return factory
				.getCurrentSession()
				.createQuery(
						"from PhieuNhapPhuKien p where p.nhanVien.id = :id and p.xoa = false")
				.setInteger("id", idNhanVien).list();
	}

	/**
	 * Tìm một PhieuNhapPhuKien theo ID
	 * 
	 * @param id
	 *            id của PhieuNhapPhuKien cần tìm.
	 * @return PhieuNhapPhuKien tìm được. Nếu không tìm thấy trả về null.
	 */
	public PhieuNhapPhuKien findById(int id) {
		PhieuNhapPhuKien p = (PhieuNhapPhuKien) factory.getCurrentSession()
				.get(PhieuNhapPhuKien.class, id);
		return p.isXoa() ? null : p;
	}

	/**
	 * Tìm tất cả PhieuNhapPhuKien.
	 * 
	 * @return Danh sách PhieuNhapPhuKien tìm được.
	 */
	@SuppressWarnings("unchecked")
	public List<PhieuNhapPhuKien> findAll() {
		return factory.getCurrentSession().createCriteria(
				PhieuNhapPhuKien.class).add(Restrictions.eq("xoa", false))
				.list();
	}
}
