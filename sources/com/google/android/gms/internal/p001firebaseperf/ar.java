package com.google.android.gms.internal.p001firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.ar  reason: invalid package */
public enum ar implements ds {
    APPLICATION_PROCESS_STATE_UNKNOWN(0),
    FOREGROUND(1),
    BACKGROUND(2),
    FOREGROUND_BACKGROUND(3);
    
    private static final dv<ar> zzjf = null;
    private final int value;

    public final int zzdp() {
        return this.value;
    }

    public static du zzdq() {
        return as.f9501a;
    }

    private ar(int i2) {
        this.value = i2;
    }

    static {
        zzjf = new at();
    }
}
