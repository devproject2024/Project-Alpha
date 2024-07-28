package com.paytmmoney.lite.mod;

import android.view.KeyEvent;
import android.view.View;
import com.business.merchant_payments.common.utility.AppConstants;
import kotlin.g.b.k;

public final class PaymentWebview$initWebViewSetup$2 implements View.OnKeyListener {
    PaymentWebview$initWebViewSetup$2() {
    }

    public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
        k.c(view, "v");
        k.c(keyEvent, AppConstants.NOTIFICATION_DETAILS.EVENT);
        if (keyEvent.getAction() != 0 || i2 == 66) {
        }
        return false;
    }
}
