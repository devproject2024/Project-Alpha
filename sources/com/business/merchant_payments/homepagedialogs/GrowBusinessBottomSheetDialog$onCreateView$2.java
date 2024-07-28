package com.business.merchant_payments.homepagedialogs;

import android.view.View;
import com.business.merchant_payments.PaymentsConfig;
import kotlin.g.b.k;

public final class GrowBusinessBottomSheetDialog$onCreateView$2 implements View.OnClickListener {
    public final /* synthetic */ GrowBusinessBottomSheetDialog this$0;

    public GrowBusinessBottomSheetDialog$onCreateView$2(GrowBusinessBottomSheetDialog growBusinessBottomSheetDialog) {
        this.this$0 = growBusinessBottomSheetDialog;
    }

    public final void onClick(View view) {
        if (this.this$0.getActivity() != null) {
            PaymentsConfig instance = PaymentsConfig.getInstance();
            k.b(instance, "PaymentsConfig.getInstance()");
            instance.getEventPublisher().a(this.this$0.getActivity(), "accept_payments_home", "Order QR Dialog Do It Later Clicked", "", "");
        }
        this.this$0.dismiss();
    }
}
