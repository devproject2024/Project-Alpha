package androidx.work.impl.a;

import android.content.Context;
import androidx.work.impl.a.a.b;
import androidx.work.impl.a.a.c;
import androidx.work.impl.a.a.e;
import androidx.work.impl.a.a.f;
import androidx.work.impl.a.a.g;
import androidx.work.impl.a.a.h;
import androidx.work.impl.b.p;
import androidx.work.impl.utils.b.a;
import androidx.work.l;
import java.util.ArrayList;
import java.util.List;

public final class d implements c.a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5145a = l.a("WorkConstraintsTracker");

    /* renamed from: b  reason: collision with root package name */
    private final c f5146b;

    /* renamed from: c  reason: collision with root package name */
    private final c<?>[] f5147c;

    /* renamed from: d  reason: collision with root package name */
    private final Object f5148d = new Object();

    public d(Context context, a aVar, c cVar) {
        Context applicationContext = context.getApplicationContext();
        this.f5146b = cVar;
        this.f5147c = new c[]{new androidx.work.impl.a.a.a(applicationContext, aVar), new b(applicationContext, aVar), new h(applicationContext, aVar), new androidx.work.impl.a.a.d(applicationContext, aVar), new g(applicationContext, aVar), new f(applicationContext, aVar), new e(applicationContext, aVar)};
    }

    public final void a(Iterable<p> iterable) {
        synchronized (this.f5148d) {
            for (c<?> a2 : this.f5147c) {
                a2.a((c.a) null);
            }
            for (c<?> a3 : this.f5147c) {
                a3.a(iterable);
            }
            for (c<?> a4 : this.f5147c) {
                a4.a((c.a) this);
            }
        }
    }

    public final void a() {
        synchronized (this.f5148d) {
            for (c<?> a2 : this.f5147c) {
                a2.a();
            }
        }
    }

    public final boolean a(String str) {
        synchronized (this.f5148d) {
            for (c<?> cVar : this.f5147c) {
                if (cVar.f5111b != null && cVar.b(cVar.f5111b) && cVar.f5110a.contains(str)) {
                    l.a();
                    String.format("Work %s constrained by %s", new Object[]{str, cVar.getClass().getSimpleName()});
                    return false;
                }
            }
            return true;
        }
    }

    public final void a(List<String> list) {
        synchronized (this.f5148d) {
            ArrayList arrayList = new ArrayList();
            for (String next : list) {
                if (a(next)) {
                    l.a();
                    String.format("Constraints met for %s", new Object[]{next});
                    arrayList.add(next);
                }
            }
            if (this.f5146b != null) {
                this.f5146b.a(arrayList);
            }
        }
    }

    public final void b(List<String> list) {
        synchronized (this.f5148d) {
            if (this.f5146b != null) {
                this.f5146b.b(list);
            }
        }
    }
}
