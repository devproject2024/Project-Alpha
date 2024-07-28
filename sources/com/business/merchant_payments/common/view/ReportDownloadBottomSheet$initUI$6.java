package com.business.merchant_payments.common.view;

import android.view.View;

public final class ReportDownloadBottomSheet$initUI$6 implements View.OnClickListener {
    public final /* synthetic */ ReportDownloadBottomSheet this$0;

    public ReportDownloadBottomSheet$initUI$6(ReportDownloadBottomSheet reportDownloadBottomSheet) {
        this.this$0 = reportDownloadBottomSheet;
    }

    public final void onClick(View view) {
        this.this$0.downloadReportForCurrentSelection();
        this.this$0.dismiss();
    }
}
