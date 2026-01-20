package com.study.attend.domain.study.controller;

import com.study.attend.domain.study.dto.StudyRequestDto;
import com.study.attend.domain.study.service.StudyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/studies")
@RequiredArgsConstructor
public class StudyController {

    private final StudyService studyService;

    @PostMapping
    public ResponseEntity<Long> createStudy(@RequestBody StudyRequestDto request){

        return ResponseEntity.ok(studyService.createStudy(request));
    }

}
