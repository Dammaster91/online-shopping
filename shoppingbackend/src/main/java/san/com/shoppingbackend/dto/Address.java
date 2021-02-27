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
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "address")
public class Address implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/*------------------*/
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, nullable = false, updatable = false)

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	/*------------------*/

	@Column(name = "user_id")
	private Integer userId;

	@Column(name = "address_line_one")
	@NotBlank(message = "Please enter the user address!")
	private String addressLineOne;

	@Column(name = "address_line_two")
	@NotBlank(message = "Please enter the user address!")
	private String addressLineTwo;

	@Column(name = "city")
	@NotBlank(message = "Please enter the user city Name!")
	private String city;

	@Column(name = "state")
	@NotBlank(message = "Please enter the user state Name!")
	private String state;

	@Column(name = "country")
	@NotBlank(message = "Please enter the user country Name!")
	private String country;

	@Column(name = "postal_code")
	@NotBlank(message = "Please enter the user pin code!")
	private String postalCode;

	@Column(name = "shipping")
	private Boolean shipping;

	@Column(name = "billing")
	private Boolean billing;

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

	public String getAddressLineOne() {
		return addressLineOne;
	}

	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}

	public String getAddressLineTwo() {
		return addressLineTwo;
	}

	public void setAddressLineTwo(String addressLineTwo) {
		this.addressLineTwo = addressLineTwo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public Boolean getShipping() {
		return shipping;
	}

	public void setShipping(Boolean shipping) {
		this.shipping = shipping;
	}

	public Boolean getBilling() {
		return billing;
	}

	public void setBilling(Boolean billing) {
		this.billing = billing;
	}

}
