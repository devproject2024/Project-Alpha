package com.google.android.play.core.d;

import com.google.android.play.core.e.p;

final /* synthetic */ class aj implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final ar f37349a;

    /* renamed from: b  reason: collision with root package name */
    private final p f37350b;

    aj(ar arVar, p pVar) {
        this.f37349a = arVar;
        this.f37350b = pVar;
    }

    public final void run() {
        ar arVar = this.f37349a;
        p pVar = this.f37350b;
        try {
            pVar.a(arVar.c());
        } catch (Exception e2) {
            pVar.a(e2);
        }
    }
}
