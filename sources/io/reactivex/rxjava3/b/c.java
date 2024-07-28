package io.reactivex.rxjava3.b;

import java.util.Objects;

public interface c {
    void dispose();

    boolean isDisposed();

    /* renamed from: io.reactivex.rxjava3.b.c$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static c b(Runnable runnable) {
            Objects.requireNonNull(runnable, "run is null");
            return new f(runnable);
        }
    }
}
