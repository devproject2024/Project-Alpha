package net.one97.paytm.hotels2.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import net.one97.paytm.AJRRechargePaymentActivity;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.recharge.common.utils.ab;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.utils.ac;
import net.one97.paytm.utils.ba;

public final class a {

    /* renamed from: net.one97.paytm.hotels2.utils.a$a  reason: collision with other inner class name */
    public interface C0913a {
        void onEnd();

        void onError();

        void onStart();
    }

    public static void a(Context context) {
        CJRHomePageItem a2 = ac.a(context, "paytmmp://hotel-booking");
        Intent a3 = ba.a(context);
        a3.putExtra("extra_home_data", a2);
        a3.putExtra("origin", "deeplinking");
        context.startActivity(a3);
    }

    public static void a(Activity activity, CJRRechargePayment cJRRechargePayment) {
        Intent intent = new Intent(activity, AJRRechargePaymentActivity.class);
        intent.putExtra(SDKConstants.PAYMENT_INFO, cJRRechargePayment);
        intent.putExtra(UpiConstants.FROM, "Paytm Hotel");
        ab.a(cJRRechargePayment, intent);
        activity.startActivityForResult(intent, 104);
    }
}
