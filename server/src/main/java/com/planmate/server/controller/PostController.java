package com.planmate.server.controller;

import com.planmate.server.domain.Post;
import com.planmate.server.dto.request.post.PostDto;
import com.planmate.server.service.post.PostService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/check/{postId}")
    @ApiOperation("Id로 게시물 조회")
    @ApiResponses({
            @ApiResponse(responseCode = "200",description = "게시글 정상 조회"),
            @ApiResponse(responseCode = "401",description = "해당 사용자가 인증되지 않음 | 토큰 만료"),
            @ApiResponse(responseCode = "403",description = "해당 사용자가 Member 권한이 아님"),
            @ApiResponse(responseCode = "404",description = "해당 Id를 가진 게시글이 없음")
    })
    public ResponseEntity<Post> findPostById(@RequestParam("postId") Long postId) {
        return ResponseEntity.ok(postService.findByPostId(postId));
    }

    @GetMapping("/remove/{postId}")
    @ApiOperation("Id로 게시글 삭제")
    @ApiResponses({
            @ApiResponse(responseCode = "200",description = "게시글 정상 삭제"),
            @ApiResponse(responseCode = "401",description = "해당 사용자가 인증되지 않음 | 토큰 만료"),
            @ApiResponse(responseCode = "403",description = "해당 사용자가 Member 권한이 아님"),
            @ApiResponse(responseCode = "404",description = "해당 Id를 가진 게시글이 없음")
    })
    public ResponseEntity deletePost(@RequestParam("postId") Long postId) {
        postService.deletePostById(postId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/find")
    @ApiOperation("내 게시글 조회")
    @ApiResponses({
            @ApiResponse(responseCode = "200",description = "나의 게시글 정상 조회"),
            @ApiResponse(responseCode = "401",description = "해당 사용자가 인증되지 않음 | 토큰 만료"),
            @ApiResponse(responseCode = "403",description = "해당 사용자가 Member 권한이 아님"),
            @ApiResponse(responseCode = "404",description = "게시글 조회에 실패함")
    })
    public ResponseEntity<List<Post>> findPost() {

    }
}
