// UserDTO.java
package com.nishana.restaurantpos.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {
    private Long userId;
    private String name;
    private String contactNumber;
    private String email;
}