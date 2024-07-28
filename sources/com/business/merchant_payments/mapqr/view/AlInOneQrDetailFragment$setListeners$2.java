package com.business.merchant_payments.mapqr.view;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.business.merchant_payments.PaymentsConfig;
import kotlin.g.b.k;

public final class AlInOneQrDetailFragment$setListeners$2 implements View.OnClickListener {
    public final /* synthetic */ AlInOneQrDetailFragment this$0;

    public AlInOneQrDetailFragment$setListeners$2(AlInOneQrDetailFragment alInOneQrDetailFragment) {
        this.this$0 = alInOneQrDetailFragment;
    }

    public final void onClick(View view) {
        if (this.this$0.mContext != null) {
            PaymentsConfig instance = PaymentsConfig.getInstance();
            k.b(instance, "PaymentsConfig.getInstance()");
            instance.getDeepLinkUtils().a(this.this$0.mContext, "paytmba://business-app/h/my-account/manage-qr/order-qr");
        }
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }
}
