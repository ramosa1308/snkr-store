package com.snkrstore.product.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {
    private UUID uuid;
    private String name;
    private String style;
    private String colorway;
    private Double retailPrice;
    private LocalDate releaseDate;
    private String description;
}
