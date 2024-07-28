package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.d.r;
import io.reactivex.rxjava3.e.a.d;
import io.reactivex.rxjava3.e.e.t;
import io.reactivex.rxjava3.g.f;
import java.util.Collection;
import java.util.Objects;

public final class n<T, U extends Collection<? super T>, B> extends a<T, U> {

    /* renamed from: b  reason: collision with root package name */
    final u<B> f47499b;

    /* renamed from: c  reason: collision with root package name */
    final r<U> f47500c;

    public n(u<T> uVar, u<B> uVar2, r<U> rVar) {
        super(uVar);
        this.f47499b = uVar2;
        this.f47500c = rVar;
    }

    public final void subscribeActual(w<? super U> wVar) {
        this.f46900a.subscribe(new b(new f(wVar), this.f47500c, this.f47499b));
    }

    static final class b<T, U extends Collection<? super T>, B> extends t<T, U, U> implements w<T>, c {

        /* renamed from: g  reason: collision with root package name */
        final r<U> f47502g;

        /* renamed from: h  reason: collision with root package name */
        final u<B> f47503h;

        /* renamed from: i  reason: collision with root package name */
        c f47504i;
        c j;
        U k;

        public final /* synthetic */ void a(w wVar, Object obj) {
            this.f46734a.onNext((Collection) obj);
        }

        b(w<? super U> wVar, r<U> rVar, u<B> uVar) {
            super(wVar, new io.reactivex.rxjava3.e.g.a());
            this.f47502g = rVar;
            this.f47503h = uVar;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.f47504i, cVar)) {
                this.f47504i = cVar;
                try {
                    this.k = (Collection) Objects.requireNonNull(this.f47502g.get(), "The buffer supplied is null");
                    a aVar = new a(this);
                    this.j = aVar;
                    this.f46734a.onSubscribe(this);
                    if (!this.f46736c) {
                        this.f47503h.subscribe(aVar);
                    }
                } catch (Throwable th) {
                    io.reactivex.rxjava3.c.b.b(th);
                    this.f46736c = true;
                    cVar.dispose();
                    d.error(th, (w<?>) this.f46734a);
                }
            }
        }

        public final void onNext(T t) {
            synchronized (this) {
                U u = this.k;
                if (u != null) {
                    u.add(t);
                }
            }
        }

        public final void onError(Throwable th) {
            dispose();
            this.f46734a.onError(th);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0019, code lost:
            io.reactivex.rxjava3.e.k.q.a(r2.f46735b, r2.f46734a, r2, r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x000b, code lost:
            r2.f46735b.offer(r0);
            r2.f46737d = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0017, code lost:
            if (c() == false) goto L_?;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onComplete() {
            /*
                r2 = this;
                monitor-enter(r2)
                U r0 = r2.k     // Catch:{ all -> 0x0021 }
                if (r0 != 0) goto L_0x0007
                monitor-exit(r2)     // Catch:{ all -> 0x0021 }
                return
            L_0x0007:
                r1 = 0
                r2.k = r1     // Catch:{ all -> 0x0021 }
                monitor-exit(r2)     // Catch:{ all -> 0x0021 }
                io.reactivex.rxjava3.e.c.j r1 = r2.f46735b
                r1.offer(r0)
                r0 = 1
                r2.f46737d = r0
                boolean r0 = r2.c()
                if (r0 == 0) goto L_0x0020
                io.reactivex.rxjava3.e.c.j r0 = r2.f46735b
                io.reactivex.rxjava3.a.w r1 = r2.f46734a
                io.reactivex.rxjava3.e.k.q.a(r0, r1, r2, r2)
            L_0x0020:
                return
            L_0x0021:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0021 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.e.f.e.n.b.onComplete():void");
        }

        public final void dispose() {
            if (!this.f46736c) {
                this.f46736c = true;
                this.j.dispose();
                this.f47504i.dispose();
                if (c()) {
                    this.f46735b.clear();
                }
            }
        }

        public final boolean isDisposed() {
            return this.f46736c;
        }

        /* access modifiers changed from: package-private */
        public final void e() {
            try {
                U u = (Collection) Objects.requireNonNull(this.f47502g.get(), "The buffer supplied is null");
                synchronized (this) {
                    U u2 = this.k;
                    if (u2 != null) {
                        this.k = u;
                        a(u2, (c) this);
                    }
                }
            } catch (Throwable th) {
                io.reactivex.rxjava3.c.b.b(th);
                dispose();
                this.f46734a.onError(th);
            }
        }
    }

    static final class a<T, U extends Collection<? super T>, B> extends io.reactivex.rxjava3.g.c<B> {

        /* renamed from: a  reason: collision with root package name */
        final b<T, U, B> f47501a;

        a(b<T, U, B> bVar) {
            this.f47501a = bVar;
        }

        public final void onNext(B b2) {
            this.f47501a.e();
        }

        public final void onError(Throwable th) {
            this.f47501a.onError(th);
        }

        public final void onComplete() {
            this.f47501a.onComplete();
        }
    }
}
