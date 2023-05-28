package com.planmate.server.domain;

import jdk.jshell.Snippet;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "subject")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",columnDefinition = "int")
    private Long id;

    @Column(name = "name",columnDefinition = "varchar(50)")
    private String name;

    @Column(name = "type",columnDefinition = "TINYINT(1)")
    private Boolean type;

    @Column(name = "max_study_time",columnDefinition = "time")
    private Date maxStudyTime;

    @Column(name = "study_time",columnDefinition = "time")
    private Date studyTime;

    @Column(name = "rest_time",columnDefinition = "time")
    private Date restTime;

    @Column(name = "d_day",columnDefinition = "int")
    private int dDay;

    @Column(name = "start_at",columnDefinition = "datetime")
    private Date startAt;

    @Column(name = "end_at",columnDefinition = "datetime")
    private Date endAt;

    @OneToMany(mappedBy = "subject",orphanRemoval = true)
    final private List<MemberSubject> postTagList = new ArrayList<>();


}
