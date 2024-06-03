package org.example.emptest.entity;

import lombok.Getter;

public enum EmpType {
    A("사원"),
    B("임원"),
    C("관리자"),
    D("퇴사자");

    @Getter
    private final String description;

    EmpType(String description) {
        this.description = description;
    }
}
