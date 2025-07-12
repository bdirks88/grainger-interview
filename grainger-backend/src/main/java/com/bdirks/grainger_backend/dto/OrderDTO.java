package com.bdirks.grainger_backend.dto;

import java.util.List;
import java.util.UUID;

public class OrderDTO {
  UUID orderId;
  List<ProductDTO> products;

  public List<ProductDTO> getProducts() {
    return this.products;
  }

  public void setProducts(final List<ProductDTO> products) {
    this.products = products;
  }

  public UUID getOrderId() {
    return this.orderId;
  }

  public void setOrderId(final UUID orderId) {
    this.orderId = orderId;
  }
}
