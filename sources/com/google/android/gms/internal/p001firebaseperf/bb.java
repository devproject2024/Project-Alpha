package com.google.android.gms.internal.p001firebaseperf;

import android.database.ContentObserver;
import android.os.Handler;

/* renamed from: com.google.android.gms.internal.firebase-perf.bb  reason: invalid package */
final class bb extends ContentObserver {
    bb() {
        super((Handler) null);
    }

    public final void onChange(boolean z) {
        a.f9489e.set(true);
    }
}
