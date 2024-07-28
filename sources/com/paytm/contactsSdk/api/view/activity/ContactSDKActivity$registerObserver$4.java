package com.paytm.contactsSdk.api.view.activity;

import androidx.lifecycle.z;
import com.paytm.contactsSdk.api.view.dialog.ConsentDialog;
import java.util.Map;

final class ContactSDKActivity$registerObserver$4<T> implements z<Map<String, ? extends Boolean>> {
    final /* synthetic */ ContactSDKActivity this$0;

    ContactSDKActivity$registerObserver$4(ContactSDKActivity contactSDKActivity) {
        this.this$0 = contactSDKActivity;
    }

    public final void onChanged(Map<String, Boolean> map) {
        map.isEmpty();
        ConsentDialog access$getConsentDialog$p = this.this$0.consentDialog;
        if (access$getConsentDialog$p != null) {
            access$getConsentDialog$p.dismiss();
        }
        this.this$0.permissionCheck();
    }
}
