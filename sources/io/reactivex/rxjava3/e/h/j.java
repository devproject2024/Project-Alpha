package io.reactivex.rxjava3.e.h;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

public final class j extends AtomicLong implements ThreadFactory {
    private static final long serialVersionUID = -7789753024099756196L;
    final boolean nonBlocking;
    final String prefix;
    final int priority;

    public j(String str) {
        this(str, 5, false);
    }

    public j(String str, int i2) {
        this(str, i2, false);
    }

    public j(String str, int i2, boolean z) {
        this.prefix = str;
        this.priority = i2;
        this.nonBlocking = z;
    }

    public final Thread newThread(Runnable runnable) {
        String str = this.prefix + '-' + incrementAndGet();
        Thread aVar = this.nonBlocking ? new a(runnable, str) : new Thread(runnable, str);
        aVar.setPriority(this.priority);
        aVar.setDaemon(true);
        return aVar;
    }

    public final String toString() {
        return "RxThreadFactory[" + this.prefix + "]";
    }

    static final class a extends Thread implements i {
        a(Runnable runnable, String str) {
            super(runnable, str);
        }
    }
}
