package com.paytm.contactsSdk.api.viewModel;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.a.ae;
import kotlin.g.b.k;
import net.one97.paytm.ups.listener.UpdateConsentListener;

public final class ContactSyncViewModel$updateConsent$1 implements UpdateConsentListener {
    final /* synthetic */ ContactSyncViewModel this$0;

    ContactSyncViewModel$updateConsent$1(ContactSyncViewModel contactSyncViewModel) {
        this.this$0 = contactSyncViewModel;
    }

    public final void onConsentUpdated(boolean z, String str, boolean z2) {
        k.c(str, "consent");
        if (z) {
            this.this$0.getConsentUpdateLiveData().postValue(ae.a());
            return;
        }
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(str, Boolean.valueOf(z2));
        this.this$0.getConsentUpdateLiveData().postValue(linkedHashMap);
    }
}
