package com.paytm.business.merchantprofile.inactivemerchant;

import android.view.View;
import androidx.fragment.app.FragmentActivity;

public final class PaymentAcceptanceHoldBottomSheet$onCreateView$1 implements View.OnClickListener {
    public final /* synthetic */ PaymentAcceptanceHoldBottomSheet this$0;

    public PaymentAcceptanceHoldBottomSheet$onCreateView$1(PaymentAcceptanceHoldBottomSheet paymentAcceptanceHoldBottomSheet) {
        this.this$0 = paymentAcceptanceHoldBottomSheet;
    }

    public final void onClick(View view) {
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }
}
