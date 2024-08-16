package com.ai.cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ai.cart.entity.Cart;
import com.ai.cart.service.CartService;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = {"http://localhost:3000/"})
@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {
	
	@Autowired
	private CartService service;
	
	@PostMapping("/addProduct")
	public Cart addProduct(@RequestBody Cart product) {
		return service.addProduct(product);
	}
	@GetMapping("/getByMail/{email}")
	public List<Cart> getBymail(@PathVariable String email){
		return service.getByMail(email);
	}
	
	@GetMapping("/all")
	public List<Cart> getAllProducts(){
		return service.getAllProducts();
	}
	
	
	@DeleteMapping("/delProducts/{email}")
	public String delProducts(@PathVariable String email) {
		service.deleteProducts(email);
		return "Cart Cleared";
	}

}
