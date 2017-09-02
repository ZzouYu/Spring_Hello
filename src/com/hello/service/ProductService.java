package com.hello.service;

import java.util.List;

import com.model.Product;

public interface ProductService {
    
	public List<Product> findAll();

	public int saveProduct(Product product);

	

	public void saveProductId(int productId, String groupIds);

	public void deleteProduct(Integer id);

	public void deleteProductcatagery(Integer id);

	public List<Product> searchProduct(String groupIds);
}
