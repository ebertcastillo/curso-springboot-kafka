package dev.alefiengo.tarea2.mapper;

import dev.alefiengo.tarea2.dto.CategoryRequestDto;
import dev.alefiengo.tarea2.dto.CategoryResponseDto;
import dev.alefiengo.tarea2.entity.Category;

public class CategoryMapper {

    public static Category toEntity(CategoryRequestDto dto) {
        Category category = new Category();
        category.setName(dto.getName());
        category.setDescription(dto.getDescription());
        return category;
    }

    public static CategoryResponseDto toDto(Category category) {
        if (category == null) return null;

        CategoryResponseDto dto = new CategoryResponseDto();
        dto.setId(category.getId());
        dto.setName(category.getName());
        dto.setDescription(category.getDescription());
        return dto;
    }

    public static CategoryResponseDto toDtoWithProducts(Category category) {
        CategoryResponseDto dto = toDto(category);
        if (category != null && category.getProducts() != null) {
            dto.setProducts(category.getProducts().stream()
                    .map(ProductMapper::toDto)
                    .toList());
        }
        return dto;
    }
}
