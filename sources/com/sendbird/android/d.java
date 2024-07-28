package com.sendbird.android;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

final class d {

    /* renamed from: a  reason: collision with root package name */
    private static final ExecutorService f44704a = CancelableExecutorService.newCachedThreadExecutor();

    static <T> Future<T> a(s<T> sVar) {
        return f44704a.submit(sVar.r);
    }

    static <T> Future<T> a(q<T> qVar) {
        return f44704a.submit(qVar.r);
    }
}
