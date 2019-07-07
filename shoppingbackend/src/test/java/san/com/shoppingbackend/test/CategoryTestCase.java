package san.com.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import san.com.shoppingbackend.dao.CategoryDAO;
import san.com.shoppingbackend.dto.Category;


public class CategoryTestCase {/*
	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDAO categoryDAO;
	private Category category;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("san.com.shoppingbackend");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	@Test
	public void testAddCategory() {
		category = new Category();
		category.setName("TV");
		category.setDescription("some description about TV");
		category.setImageURL("CAT_1.png");
		assertEquals("Successfully added a category inside table", true, categoryDAO.add(category));
	}
	
	@Test
	public void testGetCategory() {
		categoryDAO.get(1);
			assertEquals("Successfully added a category inside table", "sandeep", category.getName());
	}
*/}
