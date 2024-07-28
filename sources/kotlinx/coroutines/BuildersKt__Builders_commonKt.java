package kotlinx.coroutines;

import kotlin.d.a.a;
import kotlin.d.d;
import kotlin.d.e;
import kotlin.d.f;
import kotlin.d.g;
import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlin.x;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;

final /* synthetic */ class BuildersKt__Builders_commonKt {
    public static /* synthetic */ Job launch$default(CoroutineScope coroutineScope, f fVar, CoroutineStart coroutineStart, m mVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            fVar = g.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return BuildersKt.launch(coroutineScope, fVar, coroutineStart, mVar);
    }

    public static final Job launch(CoroutineScope coroutineScope, f fVar, CoroutineStart coroutineStart, m<? super CoroutineScope, ? super d<? super x>, ? extends Object> mVar) {
        StandaloneCoroutine standaloneCoroutine;
        f newCoroutineContext = CoroutineContextKt.newCoroutineContext(coroutineScope, fVar);
        if (coroutineStart.isLazy()) {
            standaloneCoroutine = new LazyStandaloneCoroutine(newCoroutineContext, mVar);
        } else {
            standaloneCoroutine = new StandaloneCoroutine(newCoroutineContext, true);
        }
        standaloneCoroutine.start(coroutineStart, standaloneCoroutine, mVar);
        return standaloneCoroutine;
    }

    public static /* synthetic */ Deferred async$default(CoroutineScope coroutineScope, f fVar, CoroutineStart coroutineStart, m mVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            fVar = g.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return BuildersKt.async(coroutineScope, fVar, coroutineStart, mVar);
    }

    public static final <T> Deferred<T> async(CoroutineScope coroutineScope, f fVar, CoroutineStart coroutineStart, m<? super CoroutineScope, ? super d<? super T>, ? extends Object> mVar) {
        DeferredCoroutine deferredCoroutine;
        f newCoroutineContext = CoroutineContextKt.newCoroutineContext(coroutineScope, fVar);
        if (coroutineStart.isLazy()) {
            deferredCoroutine = new LazyDeferredCoroutine(newCoroutineContext, mVar);
        } else {
            deferredCoroutine = new DeferredCoroutine(newCoroutineContext, true);
        }
        deferredCoroutine.start(coroutineStart, deferredCoroutine, mVar);
        return deferredCoroutine;
    }

    /* JADX INFO: finally extract failed */
    public static final <T> Object withContext(f fVar, m<? super CoroutineScope, ? super d<? super T>, ? extends Object> mVar, d<? super T> dVar) {
        Object obj;
        f context = dVar.getContext();
        f plus = context.plus(fVar);
        YieldKt.checkCompletion(plus);
        if (plus == context) {
            ScopeCoroutine scopeCoroutine = new ScopeCoroutine(plus, dVar);
            obj = UndispatchedKt.startUndispatchedOrReturn(scopeCoroutine, scopeCoroutine, mVar);
        } else if (k.a((Object) (e) plus.get(e.f47904a), (Object) (e) context.get(e.f47904a))) {
            UndispatchedCoroutine undispatchedCoroutine = new UndispatchedCoroutine(plus, dVar);
            Object updateThreadContext = ThreadContextKt.updateThreadContext(plus, (Object) null);
            try {
                Object startUndispatchedOrReturn = UndispatchedKt.startUndispatchedOrReturn(undispatchedCoroutine, undispatchedCoroutine, mVar);
                ThreadContextKt.restoreThreadContext(plus, updateThreadContext);
                obj = startUndispatchedOrReturn;
            } catch (Throwable th) {
                ThreadContextKt.restoreThreadContext(plus, updateThreadContext);
                throw th;
            }
        } else {
            DispatchedCoroutine dispatchedCoroutine = new DispatchedCoroutine(plus, dVar);
            dispatchedCoroutine.initParentJob$kotlinx_coroutines_core();
            CancellableKt.startCoroutineCancellable(mVar, dispatchedCoroutine, dispatchedCoroutine);
            obj = dispatchedCoroutine.getResult();
        }
        if (obj == a.COROUTINE_SUSPENDED) {
            k.d(dVar, "frame");
        }
        return obj;
    }
}
