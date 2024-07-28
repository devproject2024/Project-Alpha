package com.business.merchant_payments.common.view;

import android.view.View;
import com.business.merchant_payments.common.utility.AppConstants;

public final class ReportDownloadBottomSheet$initUI$5 implements View.OnClickListener {
    public final /* synthetic */ ReportDownloadBottomSheet this$0;

    public ReportDownloadBottomSheet$initUI$5(ReportDownloadBottomSheet reportDownloadBottomSheet) {
        this.this$0 = reportDownloadBottomSheet;
    }

    public final void onClick(View view) {
        this.this$0.currSelection = AppConstants.CUSTOM_DATE;
        this.this$0.updateSelection();
        this.this$0.mListener.onCustomDateClicked();
    }
}
