package san.com.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import san.com.shoppingbackend.dao.ProductDAO;
import san.com.shoppingbackend.dto.Product;

@RestController
@RequestMapping("/json/data")
public class JsonDataController {

	@Autowired
	private ProductDAO productDAO;

	@RequestMapping("/admin/all/products")
	@ResponseBody
	public List<Product> getAllProductsForAdmin() {
		return productDAO.listActiveProducts();

	}

	@RequestMapping("/all/products")
	@ResponseBody
	public List<Product> getAllProducts() {
		return productDAO.listActiveProducts();

	}

	@RequestMapping("/category/{id}/products")
	@ResponseBody
	public List<Product> getAllProducts(@PathVariable int id) {
		return productDAO.listActiveProductsByCategory(id);

	}

}
