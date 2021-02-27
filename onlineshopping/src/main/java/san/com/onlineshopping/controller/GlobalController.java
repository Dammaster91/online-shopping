package san.com.onlineshopping.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import san.com.onlineshopping.model.UserModel;
import san.com.shoppingbackend.dao.UserDAO;
import san.com.shoppingbackend.dto.User;

@ControllerAdvice
public class GlobalController {
	@Autowired
	private HttpSession session;
	@Autowired
	private UserDAO userDao;
	private UserModel userModel = null;

	@ModelAttribute("userModel")
	public UserModel getUserModel() {
		if (session.getAttribute("userModel") == null) {
			// add the user model
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			User user = userDao.getByEmail(authentication.getName());
			if (user != null) {
				// Create the new UserModel object to pass the user details
				userModel = new UserModel();
				userModel.setId(user.getId());
				userModel.setEmail(user.getEmail());
				userModel.setRole(user.getRole());
				userModel.setFullName(user.getFirstName() + " " + user.getLastName());
				if (userModel.getRole().equals("USER")) {
					// set the cart only if user is a buyer
					userModel.setCart(user.getCart());
					
				}
				// set the userModel in the Session
				session.setAttribute("userModel", userModel);
				return userModel;
			}
		}
		return (UserModel) session.getAttribute("userModel");
	}
}
