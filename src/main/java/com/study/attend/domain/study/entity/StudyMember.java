package com.study.attend.domain.study.entity;

import com.study.attend.domain.member.entity.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="STUDY_MEMBER_TBL",
        uniqueConstraints = @UniqueConstraint(columnNames = {"study_id", "member_id"})
)
public class StudyMember {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Study study;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    public StudyMember(Study study, Member member) {
        this.study = study;
        this.member = member;
    }
}