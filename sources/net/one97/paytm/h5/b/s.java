package net.one97.paytm.h5.b;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.paytm.utility.q;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.h5paytmsdk.c.aa;
import net.one97.paytm.upi.util.UpiConstants;

public final class s implements aa {
    public final boolean a(Activity activity, Bundle bundle) {
        k.c(activity, "activity");
        k.c(bundle, "bundle");
        Intent intent = new Intent();
        try {
            String string = bundle.getString("amount");
            if (string != null) {
                k.a((Object) string, "it");
                bundle.putDouble("nativeSdkForMerchantAmount", Double.parseDouble(string));
                intent.putExtra("price", string);
                bundle.remove("amount");
            }
            String string2 = bundle.getString("orderId");
            if (string2 != null) {
                bundle.remove("orderId");
                bundle.putString("orderid", string2);
                intent.putExtra("orderid", string2);
            }
            String string3 = bundle.getString("txnToken");
            if (string3 != null) {
                intent.putExtra("txnToken", string3);
            }
            String string4 = bundle.getString("mid");
            if (string4 != null) {
                intent.putExtra("mid", string4);
            }
            bundle.putBoolean("nativeSdkEnabled", true);
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
        intent.setComponent(new ComponentName("net.one97.paytm", "net.one97.paytm.AJRRechargePaymentActivity"));
        intent.putExtra("paymentmode", 2);
        intent.putExtra("bill", bundle);
        String string5 = bundle.getString("type", "");
        if (TextUtils.isEmpty(string5) || !p.a(string5, "standard", true)) {
            intent.putExtra("enable_paytm_invoke", true);
            intent.putExtra("paytm_invoke", true);
        } else {
            intent.putExtra(UpiConstants.FROM, "h5_onus_flow");
        }
        intent.putExtra("nativeSdkEnabled", true);
        intent.putExtra("isSessionTimeoutCallbackRequiredH5", true);
        activity.startActivityForResult(intent, 2112);
        return true;
    }
}
