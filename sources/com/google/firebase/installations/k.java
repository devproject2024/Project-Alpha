package com.google.firebase.installations;

import com.google.android.gms.tasks.f;
import com.google.firebase.installations.a.d;

final class k implements n {

    /* renamed from: a  reason: collision with root package name */
    final f<String> f38982a;

    public final boolean a(d dVar, Exception exc) {
        return false;
    }

    public k(f<String> fVar) {
        this.f38982a = fVar;
    }

    public final boolean a(d dVar) {
        if (!dVar.k() && !dVar.i() && !dVar.j()) {
            return false;
        }
        this.f38982a.b(dVar.a());
        return true;
    }
}
