package net.one97.paytm.utils;

import android.content.Context;
import com.appsflyer.AFInAppEventParameterName;
import com.appsflyer.AppsFlyerLib;
import com.paytm.utility.b;
import com.paytm.utility.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;

public final class v {

    /* renamed from: a  reason: collision with root package name */
    public static final v f69802a = new v();

    private v() {
    }

    public final void a(Context context, String str, Map<String, ? extends Object> map) {
        if (str != null) {
            try {
                AppsFlyerLib.getInstance().trackEvent(context, str, map);
            } catch (Exception e2) {
                if (b.v) {
                    getClass().getSimpleName();
                    q.b(e2.getMessage());
                }
            }
        }
    }

    public final void a(Context context, String str, String str2, String str3, String str4, String str5, ArrayList<String> arrayList, String str6, String str7, String str8) {
        try {
            Map hashMap = new HashMap();
            if (str2 == null) {
                str2 = "";
            }
            hashMap.put(AFInAppEventParameterName.REVENUE, str2);
            if (str4 == null) {
                str4 = "";
            }
            hashMap.put(AFInAppEventParameterName.CONTENT_ID, str4);
            if (str6 == null) {
                str6 = "";
            }
            hashMap.put(AFInAppEventParameterName.QUANTITY, str6);
            hashMap.put(AFInAppEventParameterName.CURRENCY, "INR");
            if (str5 == null) {
                str5 = "";
            }
            hashMap.put("af_order_id", str5);
            if (str3 == null) {
                str3 = "";
            }
            hashMap.put(AFInAppEventParameterName.PRICE, str3);
            if (str7 == null) {
                str7 = "";
            }
            hashMap.put(AFInAppEventParameterName.PARAM_5, str7);
            if (str8 == null) {
                str8 = "";
            }
            hashMap.put(AFInAppEventParameterName.PARAM_4, str8);
            hashMap.put(AFInAppEventParameterName.CONTENT_TYPE, "product");
            if (arrayList != null && arrayList.size() >= 3) {
                String str9 = arrayList.get(0);
                k.a((Object) str9, "categoryIds[0]");
                String str10 = str9;
                String str11 = arrayList.get(1);
                k.a((Object) str11, "categoryIds[1]");
                String str12 = str11;
                String str13 = arrayList.get(2);
                k.a((Object) str13, "categoryIds[2]");
                String str14 = str13;
                if (str10 == null) {
                    str10 = "";
                }
                hashMap.put(AFInAppEventParameterName.PARAM_1, str10);
                if (str12 == null) {
                    str12 = "";
                }
                hashMap.put(AFInAppEventParameterName.PARAM_2, str12);
                if (str14 == null) {
                    str14 = "";
                }
                hashMap.put(AFInAppEventParameterName.PARAM_3, str14);
            }
            a(context, str, hashMap);
        } catch (Exception e2) {
            if (b.v) {
                getClass().getSimpleName();
                q.b(e2.getMessage());
            }
        }
    }
}
