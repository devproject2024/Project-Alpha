package com.paytm.contactsSdk.api.view.activity;

import androidx.lifecycle.z;
import kotlin.g.b.k;

final class ContactSDKActivity$registerObserver$1<T> implements z<Boolean> {
    final /* synthetic */ ContactSDKActivity this$0;

    ContactSDKActivity$registerObserver$1(ContactSDKActivity contactSDKActivity) {
        this.this$0 = contactSDKActivity;
    }

    public final void onChanged(Boolean bool) {
        k.a((Object) bool, "it");
        if (bool.booleanValue()) {
            this.this$0.getSyncContactsVM().checkIfContactsSDKRemoteSyncEnabled();
        }
    }
}
