package dev.alefiengo.tarea2.service;

import dev.alefiengo.tarea2.dto.CategoryRequestDto;
import dev.alefiengo.tarea2.dto.CategoryResponseDto;
import dev.alefiengo.tarea2.dto.ProductResponseDto;
import java.util.List;

public interface CategoryService {
    List<CategoryResponseDto> findAll();
    CategoryResponseDto findById(Long id);
    CategoryResponseDto create(CategoryRequestDto categoryDto);
    CategoryResponseDto update(Long id, CategoryRequestDto categoryDto);
    void delete(Long id);
    List<ProductResponseDto> findProductsByCategoryId(Long id);
}
