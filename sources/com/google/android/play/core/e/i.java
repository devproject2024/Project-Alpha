package com.google.android.play.core.e;

import java.util.concurrent.Executor;

final class i<ResultT> implements n<ResultT> {

    /* renamed from: a  reason: collision with root package name */
    final Object f37460a = new Object();

    /* renamed from: b  reason: collision with root package name */
    final a<ResultT> f37461b;

    /* renamed from: c  reason: collision with root package name */
    private final Executor f37462c;

    public i(Executor executor, a<ResultT> aVar) {
        this.f37462c = executor;
        this.f37461b = aVar;
    }

    public final void a(e<ResultT> eVar) {
        synchronized (this.f37460a) {
            if (this.f37461b != null) {
                this.f37462c.execute(new h(this, eVar));
            }
        }
    }
}
