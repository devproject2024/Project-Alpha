package net.one97.paytm.acceptPayment.e;

import android.text.TextUtils;
import com.business.a.a;
import com.business.merchant_payments.common.utility.AppConstants;
import java.util.HashMap;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public final class f implements a.b {

    /* renamed from: a  reason: collision with root package name */
    private final String f52057a;

    public f(String str) {
        this.f52057a = str;
    }

    public final void a(HashMap<String, String> hashMap) {
        try {
            com.business.common_module.c.a aVar = new com.business.common_module.c.a();
            if (hashMap.containsKey("responseSize")) {
                aVar.f7333g = Long.parseLong(hashMap.get("responseSize"));
            }
            if (hashMap.containsKey("uri")) {
                aVar.f7329c = hashMap.get("uri");
            }
            if (hashMap.containsKey("requestSize")) {
                aVar.f7330d = Long.parseLong(hashMap.get("requestSize"));
            }
            if (hashMap.containsKey("errorMsg")) {
                aVar.f7335i = hashMap.get("errorMsg");
            }
            if (hashMap.containsKey("responseTime")) {
                aVar.f7332f = Long.parseLong(hashMap.get("responseTime"));
            }
            if (hashMap.containsKey("responseCode")) {
                aVar.f7331e = Integer.parseInt(hashMap.get("responseCode"));
            }
            if (hashMap.containsKey("screen_name")) {
                aVar.f7328b = hashMap.get("screen_name");
            }
            if (hashMap.containsKey(CLConstants.FIELD_ERROR_CODE)) {
                aVar.f7334h = Integer.parseInt(hashMap.get(CLConstants.FIELD_ERROR_CODE));
            }
            if (hashMap.containsKey("customMessage")) {
                aVar.d(hashMap.get("customMessage"));
            }
            if (hashMap.containsKey("verticalName")) {
                aVar.f7327a = hashMap.get("verticalName");
            } else {
                aVar.f7327a = this.f52057a;
            }
            if (hashMap.containsKey(AppConstants.X_APP_RID)) {
                aVar.j = hashMap.get(AppConstants.X_APP_RID);
            }
        } catch (Exception e2) {
            com.business.common_module.c.a aVar2 = new com.business.common_module.c.a();
            aVar2.f7327a = this.f52057a;
            aVar2.d(e2.toString());
        }
    }

    public final String a() {
        String str = com.business.common_module.c.a.a.f7336a;
        String str2 = com.business.common_module.c.a.a.f7337b;
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        return str + com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.COLON + str2;
    }
}
