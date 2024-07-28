package com.business.merchant_payments.mapqr.view;

import android.view.View;
import com.business.merchant_payments.PaymentsConfig;
import kotlin.g.b.k;

public final class PostVerifyQRActivity$setListeners$4 implements View.OnClickListener {
    public final /* synthetic */ PostVerifyQRActivity this$0;

    public PostVerifyQRActivity$setListeners$4(PostVerifyQRActivity postVerifyQRActivity) {
        this.this$0 = postVerifyQRActivity;
    }

    public final void onClick(View view) {
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        instance.getEventPublisher().b(this.this$0, "verify_qr_post_scan_page", "print_paytm_all_in_one_qr_clicked", "", "");
        PaymentsConfig instance2 = PaymentsConfig.getInstance();
        k.b(instance2, "PaymentsConfig.getInstance()");
        instance2.getDeepLinkUtils().a(this.this$0, "paytmba://business-app/business-app/h/accept-payments/download-qr");
    }
}
