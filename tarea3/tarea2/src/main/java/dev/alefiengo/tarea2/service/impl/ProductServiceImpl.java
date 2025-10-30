package dev.alefiengo.tarea2.service.impl;

import dev.alefiengo.tarea2.dto.ProductRequestDto;
import dev.alefiengo.tarea2.dto.ProductResponseDto;
import dev.alefiengo.tarea2.entity.Product;
import dev.alefiengo.tarea2.entity.Category;
import dev.alefiengo.tarea2.exception.ResourceNotFoundException;
import dev.alefiengo.tarea2.mapper.ProductMapper;
import dev.alefiengo.tarea2.repository.ProductRepository;
import dev.alefiengo.tarea2.repository.CategoryRepository;
import dev.alefiengo.tarea2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    // REMOVEMOS la inyección de ProductMapper ya que ahora es estático
    // @Autowired
    // private ProductMapper productMapper;

    @Override
    @Transactional(readOnly = true)
    public List<ProductResponseDto> findAll() {
        return productRepository.findAll().stream()
                .map(ProductMapper::toDto) // Cambio a método estático
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductResponseDto> findByNameContaining(String name) {
        return productRepository.findByNameContainingIgnoreCase(name).stream()
                .map(ProductMapper::toDto) // Cambio a método estático
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public ProductResponseDto findById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado con id: " + id));
        return ProductMapper.toDto(product); // Cambio a método estático
    }

    @Override
    public ProductResponseDto create(ProductRequestDto productDto) {
        // Buscar la categoría si se proporciona categoryId
        Category category = null;
        if (productDto.getCategoryId() != null) {
            category = categoryRepository.findById(productDto.getCategoryId())
                    .orElseThrow(() -> new ResourceNotFoundException("Categoría no encontrada con id: " + productDto.getCategoryId()));
        }

        Product product = ProductMapper.toEntity(productDto, category); // Cambio a método estático
        Product savedProduct = productRepository.save(product);
        return ProductMapper.toDto(savedProduct); // Cambio a método estático
    }

    @Override
    public ProductResponseDto update(Long id, ProductRequestDto productDto) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado con id: " + id));

        // Buscar la categoría si se proporciona categoryId
        Category category = null;
        if (productDto.getCategoryId() != null) {
            category = categoryRepository.findById(productDto.getCategoryId())
                    .orElseThrow(() -> new ResourceNotFoundException("Categoría no encontrada con id: " + productDto.getCategoryId()));
        }

        ProductMapper.updateEntityFromDto(productDto, existingProduct, category); // Cambio a método estático
        Product updatedProduct = productRepository.save(existingProduct);
        return ProductMapper.toDto(updatedProduct); // Cambio a método estático
    }

    @Override
    public void delete(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ResourceNotFoundException("Producto no encontrado con id: " + id);
        }
        productRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsById(Long id) {
        return productRepository.existsById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductResponseDto> findByCategoryId(Long categoryId) {
        // Verificar que la categoría existe
        if (!categoryRepository.existsById(categoryId)) {
            throw new ResourceNotFoundException("Categoría no encontrada con id: " + categoryId);
        }

        return productRepository.findByCategoryId(categoryId).stream()
                .map(ProductMapper::toDto) // Cambio a método estático
                .toList();
    }
}
