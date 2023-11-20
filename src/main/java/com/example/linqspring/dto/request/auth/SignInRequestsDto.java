package com.example.linqspring.dto.request.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignInRequestsDto {
    @NotBlank
    private String id;
    @NotBlank
    private String password;
}
