package com.bdirks.grainger_backend.converter;

import com.bdirks.grainger_backend.dto.ProductDTO;
import com.bdirks.grainger_backend.entity.ProductEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProductEntityToProductDtoConverter implements Converter<ProductEntity, ProductDTO> {
  @Override
  public ProductDTO convert(final ProductEntity productEntity) {
    final ProductDTO dto = new ProductDTO();
    dto.setProductId(productEntity.getProductId());
    dto.setName(productEntity.getName());
    return dto;
  }
}
