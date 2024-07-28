package androidx.room;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

final class s implements Executor {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f4504a;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayDeque<Runnable> f4505b = new ArrayDeque<>();

    /* renamed from: c  reason: collision with root package name */
    private Runnable f4506c;

    s(Executor executor) {
        this.f4504a = executor;
    }

    public final synchronized void execute(final Runnable runnable) {
        this.f4505b.offer(new Runnable() {
            public final void run() {
                try {
                    runnable.run();
                } finally {
                    s.this.a();
                }
            }
        });
        if (this.f4506c == null) {
            a();
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a() {
        Runnable poll = this.f4505b.poll();
        this.f4506c = poll;
        if (poll != null) {
            this.f4504a.execute(this.f4506c);
        }
    }
}
