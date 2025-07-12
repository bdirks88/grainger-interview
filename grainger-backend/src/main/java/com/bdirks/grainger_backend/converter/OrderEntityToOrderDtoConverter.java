package com.bdirks.grainger_backend.converter;

import com.bdirks.grainger_backend.dto.OrderDTO;
import com.bdirks.grainger_backend.dto.ProductDTO;
import com.bdirks.grainger_backend.entity.OrderEntity;
import org.springframework.core.convert.converter.Converter;

import java.util.ArrayList;
import java.util.List;

public class OrderEntityToOrderDtoConverter implements Converter<OrderEntity, OrderDTO> {
  ProductEntityToProductDtoConverter productEntityToProductDtoConverter = new ProductEntityToProductDtoConverter();

  @Override
  public OrderDTO convert(final OrderEntity orderEntity) {
    final OrderDTO orderDTO = new OrderDTO();
    orderDTO.setOrderId(orderEntity.getOrderId());

    final List<ProductDTO> productList = new ArrayList<>();
    orderEntity.getProducts().forEach(productEntity -> {
      productList.add(this.productEntityToProductDtoConverter.convert(productEntity));
    });

    orderDTO.setProducts(productList);
    return orderDTO;
  }
}
