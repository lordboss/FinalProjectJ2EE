/**
 * 
 */
package qt.dto;

import java.io.Serializable;

/**
 * @author tqthe
 * 
 */
@SuppressWarnings("serial")
public class CartItem implements Serializable {

	private SanPham product;
	private int quantity;

	/**
	 * @param product
	 * @param quantity
	 */
	public CartItem(SanPham product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	/**
	 * @param product
	 *            the product to set
	 */
	public void setProduct(SanPham product) {
		this.product = product;
	}

	/**
	 * @return the product
	 */
	public SanPham getProduct() {
		return product;
	}

	/**
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

}
