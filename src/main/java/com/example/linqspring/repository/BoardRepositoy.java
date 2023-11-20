package com.example.linqspring.repository;

import com.example.linqspring.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepositoy extends JpaRepository<BoardEntity, Integer> {
    boolean existsByBoardNumber(Integer boardnumber);

    void deleteByboardNumber(Integer boardnumber);
}
