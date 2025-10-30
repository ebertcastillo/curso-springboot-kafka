package dev.alefiengo.tarea2.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class CategoryResponseDto {
    private Long id;
    private String name;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<ProductResponseDto> products;

    // Constructor por defecto
    public CategoryResponseDto() {
    }

    // Constructor con parámetros básicos
    public CategoryResponseDto(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    // Constructor completo
    public CategoryResponseDto(Long id, String name, String description,
                               LocalDateTime createdAt, LocalDateTime updatedAt,
                               List<ProductResponseDto> products) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.products = products;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<ProductResponseDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductResponseDto> products) {
        this.products = products;
    }

    // Método toString()
    @Override
    public String toString() {
        return "CategoryResponseDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", products=" + (products != null ? products.size() : 0) + " items" +
                '}';
    }

    // Método equals()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoryResponseDto that = (CategoryResponseDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(createdAt, that.createdAt) &&
                Objects.equals(updatedAt, that.updatedAt) &&
                Objects.equals(products, that.products);
    }

    // Método hashCode()
    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, createdAt, updatedAt, products);
    }

    // Builder Pattern (opcional pero recomendado)
    public static CategoryResponseDtoBuilder builder() {
        return new CategoryResponseDtoBuilder();
    }

    public static class CategoryResponseDtoBuilder {
        private Long id;
        private String name;
        private String description;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        private List<ProductResponseDto> products;

        public CategoryResponseDtoBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public CategoryResponseDtoBuilder name(String name) {
            this.name = name;
            return this;
        }

        public CategoryResponseDtoBuilder description(String description) {
            this.description = description;
            return this;
        }

        public CategoryResponseDtoBuilder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public CategoryResponseDtoBuilder updatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public CategoryResponseDtoBuilder products(List<ProductResponseDto> products) {
            this.products = products;
            return this;
        }

        public CategoryResponseDto build() {
            return new CategoryResponseDto(id, name, description, createdAt, updatedAt, products);
        }
    }

    // Métodos de conveniencia
    public boolean hasProducts() {
        return products != null && !products.isEmpty();
    }

    public int getProductsCount() {
        return products != null ? products.size() : 0;
    }
}
