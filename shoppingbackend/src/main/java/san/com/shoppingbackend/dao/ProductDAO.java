package san.com.shoppingbackend.dao;

import java.util.List;

import san.com.shoppingbackend.dto.Product;

public interface ProductDAO {
	Product get(int id);

	List<Product> list();

	boolean add(Product product);

	boolean update(Product product);

	boolean delete(Product product);

	List<Product> listActiveProducts();

	List<Product> listActiveProductsByCategory(int categoryId);

	List<Product> getLatestProducts(int count);
}
