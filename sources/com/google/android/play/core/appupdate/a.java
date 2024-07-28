package com.google.android.play.core.appupdate;

import android.app.PendingIntent;

public abstract class a {
    private final boolean b(e eVar) {
        return eVar.b() && i() <= j();
    }

    /* access modifiers changed from: package-private */
    public final PendingIntent a(e eVar) {
        if (eVar.a() != 0) {
            if (eVar.a() == 1) {
                if (k() != null) {
                    return k();
                }
                if (b(eVar)) {
                    return m();
                }
            }
            return null;
        } else if (l() != null) {
            return l();
        } else {
            if (b(eVar)) {
                return n();
            }
            return null;
        }
    }

    public abstract String a();

    public abstract int b();

    public abstract int c();

    public abstract int d();

    public abstract Integer e();

    public abstract int f();

    public abstract long g();

    public abstract long h();

    /* access modifiers changed from: package-private */
    public abstract long i();

    /* access modifiers changed from: package-private */
    public abstract long j();

    /* access modifiers changed from: package-private */
    public abstract PendingIntent k();

    /* access modifiers changed from: package-private */
    public abstract PendingIntent l();

    /* access modifiers changed from: package-private */
    public abstract PendingIntent m();

    /* access modifiers changed from: package-private */
    public abstract PendingIntent n();

    public final boolean a(int i2) {
        return a(e.a(i2).b()) != null;
    }
}
