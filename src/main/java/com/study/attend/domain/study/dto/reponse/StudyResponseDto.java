package com.study.attend.domain.study.dto.reponse;

import com.study.attend.domain.study.entity.Study;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StudyResponseDto {

    private Long id;
    private String name;
    private int minAge;

}
