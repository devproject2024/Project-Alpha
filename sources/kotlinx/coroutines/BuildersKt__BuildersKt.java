package kotlinx.coroutines;

import kotlin.d.f;
import kotlin.d.g;
import kotlin.g.a.m;

final /* synthetic */ class BuildersKt__BuildersKt {
    public static /* synthetic */ Object runBlocking$default(f fVar, m mVar, int i2, Object obj) throws InterruptedException {
        if ((i2 & 1) != 0) {
            fVar = g.INSTANCE;
        }
        return BuildersKt.runBlocking(fVar, mVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0038, code lost:
        if (r1 == null) goto L_0x003a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> T runBlocking(kotlin.d.f r4, kotlin.g.a.m<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.d.d<? super T>, ? extends java.lang.Object> r5) throws java.lang.InterruptedException {
        /*
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            kotlin.d.e$a r1 = kotlin.d.e.f47904a
            kotlin.d.f$c r1 = (kotlin.d.f.c) r1
            kotlin.d.f$b r1 = r4.get(r1)
            kotlin.d.e r1 = (kotlin.d.e) r1
            if (r1 != 0) goto L_0x0026
            kotlinx.coroutines.ThreadLocalEventLoop r1 = kotlinx.coroutines.ThreadLocalEventLoop.INSTANCE
            kotlinx.coroutines.EventLoop r1 = r1.getEventLoop$kotlinx_coroutines_core()
            kotlinx.coroutines.GlobalScope r2 = kotlinx.coroutines.GlobalScope.INSTANCE
            kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
            r3 = r1
            kotlin.d.f r3 = (kotlin.d.f) r3
            kotlin.d.f r4 = r4.plus(r3)
            kotlin.d.f r4 = kotlinx.coroutines.CoroutineContextKt.newCoroutineContext(r2, r4)
            goto L_0x0048
        L_0x0026:
            boolean r2 = r1 instanceof kotlinx.coroutines.EventLoop
            r3 = 0
            if (r2 != 0) goto L_0x002c
            r1 = r3
        L_0x002c:
            kotlinx.coroutines.EventLoop r1 = (kotlinx.coroutines.EventLoop) r1
            if (r1 == 0) goto L_0x003a
            boolean r2 = r1.shouldBeProcessedFromContext()
            if (r2 == 0) goto L_0x0037
            goto L_0x0038
        L_0x0037:
            r1 = r3
        L_0x0038:
            if (r1 != 0) goto L_0x0040
        L_0x003a:
            kotlinx.coroutines.ThreadLocalEventLoop r1 = kotlinx.coroutines.ThreadLocalEventLoop.INSTANCE
            kotlinx.coroutines.EventLoop r1 = r1.currentOrNull$kotlinx_coroutines_core()
        L_0x0040:
            kotlinx.coroutines.GlobalScope r2 = kotlinx.coroutines.GlobalScope.INSTANCE
            kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
            kotlin.d.f r4 = kotlinx.coroutines.CoroutineContextKt.newCoroutineContext(r2, r4)
        L_0x0048:
            kotlinx.coroutines.BlockingCoroutine r2 = new kotlinx.coroutines.BlockingCoroutine
            r2.<init>(r4, r0, r1)
            kotlinx.coroutines.CoroutineStart r4 = kotlinx.coroutines.CoroutineStart.DEFAULT
            r2.start(r4, r2, r5)
            java.lang.Object r4 = r2.joinBlocking()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.BuildersKt__BuildersKt.runBlocking(kotlin.d.f, kotlin.g.a.m):java.lang.Object");
    }
}
