package com.google.android.gms.internal.p001firebaseperf;

import java.io.IOException;

/* renamed from: com.google.android.gms.internal.firebase-perf.dy  reason: invalid package */
public class dy extends IOException {
    private ex zzrs = null;

    public dy(String str) {
        super(str);
    }

    static eb zzhy() {
        return new eb("Protocol message tag had invalid wire type.");
    }
}
