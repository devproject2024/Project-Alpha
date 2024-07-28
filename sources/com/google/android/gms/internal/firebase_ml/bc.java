package com.google.android.gms.internal.firebase_ml;

final class bc extends bb {

    /* renamed from: a  reason: collision with root package name */
    private final ba f9763a = new ba();

    bc() {
    }

    public final void a(Throwable th, Throwable th2) {
        if (th2 == th) {
            throw new IllegalArgumentException("Self suppression is not allowed.", th2);
        } else if (th2 != null) {
            this.f9763a.a(th).add(th2);
        } else {
            throw new NullPointerException("The suppressed exception cannot be null.");
        }
    }
}
