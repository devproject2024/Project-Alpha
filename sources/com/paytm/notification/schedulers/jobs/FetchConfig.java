package com.paytm.notification.schedulers.jobs;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.paytm.notification.b.e;
import com.paytm.notification.g;
import com.paytm.notification.j;
import com.paytm.notification.models.callback.ConfigChannelReadyCallback;
import com.paytm.notification.models.callback.ConfigReadyCallback;
import kotlin.g.b.k;

public final class FetchConfig extends Worker {

    /* renamed from: a  reason: collision with root package name */
    public static final a f43309a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final String f43310b = f43310b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FetchConfig(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        k.c(context, "appContext");
        k.c(workerParameters, "workerParams");
    }

    public final ListenableWorker.a doWork() {
        ConfigChannelReadyCallback k;
        g.c cVar = g.f43191a;
        if (g.c.d()) {
            e.f43014a.a("Disabled state!!!! Canceling job", new Object[0]);
            ListenableWorker.a c2 = ListenableWorker.a.c();
            k.a((Object) c2, "Result.failure()");
            return c2;
        }
        try {
            boolean a2 = new com.paytm.notification.schedulers.b.a(j.f43241a.c()).a();
            try {
                g.c cVar2 = g.f43191a;
                g.t.lock();
                g.p = Boolean.valueOf(a2);
                ConfigReadyCallback g2 = g.m;
                if (g2 != null) {
                    g2.onConfigReady(a2);
                }
                if (k.a((Object) g.p, (Object) Boolean.TRUE) && k.a((Object) g.q, (Object) Boolean.TRUE) && (k = g.o) != null) {
                    k.onConfigChannelReady(true);
                }
                g.t.unlock();
                if (a2) {
                    ListenableWorker.a a3 = ListenableWorker.a.a();
                    k.a((Object) a3, "Result.success()");
                    return a3;
                }
                ListenableWorker.a b2 = ListenableWorker.a.b();
                k.a((Object) b2, "Result.retry()");
                return b2;
            } catch (com.paytm.notification.a.a.a e2) {
                e.f43014a.b(e2);
                ListenableWorker.a c3 = ListenableWorker.a.c();
                k.a((Object) c3, "Result.failure()");
                return c3;
            } catch (Exception e3) {
                e.f43014a.b(e3);
                ListenableWorker.a c32 = ListenableWorker.a.c();
                k.a((Object) c32, "Result.failure()");
                return c32;
            } catch (Throwable th) {
                g.t.unlock();
                throw th;
            }
        } catch (com.paytm.notification.schedulers.a.a e4) {
            e.b bVar = e.f43014a;
            bVar.a("[DoNotRetry] FetchConfig error: " + e4.getMessage(), new Object[0]);
            e4.printStackTrace();
            ListenableWorker.a c4 = ListenableWorker.a.c();
            k.a((Object) c4, "Result.failure()");
            return c4;
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
