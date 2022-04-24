package com.jaeyeun.jpastudy.board;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class BoardService {

    private final BoardRepository boardRepository;

    // 게시글 생성
    @Transactional
    public Long save(final BoardRequestsDTO params){
        log.info("게시글 등록");

        Board entity = boardRepository.save(params.toEntity());
        return entity.getId();
    }

    // 게시글 조회
    public List<BoardResponseDto> findAll() {
        log.info("게시글 조회");

        Sort sort = Sort.by(Sort.Direction.DESC, "id", "createdDate");
        List<Board> list = boardRepository.findAll(sort);
        return list.stream().map(BoardResponseDto::new).collect(Collectors.toList());

    }

    // 게시글 수정
    @Transactional
    public Long update(final Long id, final BoardRequestsDTO params) throws Exception {
        log.info("게시글 수정");

        Board entity = boardRepository.findById(id).orElseThrow(() -> new Exception("해당 게시글 존재하지 않음"));

        entity.update(params.getTitle(), params.getContent(), params.getWriter());
        return id;

    }
}
