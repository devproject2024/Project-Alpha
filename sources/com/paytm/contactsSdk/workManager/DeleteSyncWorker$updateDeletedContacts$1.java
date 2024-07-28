package com.paytm.contactsSdk.workManager;

import androidx.work.ListenableWorker;
import com.paytm.contactsSdk.ContactsSdk;
import com.paytm.contactsSdk.api.p002enum.SyncStage;
import com.paytm.contactsSdk.models.network.DeleteContactResponse;
import com.paytm.contactsSdk.models.network.DeleteStatusInfo;
import com.paytm.contactsSdk.utils.ContactUtil;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import java.util.List;
import kotlin.g.b.ab;
import kotlin.g.b.k;
import kotlin.u;

public final class DeleteSyncWorker$updateDeletedContacts$1 implements b {
    final /* synthetic */ DeleteSyncWorker this$0;

    DeleteSyncWorker$updateDeletedContacts$1(DeleteSyncWorker deleteSyncWorker) {
        this.this$0 = deleteSyncWorker;
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        DeleteStatusInfo statusInfo;
        if (!(iJRPaytmDataModel instanceof DeleteContactResponse) || (statusInfo = ((DeleteContactResponse) iJRPaytmDataModel).getStatusInfo()) == null || !k.a((Object) statusInfo.getStatus(), (Object) "SUCCESS")) {
            this.this$0.workResult = ContactUtil.getSyncWorkerErrorResult$contacts_sdk_release$default(ContactUtil.INSTANCE, this.this$0, (Integer) null, (NetworkCustomError) null, 6, (Object) null);
            DeleteSyncWorker.access$getLatch$p(this.this$0).countDown();
            return;
        }
        new StringBuilder("Making DB call to delete these contacts = ").append(this.this$0.getDeletedContacts());
        this.this$0.getContactsRepo().deleteDeletedContactsAfterServerSync(this.this$0.getDeletedContacts());
        this.this$0.getDeletedContacts().clear();
        DeleteSyncWorker deleteSyncWorker = this.this$0;
        List<Integer> deleteContactFromLocalWithLimit = deleteSyncWorker.getContactsRepo().getDeleteContactFromLocalWithLimit(ContactsSdk.INSTANCE.getContactsSDKApplicationInterface$contacts_sdk_release().uploadBatchSize());
        if (deleteContactFromLocalWithLimit != null) {
            deleteSyncWorker.setDeletedContacts(ab.c(deleteContactFromLocalWithLimit));
            if (!this.this$0.getDeletedContacts().isEmpty()) {
                ContactUtil.INSTANCE.sendMetaInfo$contacts_sdk_release(SyncStage.REMOTE_SYNC, this.this$0.getProgressPercent(), this.this$0.getTotalSyncContacts());
                this.this$0.updateDeletedContacts();
                return;
            }
            DeleteSyncWorker deleteSyncWorker2 = this.this$0;
            ListenableWorker.a.c cVar = new ListenableWorker.a.c();
            k.a((Object) cVar, "Result.success()");
            deleteSyncWorker2.workResult = cVar;
            DeleteSyncWorker.access$getLatch$p(this.this$0).countDown();
            return;
        }
        throw new u("null cannot be cast to non-null type kotlin.collections.MutableList<kotlin.Int>");
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        q.b("onError statusCode :".concat(String.valueOf(i2)));
        this.this$0.workResult = ContactUtil.INSTANCE.getSyncWorkerErrorResult$contacts_sdk_release(this.this$0, Integer.valueOf(i2), networkCustomError);
        DeleteSyncWorker.access$getLatch$p(this.this$0).countDown();
    }
}
