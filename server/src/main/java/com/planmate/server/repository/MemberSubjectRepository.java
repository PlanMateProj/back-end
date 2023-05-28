package com.planmate.server.repository;

import com.planmate.server.domain.MemberSubject;
import com.planmate.server.domain.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberSubjectRepository extends JpaRepository<MemberSubject,Long>  {

}
