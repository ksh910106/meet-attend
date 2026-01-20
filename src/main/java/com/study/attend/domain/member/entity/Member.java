package com.study.attend.domain.member.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "MEMBER_TBL")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int age;

}
