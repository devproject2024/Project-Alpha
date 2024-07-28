package com.google.android.gms.internal.firebase_ml;

import com.j256.ormlite.stmt.query.SimpleComparison;

public enum ac implements gj {
    UNKNOWN_EVENT_TYPE(0),
    VALIDATION_TEST(1),
    CONTINUOUS_FEEDBACK(2);
    
    private static final gm<ac> zzac = null;
    private final int value;

    public final int zzd() {
        return this.value;
    }

    public static ac zzen(int i2) {
        if (i2 == 0) {
            return UNKNOWN_EVENT_TYPE;
        }
        if (i2 == 1) {
            return VALIDATION_TEST;
        }
        if (i2 != 2) {
            return null;
        }
        return CONTINUOUS_FEEDBACK;
    }

    public static gl zzf() {
        return ad.f9739a;
    }

    public final String toString() {
        return SimpleComparison.LESS_THAN_OPERATION + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
    }

    private ac(int i2) {
        this.value = i2;
    }

    static {
        zzac = new ab();
    }
}
