package net.one97.paytm.nativesdk.transcation;

import android.app.Activity;
import com.android.volley.VolleyError;
import com.google.gson.f;
import net.one97.paytm.nativesdk.paymethods.datasource.PaymentMethodDataSource;
import net.one97.paytm.nativesdk.transcation.model.Body;
import net.one97.paytm.nativesdk.transcation.model.OtpApiResponse;

public final class NativePlusPayActivity$postDataOnCallBack$1 implements PaymentMethodDataSource.Callback<Object> {
    final /* synthetic */ OtpApiResponse $otpApiResponse;
    final /* synthetic */ NativePlusPayActivity this$0;

    NativePlusPayActivity$postDataOnCallBack$1(NativePlusPayActivity nativePlusPayActivity, OtpApiResponse otpApiResponse) {
        this.this$0 = nativePlusPayActivity;
        this.$otpApiResponse = otpApiResponse;
    }

    public final void onErrorResponse(VolleyError volleyError, Object obj) {
        Activity activity = this.this$0;
        f fVar = new f();
        Body body = this.$otpApiResponse.getBody();
        PayUtility.finishSdk(activity, fVar.b(body != null ? body.getTxnInfo() : null));
    }

    public final void onResponse(Object obj) {
        Activity activity = this.this$0;
        f fVar = new f();
        Body body = this.$otpApiResponse.getBody();
        PayUtility.finishSdk(activity, fVar.b(body != null ? body.getTxnInfo() : null));
    }
}
