package com.business.merchant_payments.mapqr.view;

import android.view.View;
import com.business.merchant_payments.PaymentsConfig;
import kotlin.g.b.k;

public final class MapQRSuccessScreen$initUI$2 implements View.OnClickListener {
    public final /* synthetic */ MapQRSuccessScreen this$0;

    public MapQRSuccessScreen$initUI$2(MapQRSuccessScreen mapQRSuccessScreen) {
        this.this$0 = mapQRSuccessScreen;
    }

    public final void onClick(View view) {
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        instance.getDeepLinkUtils().a(this.this$0, "paytmba://business-app");
    }
}
