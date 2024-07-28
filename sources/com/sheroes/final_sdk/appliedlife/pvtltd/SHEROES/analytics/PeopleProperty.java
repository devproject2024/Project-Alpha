package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.analytics;

public enum PeopleProperty {
    CURRENT_STATUS("Current Status"),
    SKILLS("Skills"),
    INTEREST("Interest"),
    WORK_EXPERIENCE("Work Experience");
    
    private final String string;

    private PeopleProperty(String str) {
        this.string = str;
    }

    public final String getString() {
        return this.string;
    }
}
