package com.alipay.imobile.network.quake;

import com.alipay.imobile.network.quake.b.a;

public final class g<T> {

    /* renamed from: a  reason: collision with root package name */
    public final T f14787a;

    /* renamed from: b  reason: collision with root package name */
    public final a.C0201a f14788b;

    /* renamed from: c  reason: collision with root package name */
    public final com.alipay.mobile.b.b.a f14789c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f14790d;

    private g(com.alipay.mobile.b.b.a aVar) {
        this.f14790d = false;
        this.f14787a = null;
        this.f14788b = null;
        this.f14789c = aVar;
    }

    private g(T t, a.C0201a aVar) {
        this.f14790d = false;
        this.f14787a = t;
        this.f14788b = aVar;
        this.f14789c = null;
    }

    public static <T> g<T> a(com.alipay.mobile.b.b.a aVar) {
        return new g<>(aVar);
    }

    public static <T> g<T> a(T t, a.C0201a aVar) {
        return new g<>(t, aVar);
    }
}
