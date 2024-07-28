package androidx.work.impl.utils;

import android.content.Context;
import androidx.work.h;
import androidx.work.i;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.b.q;
import androidx.work.impl.foreground.a;
import androidx.work.impl.foreground.b;
import androidx.work.impl.utils.a.c;
import androidx.work.u;
import java.util.UUID;

public final class l implements i {

    /* renamed from: a  reason: collision with root package name */
    final a f5468a;

    /* renamed from: b  reason: collision with root package name */
    final q f5469b;

    /* renamed from: c  reason: collision with root package name */
    private final androidx.work.impl.utils.b.a f5470c;

    public l(WorkDatabase workDatabase, a aVar, androidx.work.impl.utils.b.a aVar2) {
        this.f5468a = aVar;
        this.f5470c = aVar2;
        this.f5469b = workDatabase.b();
    }

    public final com.google.b.a.a.a<Void> setForegroundAsync(Context context, UUID uuid, h hVar) {
        c a2 = c.a();
        final c cVar = a2;
        final UUID uuid2 = uuid;
        final h hVar2 = hVar;
        final Context context2 = context;
        this.f5470c.a(new Runnable() {
            public final void run() {
                try {
                    if (!cVar.isCancelled()) {
                        String uuid = uuid2.toString();
                        u.a f2 = l.this.f5469b.f(uuid);
                        if (f2 == null || f2.isFinished()) {
                            throw new IllegalStateException("Calls to setForegroundAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
                        }
                        l.this.f5468a.a(uuid, hVar2);
                        context2.startService(b.b(context2, uuid, hVar2));
                    }
                    cVar.a(null);
                } catch (Throwable th) {
                    cVar.a(th);
                }
            }
        });
        return a2;
    }
}
