package com.google.android.gms.internal.p001firebaseperf;

import android.os.Bundle;

/* renamed from: com.google.android.gms.internal.firebase-perf.z  reason: invalid package */
public final class z {

    /* renamed from: a  reason: collision with root package name */
    public final Bundle f9735a;

    public z() {
        this(new Bundle());
    }

    public z(Bundle bundle) {
        this.f9735a = (Bundle) bundle.clone();
    }

    public final boolean a(String str, boolean z) {
        return this.f9735a.getBoolean(str, z);
    }
}
