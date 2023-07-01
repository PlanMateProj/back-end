package com.planmate.server.controller;

import com.planmate.server.domain.Authority;
import com.planmate.server.domain.Member;
import com.planmate.server.service.member.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
@Slf4j
@RequiredArgsConstructor
@Api(tags = {"사용자 API"})
public class MemberController {
    private final MemberService memberService;

    /**
     * TODO: modify image, log-out
     * */
    @GetMapping("info")
    @ApiOperation(value = "사용자 정보 조회")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "조회 환료"),
            @ApiResponse(responseCode = "401", description = "토큰 만료"),
            @ApiResponse(responseCode = "403", description = "권한 없음"),
            @ApiResponse(responseCode = "404", description = "해당 멤버 없음"),
    })
    public ResponseEntity<Member> getInfo() {
        return ResponseEntity.ok(memberService.getInfo());
    }

    @DeleteMapping("sign-out")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "삭제 환료"),
            @ApiResponse(responseCode = "401", description = "토큰 만료"),
            @ApiResponse(responseCode = "403", description = "권한 없음"),
            @ApiResponse(responseCode = "404", description = "해당 멤버 없음"),
    })
    public ResponseEntity signOut() {
        memberService.signOut();
        return ResponseEntity.ok().build();
    }
}
