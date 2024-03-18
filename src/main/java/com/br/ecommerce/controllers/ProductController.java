package com.br.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;
import com.br.ecommerce.domain.product.Product;
import com.br.ecommerce.domain.product.ProductRepository;
import com.br.ecommerce.domain.product.RequestProduct;

import jakarta.transaction.Transactional;
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
	
	@GetMapping("/names")
	public List<Product> orderNames(){
		return repository.findByOrderByNameDesc();
	}
	
	@GetMapping("/soma")
	public ResponseEntity retorneSomaProducts() {
		return ResponseEntity.ok(repository.somaProdutos());
	}
	
	@PostMapping
	public ResponseEntity registerProduct(@RequestBody @Valid RequestProduct data){
		Product product = new Product(data);
		repository.save(product);
		return ResponseEntity.ok(product);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity updateProduct(@PathVariable String id, @RequestBody @Valid RequestProduct data) {
	    Optional<Product> productOptional = repository.findById(id);
	    if (productOptional.isPresent()) {
	        Product product = productOptional.get();
	        product.setName(data.name());
	        product.setPrice(data.price());
	        repository.save(product);
	        return ResponseEntity.ok(product);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}

	
	@DeleteMapping("/{id}")
	public ResponseEntity deleteProduct(@PathVariable String id) {
		try {
	        repository.deleteById(id);
	        return ResponseEntity.noContent().build();
	    } catch (EmptyResultDataAccessException e) {
	        return ResponseEntity.notFound().build();
	    }
	}

	@GetMapping("/{id}")
	public ResponseEntity getProduct(@PathVariable String id) {
	    Optional<Product> productOptional = repository.findById(id);
	    if (productOptional.isPresent()) {
	        Product product = productOptional.get();
	        return ResponseEntity.ok(product);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	
	@GetMapping("/count_products")
	public ResponseEntity countproduct() {
		return ResponseEntity.ok(repository.count());
	}
}
