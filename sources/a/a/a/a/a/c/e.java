package a.a.a.a.a.c;

import a.a.a.a.a.a.c;
import a.a.a.a.a.a.d;
import a.a.a.a.a.c.b;
import a.a.a.a.a.h.a;
import java.util.Collections;

public final class e implements c, b.C0000b {

    /* renamed from: c  reason: collision with root package name */
    private static e f725c;

    /* renamed from: a  reason: collision with root package name */
    public float f726a = 0.0f;

    /* renamed from: b  reason: collision with root package name */
    public d f727b;

    /* renamed from: d  reason: collision with root package name */
    private final a.a.a.a.a.a.e f728d;

    /* renamed from: e  reason: collision with root package name */
    private final a.a.a.a.a.a.b f729e;

    /* renamed from: f  reason: collision with root package name */
    private a f730f;

    private e(a.a.a.a.a.a.e eVar, a.a.a.a.a.a.b bVar) {
        this.f728d = eVar;
        this.f729e = bVar;
    }

    public static e a() {
        if (f725c == null) {
            f725c = new e(new a.a.a.a.a.a.e(), new a.a.a.a.a.a.b());
        }
        return f725c;
    }

    public final void b() {
        b.a().f718e = this;
        b.a().b();
        if (!b.a().f717d) {
            a.a();
            a.b();
        }
        this.f727b.a();
    }

    public final void a(boolean z) {
        if (z) {
            a.a();
            a.b();
            return;
        }
        a.a();
        a.c();
    }

    public final void a(float f2) {
        this.f726a = f2;
        if (this.f730f == null) {
            this.f730f = a.a();
        }
        for (T t : Collections.unmodifiableCollection(this.f730f.f712b)) {
            t.f703c.a(f2);
        }
    }
}
