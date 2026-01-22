package com.study.attend.domain.study.repository;

import com.study.attend.domain.study.entity.StudyInvite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudyInviteRepository extends JpaRepository<StudyInvite, Long> {
    List<StudyInvite> findByInviteeId(Long memberId);
}
