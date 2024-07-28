package com.google.android.play.core.e;

import java.util.concurrent.Executor;

final class m<ResultT> implements n<ResultT> {

    /* renamed from: a  reason: collision with root package name */
    final Object f37470a = new Object();

    /* renamed from: b  reason: collision with root package name */
    final c<? super ResultT> f37471b;

    /* renamed from: c  reason: collision with root package name */
    private final Executor f37472c;

    public m(Executor executor, c<? super ResultT> cVar) {
        this.f37472c = executor;
        this.f37471b = cVar;
    }

    public final void a(e<ResultT> eVar) {
        if (eVar.b()) {
            synchronized (this.f37470a) {
                if (this.f37471b != null) {
                    this.f37472c.execute(new l(this, eVar));
                }
            }
        }
    }
}
