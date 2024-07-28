package com.google.android.gms.measurement.internal;

abstract class jg extends jh {

    /* renamed from: a  reason: collision with root package name */
    private boolean f12260a;

    jg(jj jjVar) {
        super(jjVar);
        this.f12261b.f12268d++;
    }

    /* access modifiers changed from: protected */
    public abstract boolean a();

    /* access modifiers changed from: package-private */
    public final boolean v() {
        return this.f12260a;
    }

    /* access modifiers changed from: protected */
    public final void w() {
        if (!v()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void x() {
        if (!this.f12260a) {
            a();
            this.f12261b.f12269e++;
            this.f12260a = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }
}
