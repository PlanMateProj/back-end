package com.planmate.server.domain;

import lombok.*;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "member_subject")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberSubject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id", columnDefinition = "int")
    private int memberId;

    @Column(name = "subject_id", columnDefinition = "int")
    private int subjectId;


    @JoinColumn(name = "id",columnDefinition = "int")
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    private Subject subject;

}
