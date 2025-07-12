package com.bdirks.grainger_backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "orders")
public class OrderEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private final UUID orderId = UUID.randomUUID();

  @ManyToMany
  @JoinTable(
      name = "order_product",  // name of the join table
      joinColumns = @JoinColumn(name = "order_id"),
      inverseJoinColumns = @JoinColumn(name = "product_id")
  )
  private List<ProductEntity> products = new ArrayList<>();

  public void setProducts(final List<ProductEntity> products) {
    this.products.addAll(products);
  }

  public UUID getOrderId() {
    return this.orderId;
  }

  public List<ProductEntity> getProducts() {
    return this.products;
  }
}
