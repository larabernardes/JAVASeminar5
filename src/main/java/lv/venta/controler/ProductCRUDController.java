package lv.venta.controler;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.venta.model.Product;
import lv.venta.service.IProductCRUDService;

@Controller
@RequestMapping("/product/crud")
public class ProductCRUDController {
	
	@Autowired
	private IProductCRUDService productCRUDService;
	
	@GetMapping("/all") //localhost:8080/product/crud/all
	public String getProductCrudAll(Model model) {
		
		try
		{
			
		ArrayList<Product> result = productCRUDService.retrieveAll();
		model.addAttribute("mypackage", result);
		return "show-all-product-page"; // will show html page in the web browser with my package data
		
		}
		catch (Exception e) {
			model.addAttribute("mypackage", e.getMessage());
			return "error-page"; // will show error-page.html page with exception message
		}
	
	}
	
	
	

}
