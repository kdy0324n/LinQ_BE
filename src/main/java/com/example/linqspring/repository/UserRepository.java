package com.example.linqspring.repository;

import com.example.linqspring.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,String> {
    boolean existsById(String id);
    boolean existsByEmail(String password);
    boolean existsByNickname(String nickname);

    UserEntity findByid(String id);


}
