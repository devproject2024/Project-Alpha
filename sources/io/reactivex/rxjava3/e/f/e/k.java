package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.d.a;
import io.reactivex.rxjava3.d.g;
import io.reactivex.rxjava3.e.e.s;
import java.util.Objects;

public final class k {
    /* JADX WARNING: Removed duplicated region for block: B:3:0x0016  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> void a(io.reactivex.rxjava3.a.u<? extends T> r3, io.reactivex.rxjava3.a.w<? super T> r4) {
        /*
            java.util.concurrent.LinkedBlockingQueue r0 = new java.util.concurrent.LinkedBlockingQueue
            r0.<init>()
            io.reactivex.rxjava3.e.e.i r1 = new io.reactivex.rxjava3.e.e.i
            r1.<init>(r0)
            r4.onSubscribe(r1)
            r3.subscribe(r1)
        L_0x0010:
            boolean r3 = r1.isDisposed()
            if (r3 != 0) goto L_0x0039
            java.lang.Object r3 = r0.poll()
            if (r3 != 0) goto L_0x0029
            java.lang.Object r3 = r0.take()     // Catch:{ InterruptedException -> 0x0021 }
            goto L_0x0029
        L_0x0021:
            r3 = move-exception
            r1.dispose()
            r4.onError(r3)
            return
        L_0x0029:
            boolean r2 = r1.isDisposed()
            if (r2 != 0) goto L_0x0039
            java.lang.Object r2 = io.reactivex.rxjava3.e.e.i.TERMINATED
            if (r3 == r2) goto L_0x0039
            boolean r3 = io.reactivex.rxjava3.e.k.m.acceptFull((java.lang.Object) r3, r4)
            if (r3 == 0) goto L_0x0010
        L_0x0039:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.e.f.e.k.a(io.reactivex.rxjava3.a.u, io.reactivex.rxjava3.a.w):void");
    }

    public static <T> void a(u<? extends T> uVar, g<? super T> gVar, g<? super Throwable> gVar2, a aVar) {
        Objects.requireNonNull(gVar, "onNext is null");
        Objects.requireNonNull(gVar2, "onError is null");
        Objects.requireNonNull(aVar, "onComplete is null");
        a(uVar, new s(gVar, gVar2, aVar, io.reactivex.rxjava3.e.b.a.b()));
    }
}
