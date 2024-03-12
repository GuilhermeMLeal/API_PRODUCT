package com.br.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.br.ecommerce.domain.product.Product;
import com.br.ecommerce.domain.product.ProductRepository;
import com.br.ecommerce.domain.product.RequestProduct;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductRepository repository;
	

	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts() {
	    List<Product> allProducts = repository.findAll();
	    return ResponseEntity.ok(allProducts);
	}
	
	@PostMapping
	public ResponseEntity registerProduct(@RequestBody @Valid RequestProduct data){
		Product product = new Product(data);
		repository.save(product);
		System.out.println(data);
		return ResponseEntity.ok().build();
	}
}
