package com.study.attend.domain.study.service;

public interface StudyInviteService {

    Long invite(Long studyId, Long inviterId, Long inviteMemberId);
}
