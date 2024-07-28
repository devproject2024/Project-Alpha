package kotlinx.coroutines;

import kotlin.d.f;
import kotlin.x;

class StandaloneCoroutine extends AbstractCoroutine<x> {
    public StandaloneCoroutine(f fVar, boolean z) {
        super(fVar, z);
    }

    /* access modifiers changed from: protected */
    public boolean handleJobException(Throwable th) {
        CoroutineExceptionHandlerKt.handleCoroutineException(getContext(), th);
        return true;
    }
}
