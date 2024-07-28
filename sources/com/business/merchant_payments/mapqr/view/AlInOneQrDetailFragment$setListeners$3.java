package com.business.merchant_payments.mapqr.view;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.business.merchant_payments.gtm.GAGTMTagAnalytics;

public final class AlInOneQrDetailFragment$setListeners$3 implements View.OnClickListener {
    public final /* synthetic */ AlInOneQrDetailFragment this$0;

    public AlInOneQrDetailFragment$setListeners$3(AlInOneQrDetailFragment alInOneQrDetailFragment) {
        this.this$0 = alInOneQrDetailFragment;
    }

    public final void onClick(View view) {
        GAGTMTagAnalytics.getSingleInstance().sendEvent(this.this$0.getContext(), "verify_QR_QR_Shown", "Close button clicked", "", "");
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }
}
