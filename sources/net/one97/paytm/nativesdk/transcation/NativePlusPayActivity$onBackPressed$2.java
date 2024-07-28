package net.one97.paytm.nativesdk.transcation;

import android.app.AlertDialog;
import android.view.View;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.upi.common.upi.CommonPayParams;

public final class NativePlusPayActivity$onBackPressed$2 implements View.OnClickListener {
    final /* synthetic */ NativePlusPayActivity this$0;

    NativePlusPayActivity$onBackPressed$2(NativePlusPayActivity nativePlusPayActivity) {
        this.this$0 = nativePlusPayActivity;
    }

    public final void onClick(View view) {
        k.c(view, "v");
        AlertDialog access$getMAlertDialog$p = this.this$0.mAlertDialog;
        if (access$getMAlertDialog$p != null) {
            access$getMAlertDialog$p.dismiss();
        }
        SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams(SDKConstants.GA_KEY_CANCEL_PAYMENT, CommonPayParams.Builder.NO, ""));
    }
}
