package com.paytm.contactsSdk.network;

import android.content.Context;
import com.paytm.contactsSdk.constant.ContactsConstant;
import com.paytm.contactsSdk.models.requests.HealthContactDetailReq;
import com.paytm.contactsSdk.models.requests.HealthRequest;
import com.paytm.network.a;
import com.paytm.utility.b;
import kotlin.g.b.k;

public final class HealthMonitorManager {
    public static final HealthMonitorManager INSTANCE = new HealthMonitorManager();
    /* access modifiers changed from: private */
    public static final String TAG;

    static {
        String simpleName = HealthMonitorManager.class.getSimpleName();
        k.a((Object) simpleName, "HealthMonitorManager::class.java.simpleName");
        TAG = simpleName;
    }

    private HealthMonitorManager() {
    }

    public final void checkHealth(Context context) {
        k.c(context, "context");
        a healthAPINetworkCall = NetworkRequestHelper.INSTANCE.healthAPINetworkCall(context, getHealthAPIRequest(context), getAPIListener());
        if (healthAPINetworkCall != null) {
            healthAPINetworkCall.a();
        }
    }

    private final HealthRequest getHealthAPIRequest(Context context) {
        String A = b.A(context);
        HealthContactDetailReq healthContactDetailReq = new HealthContactDetailReq(ContactsConstant.CONTACT_TYPE_VALUE, 0, 0, ContactEnrichmentManager.INSTANCE.getLastEnrichmentDataSyncedTimeStamp(context));
        k.a((Object) A, "deviceID");
        return new HealthRequest(A, healthContactDetailReq);
    }

    private final com.paytm.network.listener.b getAPIListener() {
        return new HealthMonitorManager$getAPIListener$1();
    }
}
