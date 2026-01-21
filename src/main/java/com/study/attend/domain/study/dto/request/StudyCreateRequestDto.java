package com.study.attend.domain.study.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StudyCreateRequestDto {

    private Long memberId;
    private String name;
    private int minAge;
}
