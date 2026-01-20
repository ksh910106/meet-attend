package com.study.attend.domain.member.repository;

import com.study.attend.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;


//레포지토리의 역할
//1 Member엔터티를 DB에 저장하고 수정 삭제를 함.
//2 Member테이블과 자바 코드 사이를 연결
public interface MemberRepository extends JpaRepository<Member,Long> {

}
