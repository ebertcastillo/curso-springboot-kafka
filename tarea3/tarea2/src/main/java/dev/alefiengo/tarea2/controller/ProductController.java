package dev.alefiengo.tarea2.controller;

import dev.alefiengo.tarea2.dto.ApiResponse;
import dev.alefiengo.tarea2.dto.ProductRequestDto;
import dev.alefiengo.tarea2.dto.ProductResponseDto;
import dev.alefiengo.tarea2.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<ProductResponseDto>>> getAllProducts(
            @RequestParam(required = false) String name) {

        List<ProductResponseDto> products;
        if (name != null && !name.isEmpty()) {
            products = productService.findByNameContaining(name);
        } else {
            products = productService.findAll();
        }

        ApiResponse<List<ProductResponseDto>> response = new ApiResponse<>(
                "success", HttpStatus.OK.value(), "Productos obtenidos exitosamente",
                products, "/api/products"
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ProductResponseDto>> getProductById(@PathVariable Long id) {
        ProductResponseDto product = productService.findById(id);
        ApiResponse<ProductResponseDto> response = new ApiResponse<>(
                "success", HttpStatus.OK.value(), "Producto obtenido exitosamente",
                product, "/api/products/" + id
        );
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ProductResponseDto>> createProduct(
            @Valid @RequestBody ProductRequestDto productDto) {
        ProductResponseDto createdProduct = productService.create(productDto);
        ApiResponse<ProductResponseDto> response = new ApiResponse<>(
                "success", HttpStatus.CREATED.value(), "Producto creado exitosamente",
                createdProduct, "/api/products"
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ProductResponseDto>> updateProduct(
            @PathVariable Long id, @Valid @RequestBody ProductRequestDto productDto) {
        ProductResponseDto updatedProduct = productService.update(id, productDto);
        ApiResponse<ProductResponseDto> response = new ApiResponse<>(
                "success", HttpStatus.OK.value(), "Producto actualizado exitosamente",
                updatedProduct, "/api/products/" + id
        );
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteProduct(@PathVariable Long id) {
        productService.delete(id);
        ApiResponse<Void> response = new ApiResponse<>(
                "success", HttpStatus.NO_CONTENT.value(), "Producto eliminado exitosamente",
                null, "/api/products/" + id
        );
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
    }
}