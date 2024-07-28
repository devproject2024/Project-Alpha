package com.paytm.contactsSdk.workManager;

import android.content.Context;
import com.paytm.contactsSdk.api.p002enum.SyncStage;
import com.paytm.contactsSdk.utils.ContactUtil;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import java.util.List;
import kotlin.g.b.k;

public final class UploadNewContactsWorker$syncData$1 implements b {
    final /* synthetic */ List $contactSyncList;
    final /* synthetic */ UploadNewContactsWorker this$0;

    UploadNewContactsWorker$syncData$1(UploadNewContactsWorker uploadNewContactsWorker, List list) {
        this.this$0 = uploadNewContactsWorker;
        this.$contactSyncList = list;
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        UploadNewContactsWorker.Companion.getTAG();
        q.b(" onApiSuccess OnSuccess");
        UploadNewContactsWorker uploadNewContactsWorker = this.this$0;
        Context applicationContext = uploadNewContactsWorker.getApplicationContext();
        k.a((Object) applicationContext, "applicationContext");
        uploadNewContactsWorker.changeContactsToSynced(applicationContext, this.$contactSyncList);
        ContactUtil.INSTANCE.sendMetaInfo$contacts_sdk_release(SyncStage.REMOTE_SYNC, this.this$0.getProgressPert(), this.this$0.getTotalSyncContacts());
        this.this$0.syncData();
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        UploadNewContactsWorker.Companion.getTAG();
        q.b("OnError statusCode: ".concat(String.valueOf(i2)));
        this.this$0.setWorkerResult(ContactUtil.INSTANCE.getSyncWorkerErrorResult$contacts_sdk_release(this.this$0, Integer.valueOf(i2), networkCustomError));
        this.this$0.getCountDownLatch().countDown();
    }
}
