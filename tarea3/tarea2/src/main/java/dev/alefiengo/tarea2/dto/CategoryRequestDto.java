package dev.alefiengo.tarea2.dto;

import jakarta.validation.constraints.NotBlank;

public class CategoryRequestDto {

    @NotBlank(message = "{category.name.notblank}")
    private String name;

    private String description;

    // Constructor por defecto
    public CategoryRequestDto() {
    }

    // Constructor con parámetros
    public CategoryRequestDto(String name, String description) {
        this.name = name;
        this.description = description;
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

    // Método toString()
    @Override
    public String toString() {
        return "CategoryRequestDto{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    // Métodos equals() y hashCode() (opcionales)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoryRequestDto that = (CategoryRequestDto) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return description != null ? description.equals(that.description) : that.description == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
