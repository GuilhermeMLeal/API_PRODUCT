package com.br.ecommerce.domain.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
	List<Product> findByOrderByNameDesc();
	
	@Query(value = "SELECT SUM(price) FROM product ", nativeQuery = true)
	int somaProdutos();
}
 