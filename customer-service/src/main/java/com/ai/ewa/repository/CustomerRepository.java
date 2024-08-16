package com.ai.ewa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ai.ewa.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long>{

	Optional<Customer> findByEmail(String email);

}
