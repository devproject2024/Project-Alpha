package net.one97.paytm.passbook.genericPassbook.a;

import android.content.Context;
import com.paytm.network.a;
import com.paytm.utility.b;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.passbook.beans.CJRAccountSummary;
import net.one97.paytm.passbook.beans.CustProductList;
import net.one97.paytm.passbook.d;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.passbook.mapping.a.a;
import net.one97.paytm.passbook.mapping.a.g;
import net.one97.paytm.passbook.mapping.a.i;
import net.one97.paytm.passbook.mapping.e;
import net.one97.paytm.upi.util.UpiConstantServiceApi;
import net.one97.paytm.upi.util.UpiConstants;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f57277a = new c();

    private c() {
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

    public final void a(Context context, i.a<IJRDataModel> aVar, g gVar, String str) {
        Context context2 = context;
        String str2 = str;
        k.c(context, "context");
        k.c(aVar, "listener");
        g gVar2 = gVar;
        k.c(gVar2, "errorListener");
        k.c(str2, "acctRefId");
        k.a((Object) e.a(), "GTMLoader.getInstance()");
        String k = e.k();
        k.a((Object) k, "GTMLoader.getInstance().paymentBankBalanceUrl");
        String e2 = b.e(context, p.a(k, "account_type=isa", "", false));
        k.a((Object) e2, "CJRAppCommonUtility.addA…text, custProductListUrl)");
        String str3 = e2 + "&account_ref_id=" + str2 + "&account_type=ica";
        Map hashMap = new HashMap();
        String lowerCase = "Authorization".toLowerCase();
        k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
        String a2 = net.one97.paytm.passbook.mapping.b.a(context);
        k.a((Object) a2, "CJRServerUtility.getSSOToken(context)");
        hashMap.put(lowerCase, a2);
        hashMap.put("Content-Type", "application/json");
        hashMap.put("channel", UpiConstants.B2C_ANDROID);
        a aVar2 = new a(str3, aVar, gVar2, (IJRDataModel) new CJRAccountSummary(), (Map<String, String>) hashMap, a.c.PAYMENTSBANK, a.b.USER_FACING, getClass().getSimpleName(), Boolean.FALSE);
        net.one97.paytm.passbook.mapping.a.c.a();
        net.one97.paytm.passbook.mapping.a.c.b(aVar2);
    }

    public final void a(Context context, i.a<IJRDataModel> aVar, g gVar) {
        k.c(context, "context");
        k.c(aVar, "listener");
        k.c(gVar, "errorListener");
        Map hashMap = new HashMap();
        String a2 = net.one97.paytm.passbook.mapping.b.a(context);
        k.a((Object) a2, "CJRServerUtility.getSSOToken(context)");
        hashMap.put("User-Token", a2);
        hashMap.put("Content-Type", "application/json");
        hashMap.put("channel", UpiConstants.B2C_ANDROID);
        net.one97.paytm.passbook.mapping.a.a aVar2 = new net.one97.paytm.passbook.mapping.a.a(b.e(context, d.b().a(UpiConstantServiceApi.GTM_KEY_PPB_CURRENT_ACCOUNT_URL)) + "&accType=ICA", aVar, gVar, new CustProductList(), hashMap, a.c.PAYMENTSBANK, a.b.USER_FACING, getClass().getSimpleName());
        net.one97.paytm.passbook.mapping.a.c.a();
        net.one97.paytm.passbook.mapping.a.c.b(aVar2);
    }
}
