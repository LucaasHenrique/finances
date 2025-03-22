package com.br.springBank.model.types;

public enum GroupType {
    INCOME("income"),
    EXPENSE("expense");

    private final String role;

    GroupType(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
