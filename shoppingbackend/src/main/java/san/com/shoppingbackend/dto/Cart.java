package san.com.shoppingbackend.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/*---------------*/
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "uid", referencedColumnName = "id", insertable = false, nullable = false, updatable = false)
	//@JoinColumn(name = "uid")
	
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	/*---------------*/

	@Column(name = "uid")
	private Integer userId;

	

	@Column(name = "grand_total")
	private Double grandTotal;

	@Column(name = "cart_lines")
	private Integer cartLines;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(Double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public Integer getCartLines() {
		return cartLines;
	}

	public void setCartLines(Integer cartLines) {
		this.cartLines = cartLines;
	}

}
