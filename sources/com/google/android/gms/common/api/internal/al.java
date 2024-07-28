package com.google.android.gms.common.api.internal;

import com.google.android.gms.signin.internal.d;
import com.google.android.gms.signin.internal.zak;
import java.lang.ref.WeakReference;

final class al extends d {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<ag> f8420a;

    al(ag agVar) {
        this.f8420a = new WeakReference<>(agVar);
    }

    public final void a(zak zak) {
        ag agVar = (ag) this.f8420a.get();
        if (agVar != null) {
            agVar.f8403a.a((ax) new ao(agVar, agVar, zak));
        }
    }
}
