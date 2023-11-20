package com.example.linqspring.entity;

import com.example.linqspring.dto.request.auth.SignUpRequestDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="userinfo")
@Table(name="userinfo")
public class UserEntity {
    @Id
    private String id;
    private String email;
    private String password;
    private String name;
    private String nickname;
    private String birth;


    public UserEntity(SignUpRequestDto dto){

        this.id=dto.getId();
        this.email=dto.getEmail();
        this.password=dto.getPassword();
        this.name=dto.getName();
        this.nickname=dto.getNickname();
        this.birth=dto.getBirth();

    }
}
