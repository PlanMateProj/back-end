package com.planmate.server.domain;

import jdk.jshell.Snippet;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Date;

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
    private long id;

    @Column(name = "name",columnDefinition = "varchar(50)")
    private String name;

    //@ColumnDefault("1")
    @Column(name = "type",columnDefinition = "TINYINT(1)")
    private int type;

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

}
