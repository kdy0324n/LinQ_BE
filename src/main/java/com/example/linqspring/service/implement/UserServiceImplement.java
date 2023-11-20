package com.example.linqspring.service.implement;

import com.example.linqspring.dto.response.ResponseDto;
import com.example.linqspring.dto.response.user.GetSignInUserResponseDto;
import com.example.linqspring.entity.UserEntity;
import com.example.linqspring.repository.UserRepository;
import com.example.linqspring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImplement implements UserService {

    private final UserRepository userRepository;

    @Override
    public ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(String id) {
        UserEntity userEntity = null;

        try{
            userEntity = userRepository.findByid(id);
            if(userEntity==null)return GetSignInUserResponseDto.notExistUser();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetSignInUserResponseDto.success(userEntity);
    }
}
