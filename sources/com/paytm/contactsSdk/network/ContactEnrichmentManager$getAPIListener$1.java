package com.paytm.contactsSdk.network;

import android.content.Context;
import com.paytm.contactsSdk.listener.EnrichmentDataSyncListener;
import com.paytm.contactsSdk.models.responses.Search.EnrichmentContactResponse;
import com.paytm.contactsSdk.models.responses.Search.SearchContactResponse;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import kotlin.u;

public final class ContactEnrichmentManager$getAPIListener$1 implements b {
    final /* synthetic */ Context $context;

    ContactEnrichmentManager$getAPIListener$1(Context context) {
        this.$context = context;
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        String unused = ContactEnrichmentManager.TAG;
        q.d("onApiSuccess");
        if (iJRPaytmDataModel != null) {
            EnrichmentContactResponse response = ((SearchContactResponse) iJRPaytmDataModel).getResponse();
            if (response != null) {
                ContactEnrichmentManager.INSTANCE.saveLastEnrichmentDataSyncedTimeStamp(this.$context, response.getTimeStamp());
                ContactEnrichmentManager.INSTANCE.saveEnrichmentDataToLocal(response.getContacts());
                if (!response.getLastPage()) {
                    ContactEnrichmentManager.INSTANCE.getEnrichmentData(this.$context);
                    return;
                }
                EnrichmentDataSyncListener access$getListener$p = ContactEnrichmentManager.listener;
                if (access$getListener$p != null) {
                    access$getListener$p.onComplete();
                    return;
                }
                return;
            }
            return;
        }
        throw new u("null cannot be cast to non-null type com.paytm.contactsSdk.models.responses.Search.SearchContactResponse");
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        String unused = ContactEnrichmentManager.TAG;
        q.b("OnError statusCode: ".concat(String.valueOf(i2)));
        EnrichmentDataSyncListener access$getListener$p = ContactEnrichmentManager.listener;
        if (access$getListener$p != null) {
            access$getListener$p.onError(i2, iJRPaytmDataModel, networkCustomError);
        }
    }
}
