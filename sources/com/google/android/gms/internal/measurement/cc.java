package com.google.android.gms.internal.measurement;

final class cc extends by {

    /* renamed from: a  reason: collision with root package name */
    private final cb f10521a = new cb();

    cc() {
    }

    public final void a(Throwable th, Throwable th2) {
        if (th2 == th) {
            throw new IllegalArgumentException("Self suppression is not allowed.", th2);
        } else if (th2 != null) {
            this.f10521a.a(th).add(th2);
        } else {
            throw new NullPointerException("The suppressed exception cannot be null.");
        }
    }
}
