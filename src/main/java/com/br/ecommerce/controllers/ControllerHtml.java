package com.br.ecommerce.controllers;

import jakarta.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.br.ecommerce.domain.product.Product;
import com.br.ecommerce.domain.product.ProductRepository;

@Named
@ViewScoped
public class ControllerHtml {

    @Autowired
    private ProductRepository productRepository;

    private Product product = new Product();

    public void salvar() {
        productRepository.save(product);
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
