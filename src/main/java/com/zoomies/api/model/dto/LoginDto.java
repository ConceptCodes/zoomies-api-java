package com.zoomies.api.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Data
@NoArgsConstructor
public class LoginDto {

    @NotNull
    @Email(message = "Email must be valid")
    @NotBlank
    private String email;

    @NotNull
    @Size(min = 8, max = 20)
    @NotBlank
    private String password;
}
