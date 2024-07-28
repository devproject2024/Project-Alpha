package com.paytm.erroranalytics.schedulers.jobs;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.paytm.erroranalytics.a.a;
import com.paytm.erroranalytics.a.d;
import com.paytm.erroranalytics.a.f;
import com.paytm.erroranalytics.e;
import java.util.Map;

public class SyncEventJob extends Worker {

    /* renamed from: a  reason: collision with root package name */
    private d f42838a;

    public SyncEventJob(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    public ListenableWorker.a doWork() {
        try {
            String str = e.f42808a;
            if (e.c()) {
                String str2 = e.f42808a;
                return new ListenableWorker.a.C0076a();
            }
            this.f42838a = f.d().b();
            a c2 = f.d().c();
            com.paytm.erroranalytics.c.a a2 = c2.a();
            Map<String, String> d2 = c2.f42698a.d();
            if (a2.f42714f == null || d2 == null || d2.isEmpty()) {
                return new ListenableWorker.a.C0076a();
            }
            try {
                if (new com.paytm.erroranalytics.schedulers.b.a(getApplicationContext(), this.f42838a, a2, d2).a()) {
                    return new ListenableWorker.a.c();
                }
                return new ListenableWorker.a.b();
            } catch (com.paytm.erroranalytics.schedulers.a.a unused) {
                String str3 = e.f42808a;
                return new ListenableWorker.a.C0076a();
            }
        } catch (com.paytm.erroranalytics.a.a.a unused2) {
            String str4 = e.f42808a;
            return new ListenableWorker.a.C0076a();
        } catch (Exception unused3) {
            String str5 = e.f42808a;
            return new ListenableWorker.a.C0076a();
        }
    }
}
