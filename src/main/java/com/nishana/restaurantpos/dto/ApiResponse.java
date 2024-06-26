package com.nishana.restaurantpos.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ApiResponse<T> {
    private String message;
    private T data;

    public ApiResponse(String message, T data) {
        this.message = message;
        this.data = data;
    }

    // Getters and Setters
}
