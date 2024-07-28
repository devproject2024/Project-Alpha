package com.paytm.contactsSdk;

import androidx.arch.core.a.a;
import kotlin.g.b.k;
import net.one97.paytm.ups.listener.UpdateConsentListener;

public final class ContactsSDKApplicationInterface$updateConsent$1 implements UpdateConsentListener {
    final /* synthetic */ ContactsSDKApplicationInterface this$0;

    ContactsSDKApplicationInterface$updateConsent$1(ContactsSDKApplicationInterface contactsSDKApplicationInterface) {
        this.this$0 = contactsSDKApplicationInterface;
    }

    public final void onConsentUpdated(boolean z, String str, boolean z2) {
        k.c(str, "consent");
        a.b().execute(new ContactsSDKApplicationInterface$updateConsent$1$onConsentUpdated$1(this, z));
    }
}
