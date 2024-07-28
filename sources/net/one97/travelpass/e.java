package net.one97.travelpass;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.paytm.network.listener.b;
import java.util.Map;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.nativesdk.Utils.FetchPayOptionsListener;

public interface e {
    String a();

    String a(Context context);

    String a(String str);

    String a(CJRPGTokenList cJRPGTokenList);

    void a(Activity activity, b bVar);

    void a(Activity activity, Exception exc);

    void a(Context context, Intent intent);

    void a(Context context, Intent intent, int i2);

    void a(Context context, Bundle bundle);

    void a(Context context, CJRRechargePayment cJRRechargePayment, FetchPayOptionsListener fetchPayOptionsListener);

    void a(String str, String str2, String str3, String str4, Map<String, Object> map);

    void a(String str, Map<String, Object> map, Context context);

    boolean a(Context context, String str);

    String b(String str);

    boolean b(Context context);

    String c(String str);

    String d(String str);

    String e(String str);
}
