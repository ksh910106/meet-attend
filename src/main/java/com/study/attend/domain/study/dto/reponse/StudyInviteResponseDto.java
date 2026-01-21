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

    public static StudyInviteResponseDto from(StudyInvite invite) {
        return new StudyInviteResponseDto(
                invite.getId(),
                invite.getStudy().getName(),
                invite.getInviter().getName(),
                invite.getStatus().name()
        );
    }

}
