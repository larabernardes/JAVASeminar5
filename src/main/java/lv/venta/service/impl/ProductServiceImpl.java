package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import lv.venta.model.Product;
import lv.venta.service.IProductCRUDService;
import lv.venta.service.IProductFilteringService;

@Service
public class ProductServiceImpl implements IProductCRUDService, IProductFilteringService {

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Product> retrieveAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product retrieveById(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateById(int id, String title, String description, float price, int quantity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(int id) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
