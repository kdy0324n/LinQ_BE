package com.example.linqspring.dto.request.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequestDto {
    @NotBlank
    private String id;
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    @NotBlank
    private String name;
    @NotBlank
    private String nickname;
    @NotBlank
    private String birth;
    /*private Date userBirth;
    private Timestamp userDate;
    private int userType;*/
}
