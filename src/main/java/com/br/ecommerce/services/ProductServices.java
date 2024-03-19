package com.br.ecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.br.ecommerce.domain.product.Mensage;
import com.br.ecommerce.domain.product.Product;
import com.br.ecommerce.domain.product.ProductRepository;

@Service
public class ProductServices {

	@Autowired
	private Mensage mensage;
	
	@Autowired 
	private ProductRepository productRepo;
	
	//Method to register products
	public ResponseEntity<?> registerEntity(Product obj){
	    if(obj.getName().equals("")) {
	        mensage.setMensage("O nome não pode ser nulo");
	        return new ResponseEntity<>(mensage, HttpStatus.BAD_REQUEST);
	    }
	    if(obj.getPrice() == null) {
	        mensage.setMensage("O preço não pode ser nulo");
	        return new ResponseEntity<>(mensage, HttpStatus.BAD_REQUEST);
	    }
	    else {
	        return ResponseEntity.ok(productRepo.save(obj));
	    }
	}
	
	//Method to get all entities in products
	public ResponseEntity<?> getAllEntities(){
		return new ResponseEntity<>(productRepo.findAll(),HttpStatus.OK);
	}

	
}
