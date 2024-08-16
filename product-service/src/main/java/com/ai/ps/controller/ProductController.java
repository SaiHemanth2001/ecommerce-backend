package com.ai.ps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ai.ps.entity.Product;
import com.ai.ps.service.ProductService;

import lombok.RequiredArgsConstructor;
@CrossOrigin(origins = {"http://localhost:3000/"})
@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product) {
		return service.addProduct(product);
	}
	
	@GetMapping("/getByName/{name}")
	public Product getProduct(@PathVariable String name) {
		return service.getProduct(name);
	}
	
	@GetMapping("/all")
	public List<Product> getAllProducts(){
		return service.getAllProducts();
	}
	
	@GetMapping("/getById/{id}")
	public Product getById(@PathVariable long id) throws Exception{
		return service.getById(id);
	}
	@PutMapping("/updateProduct/{id}")
	public Product update(@PathVariable long id, @RequestBody Product product) throws Exception {
		return service.updateItem(id,product);
	}
	
	@GetMapping("/getByCategory/{category}")
	public List<Product> getByCategory(@PathVariable String category){
		return service.getByCategory(category);
	}
 
}
