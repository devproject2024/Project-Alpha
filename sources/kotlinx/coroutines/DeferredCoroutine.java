package kotlinx.coroutines;

import kotlin.d.d;
import kotlin.d.f;

class DeferredCoroutine<T> extends AbstractCoroutine<T> implements Deferred<T> {
    public Object await(d<? super T> dVar) {
        return await$suspendImpl(this, dVar);
    }

    public DeferredCoroutine(f fVar, boolean z) {
        super(fVar, z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0022  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.lang.Object await$suspendImpl(kotlinx.coroutines.DeferredCoroutine r4, kotlin.d.d r5) {
        /*
            boolean r0 = r5 instanceof kotlinx.coroutines.DeferredCoroutine$await$1
            if (r0 == 0) goto L_0x0014
            r0 = r5
            kotlinx.coroutines.DeferredCoroutine$await$1 r0 = (kotlinx.coroutines.DeferredCoroutine$await$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L_0x0019
        L_0x0014:
            kotlinx.coroutines.DeferredCoroutine$await$1 r0 = new kotlinx.coroutines.DeferredCoroutine$await$1
            r0.<init>(r4, r5)
        L_0x0019:
            java.lang.Object r5 = r0.result
            kotlin.d.a.a r1 = kotlin.d.a.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0030
            if (r2 != r3) goto L_0x0028
            kotlin.ResultKt.a((java.lang.Object) r5)
            goto L_0x003e
        L_0x0028:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0030:
            kotlin.ResultKt.a((java.lang.Object) r5)
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r4.awaitInternal$kotlinx_coroutines_core(r0)
            if (r5 != r1) goto L_0x003e
            return r1
        L_0x003e:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.DeferredCoroutine.await$suspendImpl(kotlinx.coroutines.DeferredCoroutine, kotlin.d.d):java.lang.Object");
    }
}
