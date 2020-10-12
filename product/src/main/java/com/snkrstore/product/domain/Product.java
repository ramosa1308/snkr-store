package com.snkrstore.product.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "product")
public class Product implements Serializable {
    @Id
    @NotEmpty
    private String ticker;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;
    @NotBlank
    private String brand;
    @NotBlank
    private String subBrand;
    @NotBlank
    private String detail;
    private String style;
    private String colorway;
    @Positive
    private Double retailPrice;
    private LocalDate releaseDate;
    private String description;
}
