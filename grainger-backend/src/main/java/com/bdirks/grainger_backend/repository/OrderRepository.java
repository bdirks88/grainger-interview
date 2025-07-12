package com.bdirks.grainger_backend.repository;

import com.bdirks.grainger_backend.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, UUID> {
  @Query(value = "SELECT o FROM OrderEntity o JOIN FETCH o.products WHERE o.orderId = :orderId")
  Optional<OrderEntity> findByOrderIdWithProducts(@Param("orderId") UUID orderId);
}

