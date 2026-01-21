package com.study.attend.domain.study.service.impl;

import com.study.attend.domain.member.repository.MemberRepository;
import com.study.attend.domain.study.repository.StudyInviteRepository;
import com.study.attend.domain.study.repository.StudyMemberRepository;
import com.study.attend.domain.study.repository.StudyRepository;
import com.study.attend.domain.study.repository.StudyVoteRepository;
import com.study.attend.domain.study.service.StudyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class StudyServiceImpl implements StudyService {

    private final StudyRepository studyRepository;
    private final MemberRepository memberRepository;
    private final StudyMemberRepository studyMemberRepository;
    private final StudyInviteRepository studyInviteRepository;
    private final StudyVoteRepository studyVoteRepository;

    



}
