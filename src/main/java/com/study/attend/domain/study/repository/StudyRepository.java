package com.study.attend.domain.study.repository;

import com.study.attend.domain.study.entity.Study;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyRepository extends JpaRepository<Study,Long> {

    boolean existsByName(String name);
}
