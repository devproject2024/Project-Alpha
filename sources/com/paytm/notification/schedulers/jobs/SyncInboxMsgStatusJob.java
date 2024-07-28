package com.paytm.notification.schedulers.jobs;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.paytm.notification.b.e;
import com.paytm.notification.data.c.h;
import com.paytm.notification.g;
import com.paytm.notification.j;
import com.paytm.notification.models.NotificationUserConfig;
import com.paytm.notification.schedulers.b.f;
import kotlin.g.b.k;

public final class SyncInboxMsgStatusJob extends Worker {

    /* renamed from: a  reason: collision with root package name */
    public static final a f43332a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final String f43333b = f43333b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SyncInboxMsgStatusJob(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        k.c(context, "appContext");
        k.c(workerParameters, "workerParams");
    }

    public final ListenableWorker.a doWork() {
        g.c cVar = g.f43191a;
        if (g.c.d()) {
            e.f43014a.a("Disabled state!!!! Canceling job", new Object[0]);
            ListenableWorker.a c2 = ListenableWorker.a.c();
            k.a((Object) c2, "Result.failure()");
            return c2;
        }
        try {
            h c3 = j.f43241a.c();
            NotificationUserConfig a2 = c3.a();
            if (a2.getServerEndPoints$paytmnotification_paytmRelease() == null) {
                e.f43014a.c("Reschedule Job: serverEndPoints == null. Config may not be available yet.", new Object[0]);
                ListenableWorker.a b2 = ListenableWorker.a.b();
                k.a((Object) b2, "Result.retry()");
                return b2;
            } else if (c3.f() == null) {
                e.f43014a.b("Null channel id job cancelled", new Object[0]);
                ListenableWorker.a c4 = ListenableWorker.a.c();
                k.a((Object) c4, "Result.failure()");
                return c4;
            } else {
                try {
                    new f(a2, c3, j.f43241a.d()).a();
                    ListenableWorker.a a3 = ListenableWorker.a.a();
                    k.a((Object) a3, "Result.success()");
                    return a3;
                } catch (com.paytm.notification.schedulers.a.a e2) {
                    e.b bVar = e.f43014a;
                    bVar.a("[DoNotRetry] SyncInboxMsgStatus error: " + e2.getMessage(), new Object[0]);
                    e2.printStackTrace();
                    ListenableWorker.a c5 = ListenableWorker.a.c();
                    k.a((Object) c5, "Result.failure()");
                    return c5;
                }
            }
        } catch (com.paytm.notification.a.a.a e3) {
            e.f43014a.b(e3);
            ListenableWorker.a c6 = ListenableWorker.a.c();
            k.a((Object) c6, "Result.failure()");
            return c6;
        } catch (Exception e4) {
            e.f43014a.b(e4);
            ListenableWorker.a c62 = ListenableWorker.a.c();
            k.a((Object) c62, "Result.failure()");
            return c62;
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
