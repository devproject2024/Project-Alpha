package com.google.android.gms.internal.firebase_ml;

import com.google.android.gms.common.api.internal.c;
import com.google.android.gms.common.internal.j;

final /* synthetic */ class eb implements c.a {

    /* renamed from: a  reason: collision with root package name */
    private final ec f9841a;

    eb(ec ecVar) {
        this.f9841a = ecVar;
    }

    public final void a(boolean z) {
        ec ecVar = this.f9841a;
        j jVar = ec.f9842a;
        StringBuilder sb = new StringBuilder(34);
        sb.append("Background state changed to: ");
        sb.append(z);
        jVar.b(sb.toString());
        ecVar.f9844b.set(z ? 2000 : 300000);
        ecVar.a();
    }
}
