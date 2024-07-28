package com.google.android.gms.measurement.internal;

abstract class fw extends ft {

    /* renamed from: a  reason: collision with root package name */
    private boolean f12001a;

    fw(fc fcVar) {
        super(fcVar);
        this.y.j++;
    }

    /* access modifiers changed from: protected */
    public abstract boolean a();

    /* access modifiers changed from: protected */
    public void b() {
    }

    /* access modifiers changed from: package-private */
    public final boolean v() {
        return this.f12001a;
    }

    /* access modifiers changed from: protected */
    public final void w() {
        if (!v()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void x() {
        if (this.f12001a) {
            throw new IllegalStateException("Can't initialize twice");
        } else if (!a()) {
            this.y.t();
            this.f12001a = true;
        }
    }

    public final void y() {
        if (!this.f12001a) {
            b();
            this.y.t();
            this.f12001a = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }
}
