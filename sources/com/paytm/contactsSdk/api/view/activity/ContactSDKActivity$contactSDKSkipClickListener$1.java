package com.paytm.contactsSdk.api.view.activity;

import android.view.View;
import com.paytm.contactsSdk.api.view.dialog.ConsentDialog;

final class ContactSDKActivity$contactSDKSkipClickListener$1 implements View.OnClickListener {
    final /* synthetic */ ContactSDKActivity this$0;

    ContactSDKActivity$contactSDKSkipClickListener$1(ContactSDKActivity contactSDKActivity) {
        this.this$0 = contactSDKActivity;
    }

    public final void onClick(View view) {
        ConsentDialog access$getConsentDialog$p = this.this$0.consentDialog;
        if (access$getConsentDialog$p != null) {
            access$getConsentDialog$p.dismiss();
        }
        this.this$0.permissionCheck();
    }
}
