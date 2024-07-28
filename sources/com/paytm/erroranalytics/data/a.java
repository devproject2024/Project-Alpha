package com.paytm.erroranalytics.data;

import android.content.Context;
import com.paytm.erroranalytics.a.c;
import com.paytm.erroranalytics.c.a;
import com.paytm.erroranalytics.data.datasource.g;
import com.paytm.erroranalytics.e;
import com.paytm.erroranalytics.schedulers.b;
import com.paytm.erroranalytics.schedulers.d;
import com.paytm.erroranalytics.schedulers.jobs.SyncEventJob;
import java.net.MalformedURLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class a implements c {

    /* renamed from: e  reason: collision with root package name */
    private static long f42779e;

    /* renamed from: a  reason: collision with root package name */
    private com.paytm.erroranalytics.data.datasource.c f42780a;

    /* renamed from: b  reason: collision with root package name */
    private final String f42781b = a.class.getCanonicalName();

    /* renamed from: c  reason: collision with root package name */
    private com.paytm.erroranalytics.schedulers.c f42782c;

    /* renamed from: d  reason: collision with root package name */
    private Context f42783d;

    public a(Context context) throws com.paytm.erroranalytics.a.a.a {
        this.f42783d = context;
        try {
            this.f42780a = g.d();
            this.f42782c = b.a();
        } catch (com.paytm.erroranalytics.a.a.a e2) {
            if (e2.getMessage() != null) {
                e2.getMessage();
            }
            String str = e.f42808a;
            e2.getMessage();
            throw e2;
        }
    }

    public final void a(com.paytm.erroranalytics.c.b.a aVar) {
        this.f42780a.a().a(aVar);
        a(this.f42780a, this.f42783d);
    }

    public final List<com.paytm.erroranalytics.c.b.a> a() {
        return this.f42780a.a().a();
    }

    public final com.paytm.erroranalytics.c.b a(com.paytm.erroranalytics.c.a.a.b bVar, String str, String str2, Map<String, String> map) throws com.paytm.erroranalytics.data.a.a, MalformedURLException {
        return this.f42780a.b().a(bVar, str, str2, map);
    }

    public final void a(List<Long> list) {
        this.f42780a.a().a(list);
    }

    public final int b() {
        int i2 = c().j;
        long j = i2 < 30 ? 120000 : (long) (i2 * 1000);
        d.a aVar = new d.a();
        aVar.f42830b = 1;
        aVar.f42829a = 2;
        aVar.j = j;
        return this.f42782c.b(SyncEventJob.class, "sync_error_sdk_events_tag", new d(aVar, (byte) 0));
    }

    public final void a(com.paytm.erroranalytics.c.a aVar) {
        if (this.f42780a.c().isAssignableFrom(com.paytm.erroranalytics.data.datasource.b.class)) {
            com.paytm.erroranalytics.data.datasource.b.a(this.f42783d, aVar);
        }
    }

    public final com.paytm.erroranalytics.c.a c() {
        if (this.f42780a.c().isAssignableFrom(com.paytm.erroranalytics.data.datasource.b.class)) {
            return com.paytm.erroranalytics.data.datasource.b.a(this.f42783d);
        }
        return new a.C0712a().a();
    }

    public final Map<String, String> d() {
        if (this.f42780a.c().isAssignableFrom(com.paytm.erroranalytics.data.datasource.b.class)) {
            return com.paytm.erroranalytics.data.datasource.b.c(this.f42783d);
        }
        return null;
    }

    public final String e() {
        return com.paytm.erroranalytics.b.b.b(this.f42783d);
    }

    private static void a(com.paytm.erroranalytics.data.datasource.c cVar, Context context, long j) {
        if (cVar.c().isAssignableFrom(com.paytm.erroranalytics.data.datasource.b.class)) {
            com.paytm.erroranalytics.data.datasource.b.a(context, j);
        }
    }

    private static synchronized void a(com.paytm.erroranalytics.data.datasource.c cVar, Context context) {
        long j;
        synchronized (a.class) {
            try {
                long time = new Date().getTime();
                if (f42779e == 0) {
                    if (cVar.c().isAssignableFrom(com.paytm.erroranalytics.data.datasource.b.class)) {
                        j = com.paytm.erroranalytics.data.datasource.b.b(context);
                    } else {
                        j = 0;
                    }
                    if (j == 0) {
                        j = time;
                    }
                    f42779e = j;
                    a(cVar, context, f42779e);
                }
                if (f42779e != 0 && time - f42779e > 480000) {
                    cVar.a().b();
                    f42779e = time;
                    a(cVar, context, time);
                }
            } catch (Exception e2) {
                if (e2.getMessage() != null) {
                    e2.getMessage();
                }
            }
        }
    }
}
