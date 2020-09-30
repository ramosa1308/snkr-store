package com.snkrstore.product.services;

import com.snkrstore.product.web.model.ProductDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public ProductDto getProductById(UUID productId) {
        return ProductDto.builder().id(UUID.randomUUID())
                .name("Jordan 1 Retro High Satin Snake Chicago (W)")
                .colorway("GYM RED/WHITE-BLACK")
                .description("Jordan Brand added luxe materials to a classic silhouette with the release of the Jordan 1 Retro High Satin Snake Chicago (W). This release combines Jumpman’s ongoing Satin 1 concept with the colorway that started it all.\n\n" +
                        "This Jordan 1 consists of a white and red leather upper with red satin tongue and liner. Black faux snakeskin leather detailing appears on the upper as well. A white midsole, red outsole, and a traditional Jordan Wings graphic on the ankle completes the design. These sneakers released in August of 2020 and retailed for $170.")
                .retailPrice(170.0)
                .releaseDate(LocalDate.of(2020,8, 6))
                .style("MAN")
                .build();
    }

    @Override
    public ProductDto saveProductDto(ProductDto productDto) {
        return ProductDto.builder()
                .id(UUID.randomUUID())
                .build();
    }
}
