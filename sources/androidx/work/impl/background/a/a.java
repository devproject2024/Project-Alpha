package androidx.work.impl.background.a;

import androidx.work.impl.b.p;
import androidx.work.l;
import androidx.work.s;
import java.util.HashMap;
import java.util.Map;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    static final String f5225a = l.a("DelayedWorkTracker");

    /* renamed from: b  reason: collision with root package name */
    final b f5226b;

    /* renamed from: c  reason: collision with root package name */
    final s f5227c;

    /* renamed from: d  reason: collision with root package name */
    final Map<String, Runnable> f5228d = new HashMap();

    public a(b bVar, s sVar) {
        this.f5226b = bVar;
        this.f5227c = sVar;
    }

    public final void a(final p pVar) {
        Runnable remove = this.f5228d.remove(pVar.f5180a);
        if (remove != null) {
            this.f5227c.a(remove);
        }
        AnonymousClass1 r0 = new Runnable() {
            public final void run() {
                l.a();
                String str = a.f5225a;
                String.format("Scheduling work %s", new Object[]{pVar.f5180a});
                a.this.f5226b.a(pVar);
            }
        };
        this.f5228d.put(pVar.f5180a, r0);
        long currentTimeMillis = System.currentTimeMillis();
        this.f5227c.a(pVar.c() - currentTimeMillis, r0);
    }
}
