package com.google.firebase.crashlytics.a.c;

public enum t {
    DEVELOPER(1),
    USER_SIDELOAD(2),
    TEST_DISTRIBUTION(3),
    APP_STORE(4);
    
    private final int id;

    private t(int i2) {
        this.id = i2;
    }

    public final int getId() {
        return this.id;
    }

    public final String toString() {
        return Integer.toString(this.id);
    }

    public static t determineFrom(String str) {
        return str != null ? APP_STORE : DEVELOPER;
    }
}
