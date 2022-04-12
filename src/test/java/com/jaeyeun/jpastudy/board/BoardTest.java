package com.jaeyeun.jpastudy.board;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class BoardTest {

    @Autowired
    BoardRepository boardRepository;

    @Test
    void save() {

//        // 게시글 등록
//        BoardEntity board = BoardEntity.builder()
//                .title("게시판테스트제목")
//                .content("게시판테스트내용")
//                .writer("test")
//                .hits(0)
//                .deleteYn('N')
//                .build();
//
//        System.out.println("board : " + board.toString());
//
//        boardRepository.save(board);
//
//        // 1번 게시글 정보 조회
//        Optional<BoardEntity> entity = boardRepository.findById(1L);
//        Assertions.assertThat(entity.get().getTitle()).isEqualTo("게시판테스트제목");
//        Assertions.assertThat(entity.get().getContent()).isEqualTo("게시판테스트내용");

        // 1. 게시글 파라미터 생성
        Board params = Board.builder()
                .title("1번 게시글 제목")
                .content("1번 게시글 내용")
                .writer("도뎡이")
                .hits(0)
                .deleteYn('N')
                .build();

        // 2. 게시글 저장
        boardRepository.save(params);

        // 3. 1번 게시글 정보 조회
        Board entity = boardRepository.findById((long) 1).get();
        assertThat(entity.getTitle()).isEqualTo("1번 게시글 제목");
        assertThat(entity.getContent()).isEqualTo("1번 게시글 내용");
        assertThat(entity.getWriter()).isEqualTo("도뎡이");


    }
}
