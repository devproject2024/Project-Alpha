package com.google.android.play.core.b;

final class bd extends az {

    /* renamed from: a  reason: collision with root package name */
    private final bb f37285a = new bb();

    bd() {
    }

    public final void a(Throwable th, Throwable th2) {
        if (th2 == th) {
            throw new IllegalArgumentException("Self suppression is not allowed.", th2);
        } else if (th2 != null) {
            this.f37285a.a(th).add(th2);
        } else {
            throw new NullPointerException("The suppressed exception cannot be null.");
        }
    }
}
