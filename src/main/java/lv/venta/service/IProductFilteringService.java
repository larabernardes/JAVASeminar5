package lv.venta.service;

import java.util.ArrayList;

import lv.venta.model.Product;

public interface IProductFilteringService {

	
	public abstract ArrayList<Product> fiterByQuantityThreshold(int treshhold) throws Exception;
	
	public abstract ArrayList<Product> fliterByPriceBetween(float minPrice, float maxPrice) throws Exception;

}
