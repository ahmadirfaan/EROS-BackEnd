package com.enigma.reimbursment.online.enums;

public enum Religion {
    ISLAM, KRISTEN,KATOLIK,BUDHA,HINDHU;

    private static final Religion[] religionList = Religion.values();

    public static Religion getReligion(int i) {
        return religionList[i];
    }
}
