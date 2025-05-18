package com.akhi.microservices.order.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import com.akhi.microservices.order.DTO.OrderRequest;
import com.akhi.microservices.order.DTO.OrderResponse;
import com.akhi.microservices.order.model.Order;
import com.akhi.microservices.order.repository.OrderRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

  public final OrderRepository orderRepository;

  @Async("orderExecutor")
  public CompletableFuture<OrderResponse> placeOrder(OrderRequest orderRequest) {

    Order order = Order.builder().id(orderRequest.getId())
        .orderNumber(orderRequest.getOrderNumber())
        .skuCode(orderRequest.getSkuCode())
        .price(orderRequest.getPrice())
        .quantity(orderRequest.getQuantity())
        .build();

    log.info(Thread.currentThread().getName());

    orderRepository.findBySkuCode(orderRequest.getSkuCode()).ifPresent(e -> {
      throw new com.akhi.microservices.order.Esception.IllegalArgumentExceptionaks("item already exist");
    });

    Order savedValue = orderRepository.save(order);

    log.info(Thread.currentThread().isAlive() + "");

    return CompletableFuture.completedFuture(OrderResponse.builder().id(savedValue.getId())
        .orderNumber(savedValue.getOrderNumber())
        .skuCode(savedValue.getSkuCode())
        .price(savedValue.getPrice())
        .quatity(savedValue.getQuantity())
        .build());

  }

}
