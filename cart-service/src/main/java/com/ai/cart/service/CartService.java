package com.ai.cart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.cart.entity.Cart;
import com.ai.cart.repository.CartRepository;

@Service
public class CartService {
	
	@Autowired
	private CartRepository repository;

	public Cart addProduct(Cart product) {
		return repository.save(product);
	}

	public void deleteProducts(String email) {
		repository.deleteByEmail(email);
	}

	public List<Cart> getAllProducts() {
		return repository.findAll();
	}

	public List<Cart> getByMail(String email) {
		
		return repository.getByMail(email);
	}
	

}
