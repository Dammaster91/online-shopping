package san.com.shoppingbackend.dao;

import java.util.List;

import san.com.shoppingbackend.dto.Address;
import san.com.shoppingbackend.dto.Cart;
import san.com.shoppingbackend.dto.User;

public interface UserDAO {
	
	boolean addUser(User user);
	User getByEmail(String email);
	
	boolean addAddress(Address address);
	Address getBillingAddress(User user);
	List<Address> listShippingAddress(User user);

}
