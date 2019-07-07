package san.com.shoppingbackend.dao;

import java.util.List;

import san.com.shoppingbackend.dto.Category;
import san.com.shoppingbackend.dto.Product;

public interface CategoryDAO {
	Category get(int id);

	List<Category> list();

	boolean add(Category category);

	boolean update(Category category);

	boolean delete(Category category);
	
}
