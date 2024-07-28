package androidx.work.impl.utils.b;

import android.os.Handler;
import android.os.Looper;
import androidx.work.impl.utils.g;
import java.util.concurrent.Executor;

public final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    final Handler f5436a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    private final g f5437b;

    /* renamed from: c  reason: collision with root package name */
    private final Executor f5438c = new Executor() {
        public final void execute(Runnable runnable) {
            b.this.f5436a.post(runnable);
        }
    };

    public b(Executor executor) {
        this.f5437b = new g(executor);
    }

    public final Executor a() {
        return this.f5438c;
    }

    public final void a(Runnable runnable) {
        this.f5437b.execute(runnable);
    }

    public final g b() {
        return this.f5437b;
    }
}
