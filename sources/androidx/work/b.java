package androidx.work;

import android.os.Build;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f5054a;

    /* renamed from: b  reason: collision with root package name */
    public final Executor f5055b;

    /* renamed from: c  reason: collision with root package name */
    public final x f5056c;

    /* renamed from: d  reason: collision with root package name */
    public final k f5057d;

    /* renamed from: e  reason: collision with root package name */
    public final s f5058e;

    /* renamed from: f  reason: collision with root package name */
    public final int f5059f;

    /* renamed from: g  reason: collision with root package name */
    public final int f5060g;

    /* renamed from: h  reason: collision with root package name */
    public final int f5061h;

    /* renamed from: i  reason: collision with root package name */
    final int f5062i;
    private final boolean j;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        Executor f5063a;

        /* renamed from: b  reason: collision with root package name */
        x f5064b;

        /* renamed from: c  reason: collision with root package name */
        k f5065c;

        /* renamed from: d  reason: collision with root package name */
        Executor f5066d;

        /* renamed from: e  reason: collision with root package name */
        s f5067e;

        /* renamed from: f  reason: collision with root package name */
        int f5068f = 4;

        /* renamed from: g  reason: collision with root package name */
        int f5069g = 0;

        /* renamed from: h  reason: collision with root package name */
        int f5070h = Integer.MAX_VALUE;

        /* renamed from: i  reason: collision with root package name */
        int f5071i = 20;
    }

    /* renamed from: androidx.work.b$b  reason: collision with other inner class name */
    public interface C0077b {
        b a();
    }

    public b(a aVar) {
        if (aVar.f5063a == null) {
            this.f5054a = b();
        } else {
            this.f5054a = aVar.f5063a;
        }
        if (aVar.f5066d == null) {
            this.j = true;
            this.f5055b = b();
        } else {
            this.j = false;
            this.f5055b = aVar.f5066d;
        }
        if (aVar.f5064b == null) {
            this.f5056c = x.a();
        } else {
            this.f5056c = aVar.f5064b;
        }
        if (aVar.f5065c == null) {
            this.f5057d = new k() {
            };
        } else {
            this.f5057d = aVar.f5065c;
        }
        if (aVar.f5067e == null) {
            this.f5058e = new androidx.work.impl.a();
        } else {
            this.f5058e = aVar.f5067e;
        }
        this.f5059f = aVar.f5068f;
        this.f5060g = aVar.f5069g;
        this.f5061h = aVar.f5070h;
        this.f5062i = aVar.f5071i;
    }

    public final int a() {
        if (Build.VERSION.SDK_INT == 23) {
            return this.f5062i / 2;
        }
        return this.f5062i;
    }

    private static Executor b() {
        return Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)));
    }
}
