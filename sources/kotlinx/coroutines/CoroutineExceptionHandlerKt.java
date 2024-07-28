package kotlinx.coroutines;

import kotlin.a;
import kotlin.d.f;

public final class CoroutineExceptionHandlerKt {
    public static final void handleCoroutineException(f fVar, Throwable th) {
        try {
            CoroutineExceptionHandler coroutineExceptionHandler = (CoroutineExceptionHandler) fVar.get(CoroutineExceptionHandler.Key);
            if (coroutineExceptionHandler != null) {
                coroutineExceptionHandler.handleException(fVar, th);
            } else {
                CoroutineExceptionHandlerImplKt.handleCoroutineExceptionImpl(fVar, th);
            }
        } catch (Throwable th2) {
            CoroutineExceptionHandlerImplKt.handleCoroutineExceptionImpl(fVar, handlerException(th, th2));
        }
    }

    public static final Throwable handlerException(Throwable th, Throwable th2) {
        if (th == th2) {
            return th;
        }
        Throwable runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
        a.a(runtimeException, th);
        return runtimeException;
    }
}
