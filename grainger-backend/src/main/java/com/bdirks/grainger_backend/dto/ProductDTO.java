package com.bdirks.grainger_backend.dto;

import java.util.UUID;

public class ProductDTO {
  private UUID productId;
  private String name;

  public UUID getProductId() {
    return this.productId;
  }

  public void setProductId(final UUID productId) {
    this.productId = productId;
  }

  public String getName() {
    return this.name;
  }

  public void setName(final String name) {
    this.name = name;
  }
}
