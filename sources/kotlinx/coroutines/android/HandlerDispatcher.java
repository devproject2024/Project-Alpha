package kotlinx.coroutines.android;

import kotlin.g.b.g;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.MainCoroutineDispatcher;

public abstract class HandlerDispatcher extends MainCoroutineDispatcher implements Delay {
    private HandlerDispatcher() {
    }

    public /* synthetic */ HandlerDispatcher(g gVar) {
        this();
    }

    public DisposableHandle invokeOnTimeout(long j, Runnable runnable) {
        return Delay.DefaultImpls.invokeOnTimeout(this, j, runnable);
    }
}
