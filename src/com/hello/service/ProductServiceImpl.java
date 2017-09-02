package com.hello.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hello.dao.ProductDao;
import com.model.Product;

@Service("productServiceImpl")
public class ProductServiceImpl implements ProductService{
	@Resource(name="productDaoImpl")
	private ProductDao productDao;
	@Resource(name="productDaoImpl")
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return this.productDao.findAll();
	}

	@Override
	public int saveProduct(Product product) {
		return  productDao. saveProduct(product);
	}


	

	@Override
	public void saveProductId(int productId, String groupIds) {
		productDao. saveProductId( productId,groupIds);
		
	}

	@Override
	public void deleteProduct(Integer id) {
		productDao. deleteProduct( id);
		
	}

	@Override
	public void deleteProductcatagery(Integer id) {
		productDao. deleteProductcatagery( id);
		
	}

	@Override
	public List<Product> searchProduct(String groupIds) {
		return productDao. searchProduct(groupIds);
	}
    
	
}
