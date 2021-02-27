package san.com.onlineshopping.service;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import san.com.onlineshopping.model.UserModel;
import san.com.shoppingbackend.dao.CartLineDAO;
import san.com.shoppingbackend.dto.Cart;
import san.com.shoppingbackend.dto.CartLine;
import san.com.shoppingbackend.dto.Product;

@Service
@Transactional
public class CartService {

	@Autowired
	private CartLineDAO cartLineDAO;

	@Autowired
	private HttpSession session;

	private Cart getCart() {
		System.out.println(session);
		return ((UserModel) session.getAttribute("userModel")).getCart();
	}

	public List<CartLine> getCartLine() {

		Cart cart = this.getCart();

		return cartLineDAO.list(cart.getId());
	}

	public String updateCartLine(int cartLineId, int count) {
		// fetch the cart line

		CartLine cartLine = cartLineDAO.get(cartLineId);
		if (cartLine == null) {
			return "result=error";
		} else {
			Product product = cartLine.getProduct();
			double oldTotal = cartLine.getTotal();
			if (product.getQuantity() <= count) {
				count = product.getQuantity();

			}
			cartLine.setProductCount(count);
			cartLine.setBuyingPrice(product.getUnitPrice());
			cartLine.setTotal(product.getUnitPrice() * count);
			cartLineDAO.update(cartLine);
			Cart cart = this.getCart();
			cart.setGrandTotal(cart.getGrandTotal() - oldTotal + cartLine.getTotal());
			cartLineDAO.updateCart(cart);
		}

		return "result=updated";
	}

}
