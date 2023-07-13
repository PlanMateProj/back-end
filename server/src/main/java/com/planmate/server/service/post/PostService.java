package com.planmate.server.service.post;

import com.planmate.server.dto.request.post.PostDto;
import com.planmate.server.dto.request.post.ScrapDto;
import com.planmate.server.dto.response.post.PostCreateResponseDto;
import com.planmate.server.dto.response.post.PostEditResponseDto;
import com.planmate.server.dto.response.post.PostPageResponseDto;
import com.planmate.server.dto.response.post.PostResponseDto;

import java.util.List;

public interface PostService {
    PostCreateResponseDto createPost(PostDto postDto);
    PostResponseDto findByPostId(Long postId);
    void deletePost(Long postId);
    PostPageResponseDto findRecentPost(Integer pages);
    List<PostResponseDto> findMyPost();
    PostEditResponseDto editPost(PostDto postDto);
    Boolean scrapPost(ScrapDto scrapDto);
    List<PostResponseDto> findScrapPost();
    List<PostResponseDto> findPostByTagName(String tagName);
    Boolean setPostLike(Long postId);
}
