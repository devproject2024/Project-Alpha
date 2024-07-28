package com.business.merchant_payments.common.view;

import android.view.View;

public final class ReportDownloadBottomSheet$initUI$1 implements View.OnClickListener {
    public final /* synthetic */ ReportDownloadBottomSheet this$0;

    public ReportDownloadBottomSheet$initUI$1(ReportDownloadBottomSheet reportDownloadBottomSheet) {
        this.this$0 = reportDownloadBottomSheet;
    }

    public final void onClick(View view) {
        this.this$0.currSelection = "today";
        this.this$0.updateSelection();
    }
}
