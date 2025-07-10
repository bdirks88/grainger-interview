package com.bdirks.grainger_backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "product")
public class ProductEntity {
  public ProductEntity() {
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(unique = true, nullable = false, updatable = false)
  private UUID productId = UUID.randomUUID();

  private String name;

  public long getId() {
    return this.id;
  }

  public void setId(final long id) {
    this.id = id;
  }

  public UUID getProductId() {
    return this.productId;
  }

  public String getName() {
    return this.name;
  }

  public void setName(final String name) {
    this.name = name;
  }
}
