package com.airbnb.lottie.c;

import androidx.a.e;
import com.airbnb.lottie.d;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    private static final g f5966a = new g();

    /* renamed from: b  reason: collision with root package name */
    private final e<String, d> f5967b = new e<>(20);

    public static g a() {
        return f5966a;
    }

    g() {
    }

    public final d a(String str) {
        if (str == null) {
            return null;
        }
        return this.f5967b.get(str);
    }

    public final void a(String str, d dVar) {
        if (str != null) {
            this.f5967b.put(str, dVar);
        }
    }
}
