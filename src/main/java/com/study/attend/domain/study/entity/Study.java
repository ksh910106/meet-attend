package com.study.attend.domain.study.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name ="STUDY_TBL",
       uniqueConstraints = {@UniqueConstraint(columnNames = "name")})
public class Study {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private int minAge;

    public Study(String name, int minAge){
        this.name = name;
        this.minAge = minAge;
    }

}
