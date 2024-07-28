package kotlinx.coroutines.intrinsics;

import kotlin.ResultKt;
import kotlin.d.d;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.p;
import kotlin.x;
import kotlinx.coroutines.DispatchedContinuationKt;

public final class CancellableKt {
    public static final <T> void startCoroutineCancellable(b<? super d<? super T>, ? extends Object> bVar, d<? super T> dVar) {
        try {
            d<x> a2 = kotlin.d.a.b.a(kotlin.d.a.b.a(bVar, dVar));
            p.a aVar = p.Companion;
            DispatchedContinuationKt.resumeCancellableWith(a2, p.m530constructorimpl(x.f47997a));
        } catch (Throwable th) {
            p.a aVar2 = p.Companion;
            dVar.resumeWith(p.m530constructorimpl(ResultKt.a(th)));
        }
    }

    public static final <R, T> void startCoroutineCancellable(m<? super R, ? super d<? super T>, ? extends Object> mVar, R r, d<? super T> dVar) {
        try {
            d<x> a2 = kotlin.d.a.b.a(kotlin.d.a.b.a(mVar, r, dVar));
            p.a aVar = p.Companion;
            DispatchedContinuationKt.resumeCancellableWith(a2, p.m530constructorimpl(x.f47997a));
        } catch (Throwable th) {
            p.a aVar2 = p.Companion;
            dVar.resumeWith(p.m530constructorimpl(ResultKt.a(th)));
        }
    }

    public static final void startCoroutineCancellable(d<? super x> dVar, d<?> dVar2) {
        try {
            d<? super x> a2 = kotlin.d.a.b.a(dVar);
            p.a aVar = p.Companion;
            DispatchedContinuationKt.resumeCancellableWith(a2, p.m530constructorimpl(x.f47997a));
        } catch (Throwable th) {
            p.a aVar2 = p.Companion;
            dVar2.resumeWith(p.m530constructorimpl(ResultKt.a(th)));
        }
    }
}
