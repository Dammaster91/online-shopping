package san.com.shoppingbackend.dao;

import java.util.List;

import san.com.shoppingbackend.dto.Cart;
import san.com.shoppingbackend.dto.CartLine;

public interface CartLineDAO {
	public CartLine get(int id);

	public boolean add(CartLine cartLine);

	public boolean update(CartLine cartLine);

	public boolean delete(CartLine cartLine);

	public List<CartLine> list(Integer cartId);

	public List<CartLine> listAvailable(Integer cartId);

	public CartLine getByCartAndProduct(Integer cartId, Integer productId);
	public boolean updateCart(Cart cart);
}
