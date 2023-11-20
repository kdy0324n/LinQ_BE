package com.example.linqspring.service;

import com.example.linqspring.dto.request.board.PostBoardCURequestDto;
import com.example.linqspring.dto.response.board.PostBoardResponseDto;
import org.springframework.http.ResponseEntity;

public interface BoardService {
    ResponseEntity<? super PostBoardResponseDto>BoardCreate(PostBoardCURequestDto dto, String id);

    ResponseEntity<? super PostBoardResponseDto>BoardRead(PostBoardCURequestDto dto, String id);
    ResponseEntity<? super PostBoardResponseDto>BoardDelete(Integer boardNumber);

    ResponseEntity<? super PostBoardResponseDto>BoardUpdate(PostBoardCURequestDto dto, String id);
}
