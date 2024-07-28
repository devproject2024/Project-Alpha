package com.business.merchant_payments.common.view;

import android.view.View;
import com.business.merchant_payments.common.utility.AppConstants;

public final class ReportDownloadBottomSheet$initUI$2 implements View.OnClickListener {
    public final /* synthetic */ ReportDownloadBottomSheet this$0;

    public ReportDownloadBottomSheet$initUI$2(ReportDownloadBottomSheet reportDownloadBottomSheet) {
        this.this$0 = reportDownloadBottomSheet;
    }

    public final void onClick(View view) {
        this.this$0.currSelection = AppConstants.YESTERDAY;
        this.this$0.updateSelection();
    }
}
