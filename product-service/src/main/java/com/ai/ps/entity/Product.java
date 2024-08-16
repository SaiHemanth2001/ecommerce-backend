package com.ai.ps.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="products")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	@Id
	@GeneratedValue
	private long productId;
	@Column(name = "product_name")
	private String name;
	@Column(name = "quantity")
	private long quantity;
	@Column(name = "price")
	private long price;
	@Column(name = "category")
	private String category;
	@Column(name = "description")
	private String description;
	@Column(name = "image")
	private String img;

}
