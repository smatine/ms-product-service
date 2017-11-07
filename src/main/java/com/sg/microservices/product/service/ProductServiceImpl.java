package com.sg.microservices.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sg.microservices.product.dao.IProductsDAO;
import com.sg.microservices.product.entity.Product;


@Component
public class ProductServiceImpl  implements IProductService{

	
	@Autowired
	private IProductsDAO productsdao ;
	
	@Override
	public List<Product> findAllProducts() {
		
		return productsdao.findAllProducts();
	}

	@Override
	public Product findproductbasedonId(int id) {
		
		return  productsdao.findproductbasedonId(id);
	}

	@Override
	public void saveProductDetails(Product productObj) {
		
		productsdao.saveProductDetails(productObj);
		
	}

}
