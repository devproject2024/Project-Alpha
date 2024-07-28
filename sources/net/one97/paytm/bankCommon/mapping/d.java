package net.one97.paytm.bankCommon.mapping;

import android.content.Context;
import com.paytm.utility.a;
import com.paytm.utility.b;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.bankOpen.f;

public final class d extends com.paytm.utility.d {
    public static Map<String, String> d(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        hashMap.put("Accept", "application/json");
        hashMap.put("verification_type", "oauth_token");
        hashMap.put("data", a.q(context));
        hashMap.put("Authorization", b.m());
        return hashMap;
    }

    public static Map<String, String> e(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        hashMap.put("Accept", "application/json");
        hashMap.put("client_id", b.k());
        hashMap.put("client_secret", b.l());
        hashMap.put("session_token", f.a().getUserToken(context));
        hashMap.put("Authorization", b.m());
        if (b(context) != null) {
            hashMap.put("cart_id", b(context));
        }
        return hashMap;
    }
}
