package com.study.attend.domain.study.repository;

import com.study.attend.domain.study.entity.StudyMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyMemberRepository extends JpaRepository<StudyMember, Long> {

    boolean existsByStudyIdAndMemberId(Long studyId, Long memberId);

    long countByStudyId(Long studyId);

}
