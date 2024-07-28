package androidx.lifecycle;

import java.util.concurrent.atomic.AtomicReference;

public abstract class k {

    /* renamed from: a  reason: collision with root package name */
    AtomicReference<Object> f3669a = new AtomicReference<>();

    public enum a {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY
    }

    public abstract b a();

    public abstract void a(p pVar);

    public abstract void b(p pVar);

    public enum b {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        public final boolean isAtLeast(b bVar) {
            return compareTo(bVar) >= 0;
        }
    }
}
