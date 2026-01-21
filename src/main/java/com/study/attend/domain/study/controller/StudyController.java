package com.study.attend.domain.study.controller;

import com.study.attend.domain.study.dto.reponse.StudyCreateResponseDto;
import com.study.attend.domain.study.dto.reponse.StudyInviteResponseDto;
import com.study.attend.domain.study.dto.reponse.StudyResponseDto;
import com.study.attend.domain.study.dto.request.InviteAcceptRequestDto;
import com.study.attend.domain.study.dto.request.StudyCreateRequestDto;
import com.study.attend.domain.study.dto.request.StudyInviteRequestDto;
import com.study.attend.domain.study.service.StudyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studies")
@RequiredArgsConstructor
public class StudyController {

    private final StudyService studyService;

    @PostMapping
    public StudyCreateResponseDto create(@RequestBody StudyCreateRequestDto request){
        return studyService.createStudy(request);

    }

    @PostMapping("/{studyId}/invite")
    public void invite(@PathVariable Long studyId,
                       @RequestBody StudyInviteRequestDto request) {
        studyService.inviteMember(studyId, request);
    }

    @PostMapping("/invite/accept")
    public void accept(@RequestBody InviteAcceptRequestDto request) {
        studyService.acceptInvite(request);
    }

    @GetMapping
    public List<StudyResponseDto> list() {
        return studyService.getStudies();
    }

    @GetMapping("/invites")
    public List<StudyInviteResponseDto> myInvites(@RequestParam Long memberId) {
        return studyService.getMyInvites(memberId);
    }





}
