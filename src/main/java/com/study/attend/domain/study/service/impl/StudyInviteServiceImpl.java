package com.study.attend.domain.study.service.impl;

import com.study.attend.domain.member.repository.MemberRepository;
import com.study.attend.domain.study.repository.StudyInvitationRepository;
import com.study.attend.domain.study.repository.StudyMemberRepository;
import com.study.attend.domain.study.repository.StudyRepository;
import com.study.attend.domain.study.repository.StudyVoteRepository;
import com.study.attend.domain.study.service.StudyInviteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class StudyInviteServiceImpl implements StudyInviteService {

    private final StudyRepository studyRepository;
    private final MemberRepository memberRepository;
    private final StudyMemberRepository studyMemberRepository;
    private final StudyInvitationRepository studyInvitationRepository;
    private final StudyVoteRepository studyVoteRepository;

    @Override
    public Long invite(Long studyId, Long inviterId, Long inviteMemberId) {

        if(inviterId.equals(inviteMemberId)){
            throw new IllegalStateException("자기 자신은 초대할 수 없습니다.");
        }

        return null;
    }


}
