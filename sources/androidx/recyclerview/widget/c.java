package androidx.recyclerview.widget;

import androidx.recyclerview.widget.h;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public final class c<T> {

    /* renamed from: a  reason: collision with root package name */
    final Executor f4172a;

    /* renamed from: b  reason: collision with root package name */
    final Executor f4173b;

    /* renamed from: c  reason: collision with root package name */
    final h.c<T> f4174c;

    c(Executor executor, Executor executor2, h.c<T> cVar) {
        this.f4172a = executor;
        this.f4173b = executor2;
        this.f4174c = cVar;
    }

    public static final class a<T> {

        /* renamed from: d  reason: collision with root package name */
        private static final Object f4175d = new Object();

        /* renamed from: e  reason: collision with root package name */
        private static Executor f4176e = null;

        /* renamed from: a  reason: collision with root package name */
        private Executor f4177a;

        /* renamed from: b  reason: collision with root package name */
        private Executor f4178b;

        /* renamed from: c  reason: collision with root package name */
        private final h.c<T> f4179c;

        public a(h.c<T> cVar) {
            this.f4179c = cVar;
        }

        public final c<T> a() {
            if (this.f4178b == null) {
                synchronized (f4175d) {
                    if (f4176e == null) {
                        f4176e = Executors.newFixedThreadPool(2);
                    }
                }
                this.f4178b = f4176e;
            }
            return new c<>(this.f4177a, this.f4178b, this.f4179c);
        }
    }
}
