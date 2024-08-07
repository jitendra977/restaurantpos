package com.nishana.restaurantpos.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoryDTO {
    private Long id;
    private String name;
    private String description;
}