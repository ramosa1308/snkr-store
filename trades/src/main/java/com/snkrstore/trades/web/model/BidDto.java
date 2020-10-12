package com.snkrstore.trades.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BidDto {
    private Long id;
    private String productId;
    private String userId;
    private Float size;
    private Float bidPrice;
    private LocalDate expiration;
    private String status;
    private String product_condition;
}
