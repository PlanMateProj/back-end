package com.planmate.server.controller;

import com.planmate.server.domain.Post;
import com.planmate.server.domain.Token;
import com.planmate.server.dto.request.post.PostDto;
import com.planmate.server.repository.PostRepository;
import com.planmate.server.repository.TokenRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PostControllerTest {

    @LocalServerPort
    private int port;

    private RestTemplate restTemplate;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private TokenRepository tokenRepository;
    private HttpEntity request;
    private HttpHeaders httpHeaders;
    private Token token;

    public PostControllerTest() {}

    @BeforeEach
    void init() {
        restTemplate = new RestTemplate();
        token = tokenRepository.findById(7L).orElseThrow();
        httpHeaders = new HttpHeaders();
        String header = "Bearer "+token.getAccessToken();
        httpHeaders.set("Authorization",header);
    }

    @Test
    void createPost() {
        //given
        String url = "http://localhost:"+port+"/create";
        PostDto postDto = new PostDto();
        postDto.setTitle("createPost test");
        postDto.setContent("By 호진");
        request = new HttpEntity(postDto,httpHeaders);
        //when
        ResponseEntity<Post> response = restTemplate.exchange(url, HttpMethod.POST,request,Post.class);
        //then
        Assertions.assertThat(response.getBody().getTitle()).isEqualTo(postDto.getTitle());
    }

    @Test
    void findPostById() {
    }

    @Test
    void deletePost() {
    }

    @Test
    void findPost() {
    }

    @Test
    void editPost() {
    }
}