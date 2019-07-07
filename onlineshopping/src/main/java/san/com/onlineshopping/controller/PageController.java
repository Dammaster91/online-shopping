package san.com.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import san.com.onlineshopping.exception.CategoryNotFoundException;
import san.com.onlineshopping.exception.ProductNotFoundException;
import san.com.shoppingbackend.dao.CategoryDAO;
import san.com.shoppingbackend.dao.ProductDAO;
import san.com.shoppingbackend.dto.Category;
import san.com.shoppingbackend.dto.Product;

@Controller
public class PageController {
	//private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private ProductDAO productDAO;

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		//logger.info("Inside PageControllet index method-INFO");
		//logger.debug("Inside PageControllet index method-DEBUG");
		mv.addObject("userClickHome", true);
		// passing list
		mv.addObject("categories", categoryDAO.list());
		return mv;

	}

	@RequestMapping(value = { "/about" })
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Abouts Us");
		mv.addObject("userClickAbout", true);
		return mv;

	}

	@RequestMapping(value = { "/contact" })
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact", true);
		return mv;

	}

	@RequestMapping(value = { "/show/all/products" })
	public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Products");
		mv.addObject("userClickAllProducts", true);
		// passing list
		mv.addObject("categories", categoryDAO.list());
		return mv;

	}

	@RequestMapping(value = { "/show/category/{id}/products" })
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) throws CategoryNotFoundException{
		ModelAndView mv = new ModelAndView("page");
		// category to fatch single category
		Category category = null;
	
		category = categoryDAO.get(id);
		if(category==null) throw new CategoryNotFoundException();
		mv.addObject("title", category.getName());
		// passing list
		mv.addObject("categories", categoryDAO.list());
		// passing single category
		mv.addObject("category", category);
		mv.addObject("userClickCategoryProducts", true);
		return mv;

	}

	/* Viewing a single product */
	@RequestMapping(value = { "/show/{id}/product" })
	public ModelAndView showSingleProduct(@PathVariable("id") int id) throws ProductNotFoundException {
		ModelAndView mv = new ModelAndView("page");
		// category to fatch single category
		Product product = null;
		product = productDAO.get(id);
		if(product==null) throw new ProductNotFoundException(); 
		// update view count
		product.setViews(product.getViews() + 1);
		productDAO.update(product);

		mv.addObject("title", product.getName());
		// passing single category
		mv.addObject("product", product);
		mv.addObject("userClickShowProduct", true);
		return mv;

	}

}
