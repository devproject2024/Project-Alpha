package com.alipay.mobile.rome.syncsdk.d.c;

import com.alipay.mobile.rome.syncsdk.d.b.a;

final class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    a f15037a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ b f15038b;

    /* renamed from: c  reason: collision with root package name */
    private a f15039c;

    public d(b bVar, a aVar, a aVar2) {
        this.f15038b = bVar;
        this.f15039c = aVar2;
        this.f15037a = aVar;
    }

    public final void run() {
        this.f15037a.a(this.f15039c);
    }
}
