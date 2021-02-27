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

import san.com.onlineshopping.service.CartService;
import san.com.onlineshopping.validator.ProductValidator;
import san.com.shoppingbackend.dao.CategoryDAO;
import san.com.shoppingbackend.dao.ProductDAO;
import san.com.shoppingbackend.dto.Category;
import san.com.shoppingbackend.dto.Product;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private CartService cartService;

	@RequestMapping("/show")
	public ModelAndView showCart(@RequestParam(name="result",required=false)String result) {

		ModelAndView mv = new ModelAndView("page");
		if(result!=null) {
			
			switch(result) {
			case "updated":
				mv.addObject("message", "CartLine has been Updated Successfully!");
			break;
			case "error":
				mv.addObject("message", "Something went Wrong!");
				break;
			
			}
		}
		mv.addObject("title", "User Cart");
		mv.addObject("userClickShowCart", true);
		mv.addObject("cartLines", cartService.getCartLine());
		return mv;
	}

	@RequestMapping(value = "/{cartLineId}/update", method = RequestMethod.GET)
	public String updateCart(@PathVariable int cartLineId,@RequestParam int count) {
		String response=cartService.updateCartLine(cartLineId,count);
	
		return "redirect:/cart/show?"+response;
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
	@RequestMapping(value = "/category", method = RequestMethod.POST)
	public String handleCategorySubmission(@ModelAttribute Category category) {

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