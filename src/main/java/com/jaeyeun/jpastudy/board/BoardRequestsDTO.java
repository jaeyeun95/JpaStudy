package com.jaeyeun.jpastudy.board;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardRequestsDTO {

    private String title;
    private String content;
    private String writer;
    private char deleteYn;

    public Board toEntity() {
        return Board.builder()
                .title(title)
                .content(content)
                .writer(writer)
                .hits(0)
                .deleteYn(deleteYn)
                .build();
    }
}
