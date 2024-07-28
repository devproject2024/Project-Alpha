package androidx.fragment.app;

import androidx.core.g.f;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    final g<?> f3412a;

    public static e a(g<?> gVar) {
        return new e((g) f.a(gVar, "callbacks == null"));
    }

    private e(g<?> gVar) {
        this.f3412a = gVar;
    }

    public final Fragment a(String str) {
        return this.f3412a.f3418e.d(str);
    }

    public final void a() {
        this.f3412a.f3418e.l();
    }

    public final boolean b() {
        return this.f3412a.f3418e.a(true);
    }
}
