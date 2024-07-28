package com.business.merchant_payments.mapqr.view;

import android.view.View;
import com.business.merchant_payments.PaymentsConfig;
import kotlin.g.b.k;

public final class PostVerifyQRActivity$setListeners$5 implements View.OnClickListener {
    public final /* synthetic */ PostVerifyQRActivity this$0;

    public PostVerifyQRActivity$setListeners$5(PostVerifyQRActivity postVerifyQRActivity) {
        this.this$0 = postVerifyQRActivity;
    }

    public final void onClick(View view) {
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        instance.getDeepLinkUtils().a(this.this$0, "paytmba://business-app/h/my-account/manage-qr/order-qr");
        this.this$0.finish();
    }
}
