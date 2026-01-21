package com.study.attend.domain.study.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StudyInviteRequestDto {

    private Long inviteeId;
    private Long inviterId;

}
