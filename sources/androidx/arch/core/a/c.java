package androidx.arch.core.a;

public abstract class c {
    public abstract void a(Runnable runnable);

    public abstract void b(Runnable runnable);

    public abstract boolean d();

    public final void c(Runnable runnable) {
        if (d()) {
            runnable.run();
        } else {
            b(runnable);
        }
    }
}
