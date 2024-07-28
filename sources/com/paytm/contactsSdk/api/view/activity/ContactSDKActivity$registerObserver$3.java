package com.paytm.contactsSdk.api.view.activity;

import androidx.lifecycle.z;

final class ContactSDKActivity$registerObserver$3<T> implements z<Boolean> {
    final /* synthetic */ ContactSDKActivity this$0;

    ContactSDKActivity$registerObserver$3(ContactSDKActivity contactSDKActivity) {
        this.this$0 = contactSDKActivity;
    }

    public final void onChanged(Boolean bool) {
        if (!bool.booleanValue()) {
            ContactSDKActivity contactSDKActivity = this.this$0;
            contactSDKActivity.showConsentUI(contactSDKActivity.contactSDKAllowClickListener, this.this$0.contactSDKSkipClickListener);
            return;
        }
        this.this$0.permissionCheck();
    }
}
