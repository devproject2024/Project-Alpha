package com.alipay.mobile.rome.syncsdk.service;

import java.util.concurrent.ThreadFactory;

final class d implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f15139a;

    d(c cVar) {
        this.f15139a = cVar;
    }

    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, "Link_task_executor");
        thread.setDaemon(true);
        return thread;
    }
}
