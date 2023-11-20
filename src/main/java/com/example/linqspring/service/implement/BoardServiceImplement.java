package com.example.linqspring.service.implement;

import com.example.linqspring.dto.request.board.PostBoardCURequestDto;
import com.example.linqspring.dto.response.ResponseDto;
import com.example.linqspring.dto.response.board.PostBoardResponseDto;
import com.example.linqspring.entity.BoardEntity;
import com.example.linqspring.entity.UserEntity;
import com.example.linqspring.repository.BoardRepositoy;
import com.example.linqspring.repository.UserRepository;
import com.example.linqspring.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
//@Transactional
public class BoardServiceImplement implements BoardService {

    private final UserRepository userRepository;
    private final BoardRepositoy boardRepositoy;
    //@javax.transaction.Transactional(dontRollbackOn = RuntimeException.class)
    @Override
    public ResponseEntity<? super PostBoardResponseDto> BoardCreate(PostBoardCURequestDto dto, String id) {
        try{

            boolean existedId = userRepository.existsById(id);
            if(!existedId)return PostBoardResponseDto.notExistUser();

            UserEntity userEntity = userRepository.findByid(id);
            BoardEntity boardEntity = new BoardEntity(dto,id,userEntity);

            boardRepositoy.save(boardEntity);

        }catch (Exception e){
            e.printStackTrace();
            return ResponseDto.databaseError();
        }
        return PostBoardResponseDto.success();
    }

    @Override
    public ResponseEntity<? super PostBoardResponseDto> BoardRead(PostBoardCURequestDto dto, String id) {

        return null;
    }


    @Transactional
    @Override
    public ResponseEntity<? super PostBoardResponseDto> BoardDelete(Integer boardNumber) {
        boolean existedBoardNumber = boardRepositoy.existsByBoardNumber(boardNumber);
        if(!existedBoardNumber)return PostBoardResponseDto.notBoardNumber();

        boardRepositoy.deleteByboardNumber(boardNumber);
        return PostBoardResponseDto.success();
    }

    @Override
    public ResponseEntity<? super PostBoardResponseDto> BoardUpdate(PostBoardCURequestDto dto, String id) {
        try{

            boolean existedId = userRepository.existsById(id);
            if(!existedId)return PostBoardResponseDto.notExistUser();

            UserEntity userEntity = userRepository.findByid(id);
            BoardEntity boardEntity = new BoardEntity(dto,id,userEntity);

            boardRepositoy.save(boardEntity);

        }catch (Exception e){
            e.printStackTrace();
            return ResponseDto.databaseError();
        }
        return PostBoardResponseDto.success();
    }
}
