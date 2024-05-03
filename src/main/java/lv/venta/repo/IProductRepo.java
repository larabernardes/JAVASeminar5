package lv.venta.repo;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Product;

public interface IProductRepo extends CrudRepository<Product, Integer> {
	
	// public abstract by default because this is an interface
	Product findByTitleDescriptionAndPrice(String title, String description, float price);

}
