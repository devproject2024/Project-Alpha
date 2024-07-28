package com.business.merchant_payments.mapqr.view;

import android.view.View;
import com.business.merchant_payments.gtm.GAGTMTagAnalytics;

public final class ScanActivityZxing$initUI$3 implements View.OnClickListener {
    public final /* synthetic */ ScanActivityZxing this$0;

    public ScanActivityZxing$initUI$3(ScanActivityZxing scanActivityZxing) {
        this.this$0 = scanActivityZxing;
    }

    public final void onClick(View view) {
        this.this$0.onBackPressed();
        GAGTMTagAnalytics.getSingleInstance().sendEvent(this.this$0, "verify_qr_scan_and_verify_popup", "later", "", "");
    }
}
