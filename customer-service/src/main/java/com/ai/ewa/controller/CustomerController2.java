package com.ai.ewa.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ai.ewa.entity.Customer;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = {"http://localhost:3000/"})
@RequestMapping("/customer/c2")
@RestController
@RequiredArgsConstructor
public class CustomerController2 {

	private final AuthenticationService service;
	
	@GetMapping("/all")
	@PreAuthorize("hasAuthority('ADMIN')")
	public List<Customer> getAllCustomers(){
		return service.getAllCustomers();
	}
	
	@GetMapping("/id/{id}")
	public Customer getCustomerById(@PathVariable long id) {
		return service.getById(id);
	}
}
