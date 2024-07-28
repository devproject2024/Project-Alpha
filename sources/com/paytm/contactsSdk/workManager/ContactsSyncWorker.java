package com.paytm.contactsSdk.workManager;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.paytm.contactsSdk.api.ContactsProvider;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class ContactsSyncWorker extends Worker {
    public static final Companion Companion = new Companion((g) null);
    public static final String TAG = "ContactsSyncWorker";

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ContactsSyncWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        k.c(context, "context");
        k.c(workerParameters, "workerParameters");
    }

    public final ListenableWorker.a doWork() {
        ContactsProvider.INSTANCE.syncContacts$contacts_sdk_release();
        ListenableWorker.a.c cVar = new ListenableWorker.a.c();
        k.a((Object) cVar, "Result.success()");
        return cVar;
    }
}
