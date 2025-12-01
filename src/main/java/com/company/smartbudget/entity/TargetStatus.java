package com.company.smartbudget.entity;

import io.jmix.core.metamodel.datatype.EnumClass;

import org.springframework.lang.Nullable;


public enum TargetStatus implements EnumClass<String> {

    ACTIVE("A"),
    COMPLITED("C"),
    FAILED("F");

    private final String id;

    TargetStatus(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static TargetStatus fromId(String id) {
        for (TargetStatus at : TargetStatus.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}