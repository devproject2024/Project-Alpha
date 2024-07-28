package com.business.merchant_payments.newhome;

import android.view.View;

public final class SelectDateBottomSheet$initOnClicks$7 implements View.OnClickListener {
    public final /* synthetic */ SelectDateBottomSheet this$0;

    public SelectDateBottomSheet$initOnClicks$7(SelectDateBottomSheet selectDateBottomSheet) {
        this.this$0 = selectDateBottomSheet;
    }

    public final void onClick(View view) {
        this.this$0.downloadReportForCurrentSelection();
        this.this$0.dismissAllowingStateLoss();
    }
}
