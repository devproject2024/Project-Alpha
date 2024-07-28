package com.paytm.signal.schedulers;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import kotlin.g.b.k;

public final class TimeCalibrateJob extends Worker {

    /* renamed from: a  reason: collision with root package name */
    public static final a f43653a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private final String f43654b = TimeCalibrateJob.class.getCanonicalName();

    /* renamed from: c  reason: collision with root package name */
    private final Context f43655c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TimeCalibrateJob(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        k.c(context, "context");
        k.c(workerParameters, "workerParams");
        this.f43655c = context;
    }

    public final ListenableWorker.a doWork() {
        c cVar = c.f43662a;
        c.a(this.f43655c, false);
        ListenableWorker.a a2 = ListenableWorker.a.a();
        k.a((Object) a2, "Result.success()");
        return a2;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
