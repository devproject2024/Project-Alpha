package com.paytm.contactsSdk.api.view.activity;

import android.view.View;

final class ContactSDKActivity$contactSDKAllowClickListener$1 implements View.OnClickListener {
    final /* synthetic */ ContactSDKActivity this$0;

    ContactSDKActivity$contactSDKAllowClickListener$1(ContactSDKActivity contactSDKActivity) {
        this.this$0 = contactSDKActivity;
    }

    public final void onClick(View view) {
        this.this$0.getSyncContactsVM().updateConsent();
    }
}
