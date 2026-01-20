package com.study.attend.domain.study.entity;

import com.study.attend.domain.member.entity.Member;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
@Table(name="STUDY_VOTE_TBL",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"invitation_id", "voter_id"})})
public class StudyVote {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @NonNull
    private StudyInvitation invitation;

    @ManyToOne(fetch = FetchType.LAZY)
    @NonNull
    private Member voter;

    @Column(nullable = false)
    private boolean agree;
}
