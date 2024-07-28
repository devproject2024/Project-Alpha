package com.google.zxing;

import com.google.zxing.b.b;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final b f39937a;

    /* renamed from: b  reason: collision with root package name */
    private b f39938b;

    public c(b bVar) {
        if (bVar != null) {
            this.f39937a = bVar;
            return;
        }
        throw new IllegalArgumentException("Binarizer must be non-null.");
    }

    public final int a() {
        return this.f39937a.f39879a.f40563b;
    }

    public final b b() throws m {
        if (this.f39938b == null) {
            this.f39938b = this.f39937a.a();
        }
        return this.f39938b;
    }

    public final String toString() {
        try {
            return b().toString();
        } catch (m unused) {
            return "";
        }
    }
}
