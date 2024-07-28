package com.google.android.play.core.d;

import com.google.android.play.core.e.a;
import com.google.android.play.core.e.e;
import com.google.android.play.core.e.p;

final /* synthetic */ class ak implements a {

    /* renamed from: a  reason: collision with root package name */
    private final p f37351a;

    ak(p pVar) {
        this.f37351a = pVar;
    }

    public final void onComplete(e eVar) {
        p pVar = this.f37351a;
        if (eVar.b()) {
            pVar.a(eVar.c());
        } else {
            pVar.a(eVar.d());
        }
    }
}
