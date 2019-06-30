package san.com.shoppingbackend.dao;

import java.util.List;

import san.com.shoppingbackend.dto.Category;

public interface CategoryDAO {

	List<Category> list();
	Category get(int id);

}
