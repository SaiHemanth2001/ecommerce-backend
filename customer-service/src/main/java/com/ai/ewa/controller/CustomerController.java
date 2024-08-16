package com.ai.ewa.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;


@CrossOrigin(origins = {"http://localhost:3000/"})
@RequestMapping("/customer")
@RestController
@RequiredArgsConstructor
public class CustomerController {

	private final AuthenticationService service;
	
	@PostMapping("/saveCustomer")
	public ResponseEntity<AuthenticationResponse> registerCustomer(@RequestBody RegisterRequest request){
		return ResponseEntity.ok(service.saveCustomer(request));
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<String> authenticate(@RequestBody AuthenticationRequest request){
		return ResponseEntity.ok(service.authenticate(request));
	}
	
}
