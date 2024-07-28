package com.google.android.gms.internal.p001firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.ac  reason: invalid package */
public enum ac {
    GIGABYTES(1073741824),
    KILOBYTES(1024),
    BYTES(1);
    
    private long zzic;

    private ac(long j) {
        this.zzic = j;
    }

    public final long zzp(long j) {
        return (j * this.zzic) / KILOBYTES.zzic;
    }
}
