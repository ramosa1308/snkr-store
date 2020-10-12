package com.snkrstore.product.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {
    private String ticker;
    private String brand;
    private String subBrand;
    private String detail;
    private String style;
    private String colorway;
    private Double retailPrice;
    private LocalDate releaseDate;
    private String description;
}
