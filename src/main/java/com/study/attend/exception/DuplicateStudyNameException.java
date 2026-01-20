package com.study.attend.exception;

public class DuplicateStudyNameException extends RuntimeException {

    public DuplicateStudyNameException(String name) {
        super(name +"은 이미 존재하는 스터디 이름입니다.");
    }

}
