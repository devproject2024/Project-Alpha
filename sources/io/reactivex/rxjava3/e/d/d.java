package io.reactivex.rxjava3.e.d;

import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.d.h;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public final class d<T, R> extends p<R> {

    /* renamed from: a  reason: collision with root package name */
    final p<T> f46695a;

    /* renamed from: b  reason: collision with root package name */
    final h<? super T, ? extends Stream<? extends R>> f46696b;

    public d(p<T> pVar, h<? super T, ? extends Stream<? extends R>> hVar) {
        this.f46695a = pVar;
        this.f46696b = hVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.util.stream.Stream} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void subscribeActual(io.reactivex.rxjava3.a.w<? super R> r4) {
        /*
            r3 = this;
            io.reactivex.rxjava3.a.p<T> r0 = r3.f46695a
            boolean r1 = r0 instanceof io.reactivex.rxjava3.d.r
            if (r1 == 0) goto L_0x0030
            r1 = 0
            io.reactivex.rxjava3.d.r r0 = (io.reactivex.rxjava3.d.r) r0     // Catch:{ all -> 0x0028 }
            java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x0028 }
            if (r0 == 0) goto L_0x001e
            io.reactivex.rxjava3.d.h<? super T, ? extends java.util.stream.Stream<? extends R>> r1 = r3.f46696b     // Catch:{ all -> 0x0028 }
            java.lang.Object r0 = r1.apply(r0)     // Catch:{ all -> 0x0028 }
            java.lang.String r1 = "The mapper returned a null Stream"
            java.lang.Object r0 = java.util.Objects.requireNonNull(r0, r1)     // Catch:{ all -> 0x0028 }
            r1 = r0
            java.util.stream.Stream r1 = (java.util.stream.Stream) r1     // Catch:{ all -> 0x0028 }
        L_0x001e:
            if (r1 == 0) goto L_0x0024
            io.reactivex.rxjava3.e.d.f.a(r4, r1)
            return
        L_0x0024:
            io.reactivex.rxjava3.e.a.d.complete((io.reactivex.rxjava3.a.w<?>) r4)
            return
        L_0x0028:
            r0 = move-exception
            io.reactivex.rxjava3.c.b.b(r0)
            io.reactivex.rxjava3.e.a.d.error((java.lang.Throwable) r0, (io.reactivex.rxjava3.a.w<?>) r4)
            return
        L_0x0030:
            io.reactivex.rxjava3.e.d.d$a r1 = new io.reactivex.rxjava3.e.d.d$a
            io.reactivex.rxjava3.d.h<? super T, ? extends java.util.stream.Stream<? extends R>> r2 = r3.f46696b
            r1.<init>(r4, r2)
            r0.subscribe(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.e.d.d.subscribeActual(io.reactivex.rxjava3.a.w):void");
    }

    static final class a<T, R> extends AtomicInteger implements w<T>, c {
        private static final long serialVersionUID = -5127032662980523968L;
        volatile boolean disposed;
        boolean done;
        final w<? super R> downstream;
        final h<? super T, ? extends Stream<? extends R>> mapper;
        c upstream;

        a(w<? super R> wVar, h<? super T, ? extends Stream<? extends R>> hVar) {
            this.downstream = wVar;
            this.mapper = hVar;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.upstream, cVar)) {
                this.upstream = cVar;
                this.downstream.onSubscribe(this);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0049, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x004a, code lost:
            if (r5 != null) goto L_0x004c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            r5.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0054, code lost:
            throw r1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onNext(T r5) {
            /*
                r4 = this;
                boolean r0 = r4.done
                if (r0 == 0) goto L_0x0005
                return
            L_0x0005:
                io.reactivex.rxjava3.d.h<? super T, ? extends java.util.stream.Stream<? extends R>> r0 = r4.mapper     // Catch:{ all -> 0x0055 }
                java.lang.Object r5 = r0.apply(r5)     // Catch:{ all -> 0x0055 }
                java.lang.String r0 = "The mapper returned a null Stream"
                java.lang.Object r5 = java.util.Objects.requireNonNull(r5, r0)     // Catch:{ all -> 0x0055 }
                java.util.stream.Stream r5 = (java.util.stream.Stream) r5     // Catch:{ all -> 0x0055 }
                java.util.Iterator r0 = r5.iterator()     // Catch:{ all -> 0x0047 }
            L_0x0017:
                boolean r1 = r0.hasNext()     // Catch:{ all -> 0x0047 }
                if (r1 == 0) goto L_0x0041
                boolean r1 = r4.disposed     // Catch:{ all -> 0x0047 }
                r2 = 1
                if (r1 == 0) goto L_0x0025
                r4.done = r2     // Catch:{ all -> 0x0047 }
                goto L_0x0041
            L_0x0025:
                java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x0047 }
                java.lang.String r3 = "The Stream's Iterator.next returned a null value"
                java.lang.Object r1 = java.util.Objects.requireNonNull(r1, r3)     // Catch:{ all -> 0x0047 }
                boolean r3 = r4.disposed     // Catch:{ all -> 0x0047 }
                if (r3 == 0) goto L_0x0036
                r4.done = r2     // Catch:{ all -> 0x0047 }
                goto L_0x0041
            L_0x0036:
                io.reactivex.rxjava3.a.w<? super R> r3 = r4.downstream     // Catch:{ all -> 0x0047 }
                r3.onNext(r1)     // Catch:{ all -> 0x0047 }
                boolean r1 = r4.disposed     // Catch:{ all -> 0x0047 }
                if (r1 == 0) goto L_0x0017
                r4.done = r2     // Catch:{ all -> 0x0047 }
            L_0x0041:
                if (r5 == 0) goto L_0x0046
                r5.close()     // Catch:{ all -> 0x0055 }
            L_0x0046:
                return
            L_0x0047:
                r0 = move-exception
                throw r0     // Catch:{ all -> 0x0049 }
            L_0x0049:
                r1 = move-exception
                if (r5 == 0) goto L_0x0054
                r5.close()     // Catch:{ all -> 0x0050 }
                goto L_0x0054
            L_0x0050:
                r5 = move-exception
                r0.addSuppressed(r5)     // Catch:{ all -> 0x0055 }
            L_0x0054:
                throw r1     // Catch:{ all -> 0x0055 }
            L_0x0055:
                r5 = move-exception
                io.reactivex.rxjava3.c.b.b(r5)
                io.reactivex.rxjava3.b.c r0 = r4.upstream
                r0.dispose()
                r4.onError(r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.e.d.d.a.onNext(java.lang.Object):void");
        }

        public final void onError(Throwable th) {
            if (this.done) {
                io.reactivex.rxjava3.h.a.a(th);
                return;
            }
            this.done = true;
            this.downstream.onError(th);
        }

        public final void onComplete() {
            if (!this.done) {
                this.done = true;
                this.downstream.onComplete();
            }
        }

        public final void dispose() {
            this.disposed = true;
            this.upstream.dispose();
        }

        public final boolean isDisposed() {
            return this.disposed;
        }
    }
}
