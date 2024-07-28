package com.google.android.gms.internal.p001firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.g  reason: invalid package */
public final class g {
    public static int a(long j) {
        if (j > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j;
    }
}
