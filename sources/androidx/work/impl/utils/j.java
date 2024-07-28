package androidx.work.impl.utils;

import androidx.work.impl.WorkDatabase;
import androidx.work.impl.b.q;
import androidx.work.impl.d;
import androidx.work.l;
import androidx.work.u;

public final class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5462a = l.a("StopWorkRunnable");

    /* renamed from: b  reason: collision with root package name */
    private final androidx.work.impl.j f5463b;

    /* renamed from: c  reason: collision with root package name */
    private final String f5464c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f5465d;

    public j(androidx.work.impl.j jVar, String str, boolean z) {
        this.f5463b = jVar;
        this.f5464c = str;
        this.f5465d = z;
    }

    public final void run() {
        boolean z;
        WorkDatabase workDatabase = this.f5463b.f5361c;
        d dVar = this.f5463b.f5364f;
        q b2 = workDatabase.b();
        workDatabase.beginTransaction();
        try {
            boolean g2 = dVar.g(this.f5464c);
            if (this.f5465d) {
                z = this.f5463b.f5364f.a(this.f5464c);
            } else {
                if (!g2 && b2.f(this.f5464c) == u.a.RUNNING) {
                    b2.a(u.a.ENQUEUED, this.f5464c);
                }
                z = this.f5463b.f5364f.b(this.f5464c);
            }
            l.a();
            String.format("StopWorkRunnable for %s; Processor.stopWork = %s", new Object[]{this.f5464c, Boolean.valueOf(z)});
            workDatabase.setTransactionSuccessful();
        } finally {
            workDatabase.endTransaction();
        }
    }
}
