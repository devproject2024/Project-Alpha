package com.google.android.play.core.b;

import com.google.android.play.core.e.p;

public abstract class c implements Runnable {

    /* renamed from: g  reason: collision with root package name */
    final p<?> f37300g;

    c() {
        this.f37300g = null;
    }

    public c(p<?> pVar) {
        this.f37300g = pVar;
    }

    /* access modifiers changed from: protected */
    public abstract void a();

    public final void run() {
        try {
            a();
        } catch (Exception e2) {
            p<?> pVar = this.f37300g;
            if (pVar != null) {
                pVar.b(e2);
            }
        }
    }
}
