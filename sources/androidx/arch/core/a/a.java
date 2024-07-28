package androidx.arch.core.a;

import java.util.concurrent.Executor;

public class a extends c {

    /* renamed from: b  reason: collision with root package name */
    private static volatile a f1841b;

    /* renamed from: d  reason: collision with root package name */
    private static final Executor f1842d = new Executor() {
        public final void execute(Runnable runnable) {
            a.a().b(runnable);
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private static final Executor f1843e = new Executor() {
        public final void execute(Runnable runnable) {
            a.a().a(runnable);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public c f1844a = this.f1845c;

    /* renamed from: c  reason: collision with root package name */
    private c f1845c = new b();

    private a() {
    }

    public static a a() {
        if (f1841b != null) {
            return f1841b;
        }
        synchronized (a.class) {
            if (f1841b == null) {
                f1841b = new a();
            }
        }
        return f1841b;
    }

    public final void a(Runnable runnable) {
        this.f1844a.a(runnable);
    }

    public final void b(Runnable runnable) {
        this.f1844a.b(runnable);
    }

    public static Executor b() {
        return f1842d;
    }

    public static Executor c() {
        return f1843e;
    }

    public final boolean d() {
        return this.f1844a.d();
    }
}
