package com.example.linqspring.dto.request.board;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PostBoardCURequestDto {

    @NotBlank
    private String title;
    @NotBlank
    private String content;

    private List<String> boardImageList;

}
