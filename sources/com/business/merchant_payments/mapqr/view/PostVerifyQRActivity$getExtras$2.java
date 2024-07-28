package com.business.merchant_payments.mapqr.view;

import android.view.View;
import com.business.merchant_payments.PaymentsConfig;
import kotlin.g.b.k;

public final class PostVerifyQRActivity$getExtras$2 implements View.OnClickListener {
    public final /* synthetic */ PostVerifyQRActivity this$0;

    public PostVerifyQRActivity$getExtras$2(PostVerifyQRActivity postVerifyQRActivity) {
        this.this$0 = postVerifyQRActivity;
    }

    public final void onClick(View view) {
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        instance.getDeepLinkUtils().a(this.this$0, "paytmba://business-app");
        PaymentsConfig instance2 = PaymentsConfig.getInstance();
        k.b(instance2, "PaymentsConfig.getInstance()");
        instance2.getEventPublisher().b(this.this$0, "verify_qr_post_scan_page", "back_to_homescreen_clicked", "", "");
    }
}
