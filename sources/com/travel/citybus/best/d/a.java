package com.travel.citybus.best.d;

import android.content.Context;
import android.text.TextUtils;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.listener.b;
import com.paytm.utility.c;
import com.paytm.utility.d;
import com.travel.citybus.best.model.BestEPurseTokenResponse;
import com.travel.citybus.best.model.BestRecentResponse;
import com.travel.citybus.brts.f;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import org.json.JSONObject;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f23050a = new a();

    private a() {
    }

    public static void a(Context context, String str, String str2, b bVar) {
        k.c(context, "context");
        k.c(str, "tokenId");
        k.c(str2, "otp");
        k.c(bVar, "listener");
        k.a((Object) f.d(), "TransportBrtsController.getInstance()");
        String a2 = f.e().a("cityBusTokenUrl");
        if (TextUtils.isEmpty(a2)) {
            a2 = com.travel.citybus.brts.a.m;
        }
        String str3 = a2 + '/' + str;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("user_id", com.paytm.utility.b.n(context));
        jSONObject.put("otp", str2);
        Map hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        com.travel.citybus.brts.b.a.a();
        com.travel.citybus.brts.b.a.a(context, str3, (Map) null, hashMap, jSONObject.toString(), new BestEPurseTokenResponse(), bVar);
    }

    public static void a(Context context, b bVar) {
        k.c(context, "context");
        k.c(bVar, "listener");
        k.a((Object) f.d(), "TransportBrtsController.getInstance()");
        String a2 = f.e().a("cityBusEPurseUrl");
        if (TextUtils.isEmpty(a2)) {
            a2 = com.travel.citybus.brts.a.k;
        }
        Map hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        com.travel.citybus.brts.b.a.a();
        com.travel.citybus.brts.b.a.a(context, a2 + com.paytm.utility.b.n(context), hashMap, new BestEPurseTokenResponse(), bVar);
    }

    public static void a(Context context, String str, boolean z, b bVar) {
        String str2;
        k.c(context, "context");
        k.c(str, "orderId");
        k.c(bVar, "listener");
        StringBuilder sb = new StringBuilder();
        k.a((Object) f.d(), "TransportBrtsController.getInstance()");
        com.travel.citybus.a e2 = f.e();
        k.a((Object) e2, "TransportBrtsController.…ransportBrtsEventListener");
        sb.append(e2.b());
        sb.append(str);
        String b2 = c.b(sb.toString(), context);
        k.a((Object) b2, "CJRDefaultRequestParam.g…lWithoutSSO(url, context)");
        if (z) {
            str2 = (b2 + "&actions=0") + "&post_payment=1";
        } else {
            str2 = b2 + "&actions=1";
        }
        Map hashMap = new HashMap();
        String a2 = d.a(context);
        k.a((Object) a2, "CJRNetUtility.getSSOToken(context)");
        hashMap.put(AppConstants.SSO_TOKEN, a2);
        com.travel.citybus.brts.b.a.a();
        com.travel.citybus.brts.b.a.a(context, str2, hashMap, new CJROrderSummary(), bVar);
    }

    public static void b(Context context, b bVar) {
        k.c(context, "context");
        k.c(bVar, "listener");
        k.a((Object) f.d(), "TransportBrtsController.getInstance()");
        String a2 = f.e().a("cityBusRecentTickets");
        if (TextUtils.isEmpty(a2)) {
            a2 = com.travel.citybus.brts.a.n;
        }
        String str = a2 + "/" + com.paytm.utility.b.n(context) + "/recent/tickets";
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("status", "USED");
        jSONObject.put("count", 2);
        Map hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        com.travel.citybus.brts.b.a.a();
        com.travel.citybus.brts.b.a.a(context, str, (Map) null, hashMap, jSONObject.toString(), new BestRecentResponse(), bVar);
    }
}
