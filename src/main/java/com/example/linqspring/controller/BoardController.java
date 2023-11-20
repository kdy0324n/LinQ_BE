package com.example.linqspring.controller;

import com.example.linqspring.dto.request.board.PostBoardCURequestDto;
import com.example.linqspring.dto.response.board.PostBoardResponseDto;
import com.example.linqspring.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    //@javax.transaction.Transactional(dontRollbackOn = RuntimeException.class)
    @PostMapping("/create")
    public ResponseEntity<? super PostBoardResponseDto>postBoardCreate(
            @RequestBody @Valid PostBoardCURequestDto requestBody,
            @AuthenticationPrincipal String id
    ){
        ResponseEntity<? super PostBoardResponseDto>response = boardService.BoardCreate(requestBody,id);
        return response;
    }
    @PostMapping("/read")
    public ResponseEntity<? super PostBoardResponseDto>postBoardRead(
            @AuthenticationPrincipal String id
    ){
        /*ResponseEntity<? super PostBoardResponseDto>response = boardService.BoardRead(dto,id);
        return response;*/
        return null;
    }
    @PatchMapping("/update")
    public ResponseEntity<? super PostBoardResponseDto>postBoardUpdate(
            @RequestBody @Valid PostBoardCURequestDto requestBody,
            @AuthenticationPrincipal String id
    ){
        ResponseEntity<? super PostBoardResponseDto>response = boardService.BoardUpdate(requestBody,id);
        return response;
    }
    @DeleteMapping("/{boardNumber}")
    public ResponseEntity<? super PostBoardResponseDto>postBoardDelete(
            //@AuthenticationPrincipal String id,
            @PathVariable("boardNumber") Integer boardNumber
    ){
        ResponseEntity<? super PostBoardResponseDto>response = boardService.BoardDelete(boardNumber);
        return response;
    }

}
