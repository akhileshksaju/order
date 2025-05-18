package com.akhi.microservices.order.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.akhi.microservices.order.DTO.OrderRequest;
import com.akhi.microservices.order.DTO.OrderResponse;
import com.akhi.microservices.order.Esception.IllegalArgumentExceptionaks;
import com.akhi.microservices.order.service.OrderService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
@Slf4j
public class OrderController {

  private final OrderService orderService;

  @PostMapping()
  @ResponseStatus(HttpStatus.ACCEPTED)
  public CompletableFuture<ResponseEntity<OrderResponse>> createProduct(@RequestBody OrderRequest orderRequest) {
    // TODO: process POST request

    log.info(Thread.currentThread().getName());
    CompletableFuture<OrderResponse> future = orderService.placeOrder(orderRequest);
    return future.thenApply(response -> new ResponseEntity<>(response, HttpStatus.ACCEPTED))
        .exceptionally(ex -> {
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        });
  }

}
