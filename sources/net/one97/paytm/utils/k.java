package net.one97.paytm.utils;

import android.content.Context;
import com.paytm.utility.a;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.utils.GAUtil;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class k {
    public static void a(Context context, String str, String str2, String str3, String str4) {
        HashMap hashMap = new HashMap();
        hashMap.put("user_id", a.a(context));
        hashMap.put("vertical_name", "flights");
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, str);
        hashMap.put("event_category", str2);
        hashMap.put("event_action", str3);
        if (str4 != null) {
            hashMap.put("event_label", str4);
        }
        try {
            net.one97.paytm.j.a.b(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, context);
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5) {
        HashMap hashMap = new HashMap();
        hashMap.put("user_id", a.a(context));
        hashMap.put("vertical_name", "flights");
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, str);
        hashMap.put("event_category", str2);
        hashMap.put("event_action", str3);
        if (str4 != null) {
            hashMap.put("event_label", str4);
        }
        if (str5 != null) {
            hashMap.put("event_label2", str5);
        }
        try {
            net.one97.paytm.j.a.b(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, context);
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }
}
