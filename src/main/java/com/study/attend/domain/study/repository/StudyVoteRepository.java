package com.study.attend.domain.study.repository;

import com.study.attend.domain.study.entity.StudyInvitation;
import com.study.attend.domain.study.entity.StudyVote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyVoteRepository extends JpaRepository<StudyVote, Long> {

    long countByInvitationAndAgreeTrue(StudyInvitation invitation);

}
