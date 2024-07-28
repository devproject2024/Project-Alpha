package com.business.merchant_payments.common.view;

import android.view.View;
import com.business.merchant_payments.common.utility.AppConstants;

public final class ReportDownloadBottomSheet$initUI$4 implements View.OnClickListener {
    public final /* synthetic */ ReportDownloadBottomSheet this$0;

    public ReportDownloadBottomSheet$initUI$4(ReportDownloadBottomSheet reportDownloadBottomSheet) {
        this.this$0 = reportDownloadBottomSheet;
    }

    public final void onClick(View view) {
        this.this$0.currSelection = AppConstants.CURRENT_SELECTION;
        this.this$0.updateSelection();
    }
}
