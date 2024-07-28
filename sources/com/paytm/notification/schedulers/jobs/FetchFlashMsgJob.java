package com.paytm.notification.schedulers.jobs;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.paytm.notification.b.e;
import com.paytm.notification.data.c.h;
import com.paytm.notification.g;
import com.paytm.notification.i;
import com.paytm.notification.j;
import com.paytm.notification.models.NotificationUserConfig;
import com.paytm.notification.schedulers.b.b;
import kotlin.g.b.k;
import kotlin.m;

public final class FetchFlashMsgJob extends Worker {

    /* renamed from: a  reason: collision with root package name */
    public static final a f43311a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final String f43312b = f43312b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FetchFlashMsgJob(Context context, WorkerParameters workerParameters) {
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
            if (a2.getServerEndPoints$paytmnotification_paytmRelease() != null) {
                if (!(a2.getCustomerId$paytmnotification_paytmRelease() == null || c3.f() == null)) {
                    try {
                        if (k.a((Object) a2.isFlashEnabled$paytmnotification_paytmRelease(), (Object) Boolean.FALSE)) {
                            e.f43014a.a("Flash is disabled", new Object[0]);
                            ListenableWorker.a c4 = ListenableWorker.a.c();
                            k.a((Object) c4, "Result.failure()");
                            return c4;
                        } else if (new b(a2, j.f43241a.e(), j.f43241a.a()).a()) {
                            ListenableWorker.a a3 = ListenableWorker.a.a();
                            k.a((Object) a3, "Result.success()");
                            return a3;
                        } else {
                            i.a aVar = i.f43209d;
                            i d2 = i.f43210i;
                            if (d2 != null) {
                                d2.a();
                            }
                            ListenableWorker.a b2 = ListenableWorker.a.b();
                            k.a((Object) b2, "Result.retry()");
                            return b2;
                        }
                    } catch (com.paytm.notification.schedulers.a.a e2) {
                        e.b bVar = e.f43014a;
                        bVar.a("[DoNotRetry] FetchFlash error: " + e2.getMessage(), new Object[0]);
                        e2.printStackTrace();
                        ListenableWorker.a c5 = ListenableWorker.a.c();
                        k.a((Object) c5, "Result.failure()");
                        return c5;
                    }
                }
            }
            boolean a4 = k.a((Object) a2.isFlashEnabled$paytmnotification_paytmRelease(), (Object) Boolean.TRUE);
            if (a4) {
                ListenableWorker.a b3 = ListenableWorker.a.b();
                k.a((Object) b3, "Result.retry()");
                return b3;
            } else if (!a4) {
                ListenableWorker.a c6 = ListenableWorker.a.c();
                k.a((Object) c6, "Result.failure()");
                return c6;
            } else {
                throw new m();
            }
        } catch (com.paytm.notification.a.a.a e3) {
            e.f43014a.b(e3);
            ListenableWorker.a c7 = ListenableWorker.a.c();
            k.a((Object) c7, "Result.failure()");
            return c7;
        } catch (Exception e4) {
            e.f43014a.b(e4);
            ListenableWorker.a c72 = ListenableWorker.a.c();
            k.a((Object) c72, "Result.failure()");
            return c72;
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
