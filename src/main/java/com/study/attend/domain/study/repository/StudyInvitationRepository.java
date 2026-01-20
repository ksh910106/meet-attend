package com.study.attend.domain.study.repository;

import com.study.attend.domain.study.entity.StudyInvitation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyInvitationRepository extends JpaRepository<StudyInvitation, Long> {
}
