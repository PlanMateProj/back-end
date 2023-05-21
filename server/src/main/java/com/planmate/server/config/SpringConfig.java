package com.planmate.server.config;

import com.planmate.server.repository.MemberRepository;
import com.planmate.server.repository.PostRepository;
import com.planmate.server.repository.TokenRepository;
import com.planmate.server.service.member.MemberService;
import com.planmate.server.service.member.MemberServiceImpl;
import com.planmate.server.service.post.PostService;
import com.planmate.server.service.post.PostServiceImpl;
import com.planmate.server.service.token.TokenService;
import com.planmate.server.service.token.TokenServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    private final MemberRepository memberRepository;
    private final TokenRepository tokenRepository;
    private final PostRepository postRepository;

    @Autowired
    public SpringConfig(final MemberRepository memberRepository,
                        final TokenRepository tokenRepository,
                        final PostRepository postRepository) {
        this.memberRepository = memberRepository;
        this.tokenRepository = tokenRepository;
        this.postRepository = postRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository, tokenRepository);
    }

    @Bean
    public TokenService tokenService() {
        return new TokenServiceImpl(tokenRepository, memberRepository);
    }

    @Bean
    public PostService postService() {
        return new PostServiceImpl(postRepository,memberRepository);
    }
}