package san.com.onlineshopping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import san.com.onlineshopping.validator.ProductValidator;
import san.com.shoppingbackend.dao.CategoryDAO;
import san.com.shoppingbackend.dao.ProductDAO;
import san.com.shoppingbackend.dto.Category;
import san.com.shoppingbackend.dto.Product;

@Controller
@RequestMapping("/manage")
public class ManagementController {

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private ProductDAO productDAO;

	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public ModelAndView showManageProduct(@RequestParam(name = "operation", required = false) String operation) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "Manage Products");
		Product nProduct = new Product();

		nProduct.setSupplierId(1);
		nProduct.setActive(true);
		mv.addObject("product", nProduct);

		if (operation != null) {
			if (operation.equals("product")) {
				mv.addObject("message", "Product Submitted Successfully");
			}
			else if(operation.equals("category")) {
				mv.addObject("message", "Category Submitted Successfully");
	
			}
		}
		return mv;
	}

	@RequestMapping(value = "/{id}/product", method = RequestMethod.GET)
	public ModelAndView showAddedProduct(@PathVariable int id) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "Manage Products");
		Product nProduct = productDAO.get(id);
		// set the product fetch from database
		mv.addObject("product", nProduct);

		return mv;
	}

	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product mProduct, BindingResult result,
			Model model, HttpServletRequest request) {
		if (mProduct.getId() == 0) {
			new ProductValidator().validate(mProduct, result);
		} else {

			if (!mProduct.getFile().getOriginalFilename().equals("")) {
				new ProductValidator().validate(mProduct, result);

			}
		}
		if (result.hasErrors()) {
			model.addAttribute("userClickManageProducts", true);
			model.addAttribute("title", "Manage Products");
			return "page";
		}

		if (mProduct.getId() == 0) {
			productDAO.add(mProduct);
		} else {
			productDAO.update(mProduct);
		}

		if (!mProduct.getFile().getOriginalFilename().equals("")) {
			FileUploadUtility.uploadFile(request, mProduct.getFile(), mProduct.getCode());
		}

		return "redirect:/manage/product?operation=product";
	}

	@RequestMapping(value = "/product/{id}/activation", method = RequestMethod.POST)
	@ResponseBody
	public String handleProductActivation(@PathVariable int id) {

		Product product = productDAO.get(id);
		boolean isActive = product.isActive();

		product.setActive(!product.isActive());
		productDAO.update(product);
		return (isActive) ? "You have Succesfully Deactivated the product with id" + product.getId()
				: "You have Succesfully activated  the product with id" + product.getId()

		;
	}
	
	// 
	@RequestMapping(value="/category",method=RequestMethod.POST)
	public String handleCategorySubmission(@ModelAttribute Category category)  {
		
		categoryDAO.add(category);
		
		return "redirect:/manage/product?operation=category";
	}

	@ModelAttribute("categories")
	public List<Category> getCategories() {
		return categoryDAO.list();
	}

	@ModelAttribute("category")
	public Category getCategory() {
		return new Category();
	}
}