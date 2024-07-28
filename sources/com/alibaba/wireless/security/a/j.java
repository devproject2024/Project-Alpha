package com.alibaba.wireless.security.a;

import com.alibaba.wireless.security.b.b;

final class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f14640a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f14641b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ h f14642c;

    j(h hVar, String str, String str2) {
        this.f14642c = hVar;
        this.f14640a = str;
        this.f14641b = str2;
    }

    public final void run() {
        try {
            boolean unused = this.f14642c.a(this.f14640a, this.f14641b, true);
        } catch (b unused2) {
            com.alibaba.wireless.security.a.a.b.c();
        }
    }
}
