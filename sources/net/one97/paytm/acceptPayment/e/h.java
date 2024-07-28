package net.one97.paytm.acceptPayment.e;

import android.os.Build;
import com.business.a.a;
import com.business.common_module.utilities.c;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.common.utility.AppUtility;
import com.paytm.utility.b;
import java.util.HashMap;

public final class h implements a.C0102a {
    public final HashMap<String, String> a() {
        try {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("app_version", AppUtility.getVersion(net.one97.paytm.acceptPayment.configs.a.f52046a.f52049d.a()));
            c.a aVar = c.f7365a;
            hashMap.put("device_identifier", c.a.b(net.one97.paytm.acceptPayment.configs.a.f52046a.f52049d.a()));
            hashMap.put("os_version", String.valueOf(Build.VERSION.SDK_INT));
            hashMap.put("client", AppUtility.getClient());
            hashMap.put("Accept-Language", b.a(net.one97.paytm.acceptPayment.configs.a.f52046a.f52049d.a()) + "-IN");
            hashMap.put(AppConstants.X_APP_RID, AppConstants.X_APP_RID);
            return hashMap;
        } catch (Exception unused) {
            return null;
        }
    }
}
