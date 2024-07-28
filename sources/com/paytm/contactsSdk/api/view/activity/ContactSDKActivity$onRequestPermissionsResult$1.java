package com.paytm.contactsSdk.api.view.activity;

import android.content.Context;
import android.content.DialogInterface;
import com.paytm.utility.s;

final class ContactSDKActivity$onRequestPermissionsResult$1 implements DialogInterface.OnClickListener {
    final /* synthetic */ ContactSDKActivity this$0;

    ContactSDKActivity$onRequestPermissionsResult$1(ContactSDKActivity contactSDKActivity) {
        this.this$0 = contactSDKActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        dialogInterface.cancel();
        s.b((Context) this.this$0);
    }
}
