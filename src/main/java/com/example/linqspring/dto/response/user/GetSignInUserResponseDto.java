package com.example.linqspring.dto.response.user;

import com.example.linqspring.common.ResponseCode;
import com.example.linqspring.common.ResponseMessage;
import com.example.linqspring.dto.response.ResponseDto;
import com.example.linqspring.entity.UserEntity;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
public class GetSignInUserResponseDto extends ResponseDto {
    private String id;
    private String email;
    private String nickname;
    private String profileImage;

    private GetSignInUserResponseDto(UserEntity userEntity){
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.id = userEntity.getId();
        this.email = userEntity.getEmail();
        this.nickname = userEntity.getNickname();
        this.profileImage = null;
    }
    public static ResponseEntity<GetSignInUserResponseDto>success(UserEntity userEntity){
        GetSignInUserResponseDto result = new GetSignInUserResponseDto(userEntity);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> notExistUser(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXISTED_USER, ResponseMessage.NOT_EXISTED_USER);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(result);
    }

}
