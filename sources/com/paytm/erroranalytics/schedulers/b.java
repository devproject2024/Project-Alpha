package com.paytm.erroranalytics.schedulers;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.c;
import androidx.work.m;
import androidx.work.p;
import com.paytm.erroranalytics.a.a.a;
import com.paytm.erroranalytics.e;
import java.util.concurrent.TimeUnit;

public final class b extends a implements c {

    /* renamed from: b  reason: collision with root package name */
    private static b f42814b;

    private b(Context context) {
        super(context);
    }

    public static void a(Context context) throws a {
        try {
            synchronized (b.class) {
                if (f42814b == null) {
                    f42814b = new b(context);
                }
            }
        } catch (IllegalStateException e2) {
            if (e2.getMessage() != null) {
                e2.getMessage();
            }
            String str = e.f42808a;
            throw new a("Can not initialize JobManager");
        }
    }

    public static c a() throws a {
        b bVar = f42814b;
        if (bVar != null) {
            return bVar;
        }
        throw new a("You need to call initScheduler() at least once to create the singleton");
    }

    public final void b() {
        this.f42812a.b();
    }

    public final synchronized int b(Class<? extends ListenableWorker> cls, String str, d dVar) {
        int i2 = dVar.f42821b;
        if (i2 == 1) {
            super.a(cls, str, dVar);
        } else if (i2 == 2) {
            c.a aVar = new c.a();
            aVar.f5083c = m.CONNECTED;
            aVar.f5084d = true;
            super.a(str, (p.a) ((p.a) ((p.a) new p.a(cls, dVar.f42822c, TimeUnit.MILLISECONDS).a(androidx.work.a.LINEAR, 60000, TimeUnit.MILLISECONDS)).a(aVar.b())).a(str));
        } else if (i2 == 5) {
            super.a(cls, str, dVar);
        }
        return 1;
    }
}
