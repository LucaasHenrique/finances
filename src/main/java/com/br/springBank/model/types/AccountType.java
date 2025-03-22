package com.br.springBank.model.types;

public enum AccountType {
    CARD("card"),
    CHECKING_ACCOUNT("checkingAccount"),
    SAVINGS_ACCOUNT("savingsAccount");

    private final String Accounttype;

    AccountType(String type) {
        this.Accounttype = type;
    }

    public String getAccountType() {
        return Accounttype;
    }
}
