package com.paytm.signal.schedulers;

import android.content.Context;
import androidx.work.c;
import androidx.work.f;
import androidx.work.g;
import androidx.work.m;
import androidx.work.n;
import androidx.work.p;
import androidx.work.v;
import androidx.work.w;
import com.paytm.notification.b.e;
import java.util.concurrent.TimeUnit;
import kotlin.g.b.k;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final C0748a f43656a = new C0748a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private v f43657b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f43658c;

    public a(Context context) {
        k.c(context, "context");
        this.f43658c = context;
    }

    /* renamed from: com.paytm.signal.schedulers.a$a  reason: collision with other inner class name */
    public static final class C0748a {
        private C0748a() {
        }

        public /* synthetic */ C0748a(byte b2) {
            this();
        }
    }

    public final v a() {
        if (this.f43657b == null) {
            try {
                this.f43657b = v.a(this.f43658c);
            } catch (Exception e2) {
                e.f43014a.b(e2);
            }
        }
        return this.f43657b;
    }

    public final void a(long j) {
        try {
            w.a a2 = ((n.a) ((n.a) ((n.a) new n.a(SyncEventJob.class).a(j, TimeUnit.MILLISECONDS)).a(androidx.work.a.EXPONENTIAL, 30000, TimeUnit.MILLISECONDS)).a(new c.a().a(m.CONNECTED).b())).a("sync_events_tag");
            k.a((Object) a2, "OneTimeWorkRequest.Build…Tag(SyncEventJob.JOB_TAG)");
            n.a aVar = (n.a) a2;
            v a3 = a();
            if (a3 != null) {
                a3.a("sync_events_tag", g.KEEP, (n) aVar.c());
            }
            w.a a4 = ((p.a) ((p.a) ((p.a) new p.a(SyncEventJob.class, 15, TimeUnit.MINUTES).a(15, TimeUnit.MINUTES)).a(androidx.work.a.EXPONENTIAL, 30000, TimeUnit.MILLISECONDS)).a(new c.a().a(m.CONNECTED).b())).a("sync_periodic_events_tag");
            k.a((Object) a4, "PeriodicWorkRequest.Buil…b.EVENT_PERIODIC_JOB_TAG)");
            p.a aVar2 = (p.a) a4;
            v a5 = a();
            if (a5 != null) {
                a5.a("sync_periodic_events_tag", f.KEEP, (p) aVar2.c());
            }
        } catch (Exception e2) {
            e.f43014a.b(e2);
        }
    }

    public final int b(long j) {
        try {
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            w.a a2 = ((p.a) ((p.a) new p.a(TimeCalibrateJob.class, j, timeUnit, timeUnit).a(androidx.work.a.EXPONENTIAL, 30000, TimeUnit.MILLISECONDS)).a(new c.a().a(m.CONNECTED).b())).a("time_calibrate_tag");
            k.a((Object) a2, "PeriodicWorkRequest.Buil…teJob.TIME_CALIBRATE_TAG)");
            p.a aVar = (p.a) a2;
            v a3 = a();
            if (a3 == null) {
                return -1;
            }
            a3.a("time_calibrate_tag", f.REPLACE, (p) aVar.c());
            return -1;
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }
}
