package com.bdirks.grainger_backend.controller;

import com.bdirks.grainger_backend.model.Product;
import com.bdirks.grainger_backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/products")
public class ProductController {
  @Autowired
  private ProductRepository productRepository;

  @GetMapping
  public List<Product> getProducts() {
    return this.productRepository.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Product> getProduct(@PathVariable final Long id) {
    return this.productRepository.findById(id).map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public Product createProduct(@RequestBody final Product product) {
    return this.productRepository.save(product);
  }
}
