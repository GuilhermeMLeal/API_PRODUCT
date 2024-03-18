package com.br.ecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.br.ecommerce.domain.product.Mensage;
import com.br.ecommerce.domain.product.ProductRepository;

@Service
public class ProductServices {

	@Autowired
	private Mensage mensage;
	
	@Autowired 
	private ProductRepository productRepo;
	
	//public ResponseEntity<?>register_product(){
		
	//}
	
}
