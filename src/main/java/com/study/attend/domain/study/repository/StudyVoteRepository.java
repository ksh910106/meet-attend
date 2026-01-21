package com.study.attend.domain.study.repository;

import com.study.attend.domain.member.entity.Member;
import com.study.attend.domain.study.entity.Study;
import com.study.attend.domain.study.entity.StudyVote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyVoteRepository extends JpaRepository<StudyVote, Long> {

    long countByStudyAndTarget(Study study, Member target);

}
