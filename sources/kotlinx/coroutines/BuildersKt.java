package kotlinx.coroutines;

import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.x;

public final class BuildersKt {
    public static final <T> Deferred<T> async(CoroutineScope coroutineScope, f fVar, CoroutineStart coroutineStart, m<? super CoroutineScope, ? super d<? super T>, ? extends Object> mVar) {
        return BuildersKt__Builders_commonKt.async(coroutineScope, fVar, coroutineStart, mVar);
    }

    public static final Job launch(CoroutineScope coroutineScope, f fVar, CoroutineStart coroutineStart, m<? super CoroutineScope, ? super d<? super x>, ? extends Object> mVar) {
        return BuildersKt__Builders_commonKt.launch(coroutineScope, fVar, coroutineStart, mVar);
    }

    public static final <T> T runBlocking(f fVar, m<? super CoroutineScope, ? super d<? super T>, ? extends Object> mVar) throws InterruptedException {
        return BuildersKt__BuildersKt.runBlocking(fVar, mVar);
    }

    public static final <T> Object withContext(f fVar, m<? super CoroutineScope, ? super d<? super T>, ? extends Object> mVar, d<? super T> dVar) {
        return BuildersKt__Builders_commonKt.withContext(fVar, mVar, dVar);
    }
}
