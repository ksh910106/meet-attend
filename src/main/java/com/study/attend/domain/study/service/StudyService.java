package com.study.attend.domain.study.service;

import com.study.attend.domain.study.dto.StudyRequestDto;

public interface StudyService {

    Long createStudy(StudyRequestDto request);
}
