package com.planmate.server.service.post;

import com.planmate.server.domain.Member;
import com.planmate.server.domain.Post;
import com.planmate.server.exception.member.MemberNotFoundException;
import com.planmate.server.exception.post.PostNotFoundException;
import com.planmate.server.repository.MemberRepository;
import com.planmate.server.repository.PostRepository;
import com.planmate.server.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final MemberRepository memberRepository;

    public PostServiceImpl(PostRepository postRepository,MemberRepository memberRepository) {
        this.postRepository = postRepository;
        this.memberRepository = memberRepository;
    }

    @Override
    public Post findByPostId(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new PostNotFoundException(postId));
    }

    @Override
    public void deletePostById(Long postId) {
        postRepository.deleteById(postId);
    }

    @Override
    public List<Post> findPost() {
        Long memberId = JwtUtil.getMemberId();
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberNotFoundException(memberId));
        return null;
    }
}
