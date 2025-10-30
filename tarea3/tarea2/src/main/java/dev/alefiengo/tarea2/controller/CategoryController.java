package dev.alefiengo.tarea2.controller;

import dev.alefiengo.tarea2.dto.ApiResponse;
import dev.alefiengo.tarea2.dto.CategoryRequestDto;
import dev.alefiengo.tarea2.dto.CategoryResponseDto;
import dev.alefiengo.tarea2.dto.ProductResponseDto;
import dev.alefiengo.tarea2.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @GetMapping
    public ResponseEntity<ApiResponse<List<CategoryResponseDto>>> getAllCategories() {
        List<CategoryResponseDto> categories = categoryService.findAll();
        ApiResponse<List<CategoryResponseDto>> response = new ApiResponse<>(
                "success", HttpStatus.OK.value(), "Categorías obtenidas exitosamente",
                categories, "/api/categories"
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CategoryResponseDto>> getCategoryById(@PathVariable Long id) {
        CategoryResponseDto category = categoryService.findById(id);
        ApiResponse<CategoryResponseDto> response = new ApiResponse<>(
                "success", HttpStatus.OK.value(), "Categoría obtenida exitosamente",
                category, "/api/categories/" + id
        );
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<CategoryResponseDto>> createCategory(
            @Valid @RequestBody CategoryRequestDto categoryDto) {
        CategoryResponseDto createdCategory = categoryService.create(categoryDto);
        ApiResponse<CategoryResponseDto> response = new ApiResponse<>(
                "success", HttpStatus.CREATED.value(), "Categoría creada exitosamente",
                createdCategory, "/api/categories"
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<CategoryResponseDto>> updateCategory(
            @PathVariable Long id, @Valid @RequestBody CategoryRequestDto categoryDto) {
        CategoryResponseDto updatedCategory = categoryService.update(id, categoryDto);
        ApiResponse<CategoryResponseDto> response = new ApiResponse<>(
                "success", HttpStatus.OK.value(), "Categoría actualizada exitosamente",
                updatedCategory, "/api/categories/" + id
        );
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteCategory(@PathVariable Long id) {
        categoryService.delete(id);
        ApiResponse<Void> response = new ApiResponse<>(
                "success", HttpStatus.NO_CONTENT.value(), "Categoría eliminada exitosamente",
                null, "/api/categories/" + id
        );
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
    }

    @GetMapping("/{id}/products")
    public ResponseEntity<ApiResponse<List<ProductResponseDto>>> getProductsByCategory(@PathVariable Long id) {
        List<ProductResponseDto> products = categoryService.findProductsByCategoryId(id);
        ApiResponse<List<ProductResponseDto>> response = new ApiResponse<>(
                "success", HttpStatus.OK.value(), "Productos de la categoría obtenidos exitosamente",
                products, "/api/categories/" + id + "/products"
        );
        return ResponseEntity.ok(response);
    }


}
