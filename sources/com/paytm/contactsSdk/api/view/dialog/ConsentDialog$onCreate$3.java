package com.paytm.contactsSdk.api.view.dialog;

import android.content.Intent;
import android.net.Uri;
import android.view.View;

final class ConsentDialog$onCreate$3 implements View.OnClickListener {
    final /* synthetic */ ConsentDialog this$0;

    ConsentDialog$onCreate$3(ConsentDialog consentDialog) {
        this.this$0 = consentDialog;
    }

    public final void onClick(View view) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(this.this$0.consentMetaMetaInfo.getTnCLink()));
        this.this$0.getContext().startActivity(intent);
    }
}
