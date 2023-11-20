package com.example.linqspring.controller;

import com.example.linqspring.dto.response.user.GetSignInUserResponseDto;
import com.example.linqspring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("")
    public ResponseEntity<? super GetSignInUserResponseDto>getSignInUser(
            @AuthenticationPrincipal String id
    ){
        ResponseEntity<? super GetSignInUserResponseDto>response = userService.getSignInUser(id);
        return response;
    }

}
