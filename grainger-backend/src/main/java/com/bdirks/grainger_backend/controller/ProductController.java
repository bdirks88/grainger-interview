package com.bdirks.grainger_backend.controller;

import com.bdirks.grainger_backend.converter.ProductDtoToProductEntityConverter;
import com.bdirks.grainger_backend.converter.ProductEntityToProductDtoConverter;
import com.bdirks.grainger_backend.dto.ProductDTO;
import com.bdirks.grainger_backend.entity.ProductEntity;
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

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/products")
public class ProductController {
  @Autowired
  private ProductRepository productRepository;

  private final ProductDtoToProductEntityConverter productDtoToProductEntityConverter = new ProductDtoToProductEntityConverter();
  private final ProductEntityToProductDtoConverter productEntityToProductDtoConverter = new ProductEntityToProductDtoConverter();

  @GetMapping
  public List<ProductDTO> getProducts() {
    final List<ProductEntity> productEntities = this.productRepository.findAll();
    final List<ProductDTO> productDTOList = new ArrayList<>();
    productEntities.forEach(
        productEntity -> productDTOList.add(this.productEntityToProductDtoConverter.convert(productEntity)));
    return productDTOList;
  }

  @GetMapping("/{productId}")
  public ResponseEntity<ProductDTO> getProduct(@PathVariable final UUID productId) {
    return this.productRepository.findByProductId(productId)
        .map(productEntity -> ResponseEntity.ok(this.productEntityToProductDtoConverter.convert(productEntity)))
        .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public ProductDTO createProduct(@RequestBody final ProductDTO productDTO) {
    final ProductEntity productEntity = this.productDtoToProductEntityConverter.convert(productDTO);
    return this.productEntityToProductDtoConverter.convert(this.productRepository.save(productEntity));
  }
}
