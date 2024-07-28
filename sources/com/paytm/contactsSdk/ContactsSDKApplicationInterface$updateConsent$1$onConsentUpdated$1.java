package com.paytm.contactsSdk;

import android.widget.Toast;

final class ContactsSDKApplicationInterface$updateConsent$1$onConsentUpdated$1 implements Runnable {
    final /* synthetic */ boolean $hasErrors;
    final /* synthetic */ ContactsSDKApplicationInterface$updateConsent$1 this$0;

    ContactsSDKApplicationInterface$updateConsent$1$onConsentUpdated$1(ContactsSDKApplicationInterface$updateConsent$1 contactsSDKApplicationInterface$updateConsent$1, boolean z) {
        this.this$0 = contactsSDKApplicationInterface$updateConsent$1;
        this.$hasErrors = z;
    }

    public final void run() {
        if (this.$hasErrors) {
            Toast.makeText(this.this$0.this$0.getApplicationContext(), "Consent updating failed, try manually granting consent.", 1).show();
        } else {
            Toast.makeText(this.this$0.this$0.getApplicationContext(), "Consent updated", 1).show();
        }
    }
}
