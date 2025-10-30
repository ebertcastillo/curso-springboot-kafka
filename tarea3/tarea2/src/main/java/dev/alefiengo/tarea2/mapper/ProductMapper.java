package dev.alefiengo.tarea2.mapper;

import dev.alefiengo.tarea2.dto.ProductRequestDto;
import dev.alefiengo.tarea2.dto.ProductResponseDto;
import dev.alefiengo.tarea2.entity.Product;
import dev.alefiengo.tarea2.entity.Category;

public class ProductMapper {

    public static Product toEntity(ProductRequestDto dto, Category category) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setStock(dto.getStock());
        product.setCategory(category);
        return product;
    }

    public static ProductResponseDto toDto(Product product) {
        if (product == null) return null;

        ProductResponseDto dto = new ProductResponseDto();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        dto.setStock(product.getStock());

        if (product.getCategory() != null) {
            dto.setCategory(CategoryMapper.toDto(product.getCategory()));
        }

        return dto;
    }

    public static void updateEntityFromDto(ProductRequestDto dto, Product product, Category category) {
        if (product == null) return;

        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setStock(dto.getStock());
        if (category != null) {
            product.setCategory(category);
        }
    }
}