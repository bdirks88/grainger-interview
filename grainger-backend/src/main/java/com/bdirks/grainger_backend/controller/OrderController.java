package com.bdirks.grainger_backend.controller;

import com.bdirks.grainger_backend.converter.OrderEntityToOrderDtoConverter;
import com.bdirks.grainger_backend.dto.OrderDTO;
import com.bdirks.grainger_backend.entity.OrderEntity;
import com.bdirks.grainger_backend.entity.ProductEntity;
import com.bdirks.grainger_backend.repository.OrderRepository;
import com.bdirks.grainger_backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {

  OrderEntityToOrderDtoConverter orderEntityToOrderDtoConverter = new OrderEntityToOrderDtoConverter();

  @Autowired
  private OrderRepository orderRepository;

  @Autowired
  private ProductRepository productRepository;

  @GetMapping("/{orderId}")
  public ResponseEntity<OrderDTO> getOrderWithProducts(@PathVariable final UUID orderId) {
    return this.orderRepository.findByOrderIdWithProducts(orderId)
        .map(orderEntity -> ResponseEntity.ok(this.orderEntityToOrderDtoConverter.convert(orderEntity)))
        .orElse(ResponseEntity.notFound().build());
  }

  @GetMapping()
  public List<OrderDTO> getOrders() {
    final List<OrderEntity> orderEntities = this.orderRepository.findAll();
    final List<OrderDTO> orderDTOList = new ArrayList<>();

    orderEntities.forEach(orderEntity -> orderDTOList.add(this.orderEntityToOrderDtoConverter.convert(orderEntity)));

    return orderDTOList;
  }

  @PostMapping()
  public OrderDTO createOrder(final @RequestBody OrderDTO orderDTO) {
    final OrderEntity orderEntity = new OrderEntity();
    final List<ProductEntity> productEntities = new ArrayList<>();

    orderDTO.getProducts().forEach(productDTO -> {
      final Optional<ProductEntity> byProductId = this.productRepository.findByProductId(productDTO.getProductId());
      byProductId.ifPresent(productEntities::add);
    });

    orderEntity.setProducts(productEntities);

    final OrderEntity savedOrderEntity = this.orderRepository.save(orderEntity);
    return this.orderEntityToOrderDtoConverter.convert(savedOrderEntity);
  }
}

