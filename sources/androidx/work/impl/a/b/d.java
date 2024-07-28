package androidx.work.impl.a.b;

import android.content.Context;
import androidx.work.impl.utils.b.a;
import androidx.work.l;
import java.util.LinkedHashSet;
import java.util.Set;

public abstract class d<T> {

    /* renamed from: d  reason: collision with root package name */
    private static final String f5125d = l.a("ConstraintTracker");

    /* renamed from: a  reason: collision with root package name */
    protected final a f5126a;

    /* renamed from: b  reason: collision with root package name */
    protected final Context f5127b;

    /* renamed from: c  reason: collision with root package name */
    T f5128c;

    /* renamed from: e  reason: collision with root package name */
    private final Object f5129e = new Object();

    /* renamed from: f  reason: collision with root package name */
    private final Set<androidx.work.impl.a.a<T>> f5130f = new LinkedHashSet();

    public abstract T b();

    public abstract void c();

    public abstract void d();

    d(Context context, a aVar) {
        this.f5127b = context.getApplicationContext();
        this.f5126a = aVar;
    }

    public final void a(androidx.work.impl.a.a<T> aVar) {
        synchronized (this.f5129e) {
            if (this.f5130f.add(aVar)) {
                if (this.f5130f.size() == 1) {
                    this.f5128c = b();
                    l.a();
                    String.format("%s: initial state = %s", new Object[]{getClass().getSimpleName(), this.f5128c});
                    c();
                }
                aVar.a(this.f5128c);
            }
        }
    }

    public final void b(androidx.work.impl.a.a<T> aVar) {
        synchronized (this.f5129e) {
            if (this.f5130f.remove(aVar) && this.f5130f.isEmpty()) {
                d();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(T r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f5129e
            monitor-enter(r0)
            T r1 = r3.f5128c     // Catch:{ all -> 0x002f }
            if (r1 == r4) goto L_0x002d
            T r1 = r3.f5128c     // Catch:{ all -> 0x002f }
            if (r1 == 0) goto L_0x0014
            T r1 = r3.f5128c     // Catch:{ all -> 0x002f }
            boolean r1 = r1.equals(r4)     // Catch:{ all -> 0x002f }
            if (r1 == 0) goto L_0x0014
            goto L_0x002d
        L_0x0014:
            r3.f5128c = r4     // Catch:{ all -> 0x002f }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x002f }
            java.util.Set<androidx.work.impl.a.a<T>> r1 = r3.f5130f     // Catch:{ all -> 0x002f }
            r4.<init>(r1)     // Catch:{ all -> 0x002f }
            androidx.work.impl.utils.b.a r1 = r3.f5126a     // Catch:{ all -> 0x002f }
            java.util.concurrent.Executor r1 = r1.a()     // Catch:{ all -> 0x002f }
            androidx.work.impl.a.b.d$1 r2 = new androidx.work.impl.a.b.d$1     // Catch:{ all -> 0x002f }
            r2.<init>(r4)     // Catch:{ all -> 0x002f }
            r1.execute(r2)     // Catch:{ all -> 0x002f }
            monitor-exit(r0)     // Catch:{ all -> 0x002f }
            return
        L_0x002d:
            monitor-exit(r0)     // Catch:{ all -> 0x002f }
            return
        L_0x002f:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002f }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.a.b.d.a(java.lang.Object):void");
    }
}
