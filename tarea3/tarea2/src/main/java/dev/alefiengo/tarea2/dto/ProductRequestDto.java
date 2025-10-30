package dev.alefiengo.tarea2.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Objects;

public class ProductRequestDto {

    @NotBlank(message = "{product.name.notblank}")
    private String name;

    @Size(max = 500, message = "{product.description.size}")
    private String description;

    @NotNull(message = "{product.price.notnull}")
    @DecimalMin(value = "0.0", inclusive = false, message = "{product.price.positive}")
    private BigDecimal price;

    @NotNull(message = "{product.stock.notnull}")
    @Min(value = 0, message = "{product.stock.positive}")
    private Integer stock;

    private Long categoryId;

    // Constructor por defecto
    public ProductRequestDto() {
    }

    // Constructor con parámetros
    public ProductRequestDto(String name, String description, BigDecimal price, Integer stock, Long categoryId) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.categoryId = categoryId;
    }

    // Getters y Setters
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

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    // Método toString()
    @Override
    public String toString() {
        return "ProductRequestDto{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", categoryId=" + categoryId +
                '}';
    }

    // Método equals()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductRequestDto that = (ProductRequestDto) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(price, that.price) &&
                Objects.equals(stock, that.stock) &&
                Objects.equals(categoryId, that.categoryId);
    }

    // Método hashCode()
    @Override
    public int hashCode() {
        return Objects.hash(name, description, price, stock, categoryId);
    }

    // Builder Pattern
    public static ProductRequestDtoBuilder builder() {
        return new ProductRequestDtoBuilder();
    }

    public static class ProductRequestDtoBuilder {
        private String name;
        private String description;
        private BigDecimal price;
        private Integer stock;
        private Long categoryId;

        public ProductRequestDtoBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ProductRequestDtoBuilder description(String description) {
            this.description = description;
            return this;
        }

        public ProductRequestDtoBuilder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        public ProductRequestDtoBuilder stock(Integer stock) {
            this.stock = stock;
            return this;
        }

        public ProductRequestDtoBuilder categoryId(Long categoryId) {
            this.categoryId = categoryId;
            return this;
        }

        public ProductRequestDto build() {
            return new ProductRequestDto(name, description, price, stock, categoryId);
        }
    }

    // Métodos de conveniencia
    public boolean hasCategory() {
        return categoryId != null;
    }

    public boolean hasDescription() {
        return description != null && !description.trim().isEmpty();
    }
}
