package com.bdirks.grainger_backend.converter;

import com.bdirks.grainger_backend.dto.ProductDTO;
import com.bdirks.grainger_backend.entity.ProductEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProductDtoToProductEntityConverter implements Converter<ProductDTO, ProductEntity> {
  @Override
  public ProductEntity convert(final ProductDTO dto) {
    final ProductEntity productEntity = new ProductEntity();
    productEntity.setName(dto.getName());
    return productEntity;
  }
}
