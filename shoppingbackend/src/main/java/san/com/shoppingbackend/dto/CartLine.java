package san.com.shoppingbackend.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cart_line")
public class CartLine implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/*---------------*/
	@OneToOne (fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id", referencedColumnName = "id", insertable = false, nullable = false, updatable = false)
	private Product product;
	
	/*
	 * (
	 * */

	@Column(name = "cart_id")
	private Integer cartId;
	
	@Column(name = "product_count")
	private Integer productCount;
	
/*	@Column(name = "product_id")
	private Integer productId;*/
	

	@Column(name = "total")
	private Double total;
	
	@Column(name = "buying_price")
	private Double buyingPrice;
	
	@Column(name = "is_available")
	private Boolean isAvaliable;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public Integer getProductCount() {
		return productCount;
	}

	public void setProductCount(Integer productCount) {
		this.productCount = productCount;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Double getBuyingPrice() {
		return buyingPrice;
	}

	public void setBuyingPrice(Double buyingPrice) {
		this.buyingPrice = buyingPrice;
	}

	public Boolean getIsAvaliable() {
		return isAvaliable;
	}

	public void setIsAvaliable(Boolean isAvaliable) {
		this.isAvaliable = isAvaliable;
	}

	@Override
	public String toString() {
		return "CartLine [id=" + id + ", product=" + product + ", cartId=" + cartId + ", productCount=" + productCount
				+ ", total=" + total + ", buyingPrice=" + buyingPrice + ", isAvaliable=" + isAvaliable + "]";
	}

}
