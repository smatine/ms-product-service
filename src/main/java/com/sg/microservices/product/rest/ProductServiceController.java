package com.sg.microservices.product.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.sg.microservices.product.entity.Product;
import com.sg.microservices.product.service.IProductService;

@RestController
@RequestMapping("/products")
@CrossOrigin
public class ProductServiceController {

	private static final Logger logger = LoggerFactory
			.getLogger(ProductServiceController.class);
	
	
	private static final Logger eslogger = LoggerFactory
			.getLogger("es-logger");
	
	@Autowired
	private IProductService productService;
	
	@Autowired
	Tracer tracer;
	
	
	@HystrixCommand(fallbackMethod = "getDefaultProduct", commandKey = "getAllItems", groupKey = "template-product-service", commandProperties = {
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "60000"),
			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "5"), })
	@CrossOrigin
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
	public List<Product> getAllItems() {
		return productService.findAllProducts();
	}

	@HystrixCommand(fallbackMethod = "getDefaultProduct")
	public List<Product>  getDefaultProduct() {

		throw new RuntimeException("No Record found.");
	}


	@RequestMapping(value = "/id/{id}", method = RequestMethod.GET, produces = "application/json")
	@CrossOrigin
	public Product getMenuItem(@PathVariable("id") int id) {
		return productService.findproductbasedonId(id);
	}


	@RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json")
	@CrossOrigin
	public String testService() {
		
		eslogger.info("Inside Product Service Test Method");
		
		eslogger.info("Correlation_id is "  +  tracer.getCurrentSpan().traceIdString());
		
		logger.info("Inside Test Method");
		
		return "ProductService Sucess from port 8084";
		//return "ProductService Sucess from port 8085";
	}


	@RequestMapping(value = "/updatequantity", method = RequestMethod.POST, produces = "application/json")
	@CrossOrigin
	public @ResponseBody void updateQuantity(@RequestBody Product productObj) {

		logger.info("Inside Update Quantity .Recieved Product Obj :"
				+ productObj.getAvailableitems());

		productService.saveProductDetails(productObj);

	}


	@RequestMapping(value = "/saveProduct", method = RequestMethod.POST, produces = "application/json")
	@CrossOrigin
	public @ResponseBody void saveProductDetails(@RequestBody Product productObj) {

		System.out.println("Inside saveProductDetails");

		productService.saveProductDetails(productObj);

	}

}
