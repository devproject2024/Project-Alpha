package com.sendbird.android;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

final class v {

    /* renamed from: a  reason: collision with root package name */
    private final ExecutorService f45333a;

    v(ExecutorService executorService) {
        this.f45333a = executorService;
    }

    /* access modifiers changed from: package-private */
    public final <T> Future<T> a(s<T> sVar) {
        if (b()) {
            return this.f45333a.submit(sVar.r);
        }
        throw new RuntimeException("Task has been terminated");
    }

    /* access modifiers changed from: package-private */
    public final <T> Future<T> a(q<T> qVar) {
        if (b()) {
            return this.f45333a.submit(qVar.r);
        }
        throw new RuntimeException("Task has been terminated");
    }

    private boolean b() {
        ExecutorService executorService = this.f45333a;
        return executorService != null && !executorService.isShutdown() && !this.f45333a.isTerminated();
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        ExecutorService executorService = this.f45333a;
        if (executorService instanceof CancelableExecutorService) {
            ((CancelableExecutorService) executorService).cancelAll(true);
        }
    }
}
