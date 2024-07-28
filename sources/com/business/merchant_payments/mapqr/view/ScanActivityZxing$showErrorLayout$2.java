package com.business.merchant_payments.mapqr.view;

import android.view.View;
import android.widget.RelativeLayout;
import com.business.merchant_payments.R;

public final class ScanActivityZxing$showErrorLayout$2 implements View.OnClickListener {
    public final /* synthetic */ ScanActivityZxing this$0;

    public ScanActivityZxing$showErrorLayout$2(ScanActivityZxing scanActivityZxing) {
        this.this$0 = scanActivityZxing;
    }

    public final void onClick(View view) {
        RelativeLayout relativeLayout = (RelativeLayout) this.this$0._$_findCachedViewById(R.id.rlErrorLayout);
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
    }
}
