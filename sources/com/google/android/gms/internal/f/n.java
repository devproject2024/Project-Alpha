package com.google.android.gms.internal.f;

final class n extends m {

    /* renamed from: a  reason: collision with root package name */
    private final l f9483a = new l();

    n() {
    }

    public final void a(Throwable th, Throwable th2) {
        if (th2 == th) {
            throw new IllegalArgumentException("Self suppression is not allowed.", th2);
        } else if (th2 != null) {
            this.f9483a.a(th).add(th2);
        } else {
            throw new NullPointerException("The suppressed exception cannot be null.");
        }
    }
}
