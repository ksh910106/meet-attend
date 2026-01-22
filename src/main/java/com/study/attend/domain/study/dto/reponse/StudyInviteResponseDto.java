package com.study.attend.domain.study.dto.reponse;

import com.study.attend.domain.study.entity.StudyInvite;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StudyInviteResponseDto {

    private Long inviteId;
    private String studyName;
    private String inviterName;
    private String status;

}
