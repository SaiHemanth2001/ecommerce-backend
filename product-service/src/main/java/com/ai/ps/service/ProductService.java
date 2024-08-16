package com.ai.ps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.ps.entity.Product;
import com.ai.ps.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	public Product addProduct(Product product) {
		return repository.save(product);
	}

	public List<Product> getAllProducts() {
		return repository.findAll();
	}

	public Product getById(long id) throws Exception {
		return repository.findById(id).orElseThrow(()->new Exception("Product not found"));
	}

	public List<Product> getByCategory(String category) {
		return repository.findByCategory(category);
	}

	public Product updateItem(long id, Product product) throws Exception {
		Product existingProduct = repository.findById(id).orElseThrow(()->new Exception("Product not found"));
		existingProduct.setName(product.getName());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setCategory(product.getCategory());
		existingProduct.setQuantity(product.getQuantity());
		existingProduct.setDescription(product.getDescription());
		existingProduct.setImg(product.getImg());
		repository.save(existingProduct);
		return existingProduct;
	}
	
	public Product getProduct(String name) {
		return repository.getPdt(name);
	}
	
	
}
