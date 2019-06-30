package san.com.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import san.com.shoppingbackend.dao.CategoryDAO;
import san.com.shoppingbackend.dto.Category;

@Controller
public class PageController {

	@Autowired
	private CategoryDAO categoryDAO;

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		mv.addObject("userClickHome", true);
		//passing list
		mv.addObject("categories",categoryDAO.list());
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
		//passing list
		mv.addObject("categories",categoryDAO.list());
		return mv;

	}
	@RequestMapping(value = { "/show/category/{id}/products" })
	public ModelAndView showCategoryProducts(@PathVariable("id")int id) {
		ModelAndView mv = new ModelAndView("page");
		// category to fatch single category
		Category category=null;
		category=categoryDAO.get(id);
		mv.addObject("title", category.getName());
		//passing list
		mv.addObject("categories",categoryDAO.list());
		//passing single category
		mv.addObject("category",category);
		mv.addObject("userClickCategoryProducts", true);
		return mv;

	}
}
