package net.one97.paytm.paymentsBank.e;

import android.content.Context;
import android.text.TextUtils;
import com.paytm.utility.b;
import com.paytmmall.clpartifact.utils.GAUtil;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.bankCommon.mapping.c;
import net.one97.paytm.payments.b.b.a;

public final class a {
    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.equalsIgnoreCase(a.b.DEVICE_BINDING_PASSBOOK.name())) {
            return "passbook";
        }
        if (str.equalsIgnoreCase(a.b.DEVICE_BINDING_WALLET.name())) {
            return "wallet";
        }
        return "";
    }

    private static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.equalsIgnoreCase(a.b.DEVICE_BINDING_PASSBOOK.name())) {
            return "passbook passcode ";
        }
        if (str.equalsIgnoreCase(a.b.DEVICE_BINDING_WALLET.name())) {
            return "wallet passcode";
        }
        return "";
    }

    private static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.equalsIgnoreCase(a.b.DEVICE_BINDING_PASSBOOK.name())) {
            return "pb_pc_ppbl";
        }
        if (str.equalsIgnoreCase(a.b.DEVICE_BINDING_WALLET.name())) {
            return "wa_pc_ppbl";
        }
        return "";
    }

    private static void a(Context context, String str, String str2, String str3, String str4) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_category", str);
        hashMap.put("event_action", str2);
        hashMap.put("event_label", str3);
        hashMap.put("user_id", b.n(context));
        hashMap.put("device_id", b.A(context));
        hashMap.put("client_id", b.k());
        hashMap.put("screen_name", str4);
        hashMap.put("vertical_name", "ppbl");
        c.a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, context);
    }

    public static void a(Context context, String str, String str2) {
        String str3;
        String a2 = a(str);
        String b2 = b(str);
        String c2 = c(str);
        if (!TextUtils.isEmpty(a2)) {
            if (a2.equalsIgnoreCase("wallet")) {
                str3 = "wa_".concat(String.valueOf(str2));
            } else {
                str3 = a2.equalsIgnoreCase("passbook") ? "pb_".concat(String.valueOf(str2)) : "";
            }
            if (!TextUtils.isEmpty(str3)) {
                a(context, c2, str3, a2, b2);
            }
        }
    }
}
