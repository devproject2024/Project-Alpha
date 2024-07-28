package net.one97.paytm.nativesdk.transcation;

import android.app.AlertDialog;
import android.view.View;
import android.widget.TextView;
import com.alipay.iap.android.webapp.sdk.plugin.H5RpcPlugin;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.upi.common.upi.CommonPayParams;

public final class NativePlusPayActivity$onBackPressed$1 implements View.OnClickListener {
    final /* synthetic */ View $view;
    final /* synthetic */ NativePlusPayActivity this$0;

    NativePlusPayActivity$onBackPressed$1(NativePlusPayActivity nativePlusPayActivity, View view) {
        this.this$0 = nativePlusPayActivity;
        this.$view = view;
    }

    public final void onClick(View view) {
        k.c(view, "v");
        SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams("", SDKConstants.GA_DIRECT_OTP_ACTION, "cancel_otp", "init", SDKConstants.GA_NATIVE_PLUS, ""));
        if (!SDKUtility.isNetworkAvailable(this.this$0)) {
            SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams("", SDKConstants.GA_DIRECT_OTP_ACTION, "cancel_otp", H5RpcPlugin.RpcRequest.RpcParam.TIMEOUT, SDKConstants.GA_NATIVE_PLUS, ""));
            this.this$0.backPressCancelTransaction();
            return;
        }
        NativePlusPayActivity.access$getMViewModel$p(this.this$0).cancelTransaction();
        ((TextView) this.$view.findViewById(R.id.tv_no)).setOnClickListener((View.OnClickListener) null);
        SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams(SDKConstants.GA_KEY_CANCEL_PAYMENT, CommonPayParams.Builder.YES, ""));
        AlertDialog access$getMAlertDialog$p = this.this$0.mAlertDialog;
        if (access$getMAlertDialog$p != null) {
            access$getMAlertDialog$p.dismiss();
        }
        this.this$0.showProgressDialog(false);
    }
}
