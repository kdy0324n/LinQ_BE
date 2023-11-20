package com.example.linqspring.controller;

import com.example.linqspring.dto.request.auth.SignInRequestsDto;
import com.example.linqspring.dto.response.auth.SignInResponseDto;
import com.example.linqspring.dto.response.auth.SignUpResponseDto;
import com.example.linqspring.dto.request.auth.SignUpRequestDto;
import com.example.linqspring.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(originPatterns = "http://localhost:3000/")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private final AuthService authService;


    @PostMapping("/sign-up")
    public ResponseEntity<? super SignUpResponseDto> signUp(@RequestBody @Valid SignUpRequestDto requestBody){
        System.out.println(requestBody.toString());
        ResponseEntity<? super SignUpResponseDto >response = authService.signUp(requestBody);
        return response;
    }

    @PostMapping("/sign-in")
    public ResponseEntity<? super SignInResponseDto>signIn(@RequestBody @Valid SignInRequestsDto requestBody){
        ResponseEntity<? super SignInResponseDto>result = authService.signIn(requestBody);
        System.out.println("로그인");
        return result;
    }
}
