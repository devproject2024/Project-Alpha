package com.google.android.exoplayer2.g;

import android.os.Handler;
import com.google.android.exoplayer2.g.h;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public final class h<T> {

    /* renamed from: a  reason: collision with root package name */
    private final CopyOnWriteArrayList<b<T>> f32525a = new CopyOnWriteArrayList<>();

    public interface a<T> {
        void sendTo(T t);
    }

    public final void a(Handler handler, T t) {
        a.a((handler == null || t == null) ? false : true);
        a(t);
        this.f32525a.add(new b(handler, t));
    }

    public final void a(T t) {
        Iterator<b<T>> it2 = this.f32525a.iterator();
        while (it2.hasNext()) {
            b next = it2.next();
            if (next.f32526a == t) {
                next.f32527b = true;
                this.f32525a.remove(next);
            }
        }
    }

    public final void a(a<T> aVar) {
        Iterator<b<T>> it2 = this.f32525a.iterator();
        while (it2.hasNext()) {
            it2.next().a(aVar);
        }
    }

    static final class b<T> {

        /* renamed from: a  reason: collision with root package name */
        final T f32526a;

        /* renamed from: b  reason: collision with root package name */
        boolean f32527b;

        /* renamed from: c  reason: collision with root package name */
        private final Handler f32528c;

        public b(Handler handler, T t) {
            this.f32528c = handler;
            this.f32526a = t;
        }

        public final void a(a<T> aVar) {
            this.f32528c.post(new Runnable(aVar) {
                private final /* synthetic */ h.a f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    h.b.this.b(this.f$1);
                }
            });
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b(a aVar) {
            if (!this.f32527b) {
                aVar.sendTo(this.f32526a);
            }
        }
    }
}
