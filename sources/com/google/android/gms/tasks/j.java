package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

final class j<TResult, TContinuationResult> implements y<TResult> {

    /* renamed from: a  reason: collision with root package name */
    final a<TResult, TContinuationResult> f12492a;

    /* renamed from: b  reason: collision with root package name */
    final ab<TContinuationResult> f12493b;

    /* renamed from: c  reason: collision with root package name */
    private final Executor f12494c;

    public j(Executor executor, a<TResult, TContinuationResult> aVar, ab<TContinuationResult> abVar) {
        this.f12494c = executor;
        this.f12492a = aVar;
        this.f12493b = abVar;
    }

    public final void a(Task<TResult> task) {
        this.f12494c.execute(new l(this, task));
    }

    public final void P_() {
        throw new UnsupportedOperationException();
    }
}
