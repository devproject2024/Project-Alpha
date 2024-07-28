package com.google.android.play.core.e;

import java.util.concurrent.Executor;

final class k<ResultT> implements n<ResultT> {

    /* renamed from: a  reason: collision with root package name */
    final Object f37465a = new Object();

    /* renamed from: b  reason: collision with root package name */
    final b f37466b;

    /* renamed from: c  reason: collision with root package name */
    private final Executor f37467c;

    public k(Executor executor, b bVar) {
        this.f37467c = executor;
        this.f37466b = bVar;
    }

    public final void a(e<ResultT> eVar) {
        if (!eVar.b()) {
            synchronized (this.f37465a) {
                if (this.f37466b != null) {
                    this.f37467c.execute(new j(this, eVar));
                }
            }
        }
    }
}
