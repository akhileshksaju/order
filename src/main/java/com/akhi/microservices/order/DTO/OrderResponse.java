package com.akhi.microservices.order.DTO;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponse {
  private Long id;

  private String orderNumber;
  private String skuCode;
  private BigDecimal price;
  private Integer quatity;

}
