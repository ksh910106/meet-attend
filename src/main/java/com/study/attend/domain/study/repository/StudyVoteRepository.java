package com.study.attend.domain.study.repository;

import com.study.attend.domain.study.entity.StudyVote;
import com.study.attend.domain.study.entity.VoteType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyVoteRepository extends JpaRepository<StudyVote, Long> {

    long countByStudyIdAndVoteType(Long studyId, VoteType voteType);

}
