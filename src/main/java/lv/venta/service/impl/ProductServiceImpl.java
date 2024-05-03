package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Product;
import lv.venta.repo.IProductRepo;
import lv.venta.service.IProductCRUDService;
import lv.venta.service.IProductFilteringService;

@Service
public class ProductServiceImpl implements IProductCRUDService, IProductFilteringService {
	
	@Autowired
	private IProductRepo productRepo;

	@Override
	public ArrayList<Product> fiterByQuantityThreshold(int treshhold) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Product> fliterByPriceBetween(float minPrice, float maxPrice) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(String title, String description, float price, int quantity) throws Exception {
		if(title == null || description == null || price < 0 || quantity < 0)
			throw new Exception("Problem with input parameters");
			
		Product productFromDB = productRepo.findByTitleAndDescriptionAndPrice(title, description, price);
		if(productFromDB!=null) {
			productFromDB.setQuantity(productFromDB.getQuantity() + quantity); // will change only in back-end layer
			productRepo.save(productFromDB); // will change also in database layer
		}
		else {
			Product productNew = new Product(title, description, price, quantity);
			productRepo.save(productNew);
		}
	}

	@Override
	public ArrayList<Product> retrieveAll() throws Exception {
		if(productRepo.count() == 0) throw new Exception("Product table is empty!");
		
		ArrayList<Product> result = (ArrayList<Product>)productRepo.findAll();
		
		return result;
	}

	@Override
	public Product retrieveById(int id) throws Exception {
		if(id <= 0) throw new Exception("ID should be positive!");
		
		if(productRepo.existsById(id))
			return productRepo.findById(id).get();
		
		throw new Exception("Product with id (" + id + ") not in the table");
	}

	@Override
	public void updateById(int id, String title, String description, float price, int quantity) throws Exception {
		if(id <= 0 || title == null || description == null || price < 0.0f || quantity < 0) throw new Exception("Problems with input!");
		
		Product product = productRepo.findById(id).get();
		product.setPrice(price);
		product.setQuantity(quantity);
		product.setDescription(description);
		product.setTitle(title);
			
		productRepo.save(product);
		
		throw new Exception("Product with id (" + id + ") not in the table");
			
		
	}

	@Override
	public void deleteById(int id) throws Exception {
		if(id <= 0) throw new Exception("ID should be positive!");
		
		Product product = productRepo.findById(id).get();
		productRepo.delete(product);
		
		productRepo.save(product);
		
		throw new Exception("Product with id (" + id + ") not in the table");
		
	}
	
	

}
