package com.example.linqspring.service.implement;

import com.example.linqspring.dto.request.auth.SignInRequestsDto;
import com.example.linqspring.dto.response.auth.SignInResponseDto;
import com.example.linqspring.dto.response.auth.SignUpResponseDto;
import com.example.linqspring.dto.request.auth.SignUpRequestDto;
import com.example.linqspring.dto.response.ResponseDto;
import com.example.linqspring.entity.UserEntity;
import com.example.linqspring.repository.UserRepository;
import com.example.linqspring.security.JwtProvider;
import com.example.linqspring.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImplement implements AuthService {

    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public ResponseEntity<? super SignUpResponseDto> signUp(SignUpRequestDto dto) {
        try{
            String id = dto.getId();
            boolean existedId = userRepository.existsById(id);
            if(existedId)return SignUpResponseDto.duplicateId();

            String email = dto.getEmail();
            boolean existedEmail = userRepository.existsByEmail(email);
            if(existedEmail)return SignUpResponseDto.duplicateEmail();

            String nickname = dto.getNickname();
            boolean existedNickname = userRepository.existsByNickname(nickname);
            if(existedNickname)return SignUpResponseDto.duplicateNickname();

            String password = dto.getPassword();
            String encodedPassword = passwordEncoder.encode(password);
            dto.setPassword(encodedPassword);

            UserEntity userEntity = new UserEntity(dto);
            System.out.println(dto);
            userRepository.save(userEntity);
        }catch (Exception exception){
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return SignUpResponseDto.success();

    }

    @Override
    public ResponseEntity<? super SignInResponseDto> signIn(SignInRequestsDto dto) {

        String token = null;

        try{

            String id = dto.getId();
            UserEntity userEntity = userRepository.findByid(id);
            if(userEntity == null)return SignInResponseDto.signInFailed();

            String password = dto.getPassword();
            String encodedPassword = userEntity.getPassword();
            boolean isMatched = passwordEncoder.matches(password,encodedPassword);
            if(!isMatched)return SignInResponseDto.signInFailed();

            token = jwtProvider.create(id);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseDto.databaseError();
        }

        return SignInResponseDto.success(token);
    }

}
