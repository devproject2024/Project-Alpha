package net.one97.paytm.nativesdk.common.viewmodel;

import kotlin.d.a;
import kotlin.d.f;
import kotlin.g.b.k;
import kotlinx.coroutines.CoroutineExceptionHandler;
import net.one97.paytm.nativesdk.PaytmSDK;

public final class BaseNativeViewModel$$special$$inlined$CoroutineExceptionHandler$1 extends a implements CoroutineExceptionHandler {
    public BaseNativeViewModel$$special$$inlined$CoroutineExceptionHandler$1(f.c cVar) {
        super(cVar);
    }

    public final void handleException(f fVar, Throwable th) {
        k.c(fVar, "context");
        k.c(th, "exception");
        if (PaytmSDK.getCallbackListener() != null) {
            PaytmSDK.getCallbackListener().logException("BaseNativeViewModel", "Coroutine exception caught", th);
        }
    }
}
