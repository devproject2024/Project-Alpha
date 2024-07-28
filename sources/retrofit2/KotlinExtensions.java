package retrofit2;

import kotlin.d.a.a;
import kotlin.d.a.b;
import kotlin.d.d;
import kotlin.g.b.k;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

public final class KotlinExtensions {
    public static final /* synthetic */ <T> T create(Retrofit retrofit) {
        k.c(retrofit, "$this$create");
        k.b();
        return retrofit.create(Object.class);
    }

    public static final <T> Object await(Call<T> call, d<? super T> dVar) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(b.a(dVar), 1);
        CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
        cancellableContinuation.invokeOnCancellation(new KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$1(call));
        call.enqueue(new KotlinExtensions$await$2$2(cancellableContinuation));
        Object result = cancellableContinuationImpl.getResult();
        if (result == a.COROUTINE_SUSPENDED) {
            k.d(dVar, "frame");
        }
        return result;
    }

    public static final <T> Object awaitNullable(Call<T> call, d<? super T> dVar) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(b.a(dVar), 1);
        CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
        cancellableContinuation.invokeOnCancellation(new KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$2(call));
        call.enqueue(new KotlinExtensions$await$4$2(cancellableContinuation));
        Object result = cancellableContinuationImpl.getResult();
        if (result == a.COROUTINE_SUSPENDED) {
            k.d(dVar, "frame");
        }
        return result;
    }

    public static final <T> Object awaitResponse(Call<T> call, d<? super Response<T>> dVar) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(b.a(dVar), 1);
        CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
        cancellableContinuation.invokeOnCancellation(new KotlinExtensions$awaitResponse$$inlined$suspendCancellableCoroutine$lambda$1(call));
        call.enqueue(new KotlinExtensions$awaitResponse$2$2(cancellableContinuation));
        Object result = cancellableContinuationImpl.getResult();
        if (result == a.COROUTINE_SUSPENDED) {
            k.d(dVar, "frame");
        }
        return result;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0022  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object suspendAndThrow(java.lang.Exception r4, kotlin.d.d<?> r5) {
        /*
            boolean r0 = r5 instanceof retrofit2.KotlinExtensions$suspendAndThrow$1
            if (r0 == 0) goto L_0x0014
            r0 = r5
            retrofit2.KotlinExtensions$suspendAndThrow$1 r0 = (retrofit2.KotlinExtensions$suspendAndThrow$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L_0x0019
        L_0x0014:
            retrofit2.KotlinExtensions$suspendAndThrow$1 r0 = new retrofit2.KotlinExtensions$suspendAndThrow$1
            r0.<init>(r5)
        L_0x0019:
            java.lang.Object r5 = r0.result
            kotlin.d.a.a r1 = kotlin.d.a.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0030
            if (r2 != r3) goto L_0x0028
            kotlin.ResultKt.a((java.lang.Object) r5)
            goto L_0x0059
        L_0x0028:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0030:
            kotlin.ResultKt.a((java.lang.Object) r5)
            r0.L$0 = r4
            r0.label = r3
            kotlin.d.d r0 = (kotlin.d.d) r0
            kotlinx.coroutines.CoroutineDispatcher r5 = kotlinx.coroutines.Dispatchers.getDefault()
            kotlin.d.f r2 = r0.getContext()
            retrofit2.KotlinExtensions$suspendAndThrow$$inlined$suspendCoroutineUninterceptedOrReturn$lambda$1 r3 = new retrofit2.KotlinExtensions$suspendAndThrow$$inlined$suspendCoroutineUninterceptedOrReturn$lambda$1
            r3.<init>(r0, r4)
            java.lang.Runnable r3 = (java.lang.Runnable) r3
            r5.dispatch(r2, r3)
            kotlin.d.a.a r4 = kotlin.d.a.a.COROUTINE_SUSPENDED
            kotlin.d.a.a r5 = kotlin.d.a.a.COROUTINE_SUSPENDED
            if (r4 != r5) goto L_0x0056
            java.lang.String r5 = "frame"
            kotlin.g.b.k.d(r0, r5)
        L_0x0056:
            if (r4 != r1) goto L_0x0059
            return r1
        L_0x0059:
            kotlin.x r4 = kotlin.x.f47997a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: retrofit2.KotlinExtensions.suspendAndThrow(java.lang.Exception, kotlin.d.d):java.lang.Object");
    }
}
