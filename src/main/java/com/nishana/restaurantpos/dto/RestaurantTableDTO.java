package com.nishana.restaurantpos.dto;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class RestaurantTableDTO {
    private Long tableId;
    private int tableNumber;
    private int capacity;
    private String status;
    private String location;
    private boolean isSmokingAllowed;
}