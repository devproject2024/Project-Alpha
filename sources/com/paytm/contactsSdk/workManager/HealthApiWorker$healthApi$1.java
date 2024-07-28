package com.paytm.contactsSdk.workManager;

import android.content.Context;
import androidx.work.ListenableWorker;
import com.paytm.contactsSdk.api.ContactsProvider;
import com.paytm.contactsSdk.api.p002enum.HealthActionType;
import com.paytm.contactsSdk.models.responses.HealthResponse;
import com.paytm.contactsSdk.models.responses.Response;
import com.paytm.contactsSdk.repo.ContactsRepo;
import com.paytm.contactsSdk.utils.ContactUtil;
import com.paytm.contactsSdk.workManager.HealthApiWorker;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import java.util.Calendar;
import kotlin.g.b.k;
import kotlin.u;

public final class HealthApiWorker$healthApi$1 implements b {
    final /* synthetic */ HealthApiWorker this$0;

    HealthApiWorker$healthApi$1(HealthApiWorker healthApiWorker) {
        this.this$0 = healthApiWorker;
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        q.b("onApiSuccess===");
        if (iJRPaytmDataModel != null) {
            HealthResponse healthResponse = (HealthResponse) iJRPaytmDataModel;
            Response response = healthResponse.getResponse();
            if ((response != null ? response.getContactDetail() : null) != null) {
                ContactUtil contactUtil = ContactUtil.INSTANCE;
                Context access$getContext$p = this.this$0.context;
                Calendar instance = Calendar.getInstance();
                k.a((Object) instance, "Calendar.getInstance()");
                contactUtil.saveHealthApiTimestamp$contacts_sdk_release(access$getContext$p, instance.getTimeInMillis());
                HealthActionType action = HealthActionType.Companion.getAction(healthResponse.getResponse().getContactDetail().getAction());
                q.b("Action ".concat(String.valueOf(action)));
                if (action != null) {
                    int i2 = HealthApiWorker.WhenMappings.$EnumSwitchMapping$0[action.ordinal()];
                    if (i2 == 1) {
                        ContactsProvider.INSTANCE.syncContacts$contacts_sdk_release();
                    } else if (i2 == 2) {
                        ContactUtil.INSTANCE.resetAllTimestamps$contacts_sdk_release(this.this$0.context);
                        ServerSyncManager.INSTANCE.stopAllOneTimeWorkManagers(this.this$0.context);
                        new ContactsRepo().deleteAllDataFormAllTables();
                        ContactsProvider.INSTANCE.clearDynamicMappingHashMap$contacts_sdk_release();
                        ContactsProvider.INSTANCE.syncContacts$contacts_sdk_release();
                    }
                }
                HealthApiWorker healthApiWorker = this.this$0;
                ListenableWorker.a.c cVar = new ListenableWorker.a.c();
                k.a((Object) cVar, "Result.success()");
                healthApiWorker.workResult = cVar;
                HealthApiWorker.access$getLatch$p(this.this$0).countDown();
                return;
            }
            this.this$0.workResult = ContactUtil.getSyncWorkerErrorResult$contacts_sdk_release$default(ContactUtil.INSTANCE, this.this$0, (Integer) null, (NetworkCustomError) null, 6, (Object) null);
            HealthApiWorker.access$getLatch$p(this.this$0).countDown();
            return;
        }
        throw new u("null cannot be cast to non-null type com.paytm.contactsSdk.models.responses.HealthResponse");
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        q.b("onError statusCode: ".concat(String.valueOf(i2)));
        this.this$0.workResult = ContactUtil.INSTANCE.getSyncWorkerErrorResult$contacts_sdk_release(this.this$0, Integer.valueOf(i2), networkCustomError);
        HealthApiWorker.access$getLatch$p(this.this$0).countDown();
    }
}
