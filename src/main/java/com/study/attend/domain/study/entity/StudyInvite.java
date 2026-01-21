package com.study.attend.domain.study.entity;

import com.study.attend.domain.member.entity.Member;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StudyInvite {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Study study;

    @ManyToOne
    private Member inviter;

    @ManyToOne
    private Member invitee; //초대받은사람

    @Enumerated(EnumType.STRING)
    private InviteStatus status;

    public StudyInvite(Study study, Member inviter, Member invitee) {
        this.study = study;
        this.inviter = inviter;
        this.invitee = invitee;
        this.status = InviteStatus.PENDING;
    }
}
