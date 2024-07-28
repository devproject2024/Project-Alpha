package com.paytm.contactsSdk.workManager;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.paytm.contactsSdk.ContactsSdk;
import com.paytm.contactsSdk.api.ContactsConsent;
import com.paytm.contactsSdk.api.p002enum.SyncStage;
import com.paytm.contactsSdk.listener.EnrichmentDataSyncListener;
import com.paytm.contactsSdk.network.ContactEnrichmentManager;
import com.paytm.contactsSdk.utils.ContactUtil;
import com.paytm.utility.q;
import java.util.concurrent.CountDownLatch;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class EnrichmentDataSyncWorker extends Worker {
    public static final Companion Companion = new Companion((g) null);
    /* access modifiers changed from: private */
    public static final String TAG;
    public CountDownLatch countDownLatch;
    private ListenableWorker.a workerResult;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EnrichmentDataSyncWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        k.c(context, "appContext");
        k.c(workerParameters, "workerParams");
        ListenableWorker.a.b bVar = new ListenableWorker.a.b();
        k.a((Object) bVar, "Result.retry()");
        this.workerResult = bVar;
    }

    public final ListenableWorker.a getWorkerResult() {
        return this.workerResult;
    }

    public final void setWorkerResult(ListenableWorker.a aVar) {
        k.c(aVar, "<set-?>");
        this.workerResult = aVar;
    }

    public final CountDownLatch getCountDownLatch() {
        CountDownLatch countDownLatch2 = this.countDownLatch;
        if (countDownLatch2 == null) {
            k.a("countDownLatch");
        }
        return countDownLatch2;
    }

    public final void setCountDownLatch(CountDownLatch countDownLatch2) {
        k.c(countDownLatch2, "<set-?>");
        this.countDownLatch = countDownLatch2;
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final String getTAG() {
            return EnrichmentDataSyncWorker.TAG;
        }
    }

    static {
        String simpleName = EnrichmentDataSyncWorker.class.getSimpleName();
        k.a((Object) simpleName, "EnrichmentDataSyncWorker::class.java.simpleName");
        TAG = simpleName;
    }

    public final ListenableWorker.a doWork() {
        q.d("Running " + TAG);
        if (!ContactsSdk.INSTANCE.isLoggedIn()) {
            q.d("User Not Logged-in!!!");
            ListenableWorker.a.C0076a aVar = new ListenableWorker.a.C0076a();
            k.a((Object) aVar, "Result.failure()");
            return aVar;
        } else if (!ContactsConsent.INSTANCE.checkLocalConsent()) {
            q.d("Consent not given.");
            ListenableWorker.a.c cVar = new ListenableWorker.a.c();
            k.a((Object) cVar, "Result.success()");
            return cVar;
        } else {
            q.d("Consent given.");
            if (!ContactsSdk.INSTANCE.isContactsSDKRemoteSyncEnabled$contacts_sdk_release()) {
                q.d("Remote Sync Disabled");
                ListenableWorker.a.c cVar2 = new ListenableWorker.a.c();
                k.a((Object) cVar2, "Result.success()");
                return cVar2;
            }
            q.d("Remote Sync Enabled");
            if (!ContactsSdk.INSTANCE.isContactsSDKLocalSyncEnabled$contacts_sdk_release()) {
                q.d("Local Sync Disabled");
                ListenableWorker.a.c cVar3 = new ListenableWorker.a.c();
                k.a((Object) cVar3, "Result.success()");
                return cVar3;
            }
            q.d("Local Sync Enabled");
            this.countDownLatch = new CountDownLatch(1);
            ContactsSdk.INSTANCE.setRemoteSyncInProgress$contacts_sdk_release(true);
            ContactUtil.INSTANCE.sendMetaInfo$contacts_sdk_release(SyncStage.ENRICHMENT_SYNC, 0.0d, 0);
            ContactEnrichmentManager contactEnrichmentManager = ContactEnrichmentManager.INSTANCE;
            Context applicationContext = getApplicationContext();
            k.a((Object) applicationContext, "applicationContext");
            contactEnrichmentManager.startFetchingEnrichmentData(applicationContext, getEnrichmentDataSyncListener());
            CountDownLatch countDownLatch2 = this.countDownLatch;
            if (countDownLatch2 == null) {
                k.a("countDownLatch");
            }
            countDownLatch2.await();
            ContactsSdk.INSTANCE.setRemoteSyncInProgress$contacts_sdk_release(false);
            if (!k.a((Object) this.workerResult, (Object) new ListenableWorker.a.b())) {
                ContactUtil.INSTANCE.sendSyncStoppedMetaInfo$contacts_sdk_release();
            }
            return this.workerResult;
        }
    }

    private final EnrichmentDataSyncListener getEnrichmentDataSyncListener() {
        return new EnrichmentDataSyncWorker$getEnrichmentDataSyncListener$1(this);
    }
}
