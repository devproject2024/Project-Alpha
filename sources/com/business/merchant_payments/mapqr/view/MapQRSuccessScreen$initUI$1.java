package com.business.merchant_payments.mapqr.view;

import android.view.View;

public final class MapQRSuccessScreen$initUI$1 implements View.OnClickListener {
    public final /* synthetic */ MapQRSuccessScreen this$0;

    public MapQRSuccessScreen$initUI$1(MapQRSuccessScreen mapQRSuccessScreen) {
        this.this$0 = mapQRSuccessScreen;
    }

    public final void onClick(View view) {
        this.this$0.shareQrImage();
    }
}
