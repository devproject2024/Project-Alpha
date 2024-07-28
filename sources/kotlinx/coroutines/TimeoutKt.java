package kotlinx.coroutines;

import kotlin.d.d;
import kotlin.g.a.m;
import kotlinx.coroutines.intrinsics.UndispatchedKt;

public final class TimeoutKt {
    private static final <U, T extends U> Object setupTimeout(TimeoutCoroutine<U, ? super T> timeoutCoroutine, m<? super CoroutineScope, ? super d<? super T>, ? extends Object> mVar) {
        JobKt.disposeOnCompletion(timeoutCoroutine, DelayKt.getDelay(timeoutCoroutine.uCont.getContext()).invokeOnTimeout(timeoutCoroutine.time, timeoutCoroutine));
        return UndispatchedKt.startUndispatchedOrReturnIgnoreTimeout(timeoutCoroutine, timeoutCoroutine, mVar);
    }

    public static final TimeoutCancellationException TimeoutCancellationException(long j, Job job) {
        return new TimeoutCancellationException("Timed out waiting for " + j + " ms", job);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0078 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> java.lang.Object withTimeoutOrNull(long r7, kotlin.g.a.m<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.d.d<? super T>, ? extends java.lang.Object> r9, kotlin.d.d<? super T> r10) {
        /*
            boolean r0 = r10 instanceof kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1 r0 = (kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1 r0 = new kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1
            r0.<init>(r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            kotlin.d.a.a r1 = kotlin.d.a.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            java.lang.Object r7 = r0.L$1
            kotlin.g.b.x$e r7 = (kotlin.g.b.x.e) r7
            kotlin.ResultKt.a((java.lang.Object) r10)     // Catch:{ TimeoutCancellationException -> 0x002e }
            r7 = r10
            goto L_0x006e
        L_0x002e:
            r8 = move-exception
            r10 = r7
            goto L_0x0070
        L_0x0031:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0039:
            kotlin.ResultKt.a((java.lang.Object) r10)
            r5 = 0
            int r10 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r10 > 0) goto L_0x0043
            return r4
        L_0x0043:
            kotlin.g.b.x$e r10 = new kotlin.g.b.x$e
            r10.<init>()
            r10.element = r4
            r0.J$0 = r7     // Catch:{ TimeoutCancellationException -> 0x006f }
            r0.L$0 = r9     // Catch:{ TimeoutCancellationException -> 0x006f }
            r0.L$1 = r10     // Catch:{ TimeoutCancellationException -> 0x006f }
            r0.label = r3     // Catch:{ TimeoutCancellationException -> 0x006f }
            r2 = r0
            kotlin.d.d r2 = (kotlin.d.d) r2     // Catch:{ TimeoutCancellationException -> 0x006f }
            kotlinx.coroutines.TimeoutCoroutine r3 = new kotlinx.coroutines.TimeoutCoroutine     // Catch:{ TimeoutCancellationException -> 0x006f }
            r3.<init>(r7, r2)     // Catch:{ TimeoutCancellationException -> 0x006f }
            r10.element = r3     // Catch:{ TimeoutCancellationException -> 0x006f }
            java.lang.Object r7 = setupTimeout(r3, r9)     // Catch:{ TimeoutCancellationException -> 0x006f }
            kotlin.d.a.a r8 = kotlin.d.a.a.COROUTINE_SUSPENDED     // Catch:{ TimeoutCancellationException -> 0x006f }
            if (r7 != r8) goto L_0x006b
            kotlin.d.d r0 = (kotlin.d.d) r0     // Catch:{ TimeoutCancellationException -> 0x006f }
            java.lang.String r8 = "frame"
            kotlin.g.b.k.d(r0, r8)     // Catch:{ TimeoutCancellationException -> 0x006f }
        L_0x006b:
            if (r7 != r1) goto L_0x006e
            return r1
        L_0x006e:
            return r7
        L_0x006f:
            r8 = move-exception
        L_0x0070:
            kotlinx.coroutines.Job r7 = r8.coroutine
            T r9 = r10.element
            kotlinx.coroutines.TimeoutCoroutine r9 = (kotlinx.coroutines.TimeoutCoroutine) r9
            if (r7 != r9) goto L_0x0079
            return r4
        L_0x0079:
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.TimeoutKt.withTimeoutOrNull(long, kotlin.g.a.m, kotlin.d.d):java.lang.Object");
    }
}
