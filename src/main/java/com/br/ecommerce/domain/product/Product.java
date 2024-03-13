package com.br.ecommerce.domain.product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="product")
@Entity(name="product")
@EqualsAndHashCode(of="id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor 
public class Product {
	
	@Id @GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	
	private String name;
	
	private BigDecimal price;
	
	public Product(RequestProduct request) {
		this.name = request.name();
		this.price = request.price();
	}
	
}
