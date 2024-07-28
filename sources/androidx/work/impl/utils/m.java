package androidx.work.impl.utils;

import android.content.Context;
import androidx.work.e;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.b.p;
import androidx.work.impl.utils.a.c;
import androidx.work.impl.utils.b.a;
import androidx.work.l;
import androidx.work.q;
import androidx.work.u;
import java.util.UUID;

public final class m implements q {

    /* renamed from: a  reason: collision with root package name */
    static final String f5476a = l.a("WorkProgressUpdater");

    /* renamed from: b  reason: collision with root package name */
    final WorkDatabase f5477b;

    /* renamed from: c  reason: collision with root package name */
    final a f5478c;

    public m(WorkDatabase workDatabase, a aVar) {
        this.f5477b = workDatabase;
        this.f5478c = aVar;
    }

    public final com.google.b.a.a.a<Void> updateProgress(Context context, final UUID uuid, final e eVar) {
        final c a2 = c.a();
        this.f5478c.a(new Runnable() {
            public final void run() {
                String uuid = uuid.toString();
                l.a();
                String str = m.f5476a;
                String.format("Updating progress for %s (%s)", new Object[]{uuid, eVar});
                m.this.f5477b.beginTransaction();
                try {
                    p b2 = m.this.f5477b.b().b(uuid);
                    if (b2 != null) {
                        if (b2.f5181b == u.a.RUNNING) {
                            m.this.f5477b.g().a(new androidx.work.impl.b.m(uuid, eVar));
                        } else {
                            l.a();
                            String str2 = m.f5476a;
                            String.format("Ignoring setProgressAsync(...). WorkSpec (%s) is not in a RUNNING state.", new Object[]{uuid});
                        }
                        a2.a(null);
                        m.this.f5477b.setTransactionSuccessful();
                        m.this.f5477b.endTransaction();
                        return;
                    }
                    throw new IllegalStateException("Calls to setProgressAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
                } catch (Throwable th) {
                    m.this.f5477b.endTransaction();
                    throw th;
                }
            }
        });
        return a2;
    }
}
