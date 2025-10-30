package dev.alefiengo.tarea2.service;

import dev.alefiengo.tarea2.dto.ProductRequestDto;
import dev.alefiengo.tarea2.dto.ProductResponseDto;

import java.util.List;

public interface ProductService {
    List<ProductResponseDto> findAll();
    List<ProductResponseDto> findByNameContaining(String name);
    ProductResponseDto findById(Long id);
    ProductResponseDto create(ProductRequestDto productDto);
    ProductResponseDto update(Long id, ProductRequestDto productDto);
    void delete(Long id);
    boolean existsById(Long id);
    List<ProductResponseDto> findByCategoryId(Long categoryId);
}
