package com.ai.cart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ai.cart.entity.Cart;

import jakarta.transaction.Transactional;

public interface CartRepository extends JpaRepository<Cart, Long> {
	@Query(value ="SELECT * FROM cart c where c.customer_email = ?1 ORDER BY c.product_name ASC ", nativeQuery = true)
	List<Cart> getByMail(String email);
	
    @Modifying
	@Transactional
	@Query(value ="DELETE FROM cart c WHERE c.customer_email =?1", nativeQuery = true)
	void deleteByEmail(String email);

}
