package com.planmate.server.domain;

import com.planmate.server.dto.request.post.PostDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "post")
@ApiModel(value = "게시글 테이블")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    @ApiModelProperty(example = "게시글 아이디")
    private Long postId;

    @Column(name = "title")
    @ApiModelProperty(example = "게시글 제목")
    private String title;

    @Column(name = "content")
    @ApiModelProperty(example = "본문 내용")
    private String content;

    @Column(name = "updated_at")
    @ApiModelProperty(example = "게시글 업데이트 날짜")
    private Date updatedAt;

    public static Post of(PostDto postDto) {
        return Post.builder()
                .title(postDto.getTitle())
                .content(postDto.getContent())
                .build();
    }
}
