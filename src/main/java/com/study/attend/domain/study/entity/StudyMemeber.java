package com.study.attend.domain.study.entity;

import com.study.attend.domain.member.entity.Member;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="STUDY_MEMBER_TBL",
uniqueConstraints = {@UniqueConstraint(columnNames = {"study_id", "member_id"})})

//스터디와 멤버 관계를 표현하는 중간 엔터티(스터디 구성원)
public class StudyMemeber {
    @Id
    @GeneratedValue
    private Long id;

    //여러 StudyMember가 하나의 study에 속할 수있다.
    //N:1
    //DB컬럼 study_id
    @ManyToOne(fetch = FetchType.LAZY)
    private Study study;

    //여러 StudyMember가 하나의 member에 속할 수있다.
    //DB컬럼 member_id
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    public StudyMemeber(Study study, Member member) {
        this.study = study;
        this.member = member;
    }


}
