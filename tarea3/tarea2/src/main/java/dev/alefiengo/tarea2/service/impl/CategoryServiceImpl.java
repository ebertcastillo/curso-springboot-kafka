package dev.alefiengo.tarea2.service.impl;

import dev.alefiengo.tarea2.dto.CategoryRequestDto;
import dev.alefiengo.tarea2.dto.CategoryResponseDto;
import dev.alefiengo.tarea2.dto.ProductResponseDto;
import dev.alefiengo.tarea2.entity.Category;
import dev.alefiengo.tarea2.repository.CategoryRepository;
import dev.alefiengo.tarea2.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public CategoryResponseDto create(CategoryRequestDto categoryDto) {
        // Crear entidad
        Category category = new Category();
        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());

        // Guardar en BD
        Category savedCategory = categoryRepository.save(category);

        // Crear response
        CategoryResponseDto response = new CategoryResponseDto();
        response.setId(savedCategory.getId());
        response.setName(savedCategory.getName());
        response.setDescription(savedCategory.getDescription());

        return response;
    }

    @Override
    public List<CategoryResponseDto> findAll() {
        return List.of(); // Implementar luego
    }

    @Override
    public CategoryResponseDto findById(Long id) {
        return null; // Implementar luego
    }

    @Override
    public CategoryResponseDto update(Long id, CategoryRequestDto categoryDto) {
        return null; // Implementar luego
    }

    @Override
    public void delete(Long id) {
        // Implementar luego
    }

    @Override
    public List<ProductResponseDto> findProductsByCategoryId(Long id) {
        return List.of(); // Implementar luego
    }
}
