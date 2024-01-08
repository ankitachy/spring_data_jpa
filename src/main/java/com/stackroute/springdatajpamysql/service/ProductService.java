package com.stackroute.springdatajpamysql.service;

import java.util.List;

import com.stackroute.springdatajpamysql.entity.Product;

public interface ProductService {
 
	List<Product> getAllProducts();
	List<Product> getAllProductsHavingPriceLessThan(Double price);
	Product getProductById(Long Id);
	Product saveProduct(Product product);
	Product updateProduct(Product updateProduct,Long Id);
	String deleteProduct(Long Id);
}
