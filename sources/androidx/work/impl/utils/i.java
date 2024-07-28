package androidx.work.impl.utils;

import androidx.work.impl.b.p;
import androidx.work.impl.j;
import androidx.work.impl.utils.a.c;
import androidx.work.u;
import java.util.List;

public abstract class i<T> implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final c<T> f5459a = c.a();

    /* access modifiers changed from: package-private */
    public abstract T a();

    public void run() {
        try {
            this.f5459a.a(a());
        } catch (Throwable th) {
            this.f5459a.a(th);
        }
    }

    public static i<List<u>> a(final j jVar, final String str) {
        return new i<List<u>>() {
            /* access modifiers changed from: package-private */
            public final /* synthetic */ Object a() {
                return p.r.apply(j.this.f5361c.b().g(str));
            }
        };
    }
}
