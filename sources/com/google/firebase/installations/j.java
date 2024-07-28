package com.google.firebase.installations;

import com.google.android.gms.tasks.f;
import com.google.firebase.installations.a;
import com.google.firebase.installations.a.d;

final class j implements n {

    /* renamed from: a  reason: collision with root package name */
    private final o f38980a;

    /* renamed from: b  reason: collision with root package name */
    private final f<l> f38981b;

    public j(o oVar, f<l> fVar) {
        this.f38980a = oVar;
        this.f38981b = fVar;
    }

    public final boolean a(d dVar) {
        if (!dVar.i() || o.a(dVar)) {
            return false;
        }
        this.f38981b.a(new a.C0648a().a(dVar.c()).a(dVar.e()).b(dVar.f()).a());
        return true;
    }

    public final boolean a(d dVar, Exception exc) {
        if (!dVar.j() && !dVar.l() && !dVar.k()) {
            return false;
        }
        this.f38981b.b(exc);
        return true;
    }
}
