package net.one97.paytm.passbook.genericPassbook.c;

import android.content.Context;
import com.paytm.network.a;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.passbook.beans.CJRAccountSummary;
import net.one97.paytm.passbook.beans.CustProductList;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.passbook.mapping.a.a;
import net.one97.paytm.passbook.mapping.a.c;
import net.one97.paytm.passbook.mapping.a.g;
import net.one97.paytm.passbook.mapping.a.i;
import net.one97.paytm.passbook.mapping.e;
import net.one97.paytm.upi.util.UpiConstants;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f57359a = new b();

    private b() {
    }

    static String a(String str, HashMap<String, String> hashMap) {
        if (str == null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry next : hashMap.entrySet()) {
            Object key = next.getKey();
            k.a(key, "entry.key");
            String str2 = (String) key;
            Object value = next.getValue();
            k.a(value, "entry.value");
            String str3 = (String) value;
            if (sb.length() > 1) {
                sb.append(AppConstants.AND_SIGN);
                sb.append(str2);
                sb.append("=");
                sb.append(str3);
                k.a((Object) sb, "paramsURL.append(\"&\").ap…append(\"=\").append(value)");
            } else {
                sb.append("?");
                sb.append(str2);
                sb.append("=");
                sb.append(str3);
                k.a((Object) sb, "paramsURL.append(\"?\").ap…append(\"=\").append(value)");
            }
        }
        return str + sb.toString();
    }

    public final void a(Context context, i.a<IJRDataModel> aVar, g gVar) {
        k.c(context, "context");
        k.c(aVar, "listener");
        k.c(gVar, "errorListener");
        k.a((Object) e.a(), "GTMLoader.getInstance()");
        String e2 = com.paytm.utility.b.e(context, e.l());
        HashMap hashMap = new HashMap();
        String a2 = net.one97.paytm.passbook.mapping.b.a(context);
        if (a2 != null) {
            hashMap.put("User-Token", a2);
        }
        Map map = hashMap;
        map.put("Content-Type", "application/json");
        map.put("channel", UpiConstants.B2C_ANDROID);
        a aVar2 = new a(e2, aVar, gVar, new CustProductList(), map, a.c.PAYMENTSBANK, a.b.USER_FACING, getClass().getSimpleName());
        c.a();
        c.b(aVar2);
    }

    public final void b(Context context, i.a<IJRDataModel> aVar, g gVar) {
        String a2;
        k.c(aVar, "listener");
        k.c(gVar, "errorListener");
        k.a((Object) e.a(), "GTMLoader.getInstance()");
        String k = e.k();
        HashMap hashMap = new HashMap();
        if (!(context == null || (a2 = net.one97.paytm.passbook.mapping.b.a(context)) == null)) {
            String lowerCase = "Authorization".toLowerCase();
            k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
            hashMap.put(lowerCase, a2);
        }
        Map map = hashMap;
        map.put("Content-Type", "application/json");
        map.put("channel", UpiConstants.B2C_ANDROID);
        net.one97.paytm.passbook.mapping.a.a aVar2 = new net.one97.paytm.passbook.mapping.a.a(k, aVar, gVar, new CJRAccountSummary(), map, a.c.PAYMENTSBANK, a.b.USER_FACING, getClass().getSimpleName());
        c.a();
        c.b(aVar2);
    }
}
