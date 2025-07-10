package com.bdirks.grainger_backend.repository;

import com.bdirks.grainger_backend.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
  @Query(
      value = "SELECT * FROM product WHERE product_id = :product_id",
      nativeQuery = true)
  Optional<ProductEntity> findByProductId(@Param("product_id") UUID productId);
}
