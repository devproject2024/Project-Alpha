package kotlinx.coroutines;

import kotlin.d.f;

public interface CoroutineExceptionHandler extends f.b {
    public static final Key Key = Key.$$INSTANCE;

    void handleException(f fVar, Throwable th);

    public static final class Key implements f.c<CoroutineExceptionHandler> {
        static final /* synthetic */ Key $$INSTANCE = new Key();

        private Key() {
        }
    }
}
