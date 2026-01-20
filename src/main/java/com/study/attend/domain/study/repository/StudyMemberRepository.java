package com.study.attend.domain.study.repository;

import com.study.attend.domain.member.entity.Member;
import com.study.attend.domain.study.entity.Study;
import com.study.attend.domain.study.entity.StudyMemeber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyMemberRepository extends JpaRepository<StudyMemeber, Long> {

    boolean existsByStudyAndMember(Study study, Member member);

    long countByStudy(Study study);

}
