package com.paytm.contactsSdk.workManager;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.paytm.contactsSdk.manager.LocalSyncManager;
import com.paytm.utility.c.a.b;
import com.paytm.utility.q;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class DbSyncWorker extends Worker {
    public static final Companion Companion = new Companion((g) null);
    public static final String TAG = "DbSyncWorker";
    private final Context context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DbSyncWorker(Context context2, WorkerParameters workerParameters) {
        super(context2, workerParameters);
        k.c(context2, "context");
        k.c(workerParameters, "workerParameters");
        this.context = context2;
    }

    public final Context getContext() {
        return this.context;
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    public final ListenableWorker.a doWork() {
        b bVar = b.f43777a;
        if (b.a(this.context, new String[]{"android.permission.READ_CONTACTS"})) {
            q.d("Permission granted");
            LocalSyncManager.INSTANCE.localDbSync();
        } else {
            q.b("Permission not granted");
        }
        ListenableWorker.a.c cVar = new ListenableWorker.a.c();
        k.a((Object) cVar, "Result.success()");
        return cVar;
    }
}
