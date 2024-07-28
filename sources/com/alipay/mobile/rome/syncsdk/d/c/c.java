package com.alipay.mobile.rome.syncsdk.d.c;

import java.util.concurrent.ThreadFactory;

final class c implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f15036a;

    c(b bVar) {
        this.f15036a = bVar;
    }

    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, "longlink dispatcher");
    }
}
