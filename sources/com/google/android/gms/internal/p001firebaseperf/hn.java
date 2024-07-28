package com.google.android.gms.internal.p001firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.hn  reason: invalid package */
public class hn<E> {
    static int a(int i2, int i3) {
        if (i3 >= 0) {
            int i4 = i2 + (i2 >> 1) + 1;
            if (i4 < i3) {
                i4 = Integer.highestOneBit(i3 - 1) << 1;
            }
            if (i4 < 0) {
                return Integer.MAX_VALUE;
            }
            return i4;
        }
        throw new AssertionError("cannot store more than MAX_VALUE elements");
    }

    hn() {
    }
}
