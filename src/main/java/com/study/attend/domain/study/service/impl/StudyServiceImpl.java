package com.study.attend.domain.study.service.impl;

import com.study.attend.domain.study.dto.StudyRequestDto;
import com.study.attend.domain.study.entity.Study;
import com.study.attend.domain.study.repository.StudyRepository;
import com.study.attend.domain.study.service.StudyService;
import com.study.attend.exception.DuplicateStudyNameException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class StudyServiceImpl implements StudyService {

    private final StudyRepository studyRepository;

    @Override
    public Long createStudy(StudyRequestDto request) {

        if(studyRepository.existsByName(request.getName())){
            throw new DuplicateStudyNameException(request.getName());
        }

        Study study = new Study(request.getName());
        return studyRepository.save(study).getId();
    }

}
