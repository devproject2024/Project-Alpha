package com.google.firebase.perf.internal;

import com.google.android.gms.internal.p001firebaseperf.ba;
import com.google.android.gms.internal.p001firebaseperf.bc;

final class m extends v {

    /* renamed from: a  reason: collision with root package name */
    private final bc f39218a;

    m(bc bcVar) {
        this.f39218a = bcVar;
    }

    public final boolean a() {
        if ((this.f39218a.zzii & 1) != 0) {
            if (this.f39218a.b() <= 0 && this.f39218a.c() <= 0) {
                if (this.f39218a.a()) {
                    bc bcVar = this.f39218a;
                    if (((bcVar.zzka == null ? ba.b() : bcVar.zzka).zzii & 16) != 0) {
                        return true;
                    }
                }
            }
            return true;
        }
        return false;
    }
}
