package com.alipay.imobile.network.quake.h.a;

import com.alipay.imobile.network.quake.h.a.e;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    final int f14864a;

    /* renamed from: b  reason: collision with root package name */
    final e f14865b;

    /* renamed from: c  reason: collision with root package name */
    final g f14866c;

    /* renamed from: d  reason: collision with root package name */
    private final String f14867d;

    /* renamed from: e  reason: collision with root package name */
    private final String f14868e;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        String f14869a;

        /* renamed from: b  reason: collision with root package name */
        int f14870b = -1;

        /* renamed from: c  reason: collision with root package name */
        String f14871c;

        /* renamed from: d  reason: collision with root package name */
        e.a f14872d = new e.a();

        /* renamed from: e  reason: collision with root package name */
        g f14873e;
    }

    /* synthetic */ f(a aVar, byte b2) {
        this(aVar);
    }

    public final String toString() {
        return "Response{code=" + this.f14864a + ", message=" + this.f14868e + '}';
    }

    private f(a aVar) {
        this.f14867d = aVar.f14869a;
        this.f14864a = aVar.f14870b;
        this.f14868e = aVar.f14871c;
        this.f14865b = new e(aVar.f14872d, (byte) 0);
        this.f14866c = aVar.f14873e;
    }
}
