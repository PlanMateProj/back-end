package com.planmate.server.service.post;

import com.planmate.server.domain.Post;

import java.util.List;

public interface PostService {
    Post findByPostId(Long postId);
    void deletePostById(Long postId);
    List<Post> findPost();
}
