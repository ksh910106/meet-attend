package com.study.attend.domain.study.service.impl;

import com.study.attend.domain.member.entity.Member;
import com.study.attend.domain.member.repository.MemberRepository;
import com.study.attend.domain.study.dto.reponse.StudyInviteResponseDto;
import com.study.attend.domain.study.dto.reponse.StudyResponseDto;
import com.study.attend.domain.study.dto.request.InviteAcceptRequestDto;
import com.study.attend.domain.study.dto.request.StudyCreateRequestDto;
import com.study.attend.domain.study.dto.request.StudyInviteRequestDto;
import com.study.attend.domain.study.entity.*;
import com.study.attend.domain.study.repository.StudyInviteRepository;
import com.study.attend.domain.study.repository.StudyMemberRepository;
import com.study.attend.domain.study.repository.StudyRepository;
import com.study.attend.domain.study.repository.StudyVoteRepository;
import com.study.attend.domain.study.service.StudyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class StudyServiceImpl implements StudyService {

    private final StudyRepository studyRepository;
    private final MemberRepository memberRepository;
    private final StudyMemberRepository studyMemberRepository;
    private final StudyInviteRepository studyInviteRepository;
    private final StudyVoteRepository studyVoteRepository;


    @Override
    public Long createStudy(StudyCreateRequestDto request){

        if(studyRepository.existsByName(request.getName())){//
            throw new IllegalArgumentException("이미 존재하는 스터디 이름입니다.");
        }

        Study study = new Study(request.getName(),request.getMinAge());
        studyRepository.save(study);
        return study.getId();
    }

    @Override
    public void inviteStudy(StudyInviteRequestDto request){

        if(request.getInviterId().equals(request.getInviteeId())){
            throw new IllegalArgumentException("자기 자신은 초대 할 수 없습니다.");
        }

        Study study = studyRepository.findById(request.getStudyId()).orElseThrow();
        Member inviter = memberRepository.findById(request.getInviterId()).orElseThrow();
        Member invitee = memberRepository.findById(request.getInviteeId()).orElseThrow();

        if(studyMemberRepository.existsByStudyIdAndMemberId(study.getId(), invitee.getId())){
            throw new IllegalArgumentException("이미 참여 중이 회원 입니다.");
        }

        if(invitee.getAge() < study.getMinAge()){
            throw new IllegalArgumentException("스터디 최소 나이 제한에 맞지 않는 회원 입니다.");
        }

        long voteCount = studyVoteRepository.countByStudyIdAndVoteType(study.getId(), VoteType.INVITE);
        long memberCount = studyMemberRepository.countByStudyId(study.getId());

        if(voteCount <= memberCount/2){
            throw new IllegalStateException("과반수 투표가 필요합니다.");
        }

        studyInviteRepository.save(new StudyInvite(study, inviter, invitee));

    }

    @Override
    public void acceptInvite(InviteAcceptRequestDto request){

        StudyInvite invite = studyInviteRepository.findById(request.getInviteId()).orElseThrow();
        invite.getStatus().equals(InviteStatus.ACCEPTED);

        studyMemberRepository.save(
                new StudyMember(invite.getStudy(), invite.getInvitee())
        );

    }

    @Override
    @Transactional(readOnly = true)
    public List<StudyResponseDto> getStudies(){
        return studyRepository.findAll()
                .stream()
                .map(s -> new StudyResponseDto(s.getId(),s.getName(),s.getMinAge()))
                .toList();

    }

    @Override
    @Transactional(readOnly = true)
    public List<StudyInviteResponseDto> getMyInvites(Long memberId) {
        return studyInviteRepository.findByInviteeId(memberId)
                .stream()
                .map(i -> new StudyInviteResponseDto(
                        i.getId(),
                        i.getStudy().getName(),
                        i.getInviter().getName(),
                        i.getStatus().name()
                ))
                .toList();
    }



}
