package com.business.merchant_payments.mapqr.view;

import com.business.common_module.utilities.i;
import com.business.merchant_payments.R;
import com.business.merchant_payments.common.utility.APSharedPreferences;
import com.business.merchant_payments.mapqr.viewmodel.MapQRViewModel;
import com.google.zxing.r;

public final class ScanActivityZxing$handleDecode$1 implements Runnable {
    public final /* synthetic */ r $rawResult;
    public final /* synthetic */ ScanActivityZxing this$0;

    public ScanActivityZxing$handleDecode$1(ScanActivityZxing scanActivityZxing, r rVar) {
        this.this$0 = scanActivityZxing;
        this.$rawResult = rVar;
    }

    public final void run() {
        if (!i.a(this.this$0.getApplication())) {
            ScanActivityZxing scanActivityZxing = this.this$0;
            scanActivityZxing.showSnackBar(scanActivityZxing.getString(R.string.mp_network_reconnect_msg));
        }
        if (!this.this$0.isForVerifyQRFlow) {
            MapQRViewModel access$getMapQRViewModel$p = this.this$0.mapQRViewModel;
            if (access$getMapQRViewModel$p != null) {
                access$getMapQRViewModel$p.callMapQRApi(this.$rawResult.toString(), APSharedPreferences.getInstance().getCustomerId());
                return;
            }
            return;
        }
        String rVar = this.$rawResult.toString();
        if (rVar == null || rVar.length() == 0) {
            this.this$0.openPostVerifyFlow("not_scannable");
            return;
        }
        MapQRViewModel access$getMapQRViewModel$p2 = this.this$0.mapQRViewModel;
        if (access$getMapQRViewModel$p2 != null) {
            access$getMapQRViewModel$p2.triggerVerifyQRApi(this.$rawResult.toString());
        }
    }
}
