package com.paytm.contactsSdk.network;

import com.paytm.contactsSdk.api.p002enum.HealthActionType;
import com.paytm.contactsSdk.models.responses.HealthResponse;
import com.paytm.contactsSdk.models.responses.Response;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import kotlin.u;

public final class HealthMonitorManager$getAPIListener$1 implements b {
    HealthMonitorManager$getAPIListener$1() {
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel != null) {
            HealthResponse healthResponse = (HealthResponse) iJRPaytmDataModel;
            Response response = healthResponse.getResponse();
            if ((response != null ? response.getContactDetail() : null) != null) {
                HealthActionType action = HealthActionType.Companion.getAction(healthResponse.getResponse().getContactDetail().getAction());
                String unused = HealthMonitorManager.TAG;
                q.b("Action ".concat(String.valueOf(action)));
                return;
            }
            return;
        }
        throw new u("null cannot be cast to non-null type com.paytm.contactsSdk.models.responses.HealthResponse");
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        String unused = HealthMonitorManager.TAG;
        StringBuilder sb = new StringBuilder("Error ");
        sb.append(networkCustomError != null ? networkCustomError.getAlertMessage() : null);
        q.b(sb.toString());
    }
}
