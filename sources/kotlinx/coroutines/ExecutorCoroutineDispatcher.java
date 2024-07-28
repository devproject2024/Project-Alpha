package kotlinx.coroutines;

import java.io.Closeable;
import kotlin.d.b;
import kotlin.g.b.g;

public abstract class ExecutorCoroutineDispatcher extends CoroutineDispatcher implements Closeable {
    public static final Key Key = new Key((g) null);

    public static final class Key extends b<CoroutineDispatcher, ExecutorCoroutineDispatcher> {
        public /* synthetic */ Key(g gVar) {
            this();
        }

        private Key() {
            super(CoroutineDispatcher.Key, AnonymousClass1.INSTANCE);
        }
    }
}
