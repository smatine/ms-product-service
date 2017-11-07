package com.sg.microservices.product.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sg.microservices.product.entity.Product;




@Component
public interface IProductService  {

	public List<Product> findAllProducts();

	public Product findproductbasedonId(int id);

	public void  saveProductDetails(Product productObj);	

}


