package com.ai.ewa.controller;

import java.util.List;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ai.ewa.config.JwtService;
import com.ai.ewa.entity.Customer;
import com.ai.ewa.entity.Role;
import com.ai.ewa.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
	
	private final CustomerRepository repository;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;
	private final AuthenticationManager authenticationManager;

	public AuthenticationResponse saveCustomer(RegisterRequest request) {
		
		var customer = Customer
				.builder()
				.firstName(request.getFirstName())
				.lastName(request.getLastName())
				.email(request.getEmail())
				.password(passwordEncoder.encode(request.getPassword()))
				.location(request.getLocation())
				.role(Role.USER)
				.build();
		repository.save(customer);
		var jwtToken = jwtService.generateToken(customer);
		return AuthenticationResponse.builder().token(jwtToken).build();
		
		
	}

	public String authenticate(AuthenticationRequest request) {
		
		authenticationManager
			.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
		var customer = repository.findByEmail(request.getEmail()).orElseThrow(()->new UsernameNotFoundException("customer not found"));
		var jwtToken = jwtService.generateToken(customer);
		
		return jwtToken;
	}

	public List<Customer> getAllCustomers() {
		return repository.findAll();
	}

	public Customer getById(long id) {
		return repository.findById(id).orElseThrow();
	}
	
	

}
