package com.example.linqspring.entity;

import com.example.linqspring.dto.request.board.PostBoardCURequestDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="board")
@Table(name="board")
public class BoardEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int boardNumber;
    private String title;
    private String content;
    private String boardTitleImage;
    private int favoriteCount;
    private int commentCount;
    private String writeDatetime;
    private String writeNickname;
    private String writeProfileImage;
    private String id;
    public BoardEntity(PostBoardCURequestDto dto, String id, UserEntity userEntity){
        Date now = Date.from(Instant.now());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String writeDatetime = simpleDateFormat.format(now);

        this.title = dto.getTitle();
        this.content = dto.getContent();
        this.boardTitleImage = "image";
        this.favoriteCount = 0;
        this.commentCount = 0;
        this.writeDatetime = writeDatetime;
        this.writeProfileImage = "image";
        this.writeNickname = userEntity.getNickname();
        this.id = id;
    }
}
