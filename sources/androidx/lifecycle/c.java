package androidx.lifecycle;

import java.io.Closeable;
import java.util.concurrent.CancellationException;
import kotlin.d.f;
import kotlin.g.b.k;
import kotlinx.coroutines.CoroutineScope;

public final class c implements Closeable, CoroutineScope {

    /* renamed from: a  reason: collision with root package name */
    private final f f3655a;

    public c(f fVar) {
        k.c(fVar, "context");
        this.f3655a = fVar;
    }

    public final f getCoroutineContext() {
        return this.f3655a;
    }

    public final void close() {
        JobKt__JobKt.cancel$default(getCoroutineContext(), (CancellationException) null, 1, (Object) null);
    }
}
