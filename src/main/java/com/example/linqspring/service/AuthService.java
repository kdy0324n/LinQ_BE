package com.example.linqspring.service;

import com.example.linqspring.dto.request.auth.SignInRequestsDto;
import com.example.linqspring.dto.response.auth.SignInResponseDto;
import com.example.linqspring.dto.response.auth.SignUpResponseDto;
import com.example.linqspring.dto.request.auth.SignUpRequestDto;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    ResponseEntity<? super SignUpResponseDto>signUp(SignUpRequestDto dto);
    ResponseEntity<? super SignInResponseDto>signIn(SignInRequestsDto dto);

}
