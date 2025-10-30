package dev.alefiengo.tarea2.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

public class ApiResponse<T> {
    private String status;
    private int code;
    private String message;
    private T data;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timestamp;
    private String path;

    // Constructores
    public ApiResponse() {
        this.timestamp = LocalDateTime.now();
    }

    public ApiResponse(String status, int code, String message, T data, String path) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.data = data;
        this.timestamp = LocalDateTime.now();
        this.path = path;
    }

    // Getters y Setters
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    // Métodos estáticos de conveniencia
    public static <T> ApiResponse<T> success(T data, String message, String path) {
        return new ApiResponse<>("success", 200, message, data, path);
    }

    public static <T> ApiResponse<T> created(T data, String message, String path) {
        return new ApiResponse<>("success", 201, message, data, path);
    }

    public static ApiResponse<Void> error(int code, String message, String path) {
        return new ApiResponse<>("error", code, message, null, path);
    }
}
