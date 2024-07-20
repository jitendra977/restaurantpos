package com.nishana.restaurantpos.dto;
import jakarta.validation.constraints.NotEmpty;

import lombok.*;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginForm {

    @NotEmpty(message = "ユーザー名が必須")
    private String username;

    @NotEmpty(message = "Password is required")
    private String password;
}
