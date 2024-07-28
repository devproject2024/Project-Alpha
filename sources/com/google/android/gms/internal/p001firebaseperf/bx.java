package com.google.android.gms.internal.p001firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.bx  reason: invalid package */
public enum bx implements ds {
    SESSION_VERBOSITY_NONE(0),
    GAUGES_AND_SYSTEM_EVENTS(1);
    
    private static final dv<bx> zzjf = null;
    private final int value;

    public final int zzdp() {
        return this.value;
    }

    public static bx zzo(int i2) {
        if (i2 == 0) {
            return SESSION_VERBOSITY_NONE;
        }
        if (i2 != 1) {
            return null;
        }
        return GAUGES_AND_SYSTEM_EVENTS;
    }

    public static du zzdq() {
        return bz.f9517a;
    }

    private bx(int i2) {
        this.value = i2;
    }

    static {
        zzjf = new bw();
    }
}
