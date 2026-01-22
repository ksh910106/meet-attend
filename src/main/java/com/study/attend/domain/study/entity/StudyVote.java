package com.study.attend.domain.study.entity;

import com.study.attend.domain.member.entity.Member;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="STUDY_VOTE_TBL",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"study_id", "voter_id", "target_id"})})
//초대/강퇴 투표
public class StudyVote {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Study study;

    @ManyToOne
    private Member voter;

    @Enumerated(EnumType.STRING)
    private VoteType voteType;

    private StudyVote(Study study, Member voter, VoteType voteType) {
        this.study = study;
        this.voter = voter;
        this.voteType = voteType;
    }

}
