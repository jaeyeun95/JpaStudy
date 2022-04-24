package com.jaeyeun.jpastudy.board;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/boards")
    public Long save(@RequestBody final BoardRequestsDTO params) {
        log.info("게시글 등록");
        return boardService.save(params);
    }

    @GetMapping("/boards")
    public List<BoardResponseDto> findAll() {
        log.info("게시글 조회");

        return boardService.findAll();
    }

    @PatchMapping("/boards/{id}")
    public Long save(@PathVariable final Long id, @RequestBody final BoardRequestsDTO params) throws Exception {
        log.info("게시글 수정");

        return boardService.update(id, params);
    }
}
