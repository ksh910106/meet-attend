package com.study.attend.domain.study.entity;

import com.study.attend.domain.member.entity.Member;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
public class StudyInvitation {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @NonNull
    private Study study;

    @ManyToOne(fetch = FetchType.LAZY)
    @NonNull
    private Member inviteMember;

    @Column(nullable = false)
    private boolean approved = false;
}
