package com.study.attend.domain.study.service;

import com.study.attend.domain.study.dto.reponse.StudyCreateResponseDto;
import com.study.attend.domain.study.dto.reponse.StudyInviteResponseDto;
import com.study.attend.domain.study.dto.reponse.StudyResponseDto;
import com.study.attend.domain.study.dto.request.InviteAcceptRequestDto;
import com.study.attend.domain.study.dto.request.StudyCreateRequestDto;
import com.study.attend.domain.study.dto.request.StudyInviteRequestDto;

import java.util.List;

public interface StudyService {

    StudyCreateResponseDto createStudy(StudyCreateRequestDto request);

    void inviteMember(Long studyId, StudyInviteRequestDto request);

    void acceptInvite(InviteAcceptRequestDto request);

    List<StudyResponseDto> getStudies();

    List<StudyInviteResponseDto> getMyInvites(Long memberId);


}
