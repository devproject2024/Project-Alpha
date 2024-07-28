package net.one97.paytm.nativesdk.paymethods.views.fragments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.MerchantBL;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.common.model.PaymentModes;

public final class BaseInstrumentSheet$broadcastReceiver$1 extends BroadcastReceiver {
    final /* synthetic */ BaseInstrumentSheet this$0;

    BaseInstrumentSheet$broadcastReceiver$1(BaseInstrumentSheet baseInstrumentSheet) {
        this.this$0 = baseInstrumentSheet;
    }

    public final void onReceive(Context context, Intent intent) {
        k.c(context, "context");
        k.c(intent, "intent");
        String action = intent.getAction();
        if (action == null) {
            k.a();
        }
        if (p.a(SDKConstants.EMI_REFRESH_FILTER, action, true) && this.this$0.getCodPayMode() != null) {
            BaseInstrumentSheet baseInstrumentSheet = this.this$0;
            PaymentModes codPayMode = baseInstrumentSheet.getCodPayMode();
            if (codPayMode == null) {
                k.a();
            }
            baseInstrumentSheet.toggleCODView(codPayMode);
        }
        String action2 = intent.getAction();
        if (action2 == null) {
            k.a();
        }
        if (p.a(SDKConstants.TOOLBAR_AMOUNT_REFRESH, action2, true)) {
            BaseInstrumentSheet baseInstrumentSheet2 = this.this$0;
            MerchantBL merchantInstance = MerchantBL.getMerchantInstance();
            k.a((Object) merchantInstance, "MerchantBL.getMerchantInstance()");
            baseInstrumentSheet2.updateTotalAmount(SDKUtility.priceWithoutDecimal(merchantInstance.getWithoutDoubleAmount()));
        }
    }
}
