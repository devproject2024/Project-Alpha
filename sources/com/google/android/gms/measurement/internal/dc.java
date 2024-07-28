package com.google.android.gms.measurement.internal;

abstract class dc extends eb {

    /* renamed from: a  reason: collision with root package name */
    private boolean f11786a;

    dc(fc fcVar) {
        super(fcVar);
        this.y.j++;
    }

    /* access modifiers changed from: protected */
    public abstract boolean x();

    /* access modifiers changed from: protected */
    public void y() {
    }

    /* access modifiers changed from: package-private */
    public final boolean t() {
        return this.f11786a;
    }

    /* access modifiers changed from: protected */
    public final void u() {
        if (!t()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void v() {
        if (this.f11786a) {
            throw new IllegalStateException("Can't initialize twice");
        } else if (!x()) {
            this.y.t();
            this.f11786a = true;
        }
    }

    public final void w() {
        if (!this.f11786a) {
            y();
            this.y.t();
            this.f11786a = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }
}
