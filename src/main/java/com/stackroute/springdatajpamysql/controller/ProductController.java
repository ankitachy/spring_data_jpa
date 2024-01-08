package com.stackroute.springdatajpamysql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.springdatajpamysql.entity.Product;
import com.stackroute.springdatajpamysql.service.ProductService;


@RestController
public class ProductController {
	
	private ProductService prodService;
	
	@Autowired
	public ProductController(ProductService prodService) {
		this.prodService=prodService;
	}
    
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts(){
		List<Product> product=prodService.getAllProducts();
		return  new ResponseEntity<List<Product>>(product,HttpStatus.OK);
	}
	
	@GetMapping("/products/{price}")
	public ResponseEntity<List<Product>> getAllProductsHavingPriceLessThan(@PathVariable Double price){
		List<Product> product=prodService.getAllProductsHavingPriceLessThan(price);
		return  new ResponseEntity<List<Product>>(product,HttpStatus.OK);
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Long Id){
		Product product=prodService.getProductById(Id);
		return  new ResponseEntity<Product>(product,HttpStatus.OK);
	}
	
	
	@PostMapping("/products")
	public ResponseEntity<Product> saveProduct(@RequestBody Product product){
		Product newProduct=prodService.saveProduct(product);
		return  new ResponseEntity<Product>(newProduct,HttpStatus.OK);
	}
	
	@PutMapping("/products/{id}")
	public ResponseEntity<Product> updateProduct(@RequestBody Product updateProduct,@PathVariable Long Id){
		Product product=prodService.updateProduct(updateProduct,Id);
		return new ResponseEntity<Product>(product,HttpStatus.OK);
	}
	
	@DeleteMapping("/products/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable Long Id){
		String response=prodService.deleteProduct(Id);
		if(!response.isEmpty()) {
			return new ResponseEntity<String>(response,HttpStatus.OK);
		}else {
			return null;
		}
		
	}
	


}
