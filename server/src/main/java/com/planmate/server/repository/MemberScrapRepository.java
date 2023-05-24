package com.planmate.server.repository;

import com.planmate.server.domain.MemberScrap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberScrapRepository extends JpaRepository<MemberScrap,Long> {
    MemberScrap findByOwnerMemberIdAndPostPostId(Long ownerId, Long postId);
    List<MemberScrap> findByOwnerMemberId(Long memberId);
}
