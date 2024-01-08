package com.stackroute.springdatajpamysql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stackroute.springdatajpamysql.entity.Product;

@Repository

public interface ProductRepo extends JpaRepository<Product, Long>{
	@Query("from product where price<giveprice")    
	List<Product> findProductsLessThanPrice(@Param("price")Double givenprice);
	
}
