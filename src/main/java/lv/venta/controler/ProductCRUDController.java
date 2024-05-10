package lv.venta.controler;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import lv.venta.model.Product;
import lv.venta.service.IProductCRUDService;

// TODO
// Finish Service IMplementation: filterByQuantityTreshold and filterByPriceBetween
// Create Controller class with two get mapping controllers and call both service functions
// Test it!

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
	
	@GetMapping("/all/{id}")
	public String getProductCrudById(@PathVariable("id")int id, Model model) {
		try
		{
		Product result = productCRUDService.retrieveById(id);
		model.addAttribute("mypackage", result);
		return "product-test";
		}
		catch (Exception e)
		{
			model.addAttribute("mypackage", e.getMessage());
			return "error-page";
			
		}
	}
	
	@GetMapping("/one") // localhost:8080/product/crud/one?id=1
	public String getProductCrudByIdWithQuestionMark(@RequestParam("id")int id, Model model) {
		try
		{
		Product result = productCRUDService.retrieveById(id);
		model.addAttribute("mypackage", result);
		return "product-test";
		}
		catch (Exception e)
		{
			model.addAttribute("mypackage", e.getMessage());
			return "error-page";
			
		}
	}
	
	@GetMapping("/create") // localhost:8080/product/crud/create
	public String getProductCRUDCreate(Model model) {
		model.addAttribute("product", new Product());
		return "create-product-page";
	}
	
	@PostMapping("/create")
	public String postProductCRUDCreate(@Valid Product product, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			return "create-product-page"; // this will show the same html page 
		}
		else
		{
		
			try
			{
				productCRUDService.create(product.getTitle(), product.getDescription(), product.getPrice(), product.getQuantity());
				return "redirect:/product/crud/all";
			
			}
			catch(Exception e) {
				model.addAttribute("mypackage", e.getMessage());
				return "error-page";
			}
		}
	}
	
	
	@GetMapping("/update/{id}") //  localhost:8080/product/crud/update/{id}
	public String getProductCRUDUpdate(@PathVariable("id")int id, Model model) {
		try {
			Product productForUpdating = productCRUDService.retrieveById(id);
			model.addAttribute("product", productForUpdating);
			model.addAttribute("id", id);
			return "update-product-page";
		}
		catch(Exception e) {
			model.addAttribute("mypackage", e.getMessage());
			return "error-page";
		}
		
	}
	
	@PostMapping("/update/{id}")
	public String postProductCrudCreate(@PathVariable("id")int id, @Valid Product product, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			return "create-product-page"; // this will show the same html page 
		}
		else {
	
			try
			{
				productCRUDService.updateById(id, product.getTitle(), product.getDescription(), product.getPrice(), product.getQuantity());
				return "redirect:/product/crud/all/" + id;
			
			}
			catch(Exception e) {
				model.addAttribute("mypackage", e.getMessage());
				return "error-page";
			}
		}
		
	}
	
	@GetMapping("/delete/{id}") //  localhost:8080/product/crud/delete/2
	public String getProductCRUDDelete(@PathVariable("id")int id, Model model) {
		try {
			productCRUDService.deleteById(id);
			ArrayList<Product> result = productCRUDService.retrieveAll();
			model.addAttribute("mypackage", result);
			return "show-all-product-page";
		}
		catch(Exception e) {
			model.addAttribute("mypackage", e.getMessage());
			return "error-page";
		}
		
	}
	
	
	
	
	
	
	

}
