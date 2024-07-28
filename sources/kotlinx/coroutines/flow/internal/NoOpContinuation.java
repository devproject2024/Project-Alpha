package kotlinx.coroutines.flow.internal;

import kotlin.d.d;
import kotlin.d.f;
import kotlin.d.g;

final class NoOpContinuation implements d<Object> {
    public static final NoOpContinuation INSTANCE = new NoOpContinuation();
    private static final f context = g.INSTANCE;

    public final void resumeWith(Object obj) {
    }

    private NoOpContinuation() {
    }

    public final f getContext() {
        return context;
    }
}
