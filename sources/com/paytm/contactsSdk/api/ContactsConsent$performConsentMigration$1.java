package com.paytm.contactsSdk.api;

import com.paytm.contactsSdk.ContactsSDKApplicationInterface;
import com.paytm.utility.q;
import kotlin.g.b.k;
import net.one97.paytm.ups.listener.UpdateConsentListener;

public final class ContactsConsent$performConsentMigration$1 implements UpdateConsentListener {
    final /* synthetic */ ContactsSDKApplicationInterface $contactImpl;

    ContactsConsent$performConsentMigration$1(ContactsSDKApplicationInterface contactsSDKApplicationInterface) {
        this.$contactImpl = contactsSDKApplicationInterface;
    }

    public final void onConsentUpdated(boolean z, String str, boolean z2) {
        k.c(str, "consent");
        if (!z) {
            q.d("UPDATED in UPS " + System.currentTimeMillis());
            this.$contactImpl.removeConsentStatusFromSmsSdk();
            q.d("REMOVED from SMS SDK " + System.currentTimeMillis());
        }
        ContactsConsent.isMigrationInProgress = false;
    }
}
