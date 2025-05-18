package com.akhi.microservices.order.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akhi.microservices.order.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

  Optional<Order> findBySkuCode(String skuCode);

}