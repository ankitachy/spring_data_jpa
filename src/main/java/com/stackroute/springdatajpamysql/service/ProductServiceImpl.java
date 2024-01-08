package com.stackroute.springdatajpamysql.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.springdatajpamysql.entity.Product;
import com.stackroute.springdatajpamysql.repository.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService  {
	private ProductRepo prodRepo;
	
	@Autowired
	public ProductServiceImpl(ProductRepo prodRepo) {
		this.prodRepo=prodRepo;
	}

	@Override
	public List<Product> getAllProducts() {
		Iterable<Product> products=prodRepo.findAll();
		List<Product> product=new ArrayList<>();
		products.forEach(p->{
			Product newProduct=new Product();
			newProduct.setName(p.getName());
			newProduct.setPrice(p.getPrice());
			product.add(newProduct);
		});
		return product;
	}

	@Override
	public List<Product> getAllProductsHavingPriceLessThan(Double price){
		List<Product> product=prodRepo.findProductsLessThanPrice(price);
		return product;
	}

	@Override
	public Product getProductById(Long Id){
		Optional<Product> option=prodRepo.findById(Id);
		Product product=option.get();		
		return product;
	}

	@Override
	public Product saveProduct(Product product){
		Product prod=new Product();
		prod.setName(product.getName());
		prod.setPrice(0);
		prodRepo.save(prod);
		return prod;
	}

	@Override
	public Product updateProduct(Product updateProduct,Long Id){
		Optional<Product> option=prodRepo.findById(Id);
		Product product=option.get();
		product.setId(updateProduct.getId());
		product.setName(updateProduct.getName());
		product.setPrice(updateProduct.getPrice());
		prodRepo.save(product);
		return product;
	}

	@Override
	public String deleteProduct(Long Id) {
		Optional<Product> option=prodRepo.findById(Id);
		Product product=option.get();
		prodRepo.delete(product);
		return "Product Deleted";
	}
    
}
