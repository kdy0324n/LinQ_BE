package com.example.linqspring.service;

import com.example.linqspring.dto.response.user.GetSignInUserResponseDto;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<? super GetSignInUserResponseDto>getSignInUser(String id);
}
