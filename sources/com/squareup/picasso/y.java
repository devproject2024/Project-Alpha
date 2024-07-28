package com.squareup.picasso;

import com.squareup.picasso.ai;
import com.squareup.picasso.w;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class y extends ThreadPoolExecutor {
    y() {
        super(3, 3, 0, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new ai.b());
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2) {
        setCorePoolSize(i2);
        setMaximumPoolSize(i2);
    }

    public final Future<?> submit(Runnable runnable) {
        a aVar = new a((c) runnable);
        execute(aVar);
        return aVar;
    }

    static final class a extends FutureTask<c> implements Comparable<a> {

        /* renamed from: a  reason: collision with root package name */
        private final c f45475a;

        public final /* synthetic */ int compareTo(Object obj) {
            a aVar = (a) obj;
            w.e eVar = this.f45475a.s;
            w.e eVar2 = aVar.f45475a.s;
            return eVar == eVar2 ? this.f45475a.f45393a - aVar.f45475a.f45393a : eVar2.ordinal() - eVar.ordinal();
        }

        a(c cVar) {
            super(cVar, (Object) null);
            this.f45475a = cVar;
        }
    }
}
