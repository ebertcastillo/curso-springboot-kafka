package dev.alefiengo.tarea2.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class ProductResponseDto {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer stock;
    private CategoryResponseDto category;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Constructor por defecto
    public ProductResponseDto() {
    }

    // Constructor con parámetros básicos
    public ProductResponseDto(Long id, String name, String description, BigDecimal price, Integer stock) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    // Constructor completo
    public ProductResponseDto(Long id, String name, String description, BigDecimal price, Integer stock,
                              CategoryResponseDto category, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.category = category;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public CategoryResponseDto getCategory() {
        return category;
    }

    public void setCategory(CategoryResponseDto category) {
        this.category = category;
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

    // Método toString()
    @Override
    public String toString() {
        return "ProductResponseDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", category=" + (category != null ? category.getName() : "null") +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    // Método equals()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductResponseDto that = (ProductResponseDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(price, that.price) &&
                Objects.equals(stock, that.stock) &&
                Objects.equals(category, that.category) &&
                Objects.equals(createdAt, that.createdAt) &&
                Objects.equals(updatedAt, that.updatedAt);
    }

    // Método hashCode()
    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price, stock, category, createdAt, updatedAt);
    }

    // Builder Pattern
    public static ProductResponseDtoBuilder builder() {
        return new ProductResponseDtoBuilder();
    }

    public static class ProductResponseDtoBuilder {
        private Long id;
        private String name;
        private String description;
        private BigDecimal price;
        private Integer stock;
        private CategoryResponseDto category;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        public ProductResponseDtoBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public ProductResponseDtoBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ProductResponseDtoBuilder description(String description) {
            this.description = description;
            return this;
        }

        public ProductResponseDtoBuilder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        public ProductResponseDtoBuilder stock(Integer stock) {
            this.stock = stock;
            return this;
        }

        public ProductResponseDtoBuilder category(CategoryResponseDto category) {
            this.category = category;
            return this;
        }

        public ProductResponseDtoBuilder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public ProductResponseDtoBuilder updatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public ProductResponseDto build() {
            return new ProductResponseDto(id, name, description, price, stock, category, createdAt, updatedAt);
        }
    }

    // Métodos de conveniencia
    public boolean hasCategory() {
        return category != null;
    }

    public boolean hasDescription() {
        return description != null && !description.trim().isEmpty();
    }

    public boolean isInStock() {
        return stock != null && stock > 0;
    }

    public boolean isOutOfStock() {
        return stock != null && stock == 0;
    }

    public String getStockStatus() {
        if (stock == null) return "Unknown";
        return stock > 0 ? "In Stock (" + stock + ")" : "Out of Stock";
    }

    public BigDecimal getTotalValue() {
        if (price == null || stock == null) return BigDecimal.ZERO;
        return price.multiply(BigDecimal.valueOf(stock));
    }
}