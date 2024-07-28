package kotlinx.coroutines.flow;

import kotlin.d.d;
import kotlin.x;

public abstract class AbstractFlow<T> implements Flow<T> {
    public abstract Object collectSafely(FlowCollector<? super T> flowCollector, d<? super x> dVar);

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0022  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object collect(kotlinx.coroutines.flow.FlowCollector<? super T> r5, kotlin.d.d<? super kotlin.x> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.AbstractFlow$collect$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            kotlinx.coroutines.flow.AbstractFlow$collect$1 r0 = (kotlinx.coroutines.flow.AbstractFlow$collect$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            kotlinx.coroutines.flow.AbstractFlow$collect$1 r0 = new kotlinx.coroutines.flow.AbstractFlow$collect$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            kotlin.d.a.a r1 = kotlin.d.a.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r5 = r0.L$2
            kotlinx.coroutines.flow.internal.SafeCollector r5 = (kotlinx.coroutines.flow.internal.SafeCollector) r5
            kotlin.ResultKt.a((java.lang.Object) r6)     // Catch:{ all -> 0x002c }
            goto L_0x0056
        L_0x002c:
            r6 = move-exception
            r2 = r5
            goto L_0x005d
        L_0x002f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0037:
            kotlin.ResultKt.a((java.lang.Object) r6)
            kotlin.d.f r6 = r0.getContext()
            kotlinx.coroutines.flow.internal.SafeCollector r2 = new kotlinx.coroutines.flow.internal.SafeCollector
            r2.<init>(r5, r6)
            r6 = r2
            kotlinx.coroutines.flow.FlowCollector r6 = (kotlinx.coroutines.flow.FlowCollector) r6     // Catch:{ all -> 0x005c }
            r0.L$0 = r4     // Catch:{ all -> 0x005c }
            r0.L$1 = r5     // Catch:{ all -> 0x005c }
            r0.L$2 = r2     // Catch:{ all -> 0x005c }
            r0.label = r3     // Catch:{ all -> 0x005c }
            java.lang.Object r5 = r4.collectSafely(r6, r0)     // Catch:{ all -> 0x005c }
            if (r5 != r1) goto L_0x0055
            return r1
        L_0x0055:
            r5 = r2
        L_0x0056:
            r5.releaseIntercepted()
            kotlin.x r5 = kotlin.x.f47997a
            return r5
        L_0x005c:
            r6 = move-exception
        L_0x005d:
            r2.releaseIntercepted()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.AbstractFlow.collect(kotlinx.coroutines.flow.FlowCollector, kotlin.d.d):java.lang.Object");
    }
}
