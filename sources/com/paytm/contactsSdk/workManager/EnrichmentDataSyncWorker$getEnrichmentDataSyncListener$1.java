package com.paytm.contactsSdk.workManager;

import androidx.work.ListenableWorker;
import com.paytm.contactsSdk.api.p002enum.SyncStage;
import com.paytm.contactsSdk.listener.EnrichmentDataSyncListener;
import com.paytm.contactsSdk.utils.ContactUtil;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import kotlin.g.b.k;

public final class EnrichmentDataSyncWorker$getEnrichmentDataSyncListener$1 implements EnrichmentDataSyncListener {
    final /* synthetic */ EnrichmentDataSyncWorker this$0;

    EnrichmentDataSyncWorker$getEnrichmentDataSyncListener$1(EnrichmentDataSyncWorker enrichmentDataSyncWorker) {
        this.this$0 = enrichmentDataSyncWorker;
    }

    public final void onComplete() {
        EnrichmentDataSyncWorker.Companion.getTAG();
        q.b("onComplete");
        ContactUtil.INSTANCE.sendMetaInfo$contacts_sdk_release(SyncStage.ENRICHMENT_SYNC, 100.0d, 0);
        EnrichmentDataSyncWorker enrichmentDataSyncWorker = this.this$0;
        ListenableWorker.a.c cVar = new ListenableWorker.a.c();
        k.a((Object) cVar, "Result.success()");
        enrichmentDataSyncWorker.setWorkerResult(cVar);
        this.this$0.getCountDownLatch().countDown();
    }

    public final void onError(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        EnrichmentDataSyncWorker.Companion.getTAG();
        q.b("onError status code: ".concat(String.valueOf(i2)));
        this.this$0.setWorkerResult(ContactUtil.INSTANCE.getSyncWorkerErrorResult$contacts_sdk_release(this.this$0, Integer.valueOf(i2), networkCustomError));
        this.this$0.getCountDownLatch().countDown();
    }
}
