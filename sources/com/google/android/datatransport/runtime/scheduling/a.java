package com.google.android.datatransport.runtime.scheduling;

import com.google.android.datatransport.runtime.backends.e;
import com.google.android.datatransport.runtime.backends.m;
import com.google.android.datatransport.runtime.c.b;
import com.google.android.datatransport.runtime.h;
import com.google.android.datatransport.runtime.l;
import com.google.android.datatransport.runtime.q;
import com.google.android.datatransport.runtime.scheduling.a.c;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.s;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

public final class a implements e {

    /* renamed from: a  reason: collision with root package name */
    private static final Logger f7805a = Logger.getLogger(q.class.getName());

    /* renamed from: b  reason: collision with root package name */
    private final s f7806b;

    /* renamed from: c  reason: collision with root package name */
    private final Executor f7807c;

    /* renamed from: d  reason: collision with root package name */
    private final e f7808d;

    /* renamed from: e  reason: collision with root package name */
    private final c f7809e;

    /* renamed from: f  reason: collision with root package name */
    private final b f7810f;

    public a(Executor executor, e eVar, s sVar, c cVar, b bVar) {
        this.f7807c = executor;
        this.f7808d = eVar;
        this.f7806b = sVar;
        this.f7809e = cVar;
        this.f7810f = bVar;
    }

    public final void a(l lVar, h hVar, com.google.android.datatransport.h hVar2) {
        this.f7807c.execute(b.a(this, lVar, hVar2, hVar));
    }

    static /* synthetic */ void a(a aVar, l lVar, com.google.android.datatransport.h hVar, h hVar2) {
        try {
            m a2 = aVar.f7808d.a(lVar.a());
            if (a2 == null) {
                String format = String.format("Transport backend '%s' is not registered", new Object[]{lVar.a()});
                f7805a.warning(format);
                hVar.a(new IllegalArgumentException(format));
                return;
            }
            aVar.f7810f.a(new c(aVar, lVar, a2.a(hVar2)));
            hVar.a((Exception) null);
        } catch (Exception e2) {
            Logger logger = f7805a;
            logger.warning("Error scheduling event " + e2.getMessage());
            hVar.a(e2);
        }
    }

    static /* synthetic */ Object a(a aVar, l lVar, h hVar) {
        aVar.f7809e.a(lVar, hVar);
        aVar.f7806b.a(lVar, 1);
        return null;
    }
}
