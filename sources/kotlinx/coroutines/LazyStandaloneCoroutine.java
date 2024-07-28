package kotlinx.coroutines;

import kotlin.d.a.b;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.x;
import kotlinx.coroutines.intrinsics.CancellableKt;

final class LazyStandaloneCoroutine extends StandaloneCoroutine {
    private final d<x> continuation;

    public LazyStandaloneCoroutine(f fVar, m<? super CoroutineScope, ? super d<? super x>, ? extends Object> mVar) {
        super(fVar, false);
        this.continuation = b.a(mVar, this, this);
    }

    /* access modifiers changed from: protected */
    public final void onStart() {
        CancellableKt.startCoroutineCancellable((d<? super x>) this.continuation, (d<?>) this);
    }
}
