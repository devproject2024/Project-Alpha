package net.one97.paytm.paymentsBank.utils;

import android.content.Context;
import android.text.TextUtils;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytm.utility.b;
import com.paytmmall.clpartifact.utils.GAUtil;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.bankCommon.mapping.c;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class m {
    public static final void a(Context context, String str, String str2, String str3, String str4, String str5) {
        k.c(str, "action");
        k.c(str2, SDKConstants.EVENT_KEY_SCREEN_NAME);
        k.c(str3, "label");
        k.c(str4, "label2");
        k.c(str5, "label3");
        if (context != null) {
            try {
                HashMap hashMap = new HashMap();
                String n = b.n(context);
                if (!TextUtils.isEmpty(n)) {
                    k.a((Object) n, "userId");
                    hashMap.put("user_id", n);
                }
                if (context.getSystemService(ContactColumn.PHONE_NUMBER) != null) {
                    String e2 = b.e(context);
                    k.a((Object) e2, "CJRAppCommonUtility.getD…text, inTelephonyManager)");
                    hashMap.put("device_id", e2);
                    hashMap.put("client_id", "ANDROID");
                    hashMap.put("event_category", "passcode_ppbl");
                    hashMap.put("event_action", str);
                    hashMap.put("event_label", str3);
                    hashMap.put("event_label2", str4);
                    hashMap.put("event_label3", str5);
                    hashMap.put("screen_name", str2);
                    hashMap.put("vertical_name", "ppbl");
                    c.a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, context);
                    return;
                }
                throw new u("null cannot be cast to non-null type android.telephony.TelephonyManager");
            } catch (Exception unused) {
            }
        }
    }
}
