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

import qt.dto.ChiTietPhieuNhapDienThoai;
import qt.dto.PhieuNhapDienThoai;

/**
 * @author tqthe
 * 
 */
@Transactional
public class PhieuNhapDienThoaiDAO {

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
	 * Đánh dấu xóa một PhieuNhapDienThoai. PhieuNhapDienThoai bị đánh dấu xóa
	 * sẽ không thực sự bị xóa.
	 * 
	 * @param p
	 *            PhieuNhapDienThoai sẽ bị đánh dấu xóa.
	 */
	public void markAsDeleted(PhieuNhapDienThoai p) {
		p.setXoa(true);
		Set<ChiTietPhieuNhapDienThoai> ds = p.getDsChiTietPhieuNhapDienThoai();
		for (ChiTietPhieuNhapDienThoai ct : ds) {
			ct.setXoa(true);
		}

		makePersistent(p);
	}

	/**
	 * Xóa (vĩnh viễn) một PhieuNhapDienThoai. Các ChiTietPhieuNhapDienThoai
	 * thuộc về PhieuNhapDienThoai sẽ bị xóa theo.
	 * 
	 * @param p
	 *            PhieuNhapDienThoai sẽ bị xóa.
	 */
	public void makeTransient(PhieuNhapDienThoai p) {
		// remove all association before deleting
		if (p.getNhaCungCap() != null) {
			p.getNhaCungCap().getDsPhieuNhapDienThoai().remove(p);
			p.setNhaCungCap(null);
		}
		if (p.getNhanVien() != null) {
			p.getNhanVien().getDsPhieuNhapDienThoai().remove(p);
			p.setNhanVien(null);
		}

		factory.getCurrentSession().delete(p);
	}

	/**
	 * Thêm mới hoặc cập nhật một PhieuNhapDienThoai. Việc thêm mới hay cập nhật
	 * phụ thuộc vào giá trị ID.
	 * 
	 * @param p
	 *            PhieuNhapDienThoai sẽ được thêm mới hay cập nhật.
	 * @return PhieuNhapDienThoai vừa được thêm mới hay cập nhật.
	 */
	public PhieuNhapDienThoai makePersistent(PhieuNhapDienThoai p) {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(p);
		session.flush();
		return p;
	}

	/**
	 * Tìm tất cả PhieuNhapDienThoai của một NhanVien.
	 * 
	 * @param id
	 *            id của NhanVien cần tìm PhieuNhapDienThoai.
	 * @return Danh sách PhieuNhapDienThoai của NhanVien.
	 */
	@SuppressWarnings("unchecked")
	public List<PhieuNhapDienThoai> findByNhanVien(int id) {
		return factory
				.getCurrentSession()
				.createQuery(
						"from PhieuNhapDienThoai p where p.nhanVien.id = :id and p.xoa = false")
				.setInteger("id", id).list();
	}

	/**
	 * Tìm tất cả PhieuNhapDienThoai của một NhaCungCap.
	 * 
	 * @param id
	 *            id của NhaCungCap cần tìm danh sách PhieuNhapDienThoai.
	 * @return Danh sách PhieuNhapDienThoai của NhaCungCap.
	 */
	@SuppressWarnings("unchecked")
	public List<PhieuNhapDienThoai> findByNhapCungCap(int id) {
		return factory
				.getCurrentSession()
				.createQuery(
						"from PhieuNhapDienThoai p where p.nhaCungCap.id = :id and p.xoa = false")
				.setInteger("id", id).list();
	}

	/**
	 * Tìm một PhieuNhapDienThoai theo ID.
	 * 
	 * @param id
	 *            id của PhieuNhapDienThoai cần tìm.
	 * @return PhieuNhapDienThoai tìm được. Nếu không tìm thấy trả về null.
	 */
	public PhieuNhapDienThoai findById(int id) {
		PhieuNhapDienThoai p = (PhieuNhapDienThoai) factory.getCurrentSession()
				.get(PhieuNhapDienThoai.class, id);
		return p.isXoa() ? null : p;
	}

	/**
	 * Tìm tất cả PhieuNhapDienThoai.
	 * 
	 * @return Danh sách PhieuNhapDienThoai tìm được.
	 */
	@SuppressWarnings("unchecked")
	public List<PhieuNhapDienThoai> findAll() {
		return factory.getCurrentSession().createCriteria(
				PhieuNhapDienThoai.class).add(Restrictions.eq("xoa", false))
				.list();
	}
}
