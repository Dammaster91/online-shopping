package san.com.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import san.com.shoppingbackend.dao.CategoryDAO;
import san.com.shoppingbackend.dto.Category;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<Category>();

	static {
		Category category = new Category();
		category.setId(1);
		category.setName("TV");
		category.setDescription("some description about TV");
		category.setImageURL("CAT_1.png");
		categories.add(category);

		category = new Category();
		category.setId(2);
		category.setName("MOBILE");
		category.setDescription("some description about MOBILE");
		category.setImageURL("CAT_2.png");
		categories.add(category);

		category = new Category();
		category.setId(3);
		category.setName("LAPTOP");
		category.setDescription("some description about LAPTOP");
		category.setImageURL("CAT_3.png");
		categories.add(category);
	}

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

	@Override
	public Category get(int id) {
		// enchanced for loop
		for (Category category : categories) {
			if (category.getId() == id) {
				return category;
			}
		}
		return null;
	}

}
