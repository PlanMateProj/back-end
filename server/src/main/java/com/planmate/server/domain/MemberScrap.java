package com.planmate.server.domain;

import com.planmate.server.dto.request.post.PostDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "member_scrap")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberScrap {
    @Id
    @Column(name = "scrap_id",columnDefinition = "int")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(example = "스크랩 식별자")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "member_id",columnDefinition = "int")
    @ApiModelProperty(example = "맴버 참조 외래키")
    private Member owner;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "post_id",columnDefinition = "int")
    @ApiModelProperty(example = "게시물 참조 외래키")
    private Post post;

    public static MemberScrap of(Member owner,Post post) {
        return MemberScrap.builder()
                .owner(owner)
                .post(post)
                .build();
    }
}
