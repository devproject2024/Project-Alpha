package com.google.android.play.core.d;

import com.google.android.play.core.e.a;
import com.google.android.play.core.e.e;
import com.google.android.play.core.e.p;

final /* synthetic */ class ai implements a {

    /* renamed from: a  reason: collision with root package name */
    private final aq f37347a;

    /* renamed from: b  reason: collision with root package name */
    private final p f37348b;

    ai(aq aqVar, p pVar) {
        this.f37347a = aqVar;
        this.f37348b = pVar;
    }

    public final void onComplete(e eVar) {
        aq aqVar = this.f37347a;
        p pVar = this.f37348b;
        if (eVar.b()) {
            aqVar.a((b) eVar.c()).a(new ak(pVar));
        } else {
            pVar.a(eVar.d());
        }
    }
}
