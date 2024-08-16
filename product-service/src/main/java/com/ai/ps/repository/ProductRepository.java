package com.ai.ps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ai.ps.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	@Query(value=" SELECT * FROM products p where p.category = ?1", nativeQuery = true)
	List<Product> findByCategory(String category);

	@Query(value ="SELECT * FROM products p where p.product_name = ?1", nativeQuery = true)
	Product getPdt(String name);

}
