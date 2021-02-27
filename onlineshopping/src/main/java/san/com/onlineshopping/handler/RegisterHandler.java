package san.com.onlineshopping.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import san.com.onlineshopping.model.RegisterModel;
import san.com.shoppingbackend.dao.UserDAO;
import san.com.shoppingbackend.dto.Address;
import san.com.shoppingbackend.dto.Cart;
import san.com.shoppingbackend.dto.User;

@Component
public class RegisterHandler {

	@Autowired
	private UserDAO userDAO;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public RegisterModel init() {
		return new RegisterModel();
	}

	public void addUser(RegisterModel registerModel, User user) {
		registerModel.setUser(user);

	}

	public void addBilling(RegisterModel registerModel, Address billing) {
		registerModel.setBilling(billing);

	}

	public String validateUser(User user, MessageContext error) {
		String transitionValue = "success";
		// Check if
		if (!(user.getPassword().equals(user.getConfirmPassword()))) {
			error.addMessage(new MessageBuilder().error().source("confirmPassword")
					.defaultText("Password Does Not Match the Confirm password!").build());
			transitionValue = "failure";
		}
		if (userDAO.getByEmail(user.getEmail()) != null) {
			transitionValue = "failure";
			error.addMessage(
					new MessageBuilder().error().source("email").defaultText("Email Address Already used!").build());

		}
		return transitionValue;

	}

	public String saveAll(RegisterModel model) {

		String transitionValue = "success";

		// fetch the user
		User user = model.getUser();
		if (user.getRole().equals("USER")) {
			Cart cart = new Cart();
			cart.setUser(user);
			user.setCart(cart);

		}
		// Encode the password
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		// Save the User

		userDAO.addUser(user);

		// get the Address

		Address billing = model.getBilling();
		billing.setUserId(user.getId());
		billing.setBilling(true);
		// Save the User
		userDAO.addAddress(billing);

		return transitionValue;
	}
}
