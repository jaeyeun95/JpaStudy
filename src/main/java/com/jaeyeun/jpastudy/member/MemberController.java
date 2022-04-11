package com.jaeyeun.jpastudy.member;

import com.jaeyeun.jpastudy.response.ResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity registerMember(@RequestBody MemberDTO memberDTO) {
        log.info("저장할 member : {}", memberDTO.toString());
        try {
            MemberEntity member = MemberEntity.builder().id(memberDTO.getId()).pwd(memberDTO.getPwd()).build();

            MemberEntity registMember = memberService.create(member);
            return ResponseEntity.ok(registMember);
        } catch (Exception e) {
            // 예외가 발생할 경우
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return ResponseEntity.badRequest().body(responseDTO);
        }

    }


}
