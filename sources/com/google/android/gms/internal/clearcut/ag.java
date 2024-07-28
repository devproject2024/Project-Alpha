package com.google.android.gms.internal.clearcut;

final class ag {

    /* renamed from: a  reason: collision with root package name */
    final am f9124a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f9125b;

    private ag(int i2) {
        this.f9125b = new byte[i2];
        this.f9124a = am.a(this.f9125b);
    }

    /* synthetic */ ag(int i2, byte b2) {
        this(i2);
    }

    public final ab a() {
        if (this.f9124a.i() == 0) {
            return new ai(this.f9125b);
        }
        throw new IllegalStateException("Did not write as much data as expected.");
    }
}
