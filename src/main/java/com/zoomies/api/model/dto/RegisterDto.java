package com.zoomies.api.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegisterDto extends LoginDto {

    @NotBlank(message = "Full name is required")
    @NotNull(message = "Full name is required")
    private String fullName;

}
