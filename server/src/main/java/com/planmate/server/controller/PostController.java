package com.planmate.server.controller;

import com.planmate.server.dto.request.post.PostDto;
import com.planmate.server.dto.request.post.ScrapDto;
import com.planmate.server.dto.response.post.PostResponseDto;
import com.planmate.server.service.post.PostService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/create")
    @ApiOperation("새 게시물을 생성")
    @ApiResponses({
            @ApiResponse(responseCode = "200",description = "새 게시물 생성 성공"),
            @ApiResponse(responseCode = "401",description = "해당 사용자가 인증되지 않음 | 토큰 만료"),
            @ApiResponse(responseCode = "403",description = "해당 사용자가 Member 권한이 아님"),
            @ApiResponse(responseCode = "404",description = "새 게시물을 생성하는데 실패함")
    })
    public ResponseEntity<PostResponseDto> createPost(@RequestBody PostDto postDto) {
        return ResponseEntity.ok(postService.createPost(postDto));
    }

    @GetMapping("/find/with/{tagName}")
    @ApiOperation("태그로 게시물 조회")
    @ApiResponses({
            @ApiResponse(responseCode = "200",description = "태그로 게시물 조회 성공"),
            @ApiResponse(responseCode = "404",description = "태그로 게시물을 조회하는데 실패함")
    })
    public ResponseEntity<List<PostResponseDto>> createPost(@RequestParam("tagName") String tagName) {
        return ResponseEntity.ok(postService.findPostByTagName(tagName));
    }

    @GetMapping("/check/{postId}")
    @ApiOperation("Id로 게시물 조회")
    @ApiResponses({
            @ApiResponse(responseCode = "200",description = "게시물 정상 조회"),
            @ApiResponse(responseCode = "401",description = "해당 사용자가 인증되지 않음 | 토큰 만료"),
            @ApiResponse(responseCode = "403",description = "해당 사용자가 Member 권한이 아님"),
            @ApiResponse(responseCode = "404",description = "해당 Id를 가진 게시글이 없음")
    })
    public ResponseEntity<PostResponseDto > findPostById(@RequestParam("postId") Long postId) {
        return ResponseEntity.ok(postService.findByPostId(postId));
    }

    @DeleteMapping("/remove/{postId}")
    @ApiOperation("Id로 게시글 삭제")
    @ApiResponses({
            @ApiResponse(responseCode = "200",description = "게시물 정상 삭제"),
            @ApiResponse(responseCode = "401",description = "해당 사용자가 인증되지 않음 | 토큰 만료"),
            @ApiResponse(responseCode = "403",description = "해당 사용자가 Member 권한이 아님"),
            @ApiResponse(responseCode = "404",description = "해당 Id를 가진 게시물이 없음")
    })
    public ResponseEntity deletePost(@RequestParam("postId") Long postId) {
        postService.deletePostById(postId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/find")
    @ApiOperation("내 게시글 조회")
    @ApiResponses({
            @ApiResponse(responseCode = "200",description = "나의 게시물 정상 조회"),
            @ApiResponse(responseCode = "401",description = "해당 사용자가 인증되지 않음 | 토큰 만료"),
            @ApiResponse(responseCode = "403",description = "해당 사용자가 Member 권한이 아님"),
            @ApiResponse(responseCode = "404",description = "게시물 조회에 실패함")
    })
    public ResponseEntity<List<PostResponseDto>> findMyPost() {
        return ResponseEntity.ok(postService.findMyPost());
    }

    @PostMapping("/edit")
    @ApiOperation("게시글 수정")
    @ApiResponses({
            @ApiResponse(responseCode = "200",description = "게시물 수정 성공"),
            @ApiResponse(responseCode = "401",description = "해당 사용자가 인증되지 않음 | 토큰 만료"),
            @ApiResponse(responseCode = "403",description = "해당 사용자가 Member 권한이 아님"),
            @ApiResponse(responseCode = "404",description = "게시물 수정에 실패함")
    })
    public ResponseEntity<PostResponseDto> editPost(@RequestBody PostDto postDto) {
        return ResponseEntity.ok(postService.editPost(postDto));
    }

    @PostMapping("/scrap")
    @ApiOperation("게시글 스크랩")
    @ApiResponses({
            @ApiResponse(responseCode = "200",description = "게시물 스크랩 성공"),
            @ApiResponse(responseCode = "401",description = "해당 사용자가 인증되지 않음 | 토큰 만료"),
            @ApiResponse(responseCode = "403",description = "해당 사용자가 Member 권한이 아님"),
            @ApiResponse(responseCode = "404",description = "게시물 스크랩에 실패함")
    })
    public ResponseEntity<PostResponseDto> scrapPost(@RequestBody ScrapDto scrapDto) {
        return ResponseEntity.ok(postService.scrapPost(scrapDto));
    }
    
    @GetMapping("/find/scrap")
    @ApiOperation("스크랩한 게시물 조회")
    @ApiResponses({
            @ApiResponse(responseCode = "200",description = "스크랩한 게시물 조회 성공"),
            @ApiResponse(responseCode = "401",description = "해당 사용자가 인증되지 않음 | 토큰 만료"),
            @ApiResponse(responseCode = "403",description = "해당 사용자가 Member 권한이 아님"),
            @ApiResponse(responseCode = "404",description = "스크랩한 게시물 조회에 실패함")
    })
    public ResponseEntity<List<PostResponseDto>> findScrapPost() {
        return ResponseEntity.ok(postService.findScrapPost());
    }

    @DeleteMapping("/remove/scrap/{postId}")
    @ApiOperation("게시물 스크랩 취소")
    @ApiResponses({
            @ApiResponse(responseCode = "200",description = "게시물 스크랩 취소 성공"),
            @ApiResponse(responseCode = "401",description = "해당 사용자가 인증되지 않음 | 토큰 만료"),
            @ApiResponse(responseCode = "403",description = "해당 사용자가 Member 권한이 아님"),
            @ApiResponse(responseCode = "404",description = "해당 Id를 가진 게시물을 찾을 수 없음")
    })
    public ResponseEntity removeScrap(@RequestParam Long postId) {
        postService.deleteScrapById(postId);
        return ResponseEntity.ok().build();
    }
}
