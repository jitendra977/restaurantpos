package com.nishana.restaurantpos.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ApiResponse<T> {
    private T data;
    private String message;

    public ApiResponse(String message, T data) {
        this.data = data;
        this.message = message;
    }
}
